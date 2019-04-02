package baselayer;

public abstract class Cuenta {
    private double saldo;
    private String numero;
    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        
        return "Saldo: " + saldo 
                + "\nNúmero: " + numero;
    }

    public void retirar(double monto){
    // validar que el monto a sacar no sea mayor al saldo
        if(monto <= saldo){
            saldo= saldo - monto;
        }
    }
    public void depositar(double monto){
    // aumentar el saldo, siempre que no sea un número negativo.
        if(monto >0){
            saldo = monto + saldo;
        }
    }

}

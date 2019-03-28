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

    public abstract void Retiro();

    public abstract void Depositos();
}

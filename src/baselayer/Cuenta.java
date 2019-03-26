public abstract class Cuenta {
    protected double saldo;
    protected int numero;

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "Cuenta{" +
                "saldo=" + saldo +
                ", numero=" + numero +
                '}';
    }

    public abstract void Retiro();

    public abstract void Depositos();
}

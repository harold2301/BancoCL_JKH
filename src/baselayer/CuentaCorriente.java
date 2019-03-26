public class CuentaCorriente extends Cuenta {

    public CuentaCorriente() {
    }

    @Override
    public String toString() {
        return "CuentaCorriente{" +
                "saldo=" + saldo +
                ", numero=" + numero +
                '}';
    }

    public void Retiro(){};
    public void Depositos(){};
}

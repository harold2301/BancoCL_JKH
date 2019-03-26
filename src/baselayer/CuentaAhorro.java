public class CuentaAhorro extends Cuenta {

    public CuentaAhorro() {
    }

    @Override
    public String toString() {
        return "CuentaAhorro{" +
                "saldo=" + saldo +
                ", numero=" + numero +
                '}';
    }

    public void Retiro(){};
    public void Depositos(){};

}

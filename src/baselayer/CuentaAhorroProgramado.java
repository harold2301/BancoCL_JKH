public class CuentaAhorroProgramado extends Cuenta{
    private CuentaCorriente cuentaCorriente; //solo 1

    public CuentaAhorroProgramado(CuentaCorriente cuentaCorriente) {
        this.cuentaCorriente = cuentaCorriente;
    }

    public CuentaCorriente getCuentaCorriente() {
        return cuentaCorriente;
    }

    public void setCuentaCorriente(CuentaCorriente cuentaCorriente) {
        this.cuentaCorriente = cuentaCorriente;
    }

    @Override
    public String toString() {
        return "CuentaAhorroProgramado{" +
                "cuentaCorriente=" + cuentaCorriente +
                ", saldo=" + saldo +
                ", numero=" + numero +
                '}';
    }

    public void Retiro(){};
    public void Depositos(){};
}

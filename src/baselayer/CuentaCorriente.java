package baselayer;

public class CuentaCorriente extends Cuenta {

    public CuentaCorriente() {}

    @Override
    public String toString() {
        return "\n  - Cuenta corriente"
                + "\n       * Número: " + getNumero()
                + "\n       * Saldo: " + getSaldo();
    }

    @Override
    public void retiro() {
    }

    @Override
    public void depositos(double monto) {
    }
;
}

package baselayer;

public class CuentaCorriente extends Cuenta {

    public CuentaCorriente() {}

    @Override
    public String toString() {
        return "\n  - Cuenta corriente"
                + "\n       * Número: " + getNumero()
                + "\n       * Saldo: " + getSaldo();
    }

    public void retiro(double monto) {
    }

    public void depositos(double monto) {
    }
;
}

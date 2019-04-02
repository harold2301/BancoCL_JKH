package baselayer;

public class CuentaAhorro extends Cuenta {

    public CuentaAhorro() {}

    @Override
    public String toString() {
        return "\n  - Cuenta de ahorro"
                + "\n       * Número: " + getNumero()
                + "\n       * Saldo: " + getSaldo();
    }

    @Override
    public void retiro(){};
    
    @Override
    public void depositos(double monto){};

}

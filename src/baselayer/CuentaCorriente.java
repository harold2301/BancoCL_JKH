package baselayer;

public class CuentaCorriente extends Cuenta {

    public CuentaCorriente() {}

    @Override
    public String toString() {
        return "CuentaCorriente"
                + "\nSaldo: " + getSaldo()
                + "\nNúmero: " + getNumero();
    }

    @Override
    public void retiro() {
    }

    @Override
    public void depositos() {
    }
;
}

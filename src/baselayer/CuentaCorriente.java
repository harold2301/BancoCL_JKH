package baselayer;

public class CuentaCorriente extends Cuenta {

    public CuentaCorriente() {
    }

    @Override
    public String toString() {
        return "CuentaCorriente"
                + "\nSaldo: " + getSaldo()
                + "\nNúmero: " + getNumero();
    }

    @Override
    public void Retiro() {
    }

    @Override
    public void Depositos() {
    }
;
}

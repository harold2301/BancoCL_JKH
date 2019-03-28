package baselayer;

public class CuentaAhorro extends Cuenta {

    public CuentaAhorro() {}

    @Override
    public String toString() {
        return "Saldo: " + getSaldo() 
                + "Número: " + getNumero();
    }

    @Override
    public void Retiro(){};
    
    @Override
    public void Depositos(){};

}

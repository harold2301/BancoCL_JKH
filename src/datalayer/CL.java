package datalayer;

import java.util.ArrayList;
import baselayer.Cuenta;
import baselayer.CuentaAhorro;
import baselayer.CuentaCorriente;

public class CL {

    ArrayList<Cuenta> cuentas;

    public CL() {
        this.cuentas = new ArrayList();
    }

    public int validarCuentaCorriente(CuentaCorriente CC) {

        for (int i = 0; i < cuentas.size(); i++) {

            if (CC.getNumero().equalsIgnoreCase(cuentas.get(i).getNumero())) {
                return i;
            }
        }
        return -1;
    }

    public void registrarCuentaCorriente(CuentaCorriente CC) {
        cuentas.add(CC);
    }

    public int validarCuentaAhorro(CuentaAhorro CA) {

        for (int i = 0; i < cuentas.size(); i++) {

            if (CA.getNumero().equalsIgnoreCase(cuentas.get(i).getNumero())) {
                return i;
            }
        }
        return -1;
    }

    public void registrarCuentaAhorro(CuentaAhorro CA) {
        cuentas.add(CA);
    }

}

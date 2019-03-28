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
<<<<<<< HEAD
    
    public void agregarCuenta(Cuenta nuevaCuenta) {
        this.cuentas.add(nuevaCuenta);
    }
    
    public ArrayList<Cuenta> getCuentas() {
        return cuentas;
    }
    
    public int buscarCuenta(String numero) {
        for (int i = 0; i < cuentas.size(); i++) {
            if (numero.equals(cuentas.get(i).getNumero())) {
                return i;
            }
        }
        
        return -1;
    }
=======

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

>>>>>>> 8f9eb675674d78813831c0ecd6d426a3c6489c69
}

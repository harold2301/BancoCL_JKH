package datalayer;

import java.util.ArrayList;
import baselayer.Cuenta;

public class CL {
    
    ArrayList<Cuenta> cuentas;
    
    public CL() {
        this.cuentas = new ArrayList();
    }
    
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
}

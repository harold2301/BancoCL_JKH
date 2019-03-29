package datalayer;

import baselayer.Cliente;
import java.util.ArrayList;
import baselayer.Cuenta;
import baselayer.CuentaAhorro;
import baselayer.CuentaCorriente;

public class CL {

    ArrayList<Cuenta> cuentas;
    ArrayList<Cliente> clientes;

    public CL() {
        this.cuentas = new ArrayList();
    }
    
    
    public ArrayList<Cliente> getCliente() {
        return clientes;
    }
    
    public ArrayList<Cuenta> getCuentas() {
        return cuentas;
    }
    
    public int buscarCliente(String cedula) {
        for (int i = 0; i < clientes.size(); i++) {
            if (cedula.equals(clientes.get(i).getCedula())) {
                return i;
            }
        }
        
        return -1;
    }
    public int buscarCuenta(String numero) {
        for (int i = 0; i < cuentas.size(); i++) {
            if (numero.equals(cuentas.get(i).getNumero())) {
                return i;
            }
        }
        
        return -1;
    }

    public void agregarCuenta(Cuenta nuevaCuenta) {
        this.cuentas.add(nuevaCuenta);
    }
    
    public void agregarCliente(Cliente miCliente) {
        this.clientes.add(miCliente);
    }

}

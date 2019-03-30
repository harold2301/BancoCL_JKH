package datalayer;

import baselayer.Cliente;
import baselayer.Cuenta;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class CL {

    ArrayList<Cliente> clientes = new ArrayList();
    Cliente cliente = new Cliente();
    
    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public void agregarCuenta(Cuenta cuenta) {
        this.cliente.getCuentas().add(cuenta);
    }

    public ArrayList<Cuenta> getCuentas() {
        return cliente.getCuentas();
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
        for (int i = 0; i < cliente.getCuentas().size(); i++) {
            if (numero.equals(cliente.getCuentas().get(i).getNumero())) {
                return i;
            }
        }

        return -1;
    }
    
    public void agregarCliente(Cliente miCliente) {
        this.clientes.add(miCliente);
    }

}

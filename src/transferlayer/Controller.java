package transferlayer;

import baselayer.Cliente;
import datalayer.CL;
import java.io.IOException;

public class Controller {

    private final CL logica = new CL();

    public Controller() {
    }

    public void enviarCliente(String nombre, String id, String direccion, String numeroCuenta, double saldoInicial, String tipo) {
        
        String infoCliente = "";
        String infoCuenta = "";
        
        infoCliente = nombre + "," + id + "," + direccion; 
        infoCuenta = numeroCuenta + "," + saldoInicial + "," + tipo;  // Este es el formato de como se va guardar las cuentas en el archivo
        
        logica.registrarCliente(infoCliente, infoCuenta);

    }

    public void enviarCuenta(String identificacion, String numeroCuenta, double saldoInicial, String tipo) {
        
        logica.registrarCuenta(identificacion, numeroCuenta, saldoInicial, tipo);
    
    }
    
    public void enviarCuentaProgramada(String numeroCC, String numeroCuenta) {
        
        logica.registrarCuentaProgramada(numeroCC, numeroCuenta);
    
    }
    
    public int buscarCliente(String id) {
        int encontrado = logica.buscarCliente(id);
        return encontrado;
    }

    public int buscarCuenta(String numero) {
        int encontrado = logica.buscarCuenta(numero);
        return encontrado;
    }
    
    public String[] listaClientes() {
        int contador = 0;
        int size = logica.getClientes().size();
        String[] info = new String[size];
        
        for (Cliente obj : logica.getClientes()) {
            info[contador] = obj.toString();
            contador++;
        }
        
        return info;
    }
    
    public String mostrarCliente(String identificacion) throws IOException {        
        Cliente info = logica.mostrarClienteEsp(identificacion);
        return info.toString();
    }
    
    
   public void enviarDeposito(String numero,double pmonto){
       
       logica.aplicarDeposito(numero,pmonto);

   }
    public void enviarRetiro(String numero,double pmonto){
        logica.aplicarRetiro(numero,pmonto);


    }
}

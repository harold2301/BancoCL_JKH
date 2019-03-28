package transferlayer;

import baselayer.CuentaAhorroProgramado;
import baselayer.CuentaCorriente;
import datalayer.CL;

//hola prros
public class Controller {
    private final CL logica = new CL();
    
    public int enviarCuenta(String numero, double monto) {
        
        int pos = logica.buscarCuenta(numero);
        
        if (pos != -1) {
            CuentaCorriente cuenta = (CuentaCorriente)logica.getCuentas().get(pos);

            CuentaAhorroProgramado nuevaCuenta = new CuentaAhorroProgramado(cuenta);
            nuevaCuenta.setNumero(numero);
            nuevaCuenta.setSaldo(monto);

            logica.agregarCuenta(nuevaCuenta);
        } 
        
        return pos;
        
    }
}

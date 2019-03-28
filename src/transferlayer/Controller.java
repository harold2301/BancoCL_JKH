package transferlayer;

import baselayer.CuentaAhorro;
import baselayer.CuentaCorriente;
import baselayer.CuentaAhorroProgramado;
import baselayer.CuentaCorriente;
import datalayer.CL;

//hola prros


public class Controller {

    private final CL logica = new CL();

    public Controller() {
    }

    public int enviarCuentaCorriente(String numeroCuenta, double saldoInicial) {
        int valida;

        CuentaCorriente CC = new CuentaCorriente();
        CC.setNumero(numeroCuenta);
        CC.setSaldo(saldoInicial);
        
        
        valida = logica.validarCuentaCorriente(CC);
        if (valida == -1) {
            logica.registrarCuentaCorriente(CC);
            
        }
        return valida;

    }
    
<<<<<<< HEAD
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
        
=======
    public int enviarCuentaAhorro(String numeroCuenta, double saldoInicial) {
        int valida;

        CuentaAhorro CA = new CuentaAhorro();
        CA.setNumero(numeroCuenta);
        CA.setSaldo(saldoInicial);
        
        
        valida = logica.validarCuentaAhorro(CA);
        if (valida == -1) {
            logica.registrarCuentaAhorro(CA);
            
        }
        return valida;

    }

    public void enviarCuenta() {
        CuentaAhorroProgramado nuevaCuenta = new CuentaAhorroProgramado();
>>>>>>> 8f9eb675674d78813831c0ecd6d426a3c6489c69
    }
}

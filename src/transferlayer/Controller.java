package transferlayer;

import baselayer.CuentaAhorro;
import baselayer.CuentaCorriente;
import baselayer.CuentaAhorroProgramado;
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
    }
}

package transferlayer;

import baselayer.Cliente;
import baselayer.Cuenta;
import baselayer.CuentaAhorro;
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
        valida = logica.buscarCuenta(numeroCuenta);

        if (valida == -1) {

            CuentaCorriente CC = new CuentaCorriente();
            CC.setNumero(numeroCuenta);
            CC.setSaldo(saldoInicial);
        }

        return valida;

    }
    
    public int enviarCliente(String nombre, String id, String direccion, String numeroCuenta, double saldoInicial) {
        int valida;
        
        // Validación de buscar cliente
//        if (true) {
            // Validación de buscar
            valida = logica.buscarCuenta(numeroCuenta);
            if (valida == -1) {

                CuentaCorriente CC = new CuentaCorriente();
                CC.setNumero(numeroCuenta);
                CC.setSaldo(saldoInicial);
                
                logica.agregarCuenta(CC);
            }
//            
//        }


        return valida;

    }

    public int enviarCuentaProgramada(String identificacion, String numero, double monto) {

        int pos = logica.buscarCuenta(numero);

        Cuenta cuenta = logica.getCuentas().get(pos);
        CuentaCorriente cc = new CuentaCorriente();
        
        if (pos != -1) {
            
            if (cuenta.getClass() == cc.getClass()) {
                
                CuentaAhorroProgramado nuevaCuenta = new CuentaAhorroProgramado((CuentaCorriente)cuenta);
                nuevaCuenta.setNumero(numero);

                logica.agregarCuenta(nuevaCuenta);
                return -2;
            }

        }

        return pos;
    }

    public int enviarCuentaAhorro(String numeroCuenta, double saldoInicial) {
        int valida;
        valida = logica.buscarCuenta(numeroCuenta);

        if (valida == -1) {

            CuentaAhorro CA = new CuentaAhorro();
            CA.setNumero(numeroCuenta);
            CA.setSaldo(saldoInicial);
            logica.agregarCuenta(CA);
        }
        return valida;

    }

    public void enviarDeposito(String numero, double monto) {
        int pos = logica.buscarCuenta(numero);
        
        CuentaAhorroProgramado cuenta = (CuentaAhorroProgramado)logica.getCuentas().get(pos);
        cuenta.depositos(monto);
        
    }
}

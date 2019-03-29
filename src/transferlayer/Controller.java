package transferlayer;

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
    
    public int enviarCuentaCorriente(String identificacion, String numeroCuenta, double saldoInicial) {
        int validaCuenta = logica.buscarCuenta(numeroCuenta);
        int validaCliente = logica.buscarCliente(identificacion);

        if (validaCliente != -1) {
            if (validaCuenta == -1) {

                CuentaCorriente CC = new CuentaCorriente();
                CC.setNumero(numeroCuenta);
                CC.setSaldo(saldoInicial);
                
                logica.getCliente().get(validaCliente).getCuentas().add(CC);
                
            } else {
                return -2;
            }
            
        } else {
            return -1;
        }

        return 1;
    }
    
    public int enviarCuentaAhorro(String identificacion, String numeroCuenta, double saldoInicial) {
        int validaCuenta = logica.buscarCuenta(numeroCuenta);
        int validaCliente = logica.buscarCliente(identificacion);

        if (validaCliente != 1) {
            if (validaCuenta == -1) {

                CuentaAhorro CA = new CuentaAhorro();
                CA.setNumero(numeroCuenta);
                CA.setSaldo(saldoInicial);
                logica.agregarCuenta(CA);
                
                logica.getCliente().get(validaCliente).getCuentas().add(CA);
                
            } else {
                return -2;
            }
            
        } else {
                return -1;
        }
        
        return 1;
    }

    public int enviarCuentaProgramada(String identificacion, String numero, double monto) {

        int pos = logica.buscarCuenta(numero);
        int cliente = logica.buscarCliente(identificacion);

        Cuenta cuenta = logica.getCuentas().get(pos);
        CuentaCorriente cc = new CuentaCorriente();
        
        if (cliente != -1) {
            
            if (pos != -1) {

                if (cuenta.getClass() == cc.getClass()) {

                    CuentaAhorroProgramado nuevaCuenta = new CuentaAhorroProgramado((CuentaCorriente)cuenta);
                    nuevaCuenta.setNumero(numero);
                    nuevaCuenta.setSaldo(monto);

                    logica.agregarCuenta(nuevaCuenta);
                } else {
                    return -3;
                }

            } else {
                return -2;
            }
            
        } else {
            return -1;
        }
        
        return 1;
    }

    public void enviarDeposito(String numero, double monto) {
        int pos = logica.buscarCuenta(numero);
        
        CuentaAhorroProgramado cuenta = (CuentaAhorroProgramado)logica.getCuentas().get(pos);
        cuenta.depositos(monto);
        
    }
}

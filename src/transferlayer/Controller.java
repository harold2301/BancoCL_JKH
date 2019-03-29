package transferlayer;

import baselayer.Cliente;
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

    public int enviarCliente(String nombre, String cedula, String direccion) {
        int valida;
        valida = logica.buscarCliente(cedula);

        if (valida == -1) {

            Cliente cliente = new Cliente();
            cliente.setNumero(nombre);
            cliente.setSaldo(cedula);
            cliente.setSaldo(direccion);
            logica.agregarCuenta(cliente);
        }

        return valida;

    }
    public int enviarCuentaCorriente(String numeroCuenta, double saldoInicial) {
        int valida;
        valida = logica.buscarCuenta(numeroCuenta);

        if (valida == -1) {

            CuentaCorriente CC = new CuentaCorriente();
            CC.setNumero(numeroCuenta);
            CC.setSaldo(saldoInicial);
            logica.agregarCuenta(CC);
        }

        return valida;

    }

    public int enviarCuenta(String numero, double monto) {

        int pos = logica.buscarCuenta(numero);

        if (pos != -1) {
            //Se castea la cuenta corriente, ya que se necesita una cuente corriente
            //existente para que pueda existir una cuenta de ahorro programado
            CuentaCorriente cuenta = (CuentaCorriente) logica.getCuentas().get(pos);

            CuentaAhorroProgramado nuevaCuenta = new CuentaAhorroProgramado(cuenta);
            nuevaCuenta.setNumero(numero);
            nuevaCuenta.setSaldo(monto);

            logica.agregarCuenta(nuevaCuenta);
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
        
    }
}

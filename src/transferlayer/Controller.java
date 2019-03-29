package transferlayer;

import baselayer.Cliente;

import baselayer.CuentaAhorro;
import baselayer.CuentaAhorroProgramado;
import baselayer.CuentaCorriente;
import datalayer.CL;

//hola prros
public class Controller {

    private final CL logica = new CL();

    public Controller() {
    }

    public int enviarClienteCorriente(String nombre, String id, String direccion, String numeroCuenta, double saldoInicial) {
        int validaCliente;
        int validaCuenta;

        validaCliente = logica.buscarCliente(id);
        if (validaCliente == -1) {
            validaCuenta = logica.buscarCuenta(numeroCuenta);
            if (validaCuenta == -1) {
                Cliente nuevoCliente = new Cliente();
                CuentaCorriente CC = new CuentaCorriente();
                CC.setNumero(numeroCuenta);
                CC.setSaldo(saldoInicial);
                nuevoCliente.setNombre(nombre);
                nuevoCliente.setCedula(id);
                nuevoCliente.setDireccion(direccion);
                logica.agregarCuenta(CC);
                nuevoCliente.setCuentas(logica.getCuentas());
                logica.agregarCliente(nuevoCliente);
            } else {
                return -1;//Ya existe una cuenta con ese id

            }
        } else {
            return -2; //Ya existe un cliente con ese id

        }

        return 1;//TODO BIEN PERRO
    }
    
    public int enviarClienteAhorro(String nombre, String id, String direccion, String numeroCuenta, double saldoInicial) {
        int validaCliente;
        int validaCuenta;

        validaCliente = logica.buscarCliente(id);
        if (validaCliente == -1) {
            validaCuenta = logica.buscarCuenta(numeroCuenta);
            if (validaCuenta == -1) {
                Cliente nuevoCliente = new Cliente();
                CuentaAhorro CA = new CuentaAhorro();
                CA.setNumero(numeroCuenta);
                CA.setSaldo(saldoInicial);
                nuevoCliente.setNombre(nombre);
                nuevoCliente.setCedula(id);
                nuevoCliente.setDireccion(direccion);
                logica.agregarCuenta(CA);
                nuevoCliente.setCuentas(logica.getCuentas());
                logica.agregarCliente(nuevoCliente);
            } else {
                return -1;//Ya existe una cuenta con ese id

            }
        } else {
            return -2; //Ya existe un cliente con ese id

        }

        return 1;//TODO BIEN PERRO
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
        int pos = logica.buscarCuenta(numero);

        CuentaAhorroProgramado cuenta = (CuentaAhorroProgramado) logica.getCuentas().get(pos);
        cuenta.depositos(monto);

    }
}

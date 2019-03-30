package transferlayer;

import baselayer.Cliente;

import baselayer.Cuenta;
import baselayer.CuentaAhorro;
import baselayer.CuentaAhorroProgramado;
import baselayer.CuentaCorriente;
import datalayer.CL;

public class Controller {

    private final CL logica = new CL();

    public Controller() {
    }

    public void enviarClienteCorriente(String nombre, String id, String direccion, String numeroCuenta, double saldoInicial) {

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

    }

    public void enviarClienteAhorro(String nombre, String id, String direccion, String numeroCuenta, double saldoInicial) {

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

    }

    public void enviarCuentaCorriente(String identificacion, String numeroCuenta, double saldoInicial) {

        CuentaCorriente CC = new CuentaCorriente();
        CC.setNumero(numeroCuenta);
        CC.setSaldo(saldoInicial);

        int cliente = logica.buscarCliente(identificacion);

        logica.getClientes().get(cliente).getCuentas().add(CC);

    }

    public void enviarCuentaAhorro(String identificacion, String numeroCuenta, double saldoInicial) {

        CuentaAhorro CA = new CuentaAhorro();
        CA.setNumero(numeroCuenta);
        CA.setSaldo(saldoInicial);

        int cliente = logica.buscarCliente(identificacion);

        logica.getClientes().get(cliente).getCuentas().add(CA);

    }

    public int enviarCuentaProgramada(String identificacion, String numero, String numeroCuenta, double monto) {

        int pos = logica.buscarCuenta(numero);
        int cliente = logica.buscarCliente(identificacion);

        Cuenta cuenta = logica.getCuentas().get(pos);

        CuentaAhorroProgramado nuevaCuenta = new CuentaAhorroProgramado((CuentaCorriente) cuenta);
        nuevaCuenta.setNumero(numeroCuenta);
        nuevaCuenta.setSaldo(monto);

        logica.getClientes().get(cliente).getCuentas().add(cuenta);

        return 1;
    }

    public int buscarCliente(String id) {
        int encontrado = logica.buscarCliente(id);
        return encontrado;
    }

    public int buscarCuenta(String numero) {
        int encontrado = logica.buscarCuenta(numero);
        return encontrado;
    }

    public void enviarDeposito(String numero, double monto) {
        int pos = logica.buscarCuenta(numero);

        CuentaAhorroProgramado cuenta = (CuentaAhorroProgramado) logica.getCuentas().get(pos);
        cuenta.depositos(monto);

    }
}

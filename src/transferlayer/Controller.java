package transferlayer;

<<<<<<< HEAD
import baselayer.Cliente;

=======
import baselayer.Cuenta;
>>>>>>> 12f840f6546ef0e0f82b9aaf2ced3a0fbb888b48
import baselayer.CuentaAhorro;
import baselayer.CuentaAhorroProgramado;
import baselayer.CuentaCorriente;
import datalayer.CL;

//hola prros
public class Controller {

    private final CL logica = new CL();

    public Controller() {
    }
<<<<<<< HEAD

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
=======
    
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
>>>>>>> 12f840f6546ef0e0f82b9aaf2ced3a0fbb888b48
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

        CuentaAhorroProgramado cuenta = (CuentaAhorroProgramado) logica.getCuentas().get(pos);
        cuenta.depositos(monto);

    }
}

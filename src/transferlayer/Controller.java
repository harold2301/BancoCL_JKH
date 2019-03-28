package transferlayer;

<<<<<<< HEAD
import baselayer.CuentaCorriente;
=======
import baselayer.CuentaAhorroProgramado;
>>>>>>> 0695dd1d78bc80f322e4d007426dd3b5e407d009
import datalayer.CL;

//hola prros
public class Controller {
    private final CL logica = new CL();

    public Controller() {
    
<<<<<<< HEAD
    }
    
    public int enviarCuentaCorriente (String numeroCuenta, double saldoInicial){
        int valida = 0;
        
        
        CuentaCorriente CC = new CuentaCorriente ();
        CC.setNumero(numeroCuenta);
        CC.setSaldo(saldoInicial);
        return valida;
=======
    public void enviarCuenta() {
        CuentaAhorroProgramado nuevaCuenta = new CuentaAhorroProgramado(); 
>>>>>>> 0695dd1d78bc80f322e4d007426dd3b5e407d009
    }
}

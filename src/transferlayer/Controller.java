package transferlayer;

import baselayer.CuentaCorriente;
import datalayer.CL;
import java.time.LocalDate;

public class Controller {
    private final CL logica = new CL();

    public Controller() {
    
    }
    
    public int enviarCuentaCorriente (String numeroCuenta, double saldoInicial){
        int valida = 0;
        
        
        CuentaCorriente CC = new CuentaCorriente ();
        CC.setNumero(numeroCuenta);
        CC.setSaldo(saldoInicial);
        return valida;
    }
}

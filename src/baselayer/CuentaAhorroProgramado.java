package baselayer;

import java.time.LocalDate;

public class CuentaAhorroProgramado extends Cuenta{
    private CuentaCorriente cuentaCorriente; //solo 1
    private LocalDate fechaCreación;

    public CuentaAhorroProgramado() {}
    
    public CuentaAhorroProgramado(CuentaCorriente cuentaCorriente) {
        this.cuentaCorriente = cuentaCorriente;
    }

    public CuentaCorriente getCuentaCorriente() {
        return cuentaCorriente;
    }

    public void setCuentaCorriente(CuentaCorriente cuentaCorriente) {
        this.cuentaCorriente = cuentaCorriente;
    }

    public LocalDate getFechaCreación() {
        return fechaCreación;
    }

    public void setFechaCreación(LocalDate fechaCreación) {
        this.fechaCreación = fechaCreación;
    }

    @Override
    public String toString() {
        return "\n  - Cuenta de ahorro programado:" +
                "\n       * Número: " + getNumero() + 
                "\n       * Saldo: " + getSaldo() +
                "\n             = Cuenta corriente asociada: " +
                "\n                   + Número: " + cuentaCorriente.getNumero() +
                "\n                   + Saldo: " + cuentaCorriente.getSaldo();
    }

    public void retiro(double monto) {
        
    }
    
    public void depositos(double monto) {
        this.setSaldo(getSaldo() + monto);
    }
}

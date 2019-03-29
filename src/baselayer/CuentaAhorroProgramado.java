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
        return "CuentaCorriente: " + cuentaCorriente.toString() +
                "\nSaldo: " + getSaldo() +
                "\nNúmero: " + getNumero();
    }

    @Override
    public void retiro() {
        
    }
    
    @Override
    public void depositos(double monto) {
        this.setSaldo(getSaldo() + monto);
    }
}

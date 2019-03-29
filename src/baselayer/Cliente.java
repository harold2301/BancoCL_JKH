package baselayer;

import java.util.ArrayList;

public class Cliente {

    private String nombre;
    private String cedula;
    private String direccion;
    private ArrayList<Cuenta> cuentas; // puede tener varias

<<<<<<< HEAD
    public Cliente() {
    }

=======
    public Cliente() {}
    
>>>>>>> 12f840f6546ef0e0f82b9aaf2ced3a0fbb888b48
    public Cliente(String nombre, String cedula, String direccion) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public ArrayList<Cuenta> getCuentas() {
        return cuentas;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre
                + "\nCédula: " + cedula
                + "\nDirección: " + direccion
                + "\nCuentas: " + cuentas;
    }
}

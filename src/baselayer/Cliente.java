import java.util.ArrayList;

public class Cliente {
    private String nombre;
    private String cedula;
    private String direccion;
    private ArrayList<Cuenta> cuentas; // puede tener varias

    public Cliente(String nombre, String cedula, String direccion, ArrayList<Cuenta> cuentas) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.direccion = direccion;
        this.cuentas = cuentas;
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

    public void setCuentas(ArrayList<Cuenta> cuentas) {
        this.cuentas = cuentas;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nombre='" + nombre + '\'' +
                ", cedula='" + cedula + '\'' +
                ", direccion='" + direccion + '\'' +
                ", cuentas=" + cuentas +
                '}';
    }
}

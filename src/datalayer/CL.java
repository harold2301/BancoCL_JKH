package datalayer;

import baselayer.Cliente;
import baselayer.Cuenta;
import baselayer.CuentaAhorro;
import baselayer.CuentaAhorroProgramado;
import baselayer.CuentaCorriente;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

public class CL {

    public String [] cuentasProgramdas (){
        String [] cuentas = null;
        
        
        
        return cuentas;
    }
    // Función para buscar un cliente, retorna la fila en la que está
    
    public int buscarCliente(String cedula) {
        int encontrado = 0;
        try {

            FileReader reader = new FileReader("Clientes.txt");
            BufferedReader buffer = new BufferedReader(reader);

            String datos;
            String[] clientes;

            while ((datos = buffer.readLine()) != null) {
                clientes = datos.split(",");

                if (clientes[1].equals(cedula)) {
                    return encontrado;
                } else {
                    encontrado++;
                }
            }

            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return -1;
    }

    // Función para buscar una cuenta, retrona la fila en la que está
    public int buscarCuenta(String numero) {
        int encontrada = 0;
        try {

            FileReader reader = new FileReader("Cuentas.txt");
            BufferedReader buffer = new BufferedReader(reader);

            String datos;
            String[] cuentas;

            while ((datos = buffer.readLine()) != null) {
                cuentas = datos.split("/");

                for (int i = 0; i < cuentas.length; i++) {
                    String[] cuenta = cuentas[i].split(",");

                    if (cuenta[0].equals(numero)) {
                        return encontrada;
                    }

                }

                encontrada++;
            }

            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return -1;
    }

    public void registrarCliente(String cliente, String cuenta) {
        try {

            FileWriter writerCliente = new FileWriter("Clientes.txt", true);
            FileWriter writerCuenta = new FileWriter("Cuentas.txt", true);

            BufferedWriter bufferCliente = new BufferedWriter(writerCliente);
            BufferedWriter bufferCuenta = new BufferedWriter(writerCuenta);

            // Escribe las líneas en los archivos correspondientes
            bufferCliente.write(cliente);
            bufferCliente.newLine();

            bufferCuenta.write(cuenta);
            bufferCuenta.newLine();

            // Cierra la escritura en el archivo
            bufferCliente.close();
            bufferCuenta.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void registrarCuenta(String identificacion, String numeroCuenta, double monto, String tipo) {
        try {

            String datos;
            String cuentas = "";
            String[] info = new String[cantLineas()]; // Se inicializa con el entero que retorna la función cantLineas()

            int cont = buscarCliente(identificacion); // Me da la posición en la que está el usuario

            FileReader readerCuentas = new FileReader("Cuentas.txt");
            BufferedReader bufferCuentas = new BufferedReader(readerCuentas);

            int k = 0;
            while ((datos = bufferCuentas.readLine()) != null) {
                info[k] = datos;  // Aquí ingresa cada línea en un arreglo de Strings
                k++;
            }

            info[cont] = info[cont] + "/" + numeroCuenta + "," + monto + "," + tipo; // Inserta la nueva cuenta en la posición que 
            // hace referencia a la del cliente

            bufferCuentas.close();

            for (int j = 0; j < info.length; j++) { // Se concatena las cuentas
                if (j == info.length) {  // Para que la última cuenta no tenga un salto de línea y no de error al imprimir
                    cuentas += info[j];
                } else {
                    cuentas += info[j] + "\n";
                }
            }

            // Se sobreescribe todo el archivo por eso se meten los datos en array para después concatenarlos y porteriormente madarlo al archivo
            FileOutputStream stream = new FileOutputStream("Cuentas.txt");
            OutputStreamWriter output = new OutputStreamWriter(stream, "UTF-8");
            BufferedWriter buffer = new BufferedWriter(output);

            buffer.write(cuentas); // Aquí se envía la concatenación
            buffer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void registrarCuentaProgramada(String numeroCC, String numeroCuenta, LocalDate fechaCreacion) {

        try {

            FileReader readerCuentas = new FileReader("Cuentas.txt");
            BufferedReader bufferCuentas = new BufferedReader(readerCuentas);

            String datos, concat = "", concat2 = "";
            String[] cuentas, cuenta;
            String[] info = new String[cantLineas()];
            int encontrada = buscarCuenta(numeroCC); // Función que retorna la posición de la cuenta corriente
            int j = 0;

            while ((datos = bufferCuentas.readLine()) != null) {
                info[j] = datos;
                double monto = 0;
                double saldo = 0;

                if (j == encontrada) { // Cuando j esté en la posición de la cuenta ejecuta el siguiente código
                    cuentas = datos.split("/");

                    for (int i = 0; i < cuentas.length; i++) {
                        cuenta = cuentas[i].split(",");

                        if (cuenta[0].equals(numeroCC)) {
                            saldo = Double.parseDouble(cuenta[1]); // Saca el saldo de la cuenta encontrada
                            monto = saldo * 0.05; // Saca un porcentaje del saldo
                            saldo = saldo - monto; // Y se lo resta al saldo original

                            cuentas[i] = cuenta[0] + "," + saldo + "," + cuenta[2];  // Sobreescribe la cuenta anterior con el nuevo saldo
                        }

                        concat2 += cuentas[i] + "/";
                    }

                    info[j] = concat2 + numeroCuenta + "," + monto + "," 
                            + fechaCreacion + "," + "CP" + "," + numeroCC; 
                            // Ingresa la nueva cuenta con el porcentaje
                }          // obtenido del saldo de la cuenta corriente

                j++;
            }

            bufferCuentas.close();

            for (int k = 0; k < info.length; k++) {
                if (k == info.length) {
                    concat += info[k];
                } else {
                    concat += info[k] + "\n";
                }
            }

            FileOutputStream stream = new FileOutputStream("Cuentas.txt");
            OutputStreamWriter output = new OutputStreamWriter(stream, "UTF-8");
            BufferedWriter buffer = new BufferedWriter(output);

            buffer.write(concat);
            buffer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public ArrayList<Cliente> getClientes() {

        ArrayList<Cliente> clientes = new ArrayList();

        try {

            FileReader readerClientes = new FileReader("Clientes.txt");
            BufferedReader bufferClientes = new BufferedReader(readerClientes);

            ArrayList<Cuenta> cuentasC;
            String datos;
            String[] cliente;
            String[] cuentas;
            String[] cuenta;
            int j = 0;
            int k = 0;

            while ((datos = bufferClientes.readLine()) != null) {
                cliente = datos.split(",");

                // Se separan cada uno de los clientes que hay registrados
                String nombre = cliente[0];
                String identificacion = cliente[1];
                String direccion = cliente[2];

                Cliente tmpCliente = new Cliente(nombre, identificacion, direccion);
                clientes.add(tmpCliente); // Se añade los clientes a un ArrayList para después retornarlo

                j++;
            }

            readerClientes.close();

            FileReader readerCuentas = new FileReader("Cuentas.txt");
            BufferedReader bufferCuentas = new BufferedReader(readerCuentas);

            while ((datos = bufferCuentas.readLine()) != null) {
                cuentasC = new ArrayList(); // En cada iteración el ArrayList se tiene que limpiar
                cuentas = datos.split("/");

                for (int i = 0; i < cuentas.length; i++) {
                    cuenta = cuentas[i].split(",");

                    // Se separan los datos para después establecerselos al objeto tipo Cuenta
                    String numero = cuenta[0];
                    double saldo = Double.parseDouble(cuenta[1]);
                    String tipo = cuenta[2];

                    switch (tipo) {  // Crea la cuenta dependiendo del tipo que tenga registrado
                        case "CC":
                            CuentaCorriente cc = new CuentaCorriente();
                            cc.setNumero(numero);
                            cc.setSaldo(saldo);
                            cuentasC.add(cc);
                            break;

                        case "CA":
                            CuentaAhorro ca = new CuentaAhorro();
                            ca.setNumero(numero);
                            ca.setSaldo(saldo);
                            cuentasC.add(ca);
                            break;

                        case "CP":
                            CuentaAhorroProgramado cp = new CuentaAhorroProgramado();
                            cp.setCuentaCorriente(obtenerCC(cuenta[3])); // Establece la cuenta con el objeto que retorna esta función
                            cp.setNumero(numero);                        // cuenta[3] es la posición en la que está la CC asociada
                            cp.setSaldo(saldo);
                            cuentasC.add(cp);
                            break;
                    }
                }

                if (k < j) {
                    clientes.get(k).setCuentas(cuentasC); // Va añadiendo las cuentas a los clientes
                    k++;
                }
            }

            readerCuentas.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return clientes;
    }

    // Esta función es parecida a la anterior sólo que esta retorna un objeto tipo Cliente, porque sólo se está buscando uno
    public Cliente mostrarClienteEsp(String pidentificacion) throws IOException {

        Cliente tmpCliente = null;

        try {

            FileReader readerClientes = new FileReader("Clientes.txt");
            BufferedReader bufferClientes = new BufferedReader(readerClientes);

            String datos = "";
            String[] cliente;
            String[] cuentas;
            String[] cuenta;
            ArrayList<Cuenta> cuentasC = new ArrayList();
            int cont = 0;
            int j = 0;

            while ((datos = bufferClientes.readLine()) != null) {
                cliente = datos.split(",");

                if (cliente[1].equals(pidentificacion)) {
                    String nombre = cliente[0];
                    String identificacion = cliente[1];
                    String direccion = cliente[2];

                    tmpCliente = new Cliente(nombre, identificacion, direccion);
                    break;
                } else {
                    cont++; // Este cont es para saber en qué linea se tiene que buscar las cuentas
                }
            }

            readerClientes.close();

            FileReader readerCuentas = new FileReader("Cuentas.txt");
            BufferedReader bufferCuentas = new BufferedReader(readerCuentas);

            while ((datos = bufferCuentas.readLine()) != null) {

                if (j == cont) {  // Cuando el contador j llegue a la meta que es estar igual a cont para que tome las cuentas del cliente respectivo
                    cuentas = datos.split("/");

                    for (int i = 0; i < cuentas.length; i++) {
                        cuenta = cuentas[i].split(",");

                        String numero = cuenta[0];
                        double saldo = Double.parseDouble(cuenta[1]);
                        String tipo = cuenta[2];

                        switch (tipo) {
                            case "CC":
                                CuentaCorriente cc = new CuentaCorriente();
                                cc.setNumero(numero);
                                cc.setSaldo(saldo);
                                cuentasC.add(cc);
                                break;

                            case "CA":
                                CuentaAhorro ca = new CuentaAhorro();
                                ca.setNumero(numero);
                                ca.setSaldo(saldo);
                                cuentasC.add(ca);
                                break;

                            case "CP":
                                CuentaAhorroProgramado cp = new CuentaAhorroProgramado();
                                cp.setCuentaCorriente(obtenerCC(cuenta[3]));
                                cp.setNumero(numero);
                                cp.setSaldo(saldo);
                                cuentasC.add(cp);
                                break;
                        }
                    }
                }

                j++;
            }

            tmpCliente.setCuentas(cuentasC); // Se le establecen las cuentas al cliente

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        return tmpCliente;
    }

    public void aplicarRetiro(String numero, double pmonto) {
        try {

            FileReader readerCuentas = new FileReader("Cuentas.txt");
            BufferedReader buffer = new BufferedReader(readerCuentas);

            String datos, concat = "", concat2 = "";
            String[] cuentas, cuenta;
            String[] info = new String[cantLineas()];
            int encontrada = buscarCuenta(numero); // Función que retorna la posición de la cuenta corriente
            int j = 0;
            while ((datos = buffer.readLine()) != null) {
                info[j] = datos;//Se meten los datos en el arreglo de CADA LINEA del archivo.txt

                if (j == encontrada) { // Cuando j esté en la posición de la cuenta ejecuta el siguiente código
                    // Cuando encuentra la posicion del numero de cuenta que voy a depositar
                    // y coincide con la iteracion entonces se ejecuta lo siguiente
                    cuentas = datos.split("/");//Se almacena las cuentas (de la linea que se esta ejecutando del while)
                    // una a una (de la cuenta encontrada), en el arreglo de cuentas 

                    for (int i = 0; i < cuentas.length; i++) {
                        cuenta = cuentas[i].split(",");//Separa la informacion de la cuenta obtenida
                        // [0] = id
                        // [1] = monto
                        // [2] = tipo

                        if (cuenta[0].equals(numero)) {//Si el [0]id es igual al numero de cuenta se ejecuta

                            double monto2 = Double.parseDouble(cuenta[1]);//Saco el monto de cuenta 
                            double montoNuevo = monto2 - pmonto;//Le atribuyo el deposito
                            cuentas[i] = cuenta[0] + "," + montoNuevo + "," + cuenta[2];//Sobreescribo la informacion
                            //en la posicion correspondiente
                        }//Fin del if

                        concat2 += cuentas[i] + "/";//Concateno la informacion (las cuentas) de una sola linea
                    }//Fin del for

                    info[j] = concat2;
                }//Fin del if
                j++;
            }//Fin del while

            for (int k = 0; k < info.length; k++) {
                if (k == info.length) {
                    concat += info[k];
                } else {
                    concat += info[k] + "\n";
                }
            }

            readerCuentas.close();

            FileOutputStream stream = new FileOutputStream("Cuentas.txt");
            OutputStreamWriter output = new OutputStreamWriter(stream,
                    "UTF-8");
            BufferedWriter writeNew = new BufferedWriter(output);

            writeNew.write(concat);
            writeNew.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
   
    
    public void aplicarDeposito(String numero, double pmonto) {
        try {

            FileReader readerCuentas = new FileReader("Cuentas.txt");
            BufferedReader buffer = new BufferedReader(readerCuentas);

            String datos, concat = "", concat2 = "";
            String[] cuentas, cuenta;
            String[] info = new String[cantLineas()];
            int encontrada = buscarCuenta(numero); // Función que retorna la posición de la cuenta corriente
            int j = 0;
            while ((datos = buffer.readLine()) != null) {
                info[j] = datos;//Se meten los datos en el arreglo de CADA LINEA del archivo.txt

                if (j == encontrada) { // Cuando j esté en la posición de la cuenta ejecuta el siguiente código
                    // Cuando encuentra la posicion del numero de cuenta que voy a depositar
                    // y coincide con la iteracion entonces se ejecuta lo siguiente
                    cuentas = datos.split("/");//Se almacena las cuentas (de la linea que se esta ejecutando del while)
                    // una a una (de la cuenta encontrada), en el arreglo de cuentas 

                    for (int i = 0; i < cuentas.length; i++) {
                        cuenta = cuentas[i].split(",");//Separa la informacion de la cuenta obtenida
                        // [0] = id
                        // [1] = monto
                        // [2] = tipo

                        if (cuenta[0].equals(numero)) {//Si el [0]id es igual al numero de cuenta se ejecuta

                            double monto2 = Double.parseDouble(cuenta[1]);//Saco el monto de cuenta 
                            double montoNuevo = monto2 + pmonto;//Le atribuyo el deposito
                            cuentas[i] = cuenta[0] + "," + montoNuevo + "," + cuenta[2];//Sobreescribo la informacion
                            //en la posicion correspondiente
                        }//Fin del if

                        concat2 += cuentas[i] + "/";//Concateno la informacion (las cuentas) de una sola linea
                    }//Fin del for

                    info[j] = concat2;
                }//Fin del if
                j++;
            }//Fin del while

            for (int k = 0; k < info.length; k++) {
                if (k == info.length) {
                    concat += info[k];
                } else {
                    concat += info[k] + "\n";
                }
            }

            readerCuentas.close();

            FileOutputStream stream = new FileOutputStream("Cuentas.txt");
            OutputStreamWriter output = new OutputStreamWriter(stream,
                    "UTF-8");
            BufferedWriter writeNew = new BufferedWriter(output);

            writeNew.write(concat);
            writeNew.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    // Cuenta la cantidad de lineas que hay en el archivo
    public int cantLineas() throws IOException {
        FileReader reader = new FileReader("Cuentas.txt");
        BufferedReader buffer = new BufferedReader(reader);

        int i = 0;
        while ((buffer.readLine()) != null) {
            i++;
        }

        buffer.close();

        return i;
    }

    // Función que busca una cuenta por medio del número y retorna un objeto tipo CuentaCorriente
    public CuentaCorriente obtenerCC(String numeroCuenta) throws IOException {

        FileReader reader = new FileReader("Cuentas.txt");
        BufferedReader buffer = new BufferedReader(reader);

        String datos;
        String numero = "";
        double saldo = 0.0;
        String[] cuentas;
        String[] cuenta;

        while ((datos = buffer.readLine()) != null) {
            cuentas = datos.split("/");

            for (int i = 0; i < cuentas.length; i++) {
                cuenta = cuentas[i].split(",");

                if (cuenta[0].equals(numeroCuenta)) {
                    numero = cuenta[0];
                    saldo = Double.parseDouble(cuenta[1]);
                    break;
                }
            }
        }

        reader.close();

        CuentaCorriente cc = new CuentaCorriente();
        cc.setNumero(numero);
        cc.setSaldo(saldo);

        return cc;
    }
}

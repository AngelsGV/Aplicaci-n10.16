//Un libro de firmas es útil para recoger los nombres de todas las personas que han pasado por un determinado lugar.
// Crea una aplicación que permita insertar firmas (sin repetición)
// y mostrar el libro de firmas. Llamaremos al fichero firmas.txt.
package Aplicacio10_16;
import java.io.*;
public class Metodos {
    public static void insertarPersona(String nombre) {
        //Esta parte es igual que en aplicaión 10.12
        //Insertará nueva firma si no está repetida

        BufferedWriter out = null;//¿Porque? En este paso he seguido los ejercicios resultos del libro

        try {
            if (!existeFirma(nombre)) {//Si no se repite la firma se instera en el archivo
                out = new BufferedWriter(new FileWriter("firmas.txt", true));
                //append true para que se guarde sin sobreescribirse en los datos anteriores.
                out.write(nombre); //escribimos en una unica sentencia
                out.newLine();//cambio de linea del archivo
                System.out.println("Datos guardados correctamente.");//Si llega hasta el final nos mostrará este mensaje
                //He mirado en el archivo datos.txt y no se sobreescribe!
            } else {//Si eta repetida, no se graba en .txt y salta el mensaje de error
                System.out.println("La firma está repetida.");
            }
        } catch (IOException ex) {//Mensaje de excepcion
            System.out.println(ex.getMessage());

        } finally {
            if (out != null) { //Si no fura null (casi imposible porque se lo marcamos arriba)
                try {
                    out.close();//hacemos que se vacíe el búfer y se escriba en el archivo
                } catch (IOException ex) {
                    System.out.println(ex);
                }
            }
        }
    }

    public static boolean existeFirma(String nombre) throws IOException {
        BufferedReader in = null;

        try {
            in = new BufferedReader(new FileReader("firmas.txt"));
            String firma;
            while ((firma = in.readLine()) != null) {
                if (firma.equals(nombre)) {
                    // in.close();
                    return true;
                }
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException ex) {
                    System.out.println(ex);
                }
            }
        }
        return false;
    }

    public static void mostrarFirmas() {

        BufferedReader in = null;
        try {
                in = new BufferedReader(new FileReader("firmas.txt"));
                String firma;
            while ((firma = in.readLine()) != null) {
                System.out.println(firma);
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException ex) {
                    System.out.println(ex);
                }
            }
        }
    }
}
//-------------------------------------------
//Problemas:
//1. Al repetir nombres nos salta la excepcion Exception in thread "main" java.util.InputMismatchException -->OK

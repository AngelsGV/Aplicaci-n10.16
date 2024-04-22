//Un libro de firmas es útil para recoger los nombres de todas las personas que han pasado por un determinado lugar.
// Crea una aplicación que permita insertar firmas (sin repetición)
// y mostrar el libro de firmas. Llamaremos al fichero firmas.txt.
package Aplicacio10_16;
import java.io.*;
public class Metodos {
    public static void insertarPersona(String nombre) {
        //Esta parte es igual que en aplicaión 10.12

        BufferedWriter out = null;
        String firma = "";
        try{
            if(!existeFirma(nombre)) {
                out = new BufferedWriter(new FileWriter("firmas.txt", true));
                //append true para que se guarde sin sobreescribirse en los datos anteriores.
                out.write("Firma: " + nombre); //escribimos en una unica sentencia
                out.newLine();//cambio de linea del archivo
                System.out.println("Datos guardados correctamente.");//Si llega hasta el final nos mostrará este mensaje
                //He mirado en el archivo datos.txt y no se sobreescribe!
            }else{
                System.out.println("La firma está repetida.");
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());

        }finally {
            if (out != null){
                try{
                    out.close();//hacemos que se vacíe el búfer y se escriba en el archivo
                }catch (IOException ex){
                    System.out.println(ex);
                }
            }
        }
    }

    public static boolean existeFirma(String nombre) throws IOException {

        BufferedReader in = new BufferedReader(new FileReader("firmas.txt"));
        String nombre1;
        while ((nombre1 = in.readLine()) != null){
            if (nombre1.equals(nombre)){
                in.close();
                return true;
            }
        }return false;
    }

    public static void mostrarFirmas(){ try {
        BufferedReader in = null;
        String firma = "";
        try{

            in = new BufferedReader(new FileReader("firmas.txt"));
                System.out.println(firma);
        }catch (IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}
//-------------------------------------------
//Problemas:
//1. Al repetir nombres nos salta la excepcion Exception in thread "main" java.util.InputMismatchException
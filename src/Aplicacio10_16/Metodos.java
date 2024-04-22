package Aplicacio10_16;
import java.io.*;
import java.util.*;
public class Metodos {
    public static void insertarPersona(String nombre) {
        //Este es igual que en aplicaión 10.12

        BufferedWriter out = null;
        try{
            out = new BufferedWriter(new FileWriter("firmas.txt",true));
            //append true para que se guarde sin sobreescribirse en los datos anteriores.
            out.write("Firma: " + nombre ); //escribimos en una unica sentencia
            out.newLine();//cambio de linea del archivo
            System.out.println("Datos guardados correctamente.");//Si llega hasta el final nos mostrará este mensaje
            //He mirado en el archivo datos.txt y no se sobreescribe!
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

    public static boolean existeFirma(String archivo) {

        String[] f = new String[0];
        String firma = ""; //cadena vacía
        try {
            File archivo = new File("firmas.txt");
            Scanner lector = new Scanner(archivo);

            while (lector.hasNextLine()) {
                if (lector.nextLine().equals(nombre)) {
                    lector.close();
                    return true;
                }
            }
            lector.close();
        } catch (FileNotFoundException e) {
            System.err.println("Error al abrir el archivo: " + e.getMessage());
        }
        return false;
    }

    public static void mostrarFirmas(){ try {
        File archivo = new File("firmas.txt");
        Scanner lector = new Scanner(archivo);

        System.out.println("Libro de Firmas:");
        while (lector.hasNextLine()) {
            System.out.println(lector.nextLine());
        }
        lector.close();
    } catch (FileNotFoundException e) {
        System.err.println("El libro de firmas está vacío.");
    }
    }
}
//-------------------------------------------
//Problemas:
//1. Al repetir nombres nos salta la excepcion Exception in thread "main" java.util.InputMismatchException
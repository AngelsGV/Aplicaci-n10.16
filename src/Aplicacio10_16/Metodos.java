package Aplicacio10_16;
import java.io.*;
import java.util.*;
public class Metodos {
    public static void insertarPersona(String nombre) {
        try{
            File archivo = new File("firmas.txt");

        FileWriter escritor = new FileWriter(archivo, true);
        BufferedWriter bufferEscritor = new BufferedWriter(escritor);

        // Verificar si el nombre ya existe en el archivo
        if (!existeFirma(nombre)) {
            bufferEscritor.write(nombre);
            bufferEscritor.newLine();
            bufferEscritor.close();
            System.out.println("Firma insertada correctamente.");
        } else {
            System.out.println("La firma ya existe en el libro.");
        }
    } catch(
    IOException e)

    {
        System.err.println("Error al insertar la firma: " + e.getMessage());
    }}

    public static boolean existeFirma(String nombre) {
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

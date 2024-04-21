package Aplicacio10_16;

import java.util.Scanner;

import static Aplicacio10_16.Metodos.*;

public class Main {
    public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);
            boolean continuar = true; //Lo he añadido así para en la 3 opción poder salir
            //Me he decantado por un switch porque así podemos ver el resultado(para saber si está correctamente funcionando)
        // y para poder seguir insertando personas si nos apetece.
            while (continuar) {
                System.out.println("\n1. Insertar firma");
                System.out.println("2. Mostrar libro de firmas");
                System.out.println("3. Salir");
                System.out.print("Elige una opción: ");
                int opcion = sc.nextInt();

                switch (opcion) {
                    case 1:
                        System.out.print("Ingresa el nombre para la firma: ");
                        sc.nextLine(); // Limpiar el buffer
                        String nombre = sc.nextLine();
                        insertarPersona(nombre);
                        break;
                    case 2:
                        mostrarFirmas();
                        break;
                    case 3:
                        continuar = false;
                        break;
                    default:
                        System.out.println("Opción incorrecta. Selecciona una opción válida.");
                }
            }

        }
}
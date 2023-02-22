import java.util.Scanner;

import model.Carpeta;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Ingresa la ruta de la carpeta: ");
        String rutaArchivo = scanner.nextLine();
        System.out.print("Ingresa la palabra que desea buscar: ");
        String palabraBuscada = scanner.nextLine();

        try {
            Carpeta carpeta = new Carpeta(rutaArchivo);
            carpeta.contarPalabras(palabraBuscada);
        } catch (NullPointerException e) {
            System.out.println("La carpeta indicada no ha sido encontrada");
        }

        scanner.close();

    }
}

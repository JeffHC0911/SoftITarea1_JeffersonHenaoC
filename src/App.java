import java.util.Scanner;

import model.Carpeta;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingresa la ruta de la carpeta: ");
        String ruta = scanner.nextLine();
        System.out.print("Ingresa la palabra que desea buscar: ");
        String palabra = scanner.nextLine();
        scanner.close();

        Carpeta carpeta = new Carpeta(ruta);
        carpeta.contarPalabras(palabra);
    }
}

package model;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Carpeta {
    private String rutaArchivo;
    private List<Archivo> archivosCarpeta;

    public Carpeta(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
        this.archivosCarpeta = new ArrayList<Archivo>();
        this.cargarArchivos();
    }

    /**
     * Se encarga de buscar los archivos de texto en la ruta especificada por el
     * usuario
     */
    public void cargarArchivos() {
        File carpeta = new File(rutaArchivo);
        File[] archivos = carpeta.listFiles();
        for (File archivo : archivos) {
            if (archivo.isFile() && archivo.getName().endsWith(".txt") || archivo.getName().endsWith(".csv")
                    || archivo.getName().equals(".json") || archivo.getName().endsWith(".xml")) {
                Archivo a = new Archivo(archivo.getPath());
                archivosCarpeta.add(a);
            }else{
                System.out.println("No se encontraron archivo de texto en la carpeta");
            }
        }
    }

    /**
     * Se recorre el archivo, se llama al método que cuenta las palabras en el
     * archivo, se muestra cuántas veces repite
     * en cada archivo y se acumula en un contadorTotal que al final es retornado
     * 
     * @param palabra Palabra que ingresa el usuario para ser buscada
     * @return Retorna un contador que contiene el total de las repeticiones de la
     *         palabra a nivel carpeta
     * @throws IOException
     */
    public int contarPalabras(String palabra) throws IOException {
        int contadorTotal = 0;
        for (Archivo archivo : archivosCarpeta) {
            int contador = archivo.contarPalabra(palabra);
            System.out.println(archivo.getNombreArchivo() + "    " + contador + " veces");
            contadorTotal += contador;
        }
        System.out.println("Total en carpeta: " + contadorTotal + " veces");
        return contadorTotal;
    }
}
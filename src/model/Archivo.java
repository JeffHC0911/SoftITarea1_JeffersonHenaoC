package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Archivo {
    private String nombreArchivo;

    public Archivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    /**
     * Se crea un objeto File a partir de la ruta y se retorna el nombre del archivo
     * sin tener en cuenta su ruta
     * 
     * @return el nombre del archivo sin la ruta
     */
    public String getNombreArchivo() {
        File archivo = new File(nombreArchivo);
        return archivo.getName();
    }

    /**
     * El método contiene un BufferedReader para poder leer un archivo de texto
     * El readLine() permite tomar cada linea del texto
     * Se separa la linea en un arreglo de palabras con el split utilizando un regex
     * que busca regular secuencias
     * que no sean letras o números
     * 
     * @param palabra Palabra que ingresa el usuario para ser buscada en los
     *                archivos
     * @return Retorna un entero con la cantidad de veces que la palabra se
     *         encuentra en el archivo
     * @throws IOException
     */
    public int contarPalabra(String palabra) throws IOException {
        int contador = 0;
        BufferedReader reader = new BufferedReader(new FileReader(nombreArchivo));
        String linea = reader.readLine();
        while (linea != null) {
            String[] palabras = linea.split("\\W+");
            for (String palabraArchivo : palabras) {
                if (palabraArchivo.equalsIgnoreCase(palabra)) {
                    contador++;
                }
            }
            linea = reader.readLine();
        }
        reader.close();
        return contador;
    }
}

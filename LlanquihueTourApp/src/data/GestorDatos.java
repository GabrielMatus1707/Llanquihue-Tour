package data;

import model.Tour;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Clase responsable de leer el archivo de datos y cargar los objetos Tour
 * en un ArrayList.
 */
public class GestorDatos {

    /**
     * Lee el archivo tours.txt línea por línea, separa los campos con ";"
     * y crea objetos Tour que almacena en un ArrayList.
     *
     * @param rutaArchivo Ruta al archivo .txt con los datos
     * @return ArrayList con todos los objetos Tour creados
     */
    public ArrayList<Tour> cargarTours(String rutaArchivo) {

        // Lista donde se almacenarán los objetos Tour
        ArrayList<Tour> listaTours = new ArrayList<>();

        try {
            // Abrimos el archivo para leerlo línea por línea
            BufferedReader lector = new BufferedReader(new FileReader(rutaArchivo));
            String linea;

            // Recorremos cada línea del archivo
            while ((linea = lector.readLine()) != null) {

                // Separamos los campos usando ";" como delimitador
                String[] campos = linea.split(";");

                // Verificamos que la línea tenga exactamente 3 campos
                if (campos.length == 3) {
                    String nombre = campos[0];
                    String tipo = campos[1];
                    int precio = Integer.parseInt(campos[2]);

                    // Creamos el objeto Tour y lo agregamos a la lista
                    Tour tour = new Tour(nombre, tipo, precio);
                    listaTours.add(tour);
                }
            }

            lector.close(); // Cerramos el archivo al terminar

        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error en el formato del precio: " + e.getMessage());
        }

        return listaTours;
    }
}

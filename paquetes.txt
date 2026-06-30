package data;

import model.Guia;
import model.Operador;
import model.PaqueteTuristico;
import model.Tour;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Clase responsable de leer archivos de datos y cargar objetos en colecciones.
 * Semana 5: se agregó carga de Guia, Operador y PaqueteTuristico.
 * El archivo tours.txt original se mantiene compatible.
 */
public class GestorDatos {

    // ── Tours (archivo original, ahora con id y duracion) ──────────────
    public ArrayList<Tour> cargarTours(String rutaArchivo) {
        ArrayList<Tour> lista = new ArrayList<>();
        try (BufferedReader lector = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            lector.readLine(); // saltar encabezado
            while ((linea = lector.readLine()) != null) {
                if (linea.isBlank()) continue;
                String[] campos = linea.split(";");
                if (campos.length == 5) {
                    int id           = Integer.parseInt(campos[0].trim());
                    String nombre    = campos[1].trim();
                    String tipo      = campos[2].trim();
                    int precio       = Integer.parseInt(campos[3].trim());
                    int duracion     = Integer.parseInt(campos[4].trim());
                    lista.add(new Tour(id, nombre, tipo, precio, duracion));
                }
            }
            System.out.println("  ✔ " + lista.size() + " tours cargados.");
        } catch (IOException e) {
            System.out.println("  ✘ Error al leer tours: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("  ✘ Error de formato en tours: " + e.getMessage());
        }
        return lista;
    }

    // ── Guías ──────────────────────────────────────────────────────────
    public ArrayList<Guia> cargarGuias(String rutaArchivo) {
        ArrayList<Guia> lista = new ArrayList<>();
        try (BufferedReader lector = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            lector.readLine();
            while ((linea = lector.readLine()) != null) {
                if (linea.isBlank()) continue;
                String[] c = linea.split(";");
                if (c.length == 5) {
                    lista.add(new Guia(
                        Integer.parseInt(c[0].trim()),
                        c[1].trim(), c[2].trim(), c[3].trim(),
                        Integer.parseInt(c[4].trim())
                    ));
                }
            }
            System.out.println("  ✔ " + lista.size() + " guías cargados.");
        } catch (IOException e) {
            System.out.println("  ✘ Error al leer guias: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("  ✘ Error de formato en guias: " + e.getMessage());
        }
        return lista;
    }

    // ── Operadores ─────────────────────────────────────────────────────
    public ArrayList<Operador> cargarOperadores(String rutaArchivo) {
        ArrayList<Operador> lista = new ArrayList<>();
        try (BufferedReader lector = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            lector.readLine();
            while ((linea = lector.readLine()) != null) {
                if (linea.isBlank()) continue;
                String[] c = linea.split(";");
                if (c.length == 4) {
                    lista.add(new Operador(
                        Integer.parseInt(c[0].trim()),
                        c[1].trim(), c[2].trim(), c[3].trim()
                    ));
                }
            }
            System.out.println("  ✔ " + lista.size() + " operadores cargados.");
        } catch (IOException e) {
            System.out.println("  ✘ Error al leer operadores: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("  ✘ Error de formato en operadores: " + e.getMessage());
        }
        return lista;
    }

    // ── Paquetes (referencia a IDs de tour, guia y operador) ───────────
    public ArrayList<PaqueteTuristico> cargarPaquetes(String rutaArchivo,
                                                       ArrayList<Tour> tours,
                                                       ArrayList<Guia> guias,
                                                       ArrayList<Operador> operadores) {
        ArrayList<PaqueteTuristico> lista = new ArrayList<>();
        try (BufferedReader lector = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            lector.readLine();
            while ((linea = lector.readLine()) != null) {
                if (linea.isBlank()) continue;
                String[] c = linea.split(";");
                if (c.length == 6) {
                    int id       = Integer.parseInt(c[0].trim());
                    String nombre= c[1].trim();
                    int idTour   = Integer.parseInt(c[2].trim());
                    int idGuia   = Integer.parseInt(c[3].trim());
                    int idOp     = Integer.parseInt(c[4].trim());
                    int cupo     = Integer.parseInt(c[5].trim());

                    Tour t    = buscarTour(tours, idTour);
                    Guia g    = buscarGuia(guias, idGuia);
                    Operador o= buscarOperador(operadores, idOp);

                    if (t != null && g != null && o != null) {
                        lista.add(new PaqueteTuristico(id, nombre, t, g, o, cupo));
                    } else {
                        System.out.println("  ✘ Paquete ID " + id + ": referencia no encontrada.");
                    }
                }
            }
            System.out.println("  ✔ " + lista.size() + " paquetes cargados.");
        } catch (IOException e) {
            System.out.println("  ✘ Error al leer paquetes: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("  ✘ Error de formato en paquetes: " + e.getMessage());
        }
        return lista;
    }

    // ── Helpers privados ───────────────────────────────────────────────
    private Tour buscarTour(ArrayList<Tour> lista, int id) {
        for (Tour t : lista) if (t.getId() == id) return t;
        return null;
    }

    private Guia buscarGuia(ArrayList<Guia> lista, int id) {
        for (Guia g : lista) if (g.getId() == id) return g;
        return null;
    }

    private Operador buscarOperador(ArrayList<Operador> lista, int id) {
        for (Operador o : lista) if (o.getId() == id) return o;
        return null;
    }
}

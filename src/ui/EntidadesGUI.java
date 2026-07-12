package ui;

import data.GestorEntidades;
import model.ColaboradorExterno;
import model.GuiaTuristico;
import model.Vehiculo;

import javax.swing.JOptionPane;

/**
 * Interfaz gráfica básica (JOptionPane) para el ingreso y visualización
 * de entidades del sistema Llanquihue Tour: guías turísticos, vehículos
 * y colaboradores externos. No requiere persistencia; los datos viven
 * en memoria mientras se usa el programa.
 *
 * Semana 8 - Interfaz gráfica simple.
 */
public class EntidadesGUI {

    private final GestorEntidades gestor = new GestorEntidades();

    public void iniciar() {
        boolean continuar = true;

        while (continuar) {
            String menu = "===== LLANQUIHUE TOUR - Gestión de Entidades =====\n\n" +
                    "1. Ingresar Guía Turístico\n" +
                    "2. Ingresar Vehículo\n" +
                    "3. Ingresar Colaborador Externo\n" +
                    "4. Ver entidades registradas\n" +
                    "5. Salir";
            String entrada = JOptionPane.showInputDialog(null, menu, "Menú principal",
                    JOptionPane.PLAIN_MESSAGE);

            if (entrada == null) break; // el usuario cerró o canceló el diálogo

            switch (entrada.trim()) {
                case "1" -> ingresarGuia();
                case "2" -> ingresarVehiculo();
                case "3" -> ingresarColaborador();
                case "4" -> mostrarResumen();
                case "5" -> continuar = false;
                default -> JOptionPane.showMessageDialog(null, "Opción inválida.",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        JOptionPane.showMessageDialog(null, "Gestión de entidades finalizada.");
    }

    private void ingresarGuia() {
        try {
            String nombre = JOptionPane.showInputDialog("Nombre del guía:");
            if (nombre == null) return;
            String telefono = JOptionPane.showInputDialog("Teléfono:");
            if (telefono == null) return;
            String especialidad = JOptionPane.showInputDialog("Especialidad (ej: Trekking, Turismo cultural):");
            if (especialidad == null) return;
            String experienciaTxt = JOptionPane.showInputDialog("Años de experiencia:");
            if (experienciaTxt == null) return;
            int experiencia = Integer.parseInt(experienciaTxt.trim());

            GuiaTuristico guia = new GuiaTuristico(nombre, telefono, especialidad, experiencia);
            gestor.agregar(guia);
            JOptionPane.showMessageDialog(null, "Guía registrado:\n\n" + guia.mostrarResumen());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Los años de experiencia deben ser un número.",
                    "Error", JOptionPane.ERROR_MESSAGE);
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error de validación", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void ingresarVehiculo() {
        try {
            String patente = JOptionPane.showInputDialog("Patente:");
            if (patente == null) return;
            String tipo = JOptionPane.showInputDialog("Tipo de vehículo (ej: Van, Bus, Lancha):");
            if (tipo == null) return;
            String capacidadTxt = JOptionPane.showInputDialog("Capacidad (N° de pasajeros):");
            if (capacidadTxt == null) return;
            int capacidad = Integer.parseInt(capacidadTxt.trim());

            Vehiculo vehiculo = new Vehiculo(patente, tipo, capacidad);
            gestor.agregar(vehiculo);
            JOptionPane.showMessageDialog(null, "Vehículo registrado:\n\n" + vehiculo.mostrarResumen());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "La capacidad debe ser un número.",
                    "Error", JOptionPane.ERROR_MESSAGE);
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error de validación", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void ingresarColaborador() {
        try {
            String nombre = JOptionPane.showInputDialog("Nombre del colaborador:");
            if (nombre == null) return;
            String telefono = JOptionPane.showInputDialog("Teléfono:");
            if (telefono == null) return;
            String empresa = JOptionPane.showInputDialog("Empresa a la que pertenece:");
            if (empresa == null) return;
            String servicio = JOptionPane.showInputDialog("Servicio que presta (ej: Catering, Transporte):");
            if (servicio == null) return;

            ColaboradorExterno colaborador = new ColaboradorExterno(nombre, telefono, empresa, servicio);
            gestor.agregar(colaborador);
            JOptionPane.showMessageDialog(null, "Colaborador registrado:\n\n" + colaborador.mostrarResumen());
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error de validación", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void mostrarResumen() {
        gestor.mostrarTodas(); // también deja registro por consola, útil para el video
        JOptionPane.showMessageDialog(null, gestor.resumenComoTexto(), "Entidades registradas",
                JOptionPane.INFORMATION_MESSAGE);
    }
}

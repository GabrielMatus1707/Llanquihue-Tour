package ui;

import data.GestorEntidades;
import data.GestorReservas;
import exception.RutInvalidoException;
import model.Cliente;
import model.ColaboradorExterno;
import model.GuiaTuristico;
import model.PaqueteTuristico;
import model.Reserva;
import model.Vehiculo;

import javax.swing.JOptionPane;
import java.util.ArrayList;

/**
 * Interfaz gráfica básica (JOptionPane) para el ingreso y visualización
 * de entidades del sistema Llanquihue Tour: guías turísticos, vehículos,
 * colaboradores externos, clientes y reservas. No requiere persistencia;
 * los datos viven en memoria mientras se usa el programa.
 *
 * Semana 8: guías, vehículos, colaboradores.
 * EFT (Semana 9): se agregó ingreso de clientes (con validación de RUT
 * mediante excepción personalizada) y registro/cancelación de reservas
 * sobre los paquetes turísticos ya cargados desde archivos.
 */
public class EntidadesGUI {

    private final GestorEntidades gestor = new GestorEntidades();
    private final GestorReservas gestorReservas;
    private final ArrayList<PaqueteTuristico> paquetesDisponibles;

    public EntidadesGUI(GestorReservas gestorReservas, ArrayList<PaqueteTuristico> paquetesDisponibles) {
        this.gestorReservas = gestorReservas;
        this.paquetesDisponibles = paquetesDisponibles;
    }

    public void iniciar() {
        boolean continuar = true;

        while (continuar) {
            String menu = "===== LLANQUIHUE TOUR - Gestión de Entidades =====\n\n" +
                    "1. Ingresar Guía Turístico\n" +
                    "2. Ingresar Vehículo\n" +
                    "3. Ingresar Colaborador Externo\n" +
                    "4. Ingresar Cliente\n" +
                    "5. Registrar Reserva\n" +
                    "6. Cancelar última reserva\n" +
                    "7. Ver entidades registradas\n" +
                    "8. Ver historial de reservas\n" +
                    "9. Salir";
            String entrada = JOptionPane.showInputDialog(null, menu, "Menú principal",
                    JOptionPane.PLAIN_MESSAGE);

            if (entrada == null) break; // el usuario cerró o canceló el diálogo

            switch (entrada.trim()) {
                case "1" -> ingresarGuia();
                case "2" -> ingresarVehiculo();
                case "3" -> ingresarColaborador();
                case "4" -> ingresarCliente();
                case "5" -> registrarReserva();
                case "6" -> gestorReservas.cancelarUltimaReserva();
                case "7" -> mostrarResumen();
                case "8" -> mostrarHistorialReservas();
                case "9" -> continuar = false;
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

    private void ingresarCliente() {
        try {
            String nombre = JOptionPane.showInputDialog("Nombre del cliente:");
            if (nombre == null) return;
            String telefono = JOptionPane.showInputDialog("Teléfono:");
            if (telefono == null) return;
            String rutTexto = JOptionPane.showInputDialog("RUT (ej: 12.345.678-5):");
            if (rutTexto == null) return;
            String email = JOptionPane.showInputDialog("Email:");
            if (email == null) return;

            Cliente cliente = new Cliente(nombre, telefono, rutTexto, email);
            gestor.agregar(cliente);
            gestorReservas.registrarCliente(cliente);
            JOptionPane.showMessageDialog(null, "Cliente registrado:\n\n" + cliente.mostrarResumen());
        } catch (RutInvalidoException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "RUT inválido", JOptionPane.ERROR_MESSAGE);
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error de validación", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void registrarReserva() {
        try {
            if (paquetesDisponibles.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No hay paquetes turísticos disponibles.",
                        "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            String rutTexto = JOptionPane.showInputDialog("RUT del cliente (debe estar registrado):");
            if (rutTexto == null) return;
            String rutLimpio = rutTexto.replace(".", "").replace("-", "").trim().toUpperCase();
            String cuerpo = rutLimpio.substring(0, rutLimpio.length() - 1);
            Cliente cliente = gestorReservas.buscarClientePorRut(cuerpo);
            if (cliente == null) {
                JOptionPane.showMessageDialog(null, "No existe un cliente registrado con ese RUT.",
                        "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            StringBuilder listado = new StringBuilder("Paquetes disponibles:\n\n");
            for (PaqueteTuristico p : paquetesDisponibles) {
                listado.append("ID ").append(p.getId()).append(": ").append(p.getNombre()).append("\n");
            }
            String idTxt = JOptionPane.showInputDialog(listado + "\nIngrese el ID del paquete:");
            if (idTxt == null) return;
            int idPaquete = Integer.parseInt(idTxt.trim());

            PaqueteTuristico paqueteElegido = null;
            for (PaqueteTuristico p : paquetesDisponibles) {
                if (p.getId() == idPaquete) { paqueteElegido = p; break; }
            }
            if (paqueteElegido == null) {
                JOptionPane.showMessageDialog(null, "No existe un paquete con ese ID.",
                        "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String fecha = JOptionPane.showInputDialog("Fecha de la reserva (dd-mm-aaaa):");
            if (fecha == null) return;
            String personasTxt = JOptionPane.showInputDialog("Número de personas:");
            if (personasTxt == null) return;
            int personas = Integer.parseInt(personasTxt.trim());

            Reserva reserva = gestorReservas.registrarReserva(cliente, paqueteElegido, fecha, personas);
            JOptionPane.showMessageDialog(null, "Reserva registrada:\n\n" + reserva);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Debe ingresar un número válido.",
                    "Error", JOptionPane.ERROR_MESSAGE);
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error de validación", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void mostrarResumen() {
        gestor.mostrarTodas(); // también deja registro por consola, útil para el video
        JOptionPane.showMessageDialog(null, gestor.resumenComoTexto(), "Entidades registradas",
                JOptionPane.INFORMATION_MESSAGE);
    }

    private void mostrarHistorialReservas() {
        gestorReservas.mostrarHistorial(); // también deja registro por consola, útil para el video
        JOptionPane.showMessageDialog(null, "Se imprimió el historial de reservas en la consola.",
                "Historial de reservas", JOptionPane.INFORMATION_MESSAGE);
    }
}

# LlanquihueTourApp

## Descripción general

Sistema de gestión para la agencia de turismo **Llanquihue Tour**, Región de Los Lagos.
Prototipo modular en **Java** desarrollado de forma incremental en la asignatura
**Desarrollo Orientado a Objetos I** – Duoc UC, hasta la **Evaluación Final Transversal (EFT)**.

El sistema modela clientes, guías, operadores, vehículos, colaboradores externos,
tours, paquetes turísticos, servicios turísticos y reservas, aplicando
encapsulamiento, composición, colecciones (`ArrayList`, `HashMap`, `Stack`),
herencia, polimorfismo, interfaces y excepciones personalizadas.

---

## EFT – Semana 9: sistema completo

### Problemáticas del caso resueltas

| Problemática del caso | Solución implementada |
|---|---|
| Ausencia de categorización de personas (clientes no diferenciados) | Clase `Cliente`, que hereda de `Persona` e implementa `Registrable` |
| Datos duplicados / sin validación de integridad (ej. RUT) | Clase `Rut` con algoritmo de Módulo 11 + excepción personalizada `RutInvalidoException` |
| Gestión manual de reservas (correo/WhatsApp) | Clase `Reserva` (composición Cliente + PaqueteTuristico) gestionada por `GestorReservas` |
| Poca reutilización de estructuras | Jerarquías `Persona`/`ServicioTuristico`, interfaz `Registrable`, sobrecarga de constructores en `Reserva` |
| Falta de trazabilidad de paquetes turísticos | `PaqueteTuristico` (composición con `Tour`, `Guia`, `Operador`) + historial de reservas |

### Clases e interfaces nuevas de la EFT

| Clase / Interfaz | Paquete | Descripción |
|---|---|---|
| `RutInvalidoException` | exception | Excepción personalizada (checked) para RUT inválido |
| `Rut` | model | Valida y formatea un RUT chileno (Módulo 11); composición dentro de `Cliente` |
| `Cliente` | model | Hereda de `Persona`, implementa `Registrable`; agrega `rut` y `email` |
| `Reserva` | model | Composición de `Cliente` + `PaqueteTuristico`; **constructores sobrecargados** (con/sin número de personas) |
| `GestorReservas` | data | Usa `HashMap<String, Cliente>` (búsqueda de cliente por RUT), `ArrayList<Reserva>` (historial) y `Stack<Reserva>` (deshacer/cancelar la última reserva) |

`GestorDatos` se extendió con `cargarClientes()`, que lee `clientes.txt` y captura
`RutInvalidoException` fila por fila sin detener la carga del resto del archivo.
`EntidadesGUI` se extendió con las opciones **Ingresar Cliente**, **Registrar Reserva**
y **Cancelar última reserva**, y `Cliente` se integra a la misma colección
polimórfica `ArrayList<Registrable>` que ya usaban guías, vehículos y colaboradores.

### Estructuras de datos utilizadas (Paso 3 de la pauta)

- `ArrayList`: tours, guías, operadores, paquetes, clientes, servicios, entidades registrables, historial de reservas.
- `HashMap<String, Cliente>`: búsqueda de clientes por RUT en tiempo O(1), evitando duplicados.
- `Stack<Reserva>`: pila de las últimas reservas, usada para cancelar/deshacer la más reciente.

### Jerarquías, interfaces y polimorfismo (Paso 4 de la pauta)

```
Registrable                 (interfaz → mostrarResumen())
        ▲
        │ implementa
Persona                     (clase abstracta: nombre, telefono)
├── GuiaTuristico            → especialidad, experienciaAnios
├── ColaboradorExterno       → empresa, servicioPrestado
└── Cliente                  → rut (Rut), email                (nueva EFT)

Vehiculo                     → implementa Registrable directamente

ServicioTuristico            (superclase: nombre, duracionHoras)
├── RutaGastronomica         → numeroDeParadas
├── PaseoLacustre            → tipoEmbarcacion
└── ExcursionCultural        → lugarHistorico
```

`GestorEntidades` almacena `Cliente`, `GuiaTuristico`, `Vehiculo` y `ColaboradorExterno`
en una única colección `ArrayList<Registrable>`, y usa `instanceof` para diferenciar
el tipo concreto de cada objeto al recorrerla.

---

## Historial de semanas anteriores

### Semana 6 – Jerarquías de clases con herencia simple
`ServicioTuristico` como superclase y `RutaGastronomica`, `PaseoLacustre`,
`ExcursionCultural` como subclases, cada una usando `super()` y sobrescribiendo `toString()`.

### Semana 8 – Interfaces, polimorfismo y estructuras dinámicas
Interfaz `Registrable`, clase abstracta `Persona`, subclases `GuiaTuristico` y
`ColaboradorExterno`, clase `Vehiculo` (implementa `Registrable` directamente),
`GestorEntidades` con `ArrayList<Registrable>` e `instanceof`, y GUI `EntidadesGUI`
con `JOptionPane`.

---

## Estructura del proyecto

```
Llanquihue-Tour-S9/
├── src/
│   ├── model/
│   │   ├── Rut.java                 ← nueva EFT
│   │   ├── Cliente.java             ← nueva EFT
│   │   ├── Reserva.java             ← nueva EFT
│   │   ├── Registrable.java         (S8)
│   │   ├── Persona.java             (S8)
│   │   ├── GuiaTuristico.java       (S8)
│   │   ├── ColaboradorExterno.java  (S8)
│   │   ├── Vehiculo.java            (S8)
│   │   ├── ServicioTuristico.java   (S6)
│   │   ├── RutaGastronomica.java    (S6)
│   │   ├── PaseoLacustre.java       (S6)
│   │   ├── ExcursionCultural.java   (S6)
│   │   ├── Tour.java                (S5)
│   │   ├── Guia.java                (S5)
│   │   ├── Operador.java            (S5)
│   │   └── PaqueteTuristico.java    (S5)
│   ├── exception/
│   │   └── RutInvalidoException.java ← nueva EFT
│   ├── data/
│   │   ├── GestorReservas.java      ← nueva EFT (HashMap + Stack)
│   │   ├── GestorEntidades.java     (S8)
│   │   ├── GestorServicios.java     (S6)
│   │   └── GestorDatos.java         (S5, extendido con cargarClientes)
│   ├── service/
│   │   └── GestorTour.java          (S5)
│   └── ui/
│       ├── EntidadesGUI.java        (S8, extendida con Cliente/Reserva)
│       └── Main.java                (actualizada EFT)
└── resources/
    ├── tours.txt
    ├── guias.txt
    ├── operadores.txt
    ├── paquetes.txt
    └── clientes.txt                 ← nuevo EFT
```

---

## Instrucciones para clonar y ejecutar

### Requisitos
- Java JDK 17 o superior
- IntelliJ IDEA (recomendado)

### Clonar
```bash
git clone <URL-del-repositorio>
```

### En IntelliJ IDEA
1. Abre la carpeta del proyecto.
2. Marca `src/` como **Sources Root**.
3. Ejecuta la clase `ui.Main`.
4. El programa primero carga y muestra por consola los datos desde los archivos
   `.txt` (tours, guías, operadores, paquetes, clientes), luego muestra el
   listado de servicios turísticos y las reservas de ejemplo, y finalmente abre
   la ventana de gestión (`EntidadesGUI`), donde puedes ingresar guías,
   vehículos, colaboradores y clientes, registrar y cancelar reservas, y ver
   los resúmenes generados.

### Desde consola
```bash
javac -encoding UTF-8 -d out $(find src -name "*.java")
java -cp out ui.Main
```

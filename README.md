# LlanquihueTourApp

## Descripción general

Sistema de gestión para la agencia de turismo **Llanquihue Tour**, Región de Los Lagos.  
Proyecto incremental desarrollado en la asignatura **Desarrollo Orientado a Objetos I** – Duoc UC.

---

## Semana 6 – Jerarquías de clases con herencia simple

### Objetivo
Implementar una jerarquía de clases que permita modelar distintos tipos de servicios turísticos, reutilizando atributos comunes mediante herencia y especializando cada subclase con sus propios atributos.

### Clases creadas / modificadas esta semana

| Clase | Paquete | Tipo | Descripción |
|---|---|---|---|
| `ServicioTuristico` | model | Superclase | Atributos comunes: `nombre` y `duracionHoras` |
| `RutaGastronomica` | model | Subclase | Hereda de `ServicioTuristico`; agrega `numeroDeParadas` |
| `PaseoLacustre` | model | Subclase | Hereda de `ServicioTuristico`; agrega `tipoEmbarcacion` |
| `ExcursionCultural` | model | Subclase | Hereda de `ServicioTuristico`; agrega `lugarHistorico` |
| `GestorServicios` | data | Clase de datos | Crea 2 instancias de prueba de cada subclase |
| `Main` | ui | Clase principal | Muestra todos los servicios por consola vía `toString()` |

### Jerarquía de herencia

```
ServicioTuristico          (superclase)
├── RutaGastronomica       → atributo propio: numeroDeParadas
├── PaseoLacustre          → atributo propio: tipoEmbarcacion
└── ExcursionCultural      → atributo propio: lugarHistorico
```

Cada subclase usa `super(nombre, duracionHoras)` en su constructor y sobrescribe `toString()`.

---

## Semana 8 – Interfaces, polimorfismo y estructuras dinámicas

### Objetivo
Ampliar el sistema para gestionar nuevas entidades (guías turísticos, vehículos, colaboradores externos) mediante un contrato de comportamiento común (interfaz `Registrable`), aplicando herencia, polimorfismo, validación de tipos con `instanceof` y una interfaz gráfica básica de ingreso y visualización.

### Clases e interfaces creadas esta semana

| Clase / Interfaz | Paquete | Tipo | Descripción |
|---|---|---|---|
| `Registrable` | model | Interfaz | Declara el método `mostrarResumen()`; contrato común de todas las entidades gestionables |
| `Persona` | model | Clase abstracta | Superclase con atributos comunes `nombre` y `telefono` |
| `GuiaTuristico` | model | Subclase | Hereda de `Persona`, implementa `Registrable`; agrega `especialidad` y `experienciaAnios` |
| `ColaboradorExterno` | model | Subclase | Hereda de `Persona`, implementa `Registrable`; agrega `empresa` y `servicioPrestado` |
| `Vehiculo` | model | Clase | Implementa `Registrable` directamente (no es una `Persona`); agrega `patente`, `tipo` y `capacidad` |
| `GestorEntidades` | data | Clase de datos | Colección `ArrayList<Registrable>`; recorre con for-each y usa `instanceof` para diferenciar tipos |
| `EntidadesGUI` | ui | Interfaz gráfica | GUI con `JOptionPane` para ingresar y visualizar guías, vehículos y colaboradores |
| `Main` | ui | Clase principal | Muestra los servicios turísticos (S6) y luego abre `EntidadesGUI` |

### Jerarquía de interfaces y herencia (Semana 8)

```
Registrable                 (interfaz → mostrarResumen())
        ▲
        │ implementa
Persona                     (clase abstracta: nombre, telefono)
├── GuiaTuristico            → implementa Registrable; atributos: especialidad, experienciaAnios
└── ColaboradorExterno       → implementa Registrable; atributos: empresa, servicioPrestado

Vehiculo                     → implementa Registrable directamente (patente, tipo, capacidad)
```

`GestorEntidades` almacena todas estas clases en una única colección `ArrayList<Registrable>` y usa `instanceof` para diferenciar el tipo concreto de cada objeto al recorrerla.

---

## Estructura del proyecto

```
Llanquihue-Tour/
├── src/
│   ├── model/
│   │   ├── Registrable.java         ← interfaz         (nueva S8)
│   │   ├── Persona.java             ← clase abstracta  (nueva S8)
│   │   ├── GuiaTuristico.java       ← subclase         (nueva S8)
│   │   ├── ColaboradorExterno.java  ← subclase         (nueva S8)
│   │   ├── Vehiculo.java            ← implementa Registrable (nueva S8)
│   │   ├── ServicioTuristico.java   (S6)
│   │   ├── RutaGastronomica.java    (S6)
│   │   ├── PaseoLacustre.java       (S6)
│   │   ├── ExcursionCultural.java   (S6)
│   │   ├── Tour.java                (S5)
│   │   ├── Guia.java                (S5)
│   │   ├── Operador.java            (S5)
│   │   └── PaqueteTuristico.java    (S5)
│   ├── data/
│   │   ├── GestorEntidades.java     ← colección Registrable (nueva S8)
│   │   ├── GestorServicios.java     (S6)
│   │   └── GestorDatos.java         (S5)
│   ├── service/
│   │   └── GestorTour.java          (S5)
│   └── ui/
│       ├── EntidadesGUI.java        ← GUI con JOptionPane (nueva S8)
│       └── Main.java                ← actualizada S8
└── resources/
    ├── tours.txt
    ├── guias.txt
    ├── operadores.txt
    └── paquetes.txt
```

---

## Instrucciones para ejecutar

### Requisitos
- Java JDK 11 o superior
- IntelliJ IDEA (recomendado)

### En IntelliJ IDEA
1. Abre la carpeta del proyecto.
2. Marca `src/` como **Sources Root**.
3. Ejecuta la clase `ui.Main`.
4. El programa primero muestra por consola el listado de servicios turísticos y luego abre la ventana de gestión de entidades (`EntidadesGUI`), donde puedes ingresar guías, vehículos y colaboradores, y ver el resumen de todos los registrados.

### Desde consola
```bash
javac -encoding UTF-8 -d out src/model/*.java src/data/*.java src/service/*.java src/ui/*.java
java -cp out ui.Main
```

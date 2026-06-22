# LlanquihueTourApp

## Descripción del sistema

Sistema de gestión para la agencia de turismo **Llanquihue Tour**, ubicada en la Región de Los Lagos. Permite registrar, visualizar, buscar y filtrar información de tours, guías turísticos, operadores y paquetes turísticos, leyendo los datos desde archivos de texto y almacenándolos en colecciones dinámicas.

Desarrollado como proyecto de la asignatura **Desarrollo Orientado a Objetos I** – Duoc UC.  
**Semana 5:** ampliación del proyecto de Semana 3, incorporando nuevas clases, composición entre objetos, paquete `service` y validaciones con `try-catch`.

---

## Estructura del proyecto

```
Llanquihue-Tour/
├── src/
│   ├── model/
│   │   ├── Tour.java              → Entidad tour (mejorada desde S3: id, duracion, validaciones)
│   │   ├── Guia.java              → Entidad guía turístico (nueva en S5)
│   │   ├── Operador.java          → Entidad operador de servicios (nueva en S5)
│   │   └── PaqueteTuristico.java  → Paquete con composición de Tour + Guia + Operador (nueva S5)
│   ├── data/
│   │   └── GestorDatos.java       → Lectura de archivos .txt con BufferedReader
│   ├── service/
│   │   └── GestorTour.java        → Lógica de negocio: mostrar, filtrar y buscar (nuevo en S5)
│   └── ui/
│       └── Main.java              → Clase principal, punto de entrada del programa
└── resources/
    ├── tours.txt                  → Datos de tours (formato: id;nombre;tipo;precio;duracion)
    ├── guias.txt                  → Datos de guías
    ├── operadores.txt             → Datos de operadores
    └── paquetes.txt               → Datos de paquetes con referencias a IDs
```

## Paquetes y clases

| Clase | Paquete | Descripción |
|---|---|---|
| `Tour` | model | Entidad con atributos privados, getters/setters con validación y `toString()` |
| `Guia` | model | Guía turístico con especialidad y años de experiencia |
| `Operador` | model | Operador de transporte o excursiones |
| `PaqueteTuristico` | model | **Composición** con `Tour`, `Guia` y `Operador` |
| `GestorDatos` | data | Lee archivos `.txt` con `BufferedReader`; maneja errores con `try-catch` |
| `GestorTour` | service | Gestiona `ArrayList<T>`: muestra, filtra y busca registros |
| `Main` | ui | Punto de entrada; orquesta carga y visualización |

---

## Instrucciones para ejecutar

### Requisitos
- Java JDK 11 o superior
- IntelliJ IDEA (recomendado)

### En IntelliJ IDEA
1. Abre la carpeta del proyecto como proyecto Java existente.
2. Marca la carpeta `src/` como **Sources Root**.
3. En *Run > Edit Configurations*, establece el **Working Directory** en la raíz del proyecto (donde está la carpeta `resources/`).
4. Ejecuta la clase `ui.Main`.

### Desde consola
```bash
# Compilar (desde la raíz del proyecto)
javac -encoding UTF-8 -d out src/model/*.java src/data/*.java src/service/*.java src/ui/*.java

# Ejecutar
java -cp out ui.Main
```

---

## Funcionalidades

- ✅ Carga de datos desde archivos `.txt` separados por `;`
- ✅ Almacenamiento en `ArrayList<T>` con tipos genéricos
- ✅ Cuatro entidades con atributos `private`, constructores, getters/setters y `toString()`
- ✅ Validaciones con `try-catch` en lectura de archivos y en setters
- ✅ Composición: `PaqueteTuristico` contiene `Tour`, `Guia` y `Operador`
- ✅ Filtrado de tours por tipo y por precio
- ✅ Filtrado de guías por años de experiencia
- ✅ Búsqueda de tours por nombre
- ✅ Visualización completa por consola

---

*Proyecto desarrollado para Duoc UC – Desarrollo Orientado a Objetos I*

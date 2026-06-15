# LlanquihueTourApp

## Descripción

Sistema de gestión de tours para la agencia **Llanquihue Tour**, ubicada en la comuna de Llanquihue, Región de Los Lagos. La aplicación lee los datos de los tours desde un archivo `.txt`, instancia objetos de la clase `Tour` y los almacena en un `ArrayList`. Permite recorrer la colección completa y filtrar tours por tipo o precio.

## Estructura de carpetas

```
LlanquihueTourApp/
├── src/
│   ├── model/
│   │   └── Tour.java          # Clase que modela un tour
│   ├── data/
│   │   └── GestorDatos.java   # Lectura del archivo y carga en ArrayList
│   └── ui/
│       └── Main.java          # Clase principal con recorrido y filtros
└── resources/
    └── tours.txt              # Datos de los tours separados por ";"
```

## Instrucciones para ejecutar la clase Main

1. Abre el proyecto en **IntelliJ IDEA**.
2. Asegúrate de que la carpeta `resources/` esté marcada como **Resources Root** (clic derecho → Mark Directory as → Resources Root).
3. Ejecuta la clase `ui/Main.java` haciendo clic en el botón ▶ o con `Shift + F10`.
4. La salida en consola mostrará:
   - El catálogo completo de tours.
   - Los tours filtrados por tipo "cultural".
   - Los tours filtrados por precio mayor a $40.000.

# DrumFest'24: Sistema de Gestión de Bandas Musicales

## Descripción del Sistema

El sistema desarrollado tiene como objetivo la gestión eficiente del registro de bandas musicales participantes en **DrumFest'24**, un festival temático centrado en la batería acústica y el mundo de la percusión.

La solución implementa el patrón de diseño **Modelo-Vista-Controlador (MVC)**, garantizando una separación clara entre la lógica, la presentación y la interacción con el usuario.

## Características Principales

El sistema incluye las siguientes funcionalidades clave:

- **Registro de nuevas bandas**: Permite registrar la información esencial, incluyendo nombre, género, relevancia, número de miembros y baterista principal.
- **Listado de bandas**: Muestra los datos registrados de manera estructurada.
- **Exportación de datos**: Guarda los registros en formato CSV para su integración con otras herramientas.
- **Importación de datos**: Carga registros desde un archivo CSV.
- **Eliminación de registros**: Elimina bandas previamente registradas.
- **Selección de relevancia artística**: Define la importancia de la banda dentro del festival mediante una enumeración.

## Ejemplo de Funcionamiento

### Registro de Bandas

```plaintext
Seleccione la opción deseada:
1
Introduzca la banda deseada:
----------------------------
Nombre: Red Hot Chili Peppers
Género: Funk Rock
Relevancia Artista
1.- cabeza_cartel
2.- invitada
3.- telonera
4.- principal
Seleccione la opción deseada: 1
Número de miembros: 4
Nombre Baterista: Chad Smith
[32m¡Banda registrada correctamente![0m
→ Registro de nueva entrada ←
¿Desea continuar? (S/N)
s
Nombre:Muse
Género:Art Rock
Relevancia Artista
1.- cabeza_cartel
2.- invitada
3.- telonera
4.- principal
Seleccione la opción deseada:
1
Número de miembros:3
Nombre Baterista:Dominic Howard
[32m¡Banda registrada correctamente![0m
→ Registro de nueva entrada ←
¿Desea continuar? (S/N)
n
```

### Listado de Bandas

```plaintext

2
                                      • Cartel DrumFest'24 •
                                      ----------------------

                Nombre               Género             Relevancia       Miembros         Baterista
1. [36m    Red Hot Chili        Funk Rock            CABEZA_CARTEL         4         Chad Smith    [0m
2. [36m    Muse                 Art Rock             CABEZA_CARTEL         3         Dominic Howard[0m
```

### Exportación de datos

```plaintext

3
[33m ***¡ATENCIÓN!*** ¡Sobrescribirá los registros exportados anteriormente! [0m
¿Desea continuar? (S/N)
s
[32m ✓ Exportación realizada [0m
```

### Eliminación de bandas

```plaintext

5
[33m ***¡ATENCIÓN!*** ¡Se borrarán todas las bandas! [0m
¿Desea continuar? (S/N)
s
[32m ✓ Todas las bandas han sido eliminadas [0m
```

### Importación de datos

```plaintext

4
[33m ***¡ATENCIÓN!*** ¡Perderá los registros no exportados! [0m
¿Desea continuar? (S/N)
s
[32m ✓ Importación realizada ⇾ [0mRed Hot Chili Peppers#Funk Rock#CABEZA_CARTEL#4#Chad Smith
[32m ✓ Importación realizada ⇾ [0mMuse#Art Rock#CABEZA_CARTEL#3#Dominic Howard
```

### Scripts

## **compilar**

Compila los archivos fuente del proyecto:

- Verifica la presencia de dependencias (`JUnit`).
- Genera los archivos `.class` en la carpeta `bin`.

## **documentar**

Genera documentación en HTML con `javadoc`:

- Configura enlaces a Java SE 21 y JUnit 5.
- Salida almacenada en `doc`.

## **doxumentar**

Crea documentación técnica con `Doxygen`:

- Genera diagramas y detalles técnicos en `dox`.
- Registra errores en `doxumentar.log`.

## **ejecutar**

Ejecuta el programa principal desde consola:

- Llama a la clase principal `ControlBandas`.

## **limpiar**

Elimina carpetas generadas (`bin`, `doc`, `dox`, `dist`) para limpieza.

## **probar**

Ejecuta pruebas unitarias con `JUnit`:

- Corre todas las clases de prueba (`.*Test.*`).
- Muestra resultados en consola.

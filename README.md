<div align="center">

# DrumFest - Gestión de Bandas Musicales

## Descripción
</div>
La aplicación desarrollada tiene como objetivo la gestión eficiente del registro de bandas musicales participantes en **DrumFest'24**, un festival temático centrado en la batería acústica y el mundo de la percusión.

La solución implementa el patrón de diseño **Modelo-Vista-Controlador**, garantizando una separación clara entre la lógica, presentación e interacción con el usuario.
<div align="center">

## Características Principales
</div>

- **Introducción de nuevos registros**: permite registrar la información esencial de cada elemento.
- **Listado de elementos registrados**: muestra los datos almacenados de manera estructurada.
- **Exportación e importación de datos**: posibilita guardar y cargar la información en formato CSV, facilitando la integración con otras herramientas.
- **Eliminación de registros**: permite eliminar los registros almacenados.

<div align="center">

## Ejemplo de Funcionamiento

### Registro de Bandas
</div>

```plaintext
~ DrumFest'24 ~
===============
1.- Introducir bandas
2.- Listar bandas
3.- Exportar bandas
4.- Importar bandas
5.- Borrar bandas
6.- Acerca de...
7.- Salir
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
✅ ¡Banda registrada correctamente!
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
✅ ¡Banda registrada correctamente!
→ Registro de nueva entrada ←
¿Desea continuar? (S/N)
n

```
<div align="center">

### Listado de Bandas
</div>

```plaintext
2
                                      • Cartel DrumFest'24 •
                                      ----------------------

                Nombre               Género             Relevancia       Miembros         Baterista
1.  🎸    Red Hot Chili        Funk Rock            CABEZA_CARTEL         4         Chad Smith
2.  🎸    Muse                 Art Rock             CABEZA_CARTEL         3         Dominic Howard

```

<div align="center">

### Exportación de datos
</div>

```plaintext
3
⚠️ ***¡ATENCIÓN!*** ¡Sobrescribirá los registros exportados anteriormente!
¿Desea continuar? (S/N)
s
✅ ✓ Exportación realizada

```
<div align="center">

### Eliminación de bandas
</div>

```plaintext
5
⚠️ ***¡ATENCIÓN!*** ¡Se borrarán todas las bandas!
¿Desea continuar? (S/N)
s
✅ ✓ Todas las bandas han sido eliminadas

```
<div align="center">

### Importación de datos
</div>

```plaintext
4
⚠️ ***¡ATENCIÓN!*** ¡Perderá los registros no exportados!
¿Desea continuar? (S/N)
s
✅ ✓ Importación realizada ⇾ Red Hot Chili Peppers#Funk Rock#CABEZA_CARTEL#4#Chad Smith
✅ ✓ Importación realizada ⇾ Muse#Art Rock#CABEZA_CARTEL#3#Dominic Howard

```

<div align="center">

## Scripts
</div>

#### **compilar**

Compila los archivos fuente del proyecto:

- Verifica la presencia de dependencias (`JUnit`).
- Genera los archivos `.class` en la carpeta `bin`.

#### **documentar**

Genera documentación en HTML con `javadoc`:

- Configura enlaces a Java SE 21 y JUnit 5.
- Salida almacenada en `doc`.

#### **doxumentar**

Crea documentación técnica con `Doxygen`:

- Genera diagramas y detalles técnicos en `dox`.
- Registra errores en `doxumentar.log`.

#### **ejecutar**

Ejecuta el programa principal desde consola:

- Llama a la clase principal `ControlBandas`.

#### **limpiar**

Elimina carpetas generadas (`bin`, `doc`, `dox`, `dist`) para limpieza.

#### **probar**

Ejecuta pruebas unitarias con `JUnit`:

- Corre todas las clases de prueba (`.*Test.*`).
- Muestra resultados en consola.

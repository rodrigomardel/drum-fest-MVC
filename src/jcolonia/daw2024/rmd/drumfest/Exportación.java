package jcolonia.daw2024.rmd.drumfest;

import static java.lang.System.out;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

/**
 * Exportación de un listado de cadenas de texto a un archivo en el directorio
 * raíz del proyecto.
 * 
 * @author Rodrigo Martínez Delgado &lt;rodrigo.mardel.daw@gmail.com&gt;
 * @version 3.0 (20240425)
 */
public class Exportación {

	/** Entrada estándar. */
	private Scanner entrada;
	/** Ruta completa del archivo de texto. */
	private static final String NOMBRE_PREDETERMINADO = "bandas.txt";
	/** Color amarillo de alerta para la salida de texto por consola. */
	private static final String YELLOW = "\u001B[33m";
	/** Color verde de confirmación para la salida de texto por consola. */
	private static final String GREEN = "\u001B[32m";
	/** Secuencia de escape ANSI para resetear el estilo. */
	private static final String RESET = "\u001B[0m";

	/**
	 * Inicializa la entrada estándar.
	 */
	public Exportación() {
		entrada = new Scanner(System.in);
	}

	/**
	 * Exporta los elementos introducidos a un archivo, advirtiendo al usuario que
	 * dicha acción puede sobrescribir los exportados anteriormente.
	 * 
	 * @param elementos lista de cadenas de texto a exportar
	 */
	public void exportar(List<String> elementos) {
		VistaGeneral vistaGeneral = new VistaGeneral("Exportar", entrada);
		String nombreArchivo = NOMBRE_PREDETERMINADO;
		Path refArchivo = Path.of(nombreArchivo);

		try {
			if (elementos.isEmpty()) {
				out.printf("%s *** No hay ninguna nota para exportar %s %n", YELLOW, RESET);
			} else if (vistaGeneral.pedirConfirmación()) {
				Files.deleteIfExists(refArchivo);
				Path archivo = Files.createFile(refArchivo);

				try (PrintWriter out = new PrintWriter(Files.newBufferedWriter(archivo));) {
					for (int i = 0; i < elementos.size(); i++) {
						out.printf("%s %n", elementos.get(i));
					}
				}
				out.printf("%s ✓ Exportación realizada %s %n", GREEN, RESET);
			} else {
				out.printf("%s ✕ Exportación NO realizada %s %n", YELLOW, RESET);
			}
		} catch (NoSuchFileException e) {
			System.err.printf("Ruta no encontrada: %s %n", e.getLocalizedMessage());
		} catch (IOException e) {
			System.err.printf("Error de escritura: %s %n", e.getLocalizedMessage());
		}
	}
}

package jcolonia.daw2024.rmd.drumfest;

import java.util.List;

import static java.lang.System.out;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.NoSuchFileException;

/**
 * Importación de un archivo a un listado de cadenas de texto.
 * 
 * @author Rodrigo Martínez Delgado &lt;rodrigo.mardel.daw@gmail.com&gt;
 * @version 3.1 (20240423)
 */
public class Importación {

	/**
	 * Inicializa una nueva instancia, no inicializa atributos ni recibe parámetros.
	 * Se utiliza para crear un objeto básico sin estado inicial específico.
	 */
	public Importación() {
	}

	/**
	 * Importa las líneas del archivo a un listado de cadenas de texto.
	 * 
	 * @param archivoImportar referencia del archivo
	 * @param elementos       listado de elementos en el cual se añaden las cadenas
	 *                        de texto leídas
	 * @return elementos listado con las nuevas líneas añadidas
	 */
	public List<String> importar(String archivoImportar, List<String> elementos) {
		String nombreArchivo = archivoImportar;
		boolean salir = false;
		String línea;

		File refArchivo = new File(nombreArchivo);

		try (BufferedReader archivo = new BufferedReader(new FileReader(refArchivo));) {
			do {
				línea = archivo.readLine();
				if (línea == null) {
					salir = true;
				} else {
					elementos.add(línea);
					out.println("\u001B[32m ✓ Importación realizada ⇾ \u001B[0m" + línea);
				}
			} while (!salir);

		} catch (NoSuchFileException e) {
			System.err.printf("Ruta no encontrada: %s %n", e.getLocalizedMessage());
		} catch (IOException e) {
			System.err.printf("Error de lectura: %s %n", e.getLocalizedMessage());
		}
		return elementos;
	}
}

package jcolonia.daw2024.rmd.drumfest;

import static java.lang.System.out;

import java.util.List;
import java.util.Scanner;

/**
 * Vista del listado de un conjunto de elementos en forma de («<em>array</em>»)
 * de cadenas de texto.
 * 
 * @author Rodrigo Martínez Delgado &lt;rodrigo.mardel.daw@gmail.com&gt;
 * @version 2.0 (20240423)
 */
public class VistaListado extends VistaGeneral {

	/** Nombre del menú. */
	private String nombre;
	/** Color celeste para datos en la salida de texto por consola. */
	private static final String CYAN = "\u001B[36m";
	/** Secuencia de escape ANSI para resetear el estilo. */
	private static final String RESET = "\u001B[0m";
	/** Cabecera listado. */
	private static final String[] CABECERA_LISTADO = { "Nombre", "Género", "Relevancia", "Miembros", "Baterista" };

	/**
	 * Inicializa y asigna el nombre del menú.
	 * 
	 * @param nombre  nombre deseado
	 * @param entrada entrada de usuario
	 */
	public VistaListado(String nombre, Scanner entrada) {
		super(nombre, entrada);
		this.nombre = nombre;
	}

	/**
	 * Muestra el título asignado para el menú.
	 */
	public void mostrarTítulo() {
		out.printf("                                      %s%n", nombre);
		out.print("                                      -");
		for (int i = 0; i < nombre.length() - 1; i++) {
			out.print("-");
		}
		out.println();
		out.println();
	}

	/**
	 * Muestra la cabecera del listado.
	 */
	public void mostrarCabecera() {
		out.printf("           %-14.14s       %-14.14s     %-14.14s   %-14.14s   %-14.14s %n", CABECERA_LISTADO[0],
				CABECERA_LISTADO[1], CABECERA_LISTADO[2], CABECERA_LISTADO[3], CABECERA_LISTADO[4]);
	}

	/**
	 * Muestra el listado de los elementos del conjunto.
	 * 
	 * @param elemento elementos deseados
	 */
	public void listar(List<String> elemento) {
		for (int i = 0; i < elemento.size(); i++) {
			out.printf("%d. %s %n", i + 1, elemento.get(i));
		}
	}

	/**
	 * Muestra información general acerca de la aplicación y su desarrollador.
	 */
	public void acercaDe() {
		out.printf(
				"%s © DrumFest'24 v1.0 %n Aplicación para el registro y gestión de las bandas que conforman el nuevo festival de las/os %n mejores bateristas en el panorama nacional e internacional. %n Rodrigo Martínez Delgado - rodrigo.mardel.daw@gmail.com - 20241120 %s %n",
				CYAN, RESET);
	}

}

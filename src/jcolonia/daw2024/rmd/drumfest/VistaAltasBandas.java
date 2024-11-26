package jcolonia.daw2024.rmd.drumfest;

import static java.lang.System.out;

import java.util.Scanner;
import java.util.Vector;

/**
 * Vista para la introducción de bandas musicales.
 * 
 * @author Rodrigo Martínez Delgado &lt;rodrigo.mardel.daw@gmail.com&gt;
 * @version 1.0 (20240423)
 */
public class VistaAltasBandas extends VistaGeneral {

	/** Nombre de la vista. */
	private String nombre;

	/**
	 * Inicializa y asigna el nombre del menú y la entrada recibida.
	 * 
	 * @param nombre  nombre deseado
	 * @param entrada entrada de usuario
	 */
	public VistaAltasBandas(String nombre, Scanner entrada) {
		super(nombre, entrada);
		this.nombre = nombre;

	}

	/**
	 * Almacena las altas introducidas en el conjunto de elementos «{@link Banda}»
	 * que van a participar en el conjunto «{@link Festival}».
	 * 
	 * @return conjuntoAltasBandas conjunto de altas introducidas
	 */
	public Vector<Banda> introducirAltas() {
		Scanner in = getScEntrada();
		VistaAltaRelevancia vistaRelevancia = new VistaAltaRelevancia("Relevancia Artista", in);
		Vector<Banda> conjuntoAltasBandas = new Vector<Banda>();
		boolean salir = false;
		Banda banda;

		do {
			banda = new Banda();
			banda.setNombre(leerTexto("Nombre:"));
			banda.setGénero(leerTexto("Género:"));
			vistaRelevancia.mostrarTítulo();
			Relevancia relevanciaElegida = vistaRelevancia.introducirRelevancia();
			banda.setRelevancia(relevanciaElegida);
			banda.setMiembros(leerNúmero("Número de miembros:"));
			banda.setBaterista(leerTexto("Nombre Baterista:"));
			conjuntoAltasBandas.add(banda);
			out.println("\u001B[32m¡Banda registrada correctamente!\u001B[0m");
			out.println("→ Registro de nueva entrada ←");
			if (pedirConfirmación() == false) {
				salir = true;
			}
		} while (!salir);
		return conjuntoAltasBandas;
	}

	/**
	 * Muestra el título asignado para el menú.
	 */
	public void mostrarTítulo() {
		out.println(nombre);
		for (int i = 0; i < nombre.length(); i++) {
			out.print("-");
		}
		out.println();
	}

}

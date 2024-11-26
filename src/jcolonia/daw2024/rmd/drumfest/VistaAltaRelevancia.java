package jcolonia.daw2024.rmd.drumfest;

import static java.lang.System.out;

import java.util.Scanner;

/**
 * Vista para el registro de la relevancia de los artistas dentro del festival,
 * empleando valores obtenidos de la enumeración «{@link Relevancia}».
 * 
 * @see Relevancia
 * @author Rodrigo Martínez Delgado &lt;rodrigo.mardel.daw@gmail.com&gt;
 * @version 1.0 (20240423)
 */
public class VistaAltaRelevancia extends VistaGeneral {

	/** Nombre del menú. */
	private String nombre;

	/**
	 * Inicializa y asigna el nombre del menú junto con la entrada estándar.
	 * 
	 * @param nombre    nombre deseada para la vista
	 * @param scEntrada entrada estándar
	 */
	public VistaAltaRelevancia(String nombre, Scanner scEntrada) {
		super(nombre, scEntrada);
		this.nombre = nombre;
	}

	/**
	 * Muestra el título asignado para el menú.
	 */
	public void mostrarTítulo() {
		out.println(nombre);
	}

	/**
	 * Muestra las opciones para seleccionar la relevencia del artista.
	 * 
	 * @return relevancia relevancia correspondiente
	 */
	public Relevancia introducirRelevancia() {
		VistaMenú menúRelevancia;

		int opción;
		Scanner in = getScEntrada();

		Relevancia relevancia;
		menúRelevancia = new VistaMenú("Relevancia Artista:", Relevancia.getNames(), in);

		menúRelevancia.mostrarMenú();
		opción = menúRelevancia.pedirOpción();
		relevancia = Relevancia.values()[opción - 1];

		return relevancia;
	}

}

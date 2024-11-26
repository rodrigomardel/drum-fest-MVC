package jcolonia.daw2024.rmd.drumfest;

import static java.lang.System.out;
import static java.lang.System.err;

import java.util.Scanner;

/**
 * Vista del menú para la interacción con el usuario.
 * 
 * @author Rodrigo Martínez Delgado &lt;rodrigo.mardel.daw@gmail.com&gt;
 * @version 1.0 (20240408)
 */
public class VistaMenú extends VistaGeneral {

	/** Opciones almacenadas. */
	private String[] listaOpciones;
	/** Opciones numéricas del menú. */
	private int opción;
	/** Nombre del menú. */
	private String nombre;

	/**
	 * Inicializa y asigna el nombre del menú, la lista de opciones y la entrada
	 * recibida.
	 * 
	 * @param nombre        nombre deseado
	 * @param listaOpciones lista de opciones recibida
	 * @param entrada       entrada de usuario
	 */
	public VistaMenú(String nombre, String[] listaOpciones, Scanner entrada) {
		super(nombre, entrada);
		this.listaOpciones = listaOpciones;
		this.nombre = nombre;
	}

	/**
	 * Muestra el título asigando para el menú.
	 */
	public void mostrarTítulo() {
		out.println(nombre);
		for (int i = 0; i < nombre.length(); i++) {
			out.print("=");
		}
		out.println();
	}

	/**
	 * Muestra las opciones con su enumeración correspondiente.
	 */
	public void mostrarMenú() {
		for (int i = 0; i < listaOpciones.length; i++) {
			out.printf("%d.- %s %n", i + 1, listaOpciones[i]);
		}
	}

	/**
	 * Pide al usuario la opción que desea para continuar, verificando que debe
	 * estar comprendida entre las opcines listadas en el menú. Admite como valor
	 * solo número enteros.
	 * 
	 * @return la opción seleccionada
	 */
	public int pedirOpción() {
		boolean salir = false;
		String textoEntrada;
		Scanner in = getScEntrada();

		do {
			try {
				System.out.println("Seleccione la opción deseada:");
				textoEntrada = in.nextLine();
				opción = Integer.parseInt(textoEntrada);

				if (opción <= 0 || opción > listaOpciones.length) {
					out.println("\u001B[33m ✕ Opción NO válida\u001B[0m");
				} else {
					salir = true;
				}
			} catch (NumberFormatException e) {
				err.println("Error de formato, el sistema solo admite números enteros");
			}
		} while (!salir);
		return opción;
	}
}

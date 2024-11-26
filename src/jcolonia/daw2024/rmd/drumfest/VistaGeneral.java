package jcolonia.daw2024.rmd.drumfest;

import static java.lang.System.out;
import static java.lang.System.err;

import java.util.Scanner;

/**
 * Vista general para la interacción con el usuario.
 * 
 * @author Rodrigo Martínez Delgado &lt;rodrigo.mardel.daw@gmail.com&gt;
 * @version 1.2 (20241120)
 */
public class VistaGeneral {

	/** Nombre del menú. */
	private String nombre;
	/** Entrada estándar. */
	private Scanner scEntrada;
	/** Texto para confirmación. */
	private static final String SI = "S";
	/** Texto para negación. */
	private static final String NO = "N";

	/**
	 * Inicializa y asigna el nombre del menú, la lista de opciones y la entrada
	 * recibida.
	 * 
	 * @param nombre nombre deseado
	 * @param in     entrada de usuario
	 */
	public VistaGeneral(String nombre, Scanner in) {
		this.nombre = nombre;
		this.scEntrada = in;
	}

	/**
	 * Muestra el título asignado para el menú.
	 */
	public void mostrarTítulo() {
		out.println(nombre);
		for (int i = 0; i < nombre.length(); i++) {
			out.print("=");
		}
		out.println();
	}

	/**
	 * Consulta la entrada estándar.
	 * 
	 * @return valor correspondiente
	 */
	public Scanner getScEntrada() {
		return scEntrada;
	}

	/**
	 * Pregunta al usuario si desea continuar.
	 * 
	 * @return salir o continuar si el usuario lo desea
	 */
	public boolean pedirConfirmación() {
		boolean salir = false, respuesta = false;
		String textoIntroducido;

		do {
			out.println("¿Desea continuar? (S/N)");
			textoIntroducido = scEntrada.nextLine();
			if (SI.equals(textoIntroducido.toUpperCase())) {
				respuesta = true;
				salir = true;
			} else if (NO.equals(textoIntroducido.toUpperCase())) {
				respuesta = false;
				salir = true;
			} else {
				out.println("\u001B[33m*** ¡Solo es válido «S» o «N»!\u001B[0m");
			}
		} while (!salir);
		return respuesta;
	}

	/**
	 * Lectura del texto introducido por el usuario controlando que la entrada no
	 * pueda ser vacía.
	 * 
	 * @param pregunta texto de pregunta correspondiente
	 * @return entrada del usuario deseada
	 */
	public String leerTexto(String pregunta) {
		Scanner in = getScEntrada();
		String textoEntrada;
		boolean salir = false;

		do {
			out.print(pregunta);
			textoEntrada = in.nextLine();
			if (textoEntrada == null || textoEntrada.length() == 0) {
				err.println("*** Error de formato, debe introducir un valor");
			} else {
				salir = true;
			}
		} while (!salir);
		return textoEntrada.trim();
	}

	/**
	 * Lectura del número introducido por el usuario verificando que la entrada solo
	 * puedan ser números enteros.
	 * 
	 * @param pregunta texto de pregunta correspondiente
	 * @return entrada del usuario deseada
	 */
	public int leerNúmero(String pregunta) {
		Scanner in = getScEntrada();
		int número = 0;
		boolean salir = false;
		String textoEntrada;

		do {
			out.print(pregunta);
			try {
				textoEntrada = in.nextLine();
				número = Integer.parseInt(textoEntrada);
				salir = true;

			} catch (NumberFormatException e) {
				err.println("*** Error de formato, el sistema solo admite números enteros");
			}
		} while (!salir);
		return número;
	}

}

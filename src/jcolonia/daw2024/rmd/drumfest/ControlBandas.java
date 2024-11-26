package jcolonia.daw2024.rmd.drumfest;

import static java.lang.System.out;
import java.util.List;
import java.util.Scanner;

/**
 * Control de introducción, listado, borrado, exportación e importación del
 * conjunto «{@link Festival}» de bandas musicales.
 * 
 * @author Rodrigo Martínez Delgado &lt;rodrigo.mardel.daw@gmail.com&gt;
 * @version 4.0 (20240425)
 */
public class ControlBandas {

	/** Entrada estándar. */
	private Scanner entrada;
	/** Conjunto de bandas. */
	private Festival conjuntoBandas;
	/** Vista listado bandas disponibles en memoria. */
	private VistaListado vistaListado;
	/** Opciones del menú principal. */
	public static final String[] OPCIONES_MENÚ_PRINCIPAL = { "Introducir bandas", "Listar bandas", "Exportar bandas",
			"Importar bandas", "Borrar bandas", "Acerca de...", "Salir" };
	/** Ruta completa del archivo de importación/exportación. */
	private static final String NOMBRE_PREDETERMINADO = "bandas.txt";
	/** Color amarillo de alerta para la salida de texto por consola. */
	private static final String YELLOW = "\u001B[33m";
	/** Color verde de confirmación para la salida de texto por consola. */
	private static final String GREEN = "\u001B[32m";
	/** Secuencia de escape ANSI para resetear el estilo. */
	private static final String RESET = "\u001B[0m";

	/**
	 * Inicializa el conjunto, la vista del listado y asigna la entrada a la entrada
	 * estándar del control.
	 * 
	 * @param entrada entrada deseada
	 */
	public ControlBandas(Scanner entrada) {
		this.entrada = entrada;
		vistaListado = new VistaListado("• Cartel DrumFest'24 •", entrada);
		conjuntoBandas = new Festival();
	}

	/**
	 * Importa el archivo de texto de las bandas pidiendo confirmación, ya que se
	 * perderan las bandas que tengamos actualmente en memoria si no han sido
	 * exportadas. Posteriormente vuelve a cargar en el conjunto las bandas
	 * importadas.
	 */
	public void importarBandas() {
		VistaGeneral vistaGeneral = new VistaGeneral("Importar", entrada);
		List<String> listaImportada;
		Importación importaciónArchivo = new Importación();

		out.printf("%s ***¡ATENCIÓN!*** ¡Perderá los registros no exportados! %s %n", YELLOW, RESET);
		if (vistaGeneral.pedirConfirmación()) {
			conjuntoBandas.eliminarTodos();
			listaImportada = importaciónArchivo.importar(NOMBRE_PREDETERMINADO, conjuntoBandas.toCSVTextoListado());
			conjuntoBandas = Festival.ofFestival(listaImportada);
		} else {
			out.printf("%s ✕ Importación NO realizada %s %n", YELLOW, RESET);
		}
	}

	/**
	 * Exporta las bandas introducidas a un archivo de texto en formato CSV,
	 * advirtiendo al usuario que dicha acción puede sobrescribir notas exportadas
	 * anteriormente.
	 */
	public void exportarBandas() {
		Exportación exportaciónConjunto = new Exportación();

		if (conjuntoBandas.consultarElementosVacíos()) {
		} else {
			out.printf("%s ***¡ATENCIÓN!*** ¡Sobrescribirá los registros exportados anteriormente! %s %n", YELLOW,
					RESET);
			exportaciónConjunto.exportar(conjuntoBandas.toCSVTextoListado());
		}
	}

	/**
	 * Lista las bandas introducidas, volcando el resultado por pantalla de forma
	 * enumerada.
	 */
	public void listarBandas() {
		if (conjuntoBandas.consultarElementosVacíos()) {
		} else {
			vistaListado.mostrarTítulo();
			vistaListado.mostrarCabecera();
			vistaListado.listar(conjuntoBandas.toTextoListado());
		}

	}

	/**
	 * Genera una vista de altas la cual nos permite introducir nuevas bandas. Nos
	 * avisa si la banda ha sido registrada correctamente y nos pide si deseamos
	 * continuar introduciendo nuevos registros.
	 */
	public void introducirBandas() {
		VistaAltasBandas altas;
		altas = new VistaAltasBandas("Introduzca la banda deseada:", entrada);

		altas.mostrarTítulo();
		conjuntoBandas.añadirTodos(altas.introducirAltas());
	}

	/**
	 * Borra todas las bandass introducidas, pidiendo confirmación al usuario.
	 */
	public void borrarBandas() {
		VistaGeneral vistaGeneral = new VistaGeneral("Borrar", entrada);

		if (conjuntoBandas.consultarElementosVacíos()) {
		} else {
			out.printf("%s ***¡ATENCIÓN!*** ¡Se borrarán todas las bandas! %s %n", YELLOW, RESET);
			if (vistaGeneral.pedirConfirmación()) {
				conjuntoBandas.eliminarTodos();
				out.printf("%s ✓ Todas las bandas han sido eliminadas %s %n", GREEN, RESET);
			} else {
				out.printf("%s * No ha habido ninguna modificación %s %n", YELLOW, RESET);
			}
		}
	}

	/**
	 * Muestra información relacionada con el propósito de la aplicación y el
	 * desarrollador.
	 */
	public void informaciónAplicación() {
		vistaListado.acercaDe();
	}

	/**
	 * Muestra el menú principal con las opciones para la gestión de bandas.
	 */
	public void buclePrincipal() {
		VistaMenú menú;
		int opción;

		menú = new VistaMenú("~ DrumFest'24 ~", OPCIONES_MENÚ_PRINCIPAL, entrada);

		do {
			out.println();
			menú.mostrarTítulo();
			menú.mostrarMenú();
			opción = menú.pedirOpción();

			switch (opción) {
			case 1:
				introducirBandas();
				break;
			case 2:
				listarBandas();
				break;
			case 3:
				exportarBandas();
				break;
			case 4:
				importarBandas();
				break;
			case 5:
				borrarBandas();
				break;
			case 6:
				informaciónAplicación();
			}
		} while (opción != 7);
		out.println("** SESIÓN FINALIZADA **");
	}

	/**
	 * Genera un control en forma de vista, con un menú para la gestión de bandas.
	 * 
	 * @param argumentos argumentos dados al ejecutar –no se usan–
	 */
	public static void main(String[] argumentos) {
		ControlBandas programa;
		Scanner entrada;

		entrada = new Scanner(System.in);

		programa = new ControlBandas(entrada);
		programa.buclePrincipal();
		entrada.close();
	}
}

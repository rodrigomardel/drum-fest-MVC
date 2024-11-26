package jcolonia.daw2024.rmd.drumfest;

/**
 * Agrupación de características principales de las bandas musicales.
 * 
 * @author Rodrigo Martínez Delgado &lt;rodrigo.mardel.daw@gmail.com&gt;
 * @version 2.0 (20240419)
 */
public class Banda {

	/** Nombre de la banda musical. */
	private String nombre;
	/** Género musical al que pertenece la banda. */
	private String género;
	/** Relevancia de la banda. */
	private Relevancia relevancia;
	/** Número de miembros. */
	private int miembros;
	/** Nombre del baterista de la banda. */
	private String baterista;
	/** Formato empleado para la visualización en listado. */
	private static final String FORMATO_LISTADO = "\u001B[36m    %-14.14s       %-14.14s       %-14.14s   %6d         %-14.20s\u001B[0m";

	/**
	 * Inicializa una nueva instancia, no inicializa atributos ni recibe parámetros.
	 * Se utiliza para crear un objeto básico sin estado inicial específico.
	 */
	public Banda() {
	}

	/**
	 * Consulta el nombre de la banda.
	 * 
	 * @return nombre nombre correspondiente
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Modifica el nombre de la banda.
	 * 
	 * @param texto nombre deseado
	 */
	public void setNombre(String texto) {
		nombre = texto;
	}

	/**
	 * Consulta el género de la banda.
	 * 
	 * @return género género correspondiente
	 */
	public String getGénero() {
		return género;
	}

	/**
	 * Modifica el género de la banda.
	 * 
	 * @param texto género deseado
	 */
	public void setGénero(String texto) {
		género = texto;
	}

	/**
	 * Consulta la relevancia de la banda.
	 * 
	 * @return relevancia la relevancia correspondiente
	 */
	public Relevancia getRelevancia() {
		return relevancia;
	}

	/**
	 * Modifica la relevancia de la banda.
	 * 
	 * @param valor relevancia deseada
	 */
	public void setRelevancia(Relevancia valor) {
		relevancia = valor;
	}

	/**
	 * Consulta el número de miembros de la banda.
	 * 
	 * @return miembros número de miembros correspondiente
	 */
	public int getMiembros() {
		return miembros;
	}

	/**
	 * Modifica el número de miembros de la banda.
	 * 
	 * @param valor número de miembros deseado
	 */
	public void setMiembros(int valor) {
		miembros = valor;
	}

	/**
	 * Consulta el nombre del baterista de la banda.
	 * 
	 * @return baterista nombre del baterista correspondiente
	 */
	public String getBaterista() {
		return baterista;
	}

	/**
	 * Modifica el nombre del baterista de la banda.
	 * 
	 * @param texto nombre del baterista deseado
	 */
	public void setBaterista(String texto) {
		baterista = texto;
	}

	/**
	 * Crea un texto con las cinco características.<div> Ejemplo:
	 * 
	 * <pre>
	 * • Nombre: Red Hot Chili Peppers   • Género: Funk rock    • Relevancia: Artista cabeza cartel   • Miembros: 4   • Baterista: Chad Smith
	 * </pre>
	 * 
	 * </div>
	 * 
	 * @return texto correspondiente
	 */
	@Override
	public String toString() {
		String texto;
		texto = String.format(
				" \u001B[36m• Nombre: %-10s   • Género: %-10s   • Relevancia: %-16s   • Miembros: %-2d   • Baterista: %s\u001B[0m",
				nombre, género, relevancia, miembros, baterista);

		return texto;
	}

	/**
	 * Crea un texto con las cinco características en formato CSV.<div> Ejemplo:
	 * 
	 * <pre>
	 * Red Hot Chili Peppers#Funk rock#Artista_cabeza_cartel#4#Chad Smith
	 * </pre>
	 * 
	 * </div>
	 * 
	 * @return texto correspondiente
	 */
	public String toCSVString() {
		String texto;
		texto = String.format("%s#%s#%s#%d#%s", nombre, género, relevancia, miembros, baterista);

		return texto;
	}

	/**
	 * Crea un texto con las cinco características en formato listado.<div> Ejemplo:
	 * 
	 * <pre>
	 * • Red Hot Chili Peppers   • Funk rock    • Artista cabeza cartel   • 4   • Chad Smith
	 * </pre>
	 * 
	 * </div>
	 * 
	 * @return texto correspondiente
	 */
	public String toListadoString() {
		String texto;
		texto = String.format(FORMATO_LISTADO, nombre, género, relevancia, miembros, baterista);

		return texto;
	}

}

package jcolonia.daw2024.rmd.drumfest;

import static java.lang.System.err;
import static java.lang.System.out;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * Conjunto en forma de («<em>array</em>») de un número determinado de elementos
 * «{@link Banda}».
 * 
 * @author Rodrigo Martínez Delgado &lt;rodrigo.mardel.daw@gmail.com&gt;
 * @version 2.0 (20240423)
 */
public class Festival {

	/** Listado de elementos. */
	private Vector<Banda> conjuntoBandas;

	/**
	 * Inicializa el listado de elementos.
	 */
	public Festival() {
		conjuntoBandas = new Vector<Banda>();
	}

	/**
	 * Convierte una lista de líneas de archivo CSV a una nueva instancia
	 * «{@link Festival}», realizando las comprobaciones necesarias para asegurar la
	 * correcta creación de los elementos «{@link Banda}» en base a sus
	 * características.
	 * 
	 * @param líneasArchivoCSV listado de elementos de texto
	 * @return conjunto de elementos
	 */
	public static Festival ofFestival(List<String> líneasArchivoCSV) {
		Banda banda;
		Festival nuevoConjunto = new Festival();

		for (String línea : líneasArchivoCSV) {
			try {
				String[] datos = línea.split("#");
				if (datos.length != 5) {
					err.println("Error de formato en la línea: " + línea);
				} else {
					banda = new Banda();
					banda.setNombre(datos[0]);
					banda.setGénero(datos[1]);
					banda.setRelevancia(Relevancia.valueOf(datos[2]));
					banda.setMiembros(Integer.parseInt(datos[3]));
					banda.setBaterista(datos[4]);
					nuevoConjunto.añadir(banda);
				}
			} catch (NumberFormatException e) {
				err.println("Error al convertir el número de miembros: " + línea);
			} catch (IllegalArgumentException e) {
				err.println("Valor de relevancia desconocido en la línea: " + línea);
			}
		}
		return nuevoConjunto;
	}

	/**
	 * Añade un elemento al final del listado de elementos.
	 * 
	 * @param elemento elemento deseado
	 */
	public void añadir(Banda elemento) {
		conjuntoBandas.add(elemento);
	}

	/**
	 * Añade todos los elementos al final del listado.
	 * 
	 * @param elementos listado de elementos correspondiente
	 */
	public void añadirTodos(Vector<Banda> elementos) {
		conjuntoBandas.addAll(elementos);
	}

	/**
	 * Consulta un elemento en una posición concreta.
	 * 
	 * @param posición posición deseada
	 * @return elemento elemento correspondiente
	 */
	public Banda consultarPosición(int posición) {
		return conjuntoBandas.get(posición);
	}

	/**
	 * Consulta si el conjunto de elementos está vacio.
	 * 
	 * @return valor valor correspondiente
	 */
	public boolean consultarElementosVacíos() {
		if (conjuntoBandas.isEmpty()) {
			out.printf("\u001B[33m*** No hay bandas registradas ***\u001B[0m%n");
		}
		return conjuntoBandas.isEmpty();
	}

	/**
	 * Consulta el número de elementos.
	 * 
	 * @return valor correspondiente
	 */
	public int númeroElementos() {
		return conjuntoBandas.size();
	}

	/**
	 * Elimina todos los elementos.
	 */
	public void eliminarTodos() {
		conjuntoBandas.clear();
	}

	/**
	 * Elimina un elemento en una posición concreta.
	 * 
	 * @param posición posición deseada
	 * @return elemento elemento eliminado
	 */
	public Banda eliminarElemento(int posición) {
		if (posición < 0 || posición > conjuntoBandas.size()) {
			err.println("Índice fuera de rango: " + posición);
		}
		return conjuntoBandas.remove(posición);
	}

	/**
	 * Genera un listado de texto del conjunto de elementos.
	 * 
	 * @return listado listado correspondiente
	 */
	public List<String> toTextoListado() {
		ArrayList<String> listadoTextoBandas = new ArrayList<String>();

		for (Banda banda : conjuntoBandas) {
			listadoTextoBandas.add(banda.toListadoString());
		}

		return listadoTextoBandas;
	}

	/**
	 * Genera un listado de texto del conjunto de elementos en formato CSV.
	 * 
	 * @return listado listado correspondiente
	 */
	public List<String> toCSVTextoListado() {
		ArrayList<String> listadoTextoBandas = new ArrayList<String>();

		for (Banda banda : conjuntoBandas) {
			listadoTextoBandas.add(banda.toCSVString());
		}

		return listadoTextoBandas;
	}

}

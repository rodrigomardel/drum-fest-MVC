package jcolonia.daw2024.rmd.drumfest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Vector;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Pruebas sobre la clase {@link Festival}. Comprobaciones básicas de los
 * valores inicializados en el constructor, consulta, eliminado de elementos,
 * control del número de elementos.
 * 
 * @author Rodrigo Martínez Delgado &lt;rodrigo.mardel.daw@gmail.com&gt;
 * @version 1.0 (20240428)
 */
class FestivalTest {

	/** Conjunto de un número determinado de elementos. */
	private Festival conjuntoBandas;
	/** Banda con valores. */
	private Banda bandaMusical;
	/** Nombre de la banda. */
	private String nombre;
	/** Género musical de la banda. */
	private String género;
	/** Relevancia de la banda en el festival. */
	private Relevancia relevancia;
	/** Número de miembros. */
	private int miembros;
	/** Nombre baterista. */
	private String baterista;
	/** Contador genérico. */
	int contador;

	/**
	 * Inicializa recursos comunes a todas las pruebas una única vez antes de que se
	 * ejecuten todas las pruebas de la clase.
	 * 
	 * @throws Exception excepción esperada
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	/**
	 * Inicializa recursos comunes a todas las pruebas una única vez después de que
	 * se ejecuten todas las pruebas de la clase.
	 * 
	 * @throws Exception excepción esperada
	 */
	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	/**
	 * Inicializa recursos comunes antes de cada prueba individual.
	 *
	 * @throws Exception excepción esperada
	 */
	@BeforeEach
	void setUp() throws Exception {
		bandaMusical = new Banda();
		nombre = "Red Hot Chili Peppers";
		género = "Funk-Rock";
		relevancia = Relevancia.CABEZA_CARTEL;
		miembros = 4;
		baterista = "Chad Smith";
		bandaMusical.setNombre(nombre);
		bandaMusical.setGénero(género);
		bandaMusical.setRelevancia(relevancia);
		bandaMusical.setMiembros(miembros);
		bandaMusical.setBaterista(baterista);

		conjuntoBandas = new Festival();
		contador = 0;
	}

	/**
	 * Inicializa recursos comunes después de cada prueba individual.
	 *
	 * @throws Exception excepción esperada
	 */
	@AfterEach
	void tearDown() throws Exception {
	}

	/**
	 * Comprueba que usando el constructor el vector queda inicializado.Las
	 * comprobaciones se realizan a través de
	 * {@link Festival#consultarPosición(int)},
	 * {@link Festival#eliminarElemento(int)}, {@link Festival#toTextoListado()}.
	 * 
	 * @see Festival#Festival()
	 */
	@Test
	@DisplayName("Constructor ← lista elementos")
	void testConstructorListaElementos() {
		assertThrows(ArrayIndexOutOfBoundsException.class, () -> conjuntoBandas.consultarPosición(0),
				"Consulta primer elemento inexistente");
		assertThrows(ArrayIndexOutOfBoundsException.class, () -> conjuntoBandas.eliminarElemento(0),
				"Eliminar primer elemento inexistente");
		assertEquals(0, conjuntoBandas.toTextoListado().size(), "Listado debe quedar vacío");
	}

	/**
	 * Verifica que usando la factoria inicializa una nueva instancia y el formato
	 * de texto CSV es correcto. Las comprobaciones se realizan a traves de
	 * {@link Festival#toCSVTextoListado()} y {@link Festival#ofFestival(List)}.
	 * 
	 * @see Festival#ofFestival(List)
	 */
	@Test
	@DisplayName("Factoría ← List<String> to Festival")
	void testFactoríaListaElementos() {
		Festival nuevoConjuntoBandas;
		nuevoConjuntoBandas = Festival.ofFestival(conjuntoBandas.toCSVTextoListado());
		conjuntoBandas.añadir(bandaMusical);

		assertNotEquals(conjuntoBandas, nuevoConjuntoBandas, "El conjunto no debe ser el mismo");
	}

	/**
	 * Verifica que en una secuencia de agregado de forma individual de varios
	 * elementos al conjunto, se han agregado correctamente. Las comprobaciones se
	 * realizan a través de {@link Festival#añadir(Banda)} y
	 * {@link Festival#consultarPosición(int)}.
	 * 
	 * @see Festival#añadir(Banda)
	 * @see Festival#consultarPosición(int)
	 */
	@Test
	@DisplayName("Añadir elemento + consultar posición")
	void testAñadirElementoConsultarPosición() {

		for (int i = 0; i <= 4; i++) {
			conjuntoBandas.añadir(bandaMusical);
		}

		assertEquals(conjuntoBandas.consultarPosición(0), bandaMusical, "Primer elemento del conjunto");
		assertEquals(conjuntoBandas.consultarPosición(1), bandaMusical, "Segundo elemento del conjunto");
		assertEquals(conjuntoBandas.consultarPosición(2), bandaMusical, "Tercer elemento del conjunto");
		assertEquals(conjuntoBandas.consultarPosición(3), bandaMusical, "Cuarto elemento del conjunto");
	}

	/**
	 * Verifica que agregando todos elementos al conjunto, se han agregado
	 * correctamente. Las comprobaciones se realizan a través de
	 * {@link Festival#añadirTodos(Vector)} y
	 * {@link Festival#consultarPosición(int)}.
	 * 
	 * @see Festival#añadirTodos(Vector)
	 * @see Festival#consultarPosición(int)
	 */
	@Test
	@DisplayName("Añadir todos los elementos + consultar posiciones")
	void testAñadirTodosElementosConsultarPosiciones() {
		Vector<Banda> nuevoConjuntoBandas = new Vector<Banda>();

		for (int i = 0; i <= 4; i++) {
			nuevoConjuntoBandas.add(bandaMusical);
		}

		conjuntoBandas.añadirTodos(nuevoConjuntoBandas);

		assertEquals(conjuntoBandas.consultarPosición(0), bandaMusical, "Primer elemento del conjunto");
		assertEquals(conjuntoBandas.consultarPosición(1), bandaMusical, "Segundo elemento del conjunto");
		assertEquals(conjuntoBandas.consultarPosición(2), bandaMusical, "Tercer elemento del conjunto");
		assertEquals(conjuntoBandas.consultarPosición(3), bandaMusical, "Cuarto elemento del conjunto");
	}

	/**
	 * Verifica que el valor devuelto en caso de que el conjunto este vacío es el
	 * correcto. {@link Festival#Festival()} y
	 * {@link Festival#consultarElementosVacíos()}.
	 * 
	 * @see Festival#Festival()
	 */
	@Test
	@DisplayName("Conjunto vacío")
	void testConjuntoVacío() {

		assertEquals(true, conjuntoBandas.consultarElementosVacíos(), "Conjunto vacío");
	}

	/**
	 * Verifica que agregando todos elementos al conjunto, se ha borrado la primera
	 * posición y el resto quedan inalteradas. {@link Festival#añadirTodos(Vector)}
	 * y {@link Festival#eliminarElemento(int)}.
	 * 
	 * @see Festival#añadirTodos(Vector)
	 * @see Festival#eliminarElemento(int)
	 */
	@Test
	@DisplayName("Añadir todos los elementos + borrar posición (1)")
	void testAñadirTodosElementosBorrarPosición1() {
		Vector<Banda> nuevoConjuntoBandas = new Vector<Banda>();

		for (int i = 0; i <= 4; i++) {
			nuevoConjuntoBandas.add(bandaMusical);
		}

		conjuntoBandas.añadirTodos(nuevoConjuntoBandas);

		assertEquals(bandaMusical, conjuntoBandas.eliminarElemento(0), "Elemento eliminado");
		assertEquals(bandaMusical, conjuntoBandas.consultarPosición(0), "Segundo elemento");
		assertEquals(bandaMusical, conjuntoBandas.consultarPosición(1), "Tercer elemento");
		assertEquals(bandaMusical, conjuntoBandas.consultarPosición(2), "Cuarto elemento");
	}

	/**
	 * Verifica que agregando todos elementos al conjunto, se han borrado las
	 * posiciones deseadas. {@link Festival#añadirTodos(Vector)} y
	 * {@link Festival#eliminarElemento(int)}.
	 * 
	 * @see Festival#añadirTodos(Vector)
	 * @see Festival#eliminarElemento(int)
	 */
	@Test
	@DisplayName("Añadir todos los elementos + borrar todas los elementos")
	void testAñadirTodosElementosBorrarTodasPosiciones() {
		Vector<Banda> nuevoConjuntoBandas = new Vector<Banda>();

		for (int i = 0; i <= 4; i++) {
			nuevoConjuntoBandas.add(bandaMusical);
		}

		conjuntoBandas.añadirTodos(nuevoConjuntoBandas);
		conjuntoBandas.eliminarTodos();

		assertThrows(ArrayIndexOutOfBoundsException.class, () -> conjuntoBandas.consultarPosición(0),
				"Consulta primer elemento inexistente");
		assertThrows(ArrayIndexOutOfBoundsException.class, () -> conjuntoBandas.eliminarElemento(0),
				"Eliminar primer elemento inexistente");
		assertEquals(0, conjuntoBandas.toTextoListado().size(), "Listado debe quedar vacío");
	}

	/**
	 * Verifica que el texto facilitado por {@link Festival#toTextoListado()} cumple
	 * ciertos mínimos:
	 * <ul>
	 * <li>No es nulo</li>
	 * <li>No está vacío</li>
	 * <li>No encaja con el valor predeterminado por {@link Object#toString()}</li>
	 * </ul>
	 */
	@Test
	@DisplayName("Método toTextoListado → Texto")
	void toTextoListado() {
		String textoProhibido, textoRecibido;

		textoRecibido = bandaMusical.toListadoString();
		textoProhibido = Banda.class.getName();

		assertNotNull(textoRecibido, "texto nulo");
		assertNotEquals(0, textoRecibido.length(), "texto nulo");
		assertFalse(textoRecibido.startsWith(textoProhibido), "texto heredado de Object");
	}

	/**
	 * Verifica que el texto facilitado por {@link Festival#toCSVTextoListado()}
	 * cumple ciertos mínimos:
	 * <ul>
	 * <li>No es nulo</li>
	 * <li>No está vacío</li>
	 * <li>No encaja con el valor predeterminado por {@link Object#toString()}</li>
	 * </ul>
	 */
	@Test
	@DisplayName("Método toCSVTextoListado → Texto")
	void toCSVTextoListado() {
		String textoProhibido, textoRecibido;

		textoRecibido = bandaMusical.toCSVString();
		textoProhibido = Banda.class.getName();

		assertNotNull(textoRecibido, "texto nulo");
		assertNotEquals(0, textoRecibido.length(), "texto nulo");
		assertFalse(textoRecibido.startsWith(textoProhibido), "texto heredado de Object");
	}

}

package jcolonia.daw2024.rmd.drumfest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Pruebas sobre la clase {@link Banda}. Comprobaciones básicas de los valores
 * inicializados en el constructor predeterminado, modificaciones y consulta de
 * esos valores.
 * 
 * @author Rodrigo Martínez Delgado &lt;rodrigo.mardel.daw@gmail.com&gt;
 * @version 1.0 (20240426)
 */

class BandaTest {

	/** Banda con valores. */
	private Banda bandaMusical;
	/** Banda sin valores. */
	private Banda bandaMusicalsinValores;
	/** Nombre de la banda. */
	private String nombre;
	/** Género musical de la banda. */
	private String género;
	/** Relevancia de la banda en el festival. */
	private Relevancia relevancia;
	/** Número de miembros. */
	private int miembros;
	/** Nombre baterista */
	private String baterista;

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
		nombre = "Red Hot Chili Peppers";
		género = "Funk-Rock";
		relevancia = Relevancia.CABEZA_CARTEL;
		miembros = 4;
		baterista = "Chad Smith";

		bandaMusicalsinValores = new Banda();
		bandaMusical = new Banda();

		bandaMusical.setNombre(nombre);
		bandaMusical.setGénero(género);
		bandaMusical.setRelevancia(relevancia);
		bandaMusical.setMiembros(miembros);
		bandaMusical.setBaterista(baterista);
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
	 * Verifica que usando el constructor predeterminado sin argumentos, los cinco
	 * valores quedan inicializados. Las comprobaciones se realizan a través de
	 * {@link Banda#getNombre()}, {@link Banda#getGénero()},
	 * {@link Banda#getRelevancia()} y {@link Banda#getMiembros()}
	 * {@link Banda#getBaterista()}.
	 * 
	 * @see Banda#Banda()
	 */
	@Test
	@DisplayName("Constructor sin argumentos")
	void testConstructorSinArgumentos() {

		assertEquals(null, bandaMusicalsinValores.getNombre(), "Nombre banda");
		assertEquals(null, bandaMusicalsinValores.getGénero(), "Género banda");
		assertEquals(null, bandaMusicalsinValores.getRelevancia(), "Relevancia banda");
		assertEquals(0, bandaMusicalsinValores.getMiembros(), "Miembros banda");
		assertEquals(null, bandaMusicalsinValores.getBaterista(), "Baterista banda");
	}

	/**
	 * Verifica que al modificar el primer valor se cambia correctamente el valor y
	 * que los otros cuatro permanecen inalterados.
	 */
	@Test
	@DisplayName("Get Nombre + Set Nombre (1)")
	void testSetGetNombre1() {
		String nuevoNombreBanda = "Muse";

		bandaMusical.setNombre(nuevoNombreBanda);

		assertEquals(nuevoNombreBanda, bandaMusical.getNombre(), "Nombre banda");
		assertEquals(género, bandaMusical.getGénero(), "Género banda");
		assertEquals(relevancia, bandaMusical.getRelevancia(), "Relevancia banda");
		assertEquals(miembros, bandaMusical.getMiembros(), "Miembros banda");
		assertEquals(baterista, bandaMusical.getBaterista(), "Baterista banda");
	}

	/**
	 * Verifica que al modificar el segundo valor se cambia correctamente el valor y
	 * que los otros cuatro permanecen inalterados.
	 */
	@Test
	@DisplayName("Get Género + Set Género (1)")
	void testSetGetGénero1() {
		String nuevoGénero = "Art-Rock";

		bandaMusical.setGénero(nuevoGénero);

		assertEquals(nombre, bandaMusical.getNombre(), "Nombre banda");
		assertEquals(nuevoGénero, bandaMusical.getGénero(), "Género banda");
		assertEquals(relevancia, bandaMusical.getRelevancia(), "Relevancia banda");
		assertEquals(miembros, bandaMusical.getMiembros(), "Miembros banda");
		assertEquals(baterista, bandaMusical.getBaterista(), "Baterista banda");
	}

	/**
	 * Verifica que al modificar el tercer valor se cambia correctamente el valor y
	 * que los otros cuatro permanecen inalterados.
	 */
	@Test
	@DisplayName("Get Relevancia + Set Relevancia (1)")
	void testSetGetRelevancia1() {
		Relevancia nuevaRelevancia = Relevancia.INVITADA;

		bandaMusical.setRelevancia(nuevaRelevancia);

		assertEquals(nombre, bandaMusical.getNombre(), "Nombre banda");
		assertEquals(género, bandaMusical.getGénero(), "Género banda");
		assertEquals(nuevaRelevancia, bandaMusical.getRelevancia(), "Relevancia banda");
		assertEquals(miembros, bandaMusical.getMiembros(), "Miembros banda");
		assertEquals(baterista, bandaMusical.getBaterista(), "Baterista banda");
	}

	/**
	 * Verifica que al modificar el cuarto valor se cambia correctamente el valor y
	 * que los otros cuatro permanecen inalterados.
	 */
	@Test
	@DisplayName("Get Miembros + Set Miembros (1)")
	void testSetGetMiembros1() {
		int nuevosMiembros = 6;

		bandaMusical.setMiembros(nuevosMiembros);

		assertEquals(nombre, bandaMusical.getNombre(), "Nombre banda");
		assertEquals(género, bandaMusical.getGénero(), "Género banda");
		assertEquals(relevancia, bandaMusical.getRelevancia(), "Relevancia banda");
		assertEquals(nuevosMiembros, bandaMusical.getMiembros(), "Miembros banda");
		assertEquals(baterista, bandaMusical.getBaterista(), "Baterista banda");
	}

	/**
	 * Verifica que al modificar el segundo valor se cambia correctamente el valor y
	 * que los otros cuatro permanecen inalterados.
	 */
	@Test
	@DisplayName("Get Baterista + Set Baterista (1)")
	void testSetGetBaterista1() {
		String nuevoBaterista = "Dominic Howard";

		bandaMusical.setBaterista(nuevoBaterista);

		assertEquals(nombre, bandaMusical.getNombre(), "Nombre banda");
		assertEquals(género, bandaMusical.getGénero(), "Género banda");
		assertEquals(relevancia, bandaMusical.getRelevancia(), "Relevancia banda");
		assertEquals(miembros, bandaMusical.getMiembros(), "Miembros banda");
		assertEquals(nuevoBaterista, bandaMusical.getBaterista(), "Baterista banda");
	}

	/**
	 * Verifica que al consultar el primer valor se obtiene el valor correcto en
	 * sucesivos intentos -cinco repeticiones-.
	 */
	@Test
	@DisplayName("Get Nombre (5)")
	void testGetNombre5() {
		int intento = 0;

		assertEquals(nombre, bandaMusical.getNombre(), "Lectura" + (++intento));
		assertEquals(nombre, bandaMusical.getNombre(), "Lectura" + (++intento));
		assertEquals(nombre, bandaMusical.getNombre(), "Lectura" + (++intento));
		assertEquals(nombre, bandaMusical.getNombre(), "Lectura" + (++intento));
		assertEquals(nombre, bandaMusical.getNombre(), "Lectura" + (++intento));
	}

	/**
	 * Verifica que al consultar el segundo valor se obtiene el valor correcto en
	 * sucesivos intentos -cinco repeticiones-.
	 */
	@Test
	@DisplayName("Get Género (5)")
	void testGetGénero5() {
		int intento = 0;

		assertEquals(género, bandaMusical.getGénero(), "Lectura" + (++intento));
		assertEquals(género, bandaMusical.getGénero(), "Lectura" + (++intento));
		assertEquals(género, bandaMusical.getGénero(), "Lectura" + (++intento));
		assertEquals(género, bandaMusical.getGénero(), "Lectura" + (++intento));
		assertEquals(género, bandaMusical.getGénero(), "Lectura" + (++intento));
	}

	/**
	 * Verifica que al consultar el tercer valor se obtiene el valor correcto en
	 * sucesivos intentos -cinco repeticiones-.
	 */
	@Test
	@DisplayName("Get Relevancia (5)")
	void testGetRelevancia5() {
		int intento = 0;

		assertEquals(relevancia, bandaMusical.getRelevancia(), "Lectura" + (++intento));
		assertEquals(relevancia, bandaMusical.getRelevancia(), "Lectura" + (++intento));
		assertEquals(relevancia, bandaMusical.getRelevancia(), "Lectura" + (++intento));
		assertEquals(relevancia, bandaMusical.getRelevancia(), "Lectura" + (++intento));
		assertEquals(relevancia, bandaMusical.getRelevancia(), "Lectura" + (++intento));
	}

	/**
	 * Verifica que al consultar el cuarto valor se obtiene el valor correcto en
	 * sucesivos intentos -cinco repeticiones-.
	 */
	@Test
	@DisplayName("Get Miembros (5)")
	void testGetMiembros5() {
		int intento = 0;

		assertEquals(miembros, bandaMusical.getMiembros(), "Lectura" + (++intento));
		assertEquals(miembros, bandaMusical.getMiembros(), "Lectura" + (++intento));
		assertEquals(miembros, bandaMusical.getMiembros(), "Lectura" + (++intento));
		assertEquals(miembros, bandaMusical.getMiembros(), "Lectura" + (++intento));
		assertEquals(miembros, bandaMusical.getMiembros(), "Lectura" + (++intento));
	}

	/**
	 * Verifica que al consultar el quinto valor se obtiene el valor correcto en
	 * sucesivos intentos -cinco repeticiones-.
	 */
	@Test
	@DisplayName("Get Baterista (5)")
	void testGetBateris5() {
		int intento = 0;

		assertEquals(baterista, bandaMusical.getBaterista(), "Lectura" + (++intento));
		assertEquals(baterista, bandaMusical.getBaterista(), "Lectura" + (++intento));
		assertEquals(baterista, bandaMusical.getBaterista(), "Lectura" + (++intento));
		assertEquals(baterista, bandaMusical.getBaterista(), "Lectura" + (++intento));
		assertEquals(baterista, bandaMusical.getBaterista(), "Lectura" + (++intento));
	}

	/**
	 * Verifica que, tras modificar el primer valor, al consultar el primer valor se
	 * obtiene el valor modificado en sucesivos intentos -cinco repeticiones-.
	 */
	@Test
	@DisplayName("Set Nombre (1) y get Nombre A (5)")
	void testSetGetNombre5() {
		String nuevoNombre = "Foo Fighters";
		int intento = 0;

		bandaMusical.setNombre(nuevoNombre);

		assertEquals(nuevoNombre, bandaMusical.getNombre(), "Lectura" + (++intento));
		assertEquals(nuevoNombre, bandaMusical.getNombre(), "Lectura" + (++intento));
		assertEquals(nuevoNombre, bandaMusical.getNombre(), "Lectura" + (++intento));
		assertEquals(nuevoNombre, bandaMusical.getNombre(), "Lectura" + (++intento));
		assertEquals(nuevoNombre, bandaMusical.getNombre(), "Lectura" + (++intento));
	}

	/**
	 * Verifica que, tras modificar el segundo valor, al consultar el segundo valor
	 * se obtiene el valor modificado en sucesivos intentos -cinco repeticiones-.
	 */
	@Test
	@DisplayName("Set Género (1) y get Género (5)")
	void testSetGetGénero5() {
		String nuevoGénero = "Hard-Rock";
		int intento = 0;

		bandaMusical.setGénero(nuevoGénero);

		assertEquals(nuevoGénero, bandaMusical.getGénero(), "Lectura" + (++intento));
		assertEquals(nuevoGénero, bandaMusical.getGénero(), "Lectura" + (++intento));
		assertEquals(nuevoGénero, bandaMusical.getGénero(), "Lectura" + (++intento));
		assertEquals(nuevoGénero, bandaMusical.getGénero(), "Lectura" + (++intento));
		assertEquals(nuevoGénero, bandaMusical.getGénero(), "Lectura" + (++intento));
	}

	/**
	 * Verifica que, tras modificar el tercer valor, al consultar el tercer valor se
	 * obtiene el valor modificado en sucesivos intentos -cinco repeticiones-.
	 */
	@Test
	@DisplayName("Set Relevancia (1) y get Relevancia (5)")
	void testSetGetRelevancia5() {
		Relevancia nuevaRelevancia = Relevancia.TELONERA;
		int intento = 0;

		bandaMusical.setRelevancia(nuevaRelevancia);

		assertEquals(nuevaRelevancia, bandaMusical.getRelevancia(), "Lectura" + (++intento));
		assertEquals(nuevaRelevancia, bandaMusical.getRelevancia(), "Lectura" + (++intento));
		assertEquals(nuevaRelevancia, bandaMusical.getRelevancia(), "Lectura" + (++intento));
		assertEquals(nuevaRelevancia, bandaMusical.getRelevancia(), "Lectura" + (++intento));
		assertEquals(nuevaRelevancia, bandaMusical.getRelevancia(), "Lectura" + (++intento));
	}

	/**
	 * Verifica que, tras modificar el cuarto valor, al consultar el cuarto valor se
	 * obtiene el valor modificado en sucesivos intentos -cinco repeticiones-.
	 */
	@Test
	@DisplayName("Set Miembros (1) y get Miembros (5)")
	void testSetGetMiebros5() {
		int nuevosMiembros = 8;
		int intento = 0;

		bandaMusical.setMiembros(nuevosMiembros);

		assertEquals(nuevosMiembros, bandaMusical.getMiembros(), "Lectura" + (++intento));
		assertEquals(nuevosMiembros, bandaMusical.getMiembros(), "Lectura" + (++intento));
		assertEquals(nuevosMiembros, bandaMusical.getMiembros(), "Lectura" + (++intento));
		assertEquals(nuevosMiembros, bandaMusical.getMiembros(), "Lectura" + (++intento));
		assertEquals(nuevosMiembros, bandaMusical.getMiembros(), "Lectura" + (++intento));
	}

	/**
	 * Verifica que, tras modificar el quinto valor, al consultar el quinto valor se
	 * obtiene el valor modificado en sucesivos intentos -cinco repeticiones-.
	 */
	@Test
	@DisplayName("Set Baterista (1) y get Baterista A (5)")
	void testSetGetBaterista5() {
		String nuevoBaterista = "Taylor Hawkins";
		int intento = 0;

		bandaMusical.setBaterista(nuevoBaterista);

		assertEquals(nuevoBaterista, bandaMusical.getBaterista(), "Lectura" + (++intento));
		assertEquals(nuevoBaterista, bandaMusical.getBaterista(), "Lectura" + (++intento));
		assertEquals(nuevoBaterista, bandaMusical.getBaterista(), "Lectura" + (++intento));
		assertEquals(nuevoBaterista, bandaMusical.getBaterista(), "Lectura" + (++intento));
		assertEquals(nuevoBaterista, bandaMusical.getBaterista(), "Lectura" + (++intento));
	}

	/**
	 * Verifica que, en una secuencia de modificaciones y consultas alternadas sobre
	 * el primer valor el valor obtenido en cada uno es correcto.
	 */
	@Test
	@DisplayName("Set+get Nombre (5)")
	void testSetGetNombre() {
		String[] listaNombres = { "Desakato", "Queens of The Stone Age", "Deep Purple", "Queen", "Twenty One Pilots",
				"Gorillaz", "The Cat Empire" };
		int intento = 0;

		for (int i = 0; i < listaNombres.length; i++) {
			bandaMusical.setNombre(listaNombres[i]);
			assertEquals(listaNombres[i], bandaMusical.getNombre(), "Lectura" + (++intento));
		}
	}

	/**
	 * Verifica que, en una secuencia de modificaciones y consultas alternadas sobre
	 * el segundo valor el valor obtenido en cada uno es correcto.
	 */
	@Test
	@DisplayName("Set+get Género (5)")
	void testSetGetGénero() {
		String[] listaGénero = { "Rock", "Funk", "Drum & Bass", "Hardcore", "Reggae", "Heavy Metal", "Pop" };
		int intento = 0;

		for (int i = 0; i < listaGénero.length; i++) {
			bandaMusical.setGénero(listaGénero[i]);
			assertEquals(listaGénero[i], bandaMusical.getGénero(), "Lectura" + (++intento));
		}
	}

	/**
	 * Verifica que, en una secuencia de modificaciones y consultas alternadas sobre
	 * el tercer valor el valor obtenido en cada uno es correcto.
	 */
	@Test
	@DisplayName("Set+get Relevancia (5)")
	void testSetGetRelevancia() {
		int intento = 0;
		Relevancia[] relevanciaArtistas = Relevancia.values();

		for (int i = 0; i < relevanciaArtistas.length; i++) {
			bandaMusical.setRelevancia(relevanciaArtistas[i]);
			assertEquals(relevanciaArtistas[i], bandaMusical.getRelevancia(), "Lectura" + (++intento));
		}
	}

	/**
	 * Verifica que, en una secuencia de modificaciones y consultas alternadas sobre
	 * el cuarto valor el valor obtenido en cada uno es correcto.
	 */
	@Test
	@DisplayName("Set+get Miembros (5)")
	void testSetGetMiembros() {
		int[] listaMiembros = { 4, 5, 6, 2, 3 };
		int intento = 0;

		for (int i = 0; i < listaMiembros.length; i++) {
			bandaMusical.setMiembros(listaMiembros[i]);
			assertEquals(listaMiembros[i], bandaMusical.getMiembros(), "Lectura" + (++intento));
		}
	}

	/**
	 * Verifica que, en una secuencia de modificaciones y consultas alternadas sobre
	 * el quinto valor el valor obtenido en cada uno es correcto.
	 */
	@Test
	@DisplayName("Set+get Baterista (5)")
	void testSetGetBaterista() {
		String[] listaBateristas = { "Ginger Baker", "Neil Peart", "Bernard Purdie", "John Bonham",
				"Roberto Castresana", "Nano Dangelo" };
		int intento = 0;

		for (int i = 0; i < listaBateristas.length; i++) {
			bandaMusical.setBaterista(listaBateristas[i]);
			assertEquals(listaBateristas[i], bandaMusical.getBaterista(), "Lectura" + (++intento));
		}
	}

	/**
	 * Verifica que el texto facilitado por {@link Banda#toString()} cumple ciertos
	 * mínimos:
	 * <ul>
	 * <li>No es nulo</li>
	 * <li>No está vacío</li>
	 * <li>No encaja con el valor predeterminado por {@link Object#toString()}</li>
	 * </ul>
	 */
	@Test
	@DisplayName("Método toString → Texto")
	void testToString() {
		String textoProhibido, textoRecibido;

		textoRecibido = bandaMusical.toString();
		textoProhibido = Banda.class.getName();

		assertNotNull(textoRecibido, "texto nulo");
		assertNotEquals(0, textoRecibido.length(), "texto nulo");
		assertFalse(textoRecibido.startsWith(textoProhibido), "texto heredado de Object");
	}

	/**
	 * Verifica que el texto facilitado por {@link Banda#toString()} cumple ciertos
	 * mínimos:
	 * <ul>
	 * <li>No es nulo</li>
	 * <li>No está vacío</li>
	 * <li>No encaja con el valor predeterminado por {@link Object#toString()}</li>
	 * </ul>
	 */
	@Test
	@DisplayName("Método toCSVString → Texto")
	void testToCSVString() {
		String textoProhibido, textoRecibido;

		textoRecibido = bandaMusical.toString();
		textoProhibido = Banda.class.getName();

		assertNotNull(textoRecibido, "texto nulo");
		assertNotEquals(0, textoRecibido.length(), "texto nulo");
		assertFalse(textoRecibido.startsWith(textoProhibido), "texto heredado de Object");
	}

}

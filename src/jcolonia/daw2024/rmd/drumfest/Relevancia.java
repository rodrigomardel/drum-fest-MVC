package jcolonia.daw2024.rmd.drumfest;

/**
 * Enumeración para categorizar la relevancia de las artistas invitadas al
 * evento.
 * 
 * @author Rodrigo Martínez Delgado &lt;rodrigo.mardel.daw@gmail.com&gt;
 * @version 1.0 (20240416)
 */
public enum Relevancia {
	/** Artista con más relevancia */
	CABEZA_CARTEL,
	/** Artista invitada */
	INVITADA,
	/** Artista telonera */
	TELONERA,
	/** Artista principal */
	PRINCIPAL;

	/**
	 * Consulta los valores de la enumeración.
	 * 
	 * @return los valores correspondientes
	 */
	public static String[] getNames() {
		String[] nombres;
		Relevancia[] relevanciaArtistas = values();

		nombres = new String[relevanciaArtistas.length];

		for (int i = 0; i < relevanciaArtistas.length; i++) {
			nombres[i] = relevanciaArtistas[i].name().toLowerCase();
		}
		return nombres;
	}
	
}

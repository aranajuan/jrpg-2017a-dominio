package dominio;

/**
 * Items a ser equipados por un Personaje (jugable o no).
 */
public class Item {
	private ModificadorSegunItem modSalud;
	private ModificadorSegunItem modFuerza;
	private ModificadorSegunItem modDestreza;
	private ModificadorSegunItem modInteligencia;
	private ModificadorSegunItem modEnergia;


	/**
	 * Constructor Item.
	 * @param rnd RandomGenerator
	 */
	public Item(final RandomGenerator rnd) {
		modSalud = new ModificadorSegunItem(rnd, Operacion.randomOperacion(rnd));
	}

	/**
	 * Constructor Item.
	 * @param modifSalud modificador salud.
	 */
	public Item(final ModificadorSegunItem modifSalud, final ModificadorSegunItem modifFuerza,
			final ModificadorSegunItem modifDestreza, final ModificadorSegunItem modifInteligencia,
			final ModificadorSegunItem modifEnergia) {
		this.modSalud = modifSalud;
		this.modFuerza = modifFuerza;
		this.modDestreza = modifDestreza;
		this.modInteligencia = modifInteligencia;
		this.modEnergia = modifEnergia;
	}

	/**
	 * Devuelve el valor a ser sumado a la fuerza.
	 * @param fuerzaOriginal fuerza del Peleador
	 * @return fuerza extra
	 */
	public int getModifFuerza(final int fuerzaOriginal) {
		return modFuerza.getValor(fuerzaOriginal) - fuerzaOriginal;
	}

	/**
	 * Devuelve el valor a ser sumado a la destreza.
	 * @param destrezaOriginal destreza del Peleador
	 * @return destreza extra
	 */
	public int getModifDestreza(final int destrezaOriginal) {
		return modDestreza.getValor(destrezaOriginal) - destrezaOriginal;
	}

	/**
	 * Devuelve el valor a ser sumado a la inteligencia.
	 * @param inteligenciaOriginal inteligencia del Peleador
	 * @return inteligencia extra
	 */
	public int getModifInteligencia(final int inteligenciaOriginal) {
		return modInteligencia.getValor(inteligenciaOriginal) - inteligenciaOriginal;
	}

	/**
	 * Devuelve el valor a ser sumado a la energia.
	 * @param energiaOriginal energia del Peleador
	 * @return energia extra
	 */
	public int getModifEnergia(final int energiaOriginal) {
		return modEnergia.getValor(energiaOriginal) - energiaOriginal;
	}

	/**
	 * Devuelve el valor a ser sumado a la salud.
	 * @param saludOriginal salud del Peleador
	 * @return salud extra
	 */
	int getModifSalud(final int saludOriginal) {
		return modSalud.getValor(saludOriginal) - saludOriginal;
	}
}

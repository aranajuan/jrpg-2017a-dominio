package dominio;

import java.util.LinkedList;

/**
 * La clase Elfo es un Personaje que posee las habilidades Golpe Level y Ataque Bosque.
 */

public class Elfo extends Personaje {
	private static final int ADICIONAL_ENERGIA_TOPE_ELFO = 10;
	private static final int ENERGIA_MINIMA_PARA_HABILIDAD = 10;
	private static final int MULTIPLICADOR_HABILIDAD = 10;

	/**
	 * Constructor de la clase Elfo.
	 * @param nombre nombre del elfo.
	 * @param casta casta del elfo.
	 * @param id id del elfo.
	 * @param inventario inventario del elfo.
	 */
	public Elfo(final String nombre, final Casta casta, final int id, final LinkedList<Item> inventario) {
		super(nombre, casta, id, inventario);
	}

	/**
	 * Constructor de la clase Elfo.
	 * @param nombre nombre del elfo.
	 * @param salud salud del elfo.
	 * @param energia energia del elfo.
	 * @param fuerza fuerza del elfo.
	 * @param destreza destreza del elfo.
	 * @param inteligencia inteligencia del elfo.
	 * @param casta casta del elfo.
	 * @param experiencia experiencia del elfo.
	 * @param nivel nivel del elfo.
	 * @param idPersonaje id del elfo.
	 * @param inventario inventario del elfo.
	 */
	public Elfo(final String nombre, final int salud, final int energia, final int fuerza, final int destreza,
			final int inteligencia, final Casta casta, final int experiencia, final int nivel,
			final int idPersonaje, final LinkedList<Item> inventario) {
		super(nombre, salud, energia, fuerza, destreza, inteligencia, casta, experiencia, nivel,
				idPersonaje, inventario);
	}

	@Override
	protected String nombreRazaInicial() {
		return "Elfo";
	}

	@Override
	protected void inicializarHabilidadesSegunRaza() {
		habilidadesRaza = new String[2];
		habilidadesRaza[0] = "Golpe Level";
		habilidadesRaza[1] = "Ataque Bosque";
	}

	@Override
	protected int energiaTopeInicial() {
		return super.energiaTopeInicial() + ADICIONAL_ENERGIA_TOPE_ELFO;
	}

	/**
	 * Se implementa la habilidad Golpe Level.
	 * El personaje gasta energía para atacar con la intensidad de la fuerza
	 * y el nivel del personaje multiplicado por diez.
	 *
	 * @param atacado un objeto que implementa la interfaz Peleable, es aquel a ser atacado
	 * @return        true si el Elfo tiene energía mayor a diez y el daño causado es mayor a cero;
	 *                false en caso contrario.
	 */
	public boolean habilidadRaza1(final Peleable atacado) {
		if (this.getEnergia() > ENERGIA_MINIMA_PARA_HABILIDAD) {
			this.setEnergia(this.getEnergia() - ENERGIA_MINIMA_PARA_HABILIDAD);
			if (atacado.serAtacado(getFuerza() + getNivel() * MULTIPLICADOR_HABILIDAD) > 0) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Se implementa la habilidad Ataque Bosque.
	 * El personaje gasta energía para atacar con el poder de su magia.
	 *
	 * @param atacado un objeto que implementa la interfaz Peleable, es aquel a ser atacado
	 * @return        true si el Elfo tiene energía mayor a diez y el daño causado es mayor a cero;
	 *                false en caso contrario.
	 */
	public boolean habilidadRaza2(final Peleable atacado) {
		if (this.getEnergia() > ENERGIA_MINIMA_PARA_HABILIDAD) {
			this.setEnergia(this.getEnergia() - ENERGIA_MINIMA_PARA_HABILIDAD);
			if (atacado.serAtacado((int) (this.magia)) > 0) {
				return true;
			}
		}
		return false;
	}
}

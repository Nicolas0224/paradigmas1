package co.edu.poli.contexto1.modelo;
 
/**
 * Clase que representa la configuración de un simulador.
 * No puede ser heredada.
 *
 * @author Nicolas_David_Atehortua_Duarte
 * @version 1.0
 * @since 2026-03-27
 */
//Clase que no hereda
public final class ConfiguracionSimulador {
 
	/** Nivel de gravedad de la configuración del simulador. */
	private String nivelGravedad;
 
	/** Modo de entrenamiento configurado para el simulador. */
	private String modoEntrenamiento;
 
	/** Duración de la sesión en minutos. */
	private int duracionSesionMinutos;
 
	/**
	 * Constructor de la clase ConfiguracionSimulador.
	 *
	 * @param nivelGravedad         Nivel de gravedad de la sesión.
	 * @param modoEntrenamiento     Modo de entrenamiento a utilizar.
	 * @param duracionSesionMinutos Duración de la sesión en minutos.
	 */
	public ConfiguracionSimulador(String nivelGravedad, String modoEntrenamiento, int duracionSesionMinutos) {
		this.nivelGravedad = nivelGravedad;
		this.modoEntrenamiento = modoEntrenamiento;
		this.duracionSesionMinutos = duracionSesionMinutos;
	}
 
	/**
	 * Obtiene el nivel de gravedad.
	 *
	 * @return El nivel de gravedad configurado.
	 */
	public String getNivelGravedad() {
		return nivelGravedad;
	}
 
	/**
	 * Establece el nivel de gravedad.
	 *
	 * @param nivelGravedad El nuevo nivel de gravedad.
	 */
	public void setNivelGravedad(String nivelGravedad) {
		this.nivelGravedad = nivelGravedad;
	}
 
	/**
	 * Obtiene el modo de entrenamiento.
	 *
	 * @return El modo de entrenamiento configurado.
	 */
	public String getModoEntrenamiento() {
		return modoEntrenamiento;
	}
 
	/**
	 * Establece el modo de entrenamiento.
	 *
	 * @param modoEntrenamiento El nuevo modo de entrenamiento.
	 */
	public void setModoEntrenamiento(String modoEntrenamiento) {
		this.modoEntrenamiento = modoEntrenamiento;
	}
 
	/**
	 * Obtiene la duración de la sesión en minutos.
	 *
	 * @return La duración de la sesión en minutos.
	 */
	public int getDuracionSesionMinutos() {
		return duracionSesionMinutos;
	}
 
	/**
	 * Establece la duración de la sesión en minutos.
	 *
	 * @param duracionSesionMinutos La nueva duración de la sesión en minutos.
	 */
	public void setDuracionSesionMinutos(int duracionSesionMinutos) {
		this.duracionSesionMinutos = duracionSesionMinutos;
	}
 
	/**
	 * Retorna una representación en cadena de la configuración del simulador.
	 *
	 * @return Cadena con los datos de la configuración.
	 */
	@Override
    public String toString() {
        return "\n********** CONFIGURACION SIMULADOR **********\n" +
                "nivelGravedad='" + nivelGravedad + '\'' +
                ", modoEntrenamiento='" + modoEntrenamiento + '\'' +
                ", duracionSesionMinutos=" + duracionSesionMinutos;
    }
}
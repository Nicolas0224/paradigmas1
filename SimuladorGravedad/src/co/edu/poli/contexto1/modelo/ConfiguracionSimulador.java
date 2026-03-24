package co.edu.poli.contexto1.modelo;

//Clase que no hereda
public final class ConfiguracionSimulador {

	private String nivelGravedad;
	private String modoEntrenamiento;
	private int duracionSesionMinutos;

	public ConfiguracionSimulador(String nivelGravedad, String modoEntrenamiento, int duracionSesionMinutos) {
		this.nivelGravedad = nivelGravedad;
		this.modoEntrenamiento = modoEntrenamiento;
		this.duracionSesionMinutos = duracionSesionMinutos;
	}

	public String getNivelGravedad() {
		return nivelGravedad;
	}

	public void setNivelGravedad(String nivelGravedad) {
		this.nivelGravedad = nivelGravedad;
	}

	public String getModoEntrenamiento() {
		return modoEntrenamiento;
	}

	public void setModoEntrenamiento(String modoEntrenamiento) {
		this.modoEntrenamiento = modoEntrenamiento;
	}

	public int getDuracionSesionMinutos() {
		return duracionSesionMinutos;
	}

	public void setDuracionSesionMinutos(int duracionSesionMinutos) {
		this.duracionSesionMinutos = duracionSesionMinutos;
	}

	@Override
    public String toString() {
        return "\n********** CONFIGURACION SIMULADOR **********\n" +
                "nivelGravedad='" + nivelGravedad + '\'' +
                ", modoEntrenamiento='" + modoEntrenamiento + '\'' +
                ", duracionSesionMinutos=" + duracionSesionMinutos;
    }

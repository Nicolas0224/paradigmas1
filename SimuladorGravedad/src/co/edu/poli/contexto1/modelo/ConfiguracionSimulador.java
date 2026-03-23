package co.edu.poli.contexto1.modelo;

//Clase que no hereda
public final class ConfiguracionSimulador {

    private String nivelGravanioNacimiento;
    private String modoEntrenamiento;
    private int duracionSesionMinutos;

    public ConfiguracionSimulador(String nivelGravanioNacimiento, String modoEntrenamiento, int duracionSesionMinutos) {
        this.nivelGravanioNacimiento = nivelGravanioNacimiento;
        this.modoEntrenamiento = modoEntrenamiento;
        this.duracionSesionMinutos = duracionSesionMinutos;
    }

    public String getNivelGravanioNacimiento() { return nivelGravanioNacimiento; }
    public void setNivelGravanioNacimiento(String nivelGravanioNacimiento) { this.nivelGravanioNacimiento = nivelGravanioNacimiento; }

    public String getModoEntrenamiento() { return modoEntrenamiento; }
    public void setModoEntrenamiento(String modoEntrenamiento) { this.modoEntrenamiento = modoEntrenamiento; }

    public int getDuracionSesionMinutos() { return duracionSesionMinutos; }
    public void setDuracionSesionMinutos(int duracionSesionMinutos) { this.duracionSesionMinutos = duracionSesionMinutos; }

    @Override
    public String toString() {
        return "\n********** CONFIGURACION SIMULADOR **********\n" +
                "nivelGravanioNacimiento='" + nivelGravanioNacimiento + '\'' +
                ", modoEntrenamiento='" + modoEntrenamiento + '\'' +
                ", duracionSesionMinutos=" + duracionSesionMinutos;
    }
}
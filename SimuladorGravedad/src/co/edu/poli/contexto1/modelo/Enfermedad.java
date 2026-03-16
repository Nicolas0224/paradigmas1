package co.edu.poli.contexto1.modelo;

public class Enfermedad {
    private String tipo;
    private String gravedad;
    private String tratamiento;
    private String id;

    public Enfermedad(String tipo, String gravedad, String tratamiento, String id) {
        this.tipo = tipo;
        this.gravedad = gravedad;
        this.tratamiento = tratamiento;
        this.id = id;
    }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public String getGravedad() { return gravedad; }
    public void setGravedad(String gravedad) { this.gravedad = gravedad; }

    public String getTratamiento() { return tratamiento; }
    public void setTratamiento(String tratamiento) { this.tratamiento = tratamiento; }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    @Override
    public String toString() {
        return "\n********** ENFERMEDAD **********\n" +
                "tipo='" + tipo + '\'' +
                ", gravedad='" + gravedad + '\'' +
                ", tratamiento='" + tratamiento + '\'' +
                ", id='" + id + '\'';
    }
}
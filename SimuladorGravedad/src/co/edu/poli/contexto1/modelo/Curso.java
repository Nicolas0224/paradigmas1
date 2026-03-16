package co.edu.poli.contexto1.modelo;

public class Curso {
    private String id;
    private String nivel;
    private String fecha;
    private String hora;
    private Equipo[] equipo;

    public Curso(String id, String nivel, String fecha, String hora, Equipo[] equipo) {
        this.id = id;
        this.nivel = nivel;
        this.fecha = fecha;
        this.hora = hora;
        this.equipo = equipo;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getNivel() { return nivel; }
    public void setNivel(String nivel) { this.nivel = nivel; }

    public String getFecha() { return fecha; }
    public void setFecha(String fecha) { this.fecha = fecha; }

    public String getHora() { return hora; }
    public void setHora(String hora) { this.hora = hora; }

    public Equipo[] getEquipo() { return equipo; }
    public void setEquipo(Equipo[] equipo) { this.equipo = equipo; }

    @Override
    public String toString() {
        return "\n********** CURSO **********\n" +
                "id='" + id + '\'' +
                ", nivel='" + nivel + '\'' +
                ", fecha='" + fecha + '\'' +
                ", hora='" + hora + '\'';
    }
}
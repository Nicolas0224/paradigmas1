package co.edu.poli.contexto1.modelo;

public class Turno {
    private String id;
    private Usuario usuario;
    private String fecha;
    private String horaEntrada;
    private String horaSalida;
    private String duracion;
    private Instructor instructor;
    private Simulador simulador;
    private Curso curso;

    public Turno(String id, Usuario usuario, String fecha, String horaEntrada, String horaSalida,
                 String duracion, Instructor instructor, Simulador simulador, Curso curso) {
        this.id = id;
        this.usuario = usuario;
        this.fecha = fecha;
        this.horaEntrada = horaEntrada;
        this.horaSalida = horaSalida;
        this.duracion = duracion;
        this.instructor = instructor;
        this.simulador = simulador;
        this.curso = curso;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }

    public String getFecha() { return fecha; }
    public void setFecha(String fecha) { this.fecha = fecha; }

    public String getHoraEntrada() { return horaEntrada; }
    public void setHoraEntrada(String horaEntrada) { this.horaEntrada = horaEntrada; }

    public String getHoraSalida() { return horaSalida; }
    public void setHoraSalida(String horaSalida) { this.horaSalida = horaSalida; }

    public String getDuracion() { return duracion; }
    public void setDuracion(String duracion) { this.duracion = duracion; }

    public Instructor getInstructor() { return instructor; }
    public void setInstructor(Instructor instructor) { this.instructor = instructor; }

    public Simulador getSimulador() { return simulador; }
    public void setSimulador(Simulador simulador) { this.simulador = simulador; }

    public Curso getCurso() { return curso; }
    public void setCurso(Curso curso) { this.curso = curso; }

    @Override
    public String toString() {
        return "\n********** TURNO **********\n"+
                "id='" + id + '\'' +
                ", usuario" + usuario +
                ", fecha='" + fecha + '\'' +
                ", horaEntrada='" + horaEntrada + '\'' +
                ", horaSalida='" + horaSalida + '\'' +
                ", duracion='" + duracion + '\'' +
                ", instructor=" + instructor +
                ", simulador=" + simulador +
                ", curso=" + curso;
    }
}
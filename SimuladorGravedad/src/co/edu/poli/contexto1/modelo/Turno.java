package co.edu.poli.contexto1.modelo;

/**
 * Representa un turno de sesión en el sistema de simulación.
 * Agrupa la información de un usuario, la fecha y horario del turno,
 * el instructor asignado, el simulador utilizado y el curso correspondiente.
 *
 * @author Nicolas_David_Atehortua_Duarte
 * @version 1.0
 * @since 2026-03-27
 */
public class Turno {

    /** Identificador único del turno. */
    private String id;

    /** Usuario al que pertenece este turno. */
    private Usuario usuario;

    /** Fecha en que se realiza el turno. */
    private String fecha;

    /** Hora de entrada al turno. */
    private String horaEntrada;

    /** Hora de salida del turno. */
    private String horaSalida;

    /** Duración total del turno. */
    private String duracion;

    /** Instructor asignado al turno. */
    private Instructor instructor;

    /** Simulador utilizado en el turno. */
    private Simulador simulador;

    /** Curso que se desarrolla durante el turno. */
    private Curso curso;

    /**
     * Constructor de la clase Turno.
     *
     * @param id          Identificador único del turno.
     * @param usuario     Usuario al que pertenece el turno.
     * @param fecha       Fecha de realización del turno.
     * @param horaEntrada Hora de entrada al turno.
     * @param horaSalida  Hora de salida del turno.
     * @param duracion    Duración total del turno.
     * @param instructor  Instructor asignado al turno.
     * @param simulador   Simulador utilizado en el turno.
     * @param curso       Curso que se desarrolla en el turno.
     */
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

    /**
     * Obtiene el identificador del turno.
     *
     * @return El identificador único del turno.
     */
    public String getId() { return id; }

    /**
     * Establece el identificador del turno.
     *
     * @param id El nuevo identificador del turno.
     */
    public void setId(String id) { this.id = id; }

    /**
     * Obtiene el usuario asociado al turno.
     *
     * @return El {@link Usuario} asignado al turno.
     */
    public Usuario getUsuario() { return usuario; }

    /**
     * Establece el usuario del turno.
     *
     * @param usuario El nuevo usuario asociado al turno.
     */
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }

    /**
     * Obtiene la fecha del turno.
     *
     * @return La fecha en que se realiza el turno.
     */
    public String getFecha() { return fecha; }

    /**
     * Establece la fecha del turno.
     *
     * @param fecha La nueva fecha del turno.
     */
    public void setFecha(String fecha) { this.fecha = fecha; }

    /**
     * Obtiene la hora de entrada al turno.
     *
     * @return La hora de entrada.
     */
    public String getHoraEntrada() { return horaEntrada; }

    /**
     * Establece la hora de entrada al turno.
     *
     * @param horaEntrada La nueva hora de entrada.
     */
    public void setHoraEntrada(String horaEntrada) { this.horaEntrada = horaEntrada; }

    /**
     * Obtiene la hora de salida del turno.
     *
     * @return La hora de salida.
     */
    public String getHoraSalida() { return horaSalida; }

    /**
     * Establece la hora de salida del turno.
     *
     * @param horaSalida La nueva hora de salida.
     */
    public void setHoraSalida(String horaSalida) { this.horaSalida = horaSalida; }

    /**
     * Obtiene la duración del turno.
     *
     * @return La duración total del turno.
     */
    public String getDuracion() { return duracion; }

    /**
     * Establece la duración del turno.
     *
     * @param duracion La nueva duración del turno.
     */
    public void setDuracion(String duracion) { this.duracion = duracion; }

    /**
     * Obtiene el instructor asignado al turno.
     *
     * @return El {@link Instructor} del turno.
     */
    public Instructor getInstructor() { return instructor; }

    /**
     * Establece el instructor del turno.
     *
     * @param instructor El nuevo instructor asignado al turno.
     */
    public void setInstructor(Instructor instructor) { this.instructor = instructor; }

    /**
     * Obtiene el simulador utilizado en el turno.
     *
     * @return El {@link Simulador} del turno.
     */
    public Simulador getSimulador() { return simulador; }

    /**
     * Establece el simulador del turno.
     *
     * @param simulador El nuevo simulador asignado al turno.
     */
    public void setSimulador(Simulador simulador) { this.simulador = simulador; }

    /**
     * Obtiene el curso que se desarrolla en el turno.
     *
     * @return El {@link Curso} del turno.
     */
    public Curso getCurso() { return curso; }

    /**
     * Establece el curso del turno.
     *
     * @param curso El nuevo curso asignado al turno.
     */
    public void setCurso(Curso curso) { this.curso = curso; }

    /**
     * Retorna una representación en cadena de los datos del turno.
     *
     * @return Cadena con el id, usuario, fecha, horarios, duración, instructor,
     *         simulador y curso del turno.
     */
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
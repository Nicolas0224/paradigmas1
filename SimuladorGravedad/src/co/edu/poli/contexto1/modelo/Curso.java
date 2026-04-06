package co.edu.poli.contexto1.modelo;

/**
 * Representa un curso disponible dentro del sistema de simulación.
 * Cada curso tiene un identificador, un nivel de dificultad, una fecha y hora
 * programada, y un conjunto de equipos asociados necesarios para su realización.
 *
 * @author Nicolas_David_Atehortua_Duarte
 * @version 1.0
 * @since 2026-03-27
 */
public class Curso {

    /** Identificador único del curso. */
    private String id;

    /** Nivel de dificultad o categoría del curso. */
    private String nivel;

    /** Fecha en la que se lleva a cabo el curso. */
    private String fecha;

    /** Hora de inicio del curso. */
    private String hora;

    /** Arreglo de equipos requeridos para el desarrollo del curso. */
    private Equipo[] equipo;

    /**
     * Constructor de la clase Curso.
     *
     * @param id     Identificador único del curso.
     * @param nivel  Nivel de dificultad o categoría del curso.
     * @param fecha  Fecha de realización del curso.
     * @param hora   Hora de inicio del curso.
     * @param equipo Arreglo de equipos necesarios para el curso.
     */
    public Curso(String id, String nivel, String fecha, String hora, Equipo[] equipo) {
        this.id = id;
        this.nivel = nivel;
        this.fecha = fecha;
        this.hora = hora;
        this.equipo = equipo;
    }

    /**
     * Obtiene el identificador del curso.
     *
     * @return El identificador único del curso.
     */
    public String getId() { return id; }

    /**
     * Establece el identificador del curso.
     *
     * @param id El nuevo identificador del curso.
     */
    public void setId(String id) { this.id = id; }

    /**
     * Obtiene el nivel del curso.
     *
     * @return El nivel de dificultad o categoría del curso.
     */
    public String getNivel() { return nivel; }

    /**
     * Establece el nivel del curso.
     *
     * @param nivel El nuevo nivel de dificultad o categoría.
     */
    public void setNivel(String nivel) { this.nivel = nivel; }

    /**
     * Obtiene la fecha del curso.
     *
     * @return La fecha en que se realiza el curso.
     */
    public String getFecha() { return fecha; }

    /**
     * Establece la fecha del curso.
     *
     * @param fecha La nueva fecha del curso.
     */
    public void setFecha(String fecha) { this.fecha = fecha; }

    /**
     * Obtiene la hora de inicio del curso.
     *
     * @return La hora de inicio del curso.
     */
    public String getHora() { return hora; }

    /**
     * Establece la hora de inicio del curso.
     *
     * @param hora La nueva hora de inicio.
     */
    public void setHora(String hora) { this.hora = hora; }

    /**
     * Obtiene el arreglo de equipos asociados al curso.
     *
     * @return Arreglo de objetos {@link Equipo} requeridos por el curso.
     */
    public Equipo[] getEquipo() { return equipo; }

    /**
     * Establece el arreglo de equipos del curso.
     *
     * @param equipo El nuevo arreglo de equipos asociados al curso.
     */
    public void setEquipo(Equipo[] equipo) { this.equipo = equipo; }

    /**
     * Retorna una representación en cadena de los datos del curso.
     *
     * @return Cadena con el id, nivel, fecha y hora del curso.
     */
    @Override
    public String toString() {
        return "\n********** CURSO **********\n" +
                "id='" + id + '\'' +
                ", nivel='" + nivel + '\'' +
                ", fecha='" + fecha + '\'' +
                ", hora='" + hora + '\'';
    }
}
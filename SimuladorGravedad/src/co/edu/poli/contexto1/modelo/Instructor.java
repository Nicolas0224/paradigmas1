package co.edu.poli.contexto1.modelo;

/**
 * Representa un instructor responsable de guiar sesiones o turnos
 * dentro del sistema de simulación.
 * Contiene información de identificación, nombre y área de especialidad.
 *
 * @author Nicolas_David_Atehortua_Duarte
 * @version 1.0
 * @since 2026-03-27
 */
public class Instructor {

    /** Identificador único del instructor. */
    private String id;

    /** Nombre completo del instructor. */
    private String nombre;

    /** Área de especialidad del instructor. */
    private String especialidad;

    /**
     * Constructor de la clase Instructor.
     *
     * @param id           Identificador único del instructor.
     * @param nombre       Nombre completo del instructor.
     * @param especialidad Área de especialidad del instructor.
     */
    public Instructor(String id, String nombre, String especialidad) {
        this.id = id;
        this.nombre = nombre;
        this.especialidad = especialidad;
    }

    /**
     * Obtiene el identificador del instructor.
     *
     * @return El identificador único del instructor.
     */
    public String getId() { return id; }

    /**
     * Establece el identificador del instructor.
     *
     * @param id El nuevo identificador del instructor.
     */
    public void setId(String id) { this.id = id; }

    /**
     * Obtiene el nombre del instructor.
     *
     * @return El nombre completo del instructor.
     */
    public String getNombre() { return nombre; }

    /**
     * Establece el nombre del instructor.
     *
     * @param nombre El nuevo nombre del instructor.
     */
    public void setNombre(String nombre) { this.nombre = nombre; }

    /**
     * Obtiene el área de especialidad del instructor.
     *
     * @return La especialidad del instructor.
     */
    public String getEspecialidad() { return especialidad; }

    /**
     * Establece el área de especialidad del instructor.
     *
     * @param especialidad La nueva especialidad del instructor.
     */
    public void setEspecialidad(String especialidad) { this.especialidad = especialidad; }

    /**
     * Retorna una representación en cadena de los datos del instructor.
     *
     * @return Cadena con el id, nombre y especialidad del instructor.
     */
    @Override
    public String toString() {
        return "\n********** INSTRUCTOR **********\n" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", especialidad='" + especialidad + '\'';
    }
}

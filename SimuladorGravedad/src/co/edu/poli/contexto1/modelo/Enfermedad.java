package co.edu.poli.contexto1.modelo;

import java.io.Serializable;

/**
 * Representa una enfermedad que puede estar asociada a un usuario del sistema.
 * Contiene información sobre el tipo de enfermedad, su nivel de gravedad,
 * el tratamiento recomendado y un identificador único.
 * <p>
 * Implementa {@link Serializable} para permitir la persistencia y transferencia
 * de objetos de esta clase.
 * </p>
 *
 * @author Nicolas_David_Atehortua_Duarte
 * @version 1.0
 * @since 2026-03-27
 */
public class Enfermedad implements Serializable {

    /** Tipo o nombre de la enfermedad. */
    private String tipo;

    /** Nivel de gravedad de la enfermedad. */
    private String gravedad;

    /** Tratamiento indicado para la enfermedad. */
    private String tratamiento;

    /** Identificador único de la enfermedad. */
    private String id;

    /**
     * Constructor de la clase Enfermedad.
     *
     * @param tipo        Tipo o nombre de la enfermedad.
     * @param gravedad    Nivel de gravedad de la enfermedad.
     * @param tratamiento Tratamiento indicado para la enfermedad.
     * @param id          Identificador único de la enfermedad.
     */
    public Enfermedad(String tipo, String gravedad, String tratamiento, String id) {
        this.tipo = tipo;
        this.gravedad = gravedad;
        this.tratamiento = tratamiento;
        this.id = id;
    }

    /**
     * Obtiene el tipo de la enfermedad.
     *
     * @return El tipo o nombre de la enfermedad.
     */
    public String getTipo() { return tipo; }

    /**
     * Establece el tipo de la enfermedad.
     *
     * @param tipo El nuevo tipo o nombre de la enfermedad.
     */
    public void setTipo(String tipo) { this.tipo = tipo; }

    /**
     * Obtiene el nivel de gravedad de la enfermedad.
     *
     * @return El nivel de gravedad.
     */
    public String getGravedad() { return gravedad; }

    /**
     * Establece el nivel de gravedad de la enfermedad.
     *
     * @param gravedad El nuevo nivel de gravedad.
     */
    public void setGravedad(String gravedad) { this.gravedad = gravedad; }

    /**
     * Obtiene el tratamiento indicado para la enfermedad.
     *
     * @return El tratamiento de la enfermedad.
     */
    public String getTratamiento() { return tratamiento; }

    /**
     * Establece el tratamiento indicado para la enfermedad.
     *
     * @param tratamiento El nuevo tratamiento de la enfermedad.
     */
    public void setTratamiento(String tratamiento) { this.tratamiento = tratamiento; }

    /**
     * Obtiene el identificador único de la enfermedad.
     *
     * @return El identificador de la enfermedad.
     */
    public String getId() { return id; }

    /**
     * Establece el identificador único de la enfermedad.
     *
     * @param id El nuevo identificador de la enfermedad.
     */
    public void setId(String id) { this.id = id; }

    /**
     * Retorna una representación en cadena de los datos de la enfermedad.
     *
     * @return Cadena con el tipo, gravedad, tratamiento e id de la enfermedad.
     */
    @Override
    public String toString() {
        return "\n********** ENFERMEDAD **********\n" +
                "tipo='" + tipo + '\'' +
                ", gravedad='" + gravedad + '\'' +
                ", tratamiento='" + tratamiento + '\'' +
                ", id='" + id + '\'';
    }
}

package co.edu.poli.contexto1.modelo;

import java.io.Serializable;

/**
 * Representa la clasificación o tipo de un usuario dentro del sistema de simulación.
 * Almacena información taxonómica como especie, raza y tamaño, aplicable
 * principalmente a usuarios de tipo animal.
 * <p>
 * Implementa {@link Serializable} para permitir la persistencia y transferencia
 * de objetos de esta clase.
 * </p>
 *
 * @author Nicolas_David_Atehortua_Duarte
 * @version 1.0
 * @since 2026-03-27
 */
public class Tipo_de_usuario implements Serializable {

    /** Identificador único del tipo de usuario. */
    private String id;

    /** Especie a la que pertenece el usuario. */
    private String especie;

    /** Raza del usuario. */
    private String raza;

    /** Tamaño del usuario (por ejemplo: pequeño, mediano, grande). */
    private String tamaño;

    /**
     * Constructor de la clase Tipo_de_usuario.
     *
     * @param id      Identificador único del tipo de usuario.
     * @param especie Especie a la que pertenece el usuario.
     * @param raza    Raza del usuario.
     * @param tamaño  Tamaño del usuario.
     */
    public Tipo_de_usuario(String id, String especie, String raza, String tamaño) {
        this.id = id;
        this.especie = especie;
        this.raza = raza;
        this.tamaño = tamaño;
    }

    /**
     * Obtiene el identificador del tipo de usuario.
     *
     * @return El identificador único del tipo de usuario.
     */
    public String getId() { return id; }

    /**
     * Establece el identificador del tipo de usuario.
     *
     * @param id El nuevo identificador del tipo de usuario.
     */
    public void setId(String id) { this.id = id; }

    /**
     * Obtiene la especie del usuario.
     *
     * @return La especie a la que pertenece el usuario.
     */
    public String getEspecie() { return especie; }

    /**
     * Establece la especie del usuario.
     *
     * @param especie La nueva especie del usuario.
     */
    public void setEspecie(String especie) { this.especie = especie; }

    /**
     * Obtiene la raza del usuario.
     *
     * @return La raza del usuario.
     */
    public String getRaza() { return raza; }

    /**
     * Establece la raza del usuario.
     *
     * @param raza La nueva raza del usuario.
     */
    public void setRaza(String raza) { this.raza = raza; }

    /**
     * Obtiene el tamaño del usuario.
     *
     * @return El tamaño del usuario.
     */
    public String getTamaño() { return tamaño; }

    /**
     * Establece el tamaño del usuario.
     *
     * @param tamaño El nuevo tamaño del usuario.
     */
    public void setTamaño(String tamaño) { this.tamaño = tamaño; }

    /**
     * Retorna una representación en cadena del tipo de usuario.
     *
     * @return Cadena con el id, especie, raza y tamaño del tipo de usuario.
     */
    @Override
    public String toString() {
        return "\n********** TIPO DE USUARIO **********\n" +
                "id='" + id + '\'' +
                ", especie='" + especie + '\'' +
                ", raza='" + raza + '\'' +
                ", tamaño='" + tamaño + '\'';
    }
}

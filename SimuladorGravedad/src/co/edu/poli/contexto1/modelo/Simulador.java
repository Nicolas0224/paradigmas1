package co.edu.poli.contexto1.modelo;

/**
 * Representa un simulador médico disponible en el sistema.
 * Contiene información sobre su identificador, capacidad, estado operativo,
 * marca y tipo. Incluye atributos de clase compartidos como el fabricante
 * y la versión del simulador.
 *
 * @author Nicolas_David_Atehortua_Duarte
 * @version 1.0
 * @since 2026-03-27
 */
public class Simulador {

    /** Identificador único del simulador. */
    private String id;

    /** Capacidad máxima de usuarios del simulador. */
    private int capacidad;

    /** Indica si el simulador está actualmente operativo. */
    private boolean esOperativo;

    /** Marca del simulador. */
    private String marca;

    /** Tipo o categoría del simulador. */
    private String tipo;

    /**
     * Nombre del fabricante de todos los simuladores.
     * Atributo de clase compartido entre todas las instancias.
     */
    public static String fabricante = "Tesla";

    /**
     * Versión del simulador. Constante de clase que no puede modificarse.
     */
    // PUNTO 3 - atributo que no se puede cambiar
    public static final String VERSION = "v1.0";

    /**
     * Constructor de la clase Simulador.
     *
     * @param id          Identificador único del simulador.
     * @param capacidad   Capacidad máxima de usuarios.
     * @param esOperativo Estado operativo del simulador ({@code true} si está operativo).
     * @param marca       Marca del simulador.
     * @param tipo        Tipo o categoría del simulador.
     */
    public Simulador(String id, int capacidad, boolean esOperativo, String marca, String tipo) {
        this.id = id;
        this.capacidad = capacidad;
        this.esOperativo = esOperativo;
        this.marca = marca;
        this.tipo = tipo;
    }

    /**
     * Obtiene el identificador del simulador.
     *
     * @return El identificador único del simulador.
     */
    public String getId() { return id; }

    /**
     * Establece el identificador del simulador.
     *
     * @param id El nuevo identificador del simulador.
     */
    public void setId(String id) { this.id = id; }

    /**
     * Obtiene la capacidad máxima del simulador.
     *
     * @return La capacidad máxima de usuarios.
     */
    public int getCapacidad() { return capacidad; }

    /**
     * Establece la capacidad máxima del simulador.
     *
     * @param capacidad La nueva capacidad máxima de usuarios.
     */
    public void setCapacidad(int capacidad) { this.capacidad = capacidad; }

    /**
     * Indica si el simulador está operativo.
     *
     * @return {@code true} si el simulador está operativo; {@code false} en caso contrario.
     */
    public boolean isEsOperativo() { return esOperativo; }

    /**
     * Establece el estado operativo del simulador.
     *
     * @param esOperativo {@code true} para marcarlo como operativo; {@code false} para indicar que no lo está.
     */
    public void setEsOperativo(boolean esOperativo) { this.esOperativo = esOperativo; }

    /**
     * Obtiene la marca del simulador.
     *
     * @return La marca del simulador.
     */
    public String getMarca() { return marca; }

    /**
     * Establece la marca del simulador.
     *
     * @param marca La nueva marca del simulador.
     */
    public void setMarca(String marca) { this.marca = marca; }

    /**
     * Obtiene el tipo del simulador.
     *
     * @return El tipo o categoría del simulador.
     */
    public String getTipo() { return tipo; }

    /**
     * Establece el tipo del simulador.
     *
     * @param tipo El nuevo tipo o categoría del simulador.
     */
    public void setTipo(String tipo) { this.tipo = tipo; }

    /**
     * Retorna información básica del simulador incluyendo su id y versión.
     * Este método es final y no puede ser sobreescrito por subclases.
     *
     * @return Cadena con el identificador y la versión del simulador.
     */
    // PUNTO 3 - método que no se puede sobreescribir
    public final String obtenerInfo() {
        return "Simulador: " + id + " Versión: " + VERSION;
    }

    /**
     * Retorna una representación en cadena de los datos del simulador.
     *
     * @return Cadena con el id, capacidad, estado operativo, marca y tipo del simulador.
     */
    @Override
    public String toString() {
        return "\n********** SIMULADOR **********\n" +
                "id='" + id + '\'' +
                ", capacidad=" + capacidad +
                ", esOperativo=" + esOperativo +
                ", marca='" + marca + '\'' +
                ", tipo='" + tipo + '\'';
    }
}

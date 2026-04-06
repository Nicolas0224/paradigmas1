package co.edu.poli.contexto1.modelo;

/**
 * Representa un equipo físico utilizado dentro de los cursos del sistema de simulación.
 * Almacena información técnica del equipo como su modelo, vida útil, tipo,
 * marca, peso y dimensiones.
 *
 * @author Nicolas_David_Atehortua_Duarte
 * @version 1.0
 * @since 2026-03-27
 */
public class Equipo {

    /** Identificador único del equipo. */
    private String id;

    /** Modelo del equipo. */
    private String modelo;

    /** Vida útil estimada del equipo. */
    private String vidaUtil;

    /** Tipo o categoría del equipo. */
    private String tipo;

    /** Marca fabricante del equipo. */
    private String marca;

    /** Peso del equipo en kilogramos. */
    private double peso;

    /** Dimensiones del equipo (por ejemplo, en cm o formato LxAxA). */
    private String dimension;

    /**
     * Constructor de la clase Equipo.
     *
     * @param id        Identificador único del equipo.
     * @param modelo    Modelo del equipo.
     * @param vidaUtil  Vida útil estimada del equipo.
     * @param tipo      Tipo o categoría del equipo.
     * @param marca     Marca fabricante del equipo.
     * @param peso      Peso del equipo en kilogramos.
     * @param dimension Dimensiones del equipo.
     */
    public Equipo(String id, String modelo, String vidaUtil, String tipo, String marca,
                  double peso, String dimension) {
        this.id = id;
        this.modelo = modelo;
        this.vidaUtil = vidaUtil;
        this.tipo = tipo;
        this.marca = marca;
        this.peso = peso;
        this.dimension = dimension;
    }

    /**
     * Obtiene el identificador del equipo.
     *
     * @return El identificador único del equipo.
     */
    public String getId() { return id; }

    /**
     * Establece el identificador del equipo.
     *
     * @param id El nuevo identificador del equipo.
     */
    public void setId(String id) { this.id = id; }

    /**
     * Obtiene el modelo del equipo.
     *
     * @return El modelo del equipo.
     */
    public String getModelo() { return modelo; }

    /**
     * Establece el modelo del equipo.
     *
     * @param modelo El nuevo modelo del equipo.
     */
    public void setModelo(String modelo) { this.modelo = modelo; }

    /**
     * Obtiene la vida útil del equipo.
     *
     * @return La vida útil estimada del equipo.
     */
    public String getVidaUtil() { return vidaUtil; }

    /**
     * Establece la vida útil del equipo.
     *
     * @param vidaUtil La nueva vida útil del equipo.
     */
    public void setVidaUtil(String vidaUtil) { this.vidaUtil = vidaUtil; }

    /**
     * Obtiene el tipo del equipo.
     *
     * @return El tipo o categoría del equipo.
     */
    public String getTipo() { return tipo; }

    /**
     * Establece el tipo del equipo.
     *
     * @param tipo El nuevo tipo o categoría del equipo.
     */
    public void setTipo(String tipo) { this.tipo = tipo; }

    /**
     * Obtiene la marca del equipo.
     *
     * @return La marca fabricante del equipo.
     */
    public String getMarca() { return marca; }

    /**
     * Establece la marca del equipo.
     *
     * @param marca La nueva marca del equipo.
     */
    public void setMarca(String marca) { this.marca = marca; }

    /**
     * Obtiene el peso del equipo.
     *
     * @return El peso del equipo en kilogramos.
     */
    public double getPeso() { return peso; }

    /**
     * Establece el peso del equipo.
     *
     * @param peso El nuevo peso del equipo en kilogramos.
     */
    public void setPeso(double peso) { this.peso = peso; }

    /**
     * Obtiene las dimensiones del equipo.
     *
     * @return Las dimensiones del equipo.
     */
    public String getDimension() { return dimension; }

    /**
     * Establece las dimensiones del equipo.
     *
     * @param dimension Las nuevas dimensiones del equipo.
     */
    public void setDimension(String dimension) { this.dimension = dimension; }

    /**
     * Retorna una representación en cadena de los datos del equipo.
     *
     * @return Cadena con el id, modelo, vida útil, tipo, marca, peso y dimensión del equipo.
     */
    @Override
    public String toString() {
        return "\n********** EQUIPO **********\n" +
                "id='" + id + '\'' +
                ", modelo='" + modelo + '\'' +
                ", vidaUtil='" + vidaUtil + '\'' +
                ", tipo='" + tipo + '\'' +
                ", marca='" + marca + '\'' +
                ", peso=" + peso +
                ", dimension='" + dimension + '\'';
    }
}

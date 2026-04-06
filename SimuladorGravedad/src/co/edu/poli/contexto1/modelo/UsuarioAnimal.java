package co.edu.poli.contexto1.modelo;

/**
 * Representa un usuario de tipo animal dentro del sistema de simulación.
 * Extiende la clase {@link Usuario} y agrega el atributo de vacunación,
 * el cual influye directamente en el descuento aplicado al costo de la sesión.
 * <p>
 * La especie, raza y tamaño del animal se obtienen a través del
 * {@link Tipo_de_usuario} heredado del padre.
 * </p>
 *
 * @author Nicolas_David_Atehortua_Duarte
 * @version 1.0
 * @since 2026-03-27
 * @see Usuario
 */
public class UsuarioAnimal extends Usuario {

    /** Indica si el animal está vacunado. */
    private boolean vacunado;

    /**
     * Constructor de la clase UsuarioAnimal.
     *
     * @param id             Identificador único del usuario.
     * @param nombre         Nombre del animal.
     * @param sexo           Sexo del animal.
     * @param anioNacimiento Año de nacimiento del animal.
     * @param altura         Altura del animal.
     * @param tipoDeUsuario  Tipo de usuario con la clasificación del animal.
     * @param contacto       Información de contacto del responsable.
     * @param telefono       Teléfono del responsable.
     * @param peso           Peso del animal en kilogramos.
     * @param vacunado       {@code true} si el animal está vacunado; {@code false} en caso contrario.
     */
    public UsuarioAnimal(String id, String nombre, String sexo, int anioNacimiento, String altura,
                         Tipo_de_usuario tipoDeUsuario, String contacto, String telefono, double peso, boolean vacunado) {
        super(id, nombre, sexo, anioNacimiento, altura, tipoDeUsuario, contacto, telefono, peso);
        this.vacunado = vacunado;
    }

    /**
     * Indica si el animal está vacunado.
     *
     * @return {@code true} si el animal está vacunado; {@code false} en caso contrario.
     */
    public boolean isVacunado() {
        return vacunado;
    }

    /**
     * Establece el estado de vacunación del animal.
     *
     * @param vacunado {@code true} si el animal está vacunado; {@code false} en caso contrario.
     */
    public void setVacunado(boolean vacunado) {
        this.vacunado = vacunado;
    }

    /**
     * Obtiene la especie del animal desde su tipo de usuario.
     *
     * @return La especie del animal.
     */
    public String getEspecie() { return getTipoDeUsuario().getEspecie(); }

    /**
     * Obtiene la raza del animal desde su tipo de usuario.
     *
     * @return La raza del animal.
     */
    public String getRaza()    { return getTipoDeUsuario().getRaza(); }

    /**
     * Obtiene el tamaño del animal desde su tipo de usuario.
     *
     * @return El tamaño del animal.
     */
    public String getTamaño()  { return getTipoDeUsuario().getTamaño(); }

    /**
     * Calcula el costo de la sesión para el usuario animal.
     * Parte de un costo base de $3.000.000 y aplica el descuento calculado
     * según el estado de vacunación.
     *
     * @param fechaInscripcion Fecha de inscripción del usuario.
     * @return El costo total de la sesión luego de aplicar el descuento.
     */
    //Metodo abstracto del padre
    @Override
    public double calcularCostoSesion(String fechaInscripcion) {
        double costoBase = 3000000;
        int descuento = calcularDescuento(fechaInscripcion);
        return costoBase - (costoBase * descuento / 100);
    }

    /**
     * Calcula el porcentaje de descuento para el usuario animal.
     * Si el animal está vacunado, aplica un descuento del 10%;
     * de lo contrario, no aplica descuento.
     *
     * @param fechaInscripcion Fecha de inscripción del usuario.
     * @return 10 si el animal está vacunado; 0 en caso contrario.
     */
    @Override
    public int calcularDescuento(String fechaInscripcion) {
        if (vacunado) return 10;
        return 0;
    }

    /**
     * Retorna una representación en cadena de los datos del usuario animal.
     *
     * @return Cadena con la especie, raza, tamaño, estado de vacunación
     *         y los datos heredados de {@link Usuario}.
     */
    @Override
    public String toString() {
        return "\n********** DATOS ANIMAL **********\n" +
                "especie='" + getTipoDeUsuario().getEspecie() + '\'' +
                ", raza='" + getTipoDeUsuario().getRaza() + '\'' +
                ", tamaño='" + getTipoDeUsuario().getTamaño() + '\'' +
                ", vacunado=" + vacunado +
                ", " + super.toString();
    }
}

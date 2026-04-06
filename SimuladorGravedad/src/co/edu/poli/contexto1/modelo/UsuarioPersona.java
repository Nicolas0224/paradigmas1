package co.edu.poli.contexto1.modelo;

/**
 * Representa un usuario de tipo persona dentro del sistema de simulación.
 * Extiende la clase {@link Usuario} y agrega atributos propios de una persona
 * como ocupación, nivel educativo, número de cédula y grupo sanguíneo.
 * <p>
 * El nivel educativo influye directamente en el descuento aplicado al
 * costo de la sesión: los usuarios con nivel "Universitario" reciben un 5% adicional.
 * </p>
 *
 * @author Nicolas_David_Atehortua_Duarte
 * @version 1.0
 * @since 2026-03-27
 * @see Usuario
 */
public class UsuarioPersona extends Usuario {

    /** Ocupación o profesión de la persona. */
    private String ocupacion;

    /** Nivel educativo de la persona (por ejemplo: "Universitario", "Bachiller"). */
    private String nivelEducativo;

    /** Número de cédula de ciudadanía de la persona. */
    private String numeroCedula;

    /** Grupo sanguíneo de la persona. */
    private String grupoSanguineo;

    /**
     * Constructor de la clase UsuarioPersona.
     *
     * @param id              Identificador único del usuario.
     * @param nombre          Nombre completo de la persona.
     * @param sexo            Sexo de la persona.
     * @param anioNacimiento  Año de nacimiento de la persona.
     * @param altura          Altura de la persona.
     * @param tipoDeUsuario   Tipo de usuario que clasifica a la persona.
     * @param correo          Correo de contacto de la persona.
     * @param telefono        Número de teléfono de la persona.
     * @param peso            Peso de la persona en kilogramos.
     * @param ocupacion       Ocupación o profesión de la persona.
     * @param nivelEducativo  Nivel educativo de la persona.
     * @param numeroCedula    Número de cédula de la persona.
     * @param grupoSanguineo  Grupo sanguíneo de la persona.
     */
    public UsuarioPersona(String id, String nombre, String sexo, int anioNacimiento, String altura,
                          Tipo_de_usuario tipoDeUsuario, String correo, String telefono, double peso,
                          String ocupacion, String nivelEducativo, String numeroCedula, String grupoSanguineo) {
        super(id, nombre, sexo, anioNacimiento, altura, tipoDeUsuario, correo, telefono, peso);
        this.ocupacion = ocupacion;
        this.nivelEducativo = nivelEducativo;
        this.numeroCedula = numeroCedula;
        this.grupoSanguineo = grupoSanguineo;
    }

    /**
     * Obtiene la ocupación de la persona.
     *
     * @return La ocupación o profesión de la persona.
     */
    public String getOcupacion() { return ocupacion; }

    /**
     * Establece la ocupación de la persona.
     *
     * @param ocupacion La nueva ocupación de la persona.
     */
    public void setOcupacion(String ocupacion) { this.ocupacion = ocupacion; }

    /**
     * Obtiene el nivel educativo de la persona.
     *
     * @return El nivel educativo de la persona.
     */
    public String getNivelEducativo() { return nivelEducativo; }

    /**
     * Establece el nivel educativo de la persona.
     *
     * @param nivelEducativo El nuevo nivel educativo de la persona.
     */
    public void setNivelEducativo(String nivelEducativo) { this.nivelEducativo = nivelEducativo; }

    /**
     * Obtiene el número de cédula de la persona.
     *
     * @return El número de cédula de ciudadanía.
     */
    public String getNumeroCedula() { return numeroCedula; }

    /**
     * Establece el número de cédula de la persona.
     *
     * @param numeroCedula El nuevo número de cédula.
     */
    public void setNumeroCedula(String numeroCedula) { this.numeroCedula = numeroCedula; }

    /**
     * Obtiene el grupo sanguíneo de la persona.
     *
     * @return El grupo sanguíneo de la persona.
     */
    public String getGrupoSanguineo() { return grupoSanguineo; }

    /**
     * Establece el grupo sanguíneo de la persona.
     *
     * @param grupoSanguineo El nuevo grupo sanguíneo de la persona.
     */
    public void setGrupoSanguineo(String grupoSanguineo) { this.grupoSanguineo = grupoSanguineo; }

    /**
     * Calcula el costo de la sesión para el usuario persona.
     * Parte de un costo base de $1.500.000 y aplica el descuento calculado
     * según el nivel educativo y la fecha de inscripción.
     *
     * @param fechaInscripcion Fecha de inscripción del usuario.
     * @return El costo total de la sesión luego de aplicar el descuento.
     */
    //Metodo abstracto del padre
    @Override
    public double calcularCostoSesion(String fechaInscripcion) {
        double costoBase = 1500000;
        int descuento = calcularDescuento(fechaInscripcion);
        return costoBase - (costoBase * descuento / 100);
    }

    /**
     * Calcula el porcentaje de descuento para el usuario persona.
     * Suma al descuento base heredado un 5% adicional si el nivel educativo
     * es "Universitario".
     *
     * @param fechaInscripcion Fecha de inscripción del usuario.
     * @return Porcentaje total de descuento aplicable al usuario persona.
     */
    @Override
    public int calcularDescuento(String fechaInscripcion) {
        int base = super.calcularDescuento(fechaInscripcion);
        // Universitario 5%
        if (nivelEducativo.equals("Universitario")) {
            return base + 5;
        }
        return base;
    }

    /**
     * Calcula el porcentaje de descuento considerando la fecha de inscripción
     * y el tipo de membresía del usuario persona.
     * <p>
     * Los incrementos por membresía son:
     * <ul>
     *   <li>"Full": +15%</li>
     *   <li>"Medio": +10%</li>
     *   <li>"Basico": +5%</li>
     * </ul>
     * </p>
     *
     * @param fechaInscripcion Fecha de inscripción del usuario.
     * @param membresia        Tipo de membresía del usuario ("Full", "Medio" o "Basico").
     * @return Porcentaje de descuento total incluyendo el bono por membresía.
     */
    public int calcularDescuento(String fechaInscripcion, String membresia) {
        int base = calcularDescuento(fechaInscripcion);
        if (membresia.equals("Full"))   return base + 15;
        if (membresia.equals("Medio"))  return base + 10;
        if (membresia.equals("Basico")) return base + 5;
        return base;
    }

    /**
     * Retorna una representación en cadena de los datos del usuario persona.
     *
     * @return Cadena con la ocupación, nivel educativo, número de cédula, grupo sanguíneo
     *         y los datos heredados de {@link Usuario}.
     */
    @Override
    public String toString() {
        return "\n********** DATOS PERSONA **********\n" +
                "ocupacion='" + ocupacion + '\'' +
                ", nivelEducativo='" + nivelEducativo + '\'' +
                ", numeroCedula='" + numeroCedula + '\'' +
                ", grupoSanguineo='" + grupoSanguineo + '\'' +
                ", " + super.toString() +
                '}';
    }
}

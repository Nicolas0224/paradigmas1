package co.edu.poli.contexto1.modelo;

import java.io.Serializable;

/**
 * Clase abstracta que representa un usuario del sistema de simulación.
 * Define los atributos y comportamientos comunes para todos los tipos de usuario,
 * tanto personas como animales.
 * <p>
 * Las subclases deben implementar el método abstracto {@link #calcularCostoSesion(String)}
 * para definir la lógica específica de costo según el tipo de usuario.
 * </p>
 * <p>
 * Implementa {@link Serializable} para permitir la persistencia y transferencia
 * de objetos de esta clase y sus subclases.
 * </p>
 *
 * @author Nicolas_David_Atehortua_Duarte
 * @version 1.0
 * @since 2026-03-27
 * @see UsuarioPersona
 * @see UsuarioAnimal
 */
public abstract class Usuario implements Serializable {

    /** Identificador único del usuario. */
    private String id;

    /** Nombre completo del usuario. */
    private String nombre;

    /** Sexo del usuario. */
    private String sexo;

    /** Año de nacimiento del usuario. */
    private int anioNacimiento;

    /** Altura del usuario (en formato de cadena, por ejemplo "1.75m"). */
    private String altura;

    /** Tipo de usuario que clasifica al usuario según su especie, raza y tamaño. */
    private Tipo_de_usuario tipoDeUsuario;

    /** Información de contacto del usuario o responsable. */
    private String correo;

    /** Número de teléfono del usuario o responsable. */
    private String telefono;

    /** Arreglo de enfermedades registradas para el usuario. */
    private Enfermedad[] enfermedades;

    /** Peso del usuario en kilogramos. */
    private double peso;

    /**
     * Constructor de la clase abstracta Usuario.
     *
     * @param id             Identificador único del usuario.
     * @param nombre         Nombre completo del usuario.
     * @param sexo           Sexo del usuario.
     * @param anioNacimiento Año de nacimiento del usuario.
     * @param altura         Altura del usuario.
     * @param tipoDeUsuario  Tipo de usuario que lo clasifica.
     * @param correo         Correo electronico del usuario o responsable.
     * @param telefono       Número de teléfono del usuario o responsable.
     * @param peso           Peso del usuario en kilogramos.
     */
    public Usuario(String id, String nombre, String sexo, int anioNacimiento, String altura,
                   Tipo_de_usuario tipoDeUsuario, String correo, String telefono, double peso) {
        this.id = id;
        this.nombre = nombre;
        this.sexo = sexo;
        this.anioNacimiento = anioNacimiento;
        this.altura = altura;
        this.tipoDeUsuario = tipoDeUsuario;
        this.correo = correo;
        this.telefono = telefono;
        this.peso = peso;
    }

    /**
     * Obtiene el identificador del usuario.
     *
     * @return El identificador único del usuario.
     */
    public String getId() { return id; }

    /**
     * Establece el identificador del usuario.
     *
     * @param id El nuevo identificador del usuario.
     */
    public void setId(String id) { this.id = id; }

    /**
     * Obtiene el nombre del usuario.
     *
     * @return El nombre completo del usuario.
     */
    public String getNombre() { return nombre; }

    /**
     * Establece el nombre del usuario.
     *
     * @param nombre El nuevo nombre del usuario.
     */
    public void setNombre(String nombre) { this.nombre = nombre; }

    /**
     * Obtiene el sexo del usuario.
     *
     * @return El sexo del usuario.
     */
    public String getSexo() { return sexo; }

    /**
     * Establece el sexo del usuario.
     *
     * @param sexo El nuevo sexo del usuario.
     */
    public void setSexo(String sexo) { this.sexo = sexo; }

    /**
     * Obtiene el año de nacimiento del usuario.
     *
     * @return El año de nacimiento del usuario.
     */
    public int getAnioNacimiento() { return anioNacimiento; }

    /**
     * Establece el año de nacimiento del usuario.
     *
     * @param anioNacimiento El nuevo año de nacimiento del usuario.
     */
    public void setAnioNacimiento(int anioNacimiento) { this.anioNacimiento = anioNacimiento; }

    /**
     * Obtiene la altura del usuario.
     *
     * @return La altura del usuario.
     */
    public String getAltura() { return altura; }

    /**
     * Establece la altura del usuario.
     *
     * @param altura La nueva altura del usuario.
     */
    public void setAltura(String altura) { this.altura = altura; }

    /**
     * Obtiene el tipo de usuario.
     *
     * @return El {@link Tipo_de_usuario} que clasifica al usuario.
     */
    public Tipo_de_usuario getTipoDeUsuario() { return tipoDeUsuario; }

    /**
     * Establece el tipo de usuario.
     *
     * @param tipoDeUsuario El nuevo tipo de usuario.
     */
    public void setTipoDeUsuario(Tipo_de_usuario tipoDeUsuario) { this.tipoDeUsuario = tipoDeUsuario; }

    /**
     * Obtiene la información de contacto del usuario o responsable.
     *
     * @return El contacto del usuario.
     */
    public String getCorreo() { return correo; }

    /**
     * Establece la información de contacto del usuario o responsable.
     *
     * @param contacto El nuevo contacto del usuario.
     */
    public void setCorreo(String correo) { this.correo = correo; }

    /**
     * Obtiene el teléfono del usuario o responsable.
     *
     * @return El número de teléfono del usuario.
     */
    public String getTelefono() { return telefono; }

    /**
     * Establece el teléfono del usuario o responsable.
     *
     * @param telefono El nuevo número de teléfono del usuario.
     */
    public void setTelefono(String telefono) { this.telefono = telefono; }

    /**
     * Obtiene el arreglo de enfermedades registradas del usuario.
     *
     * @return Arreglo de objetos {@link Enfermedad} asociados al usuario.
     */
    public Enfermedad[] getEnfermedades() { return enfermedades; }

    /**
     * Establece el arreglo de enfermedades del usuario.
     *
     * @param enfermedades El nuevo arreglo de enfermedades del usuario.
     */
    public void setEnfermedades(Enfermedad[] enfermedades) { this.enfermedades = enfermedades; }

    /**
     * Obtiene el peso del usuario.
     *
     * @return El peso del usuario en kilogramos.
     */
    public double getPeso() { return peso; }

    /**
     * Establece el peso del usuario.
     *
     * @param peso El nuevo peso del usuario en kilogramos.
     */
    public void setPeso(double peso) { this.peso = peso; }

    /**
     * Calcula el costo de la sesión para el usuario según la fecha de inscripción.
     * Método abstracto que debe ser implementado por cada subclase con su propia
     * lógica de costo y descuento.
     *
     * @param fechaInscripcion Fecha de inscripción del usuario en formato de cadena.
     * @return El costo total de la sesión luego de aplicar descuentos.
     */
    //Metodo abstracto que toma el descuento
    public abstract double calcularCostoSesion(String fechaInscripcion);

    /**
     * Calcula la edad del usuario dado un año de referencia.
     *
     * @param anioActual Año actual de referencia para el cálculo.
     * @return La edad calculada del usuario.
     */
    protected int calcularEdad(int anioActual) {
        return anioActual - anioNacimiento;
    }

    /**
     * Calcula el Índice de Masa Corporal (IMC) del usuario.
     *
     * @param alturaM Altura del usuario en metros.
     * @return El valor del IMC calculado.
     */
    protected double calcularIMC(double alturaM) {
        return getPeso() / (alturaM * alturaM);
    }

    /**
     * Calcula el porcentaje de descuento aplicable según la fecha de inscripción.
     * Versión base que retorna 0; puede ser sobreescrita por subclases.
     *
     * @param fechaInscripcion Fecha de inscripción del usuario.
     * @return Porcentaje de descuento base (0 por defecto).
     */
    // Sobrecarga
    public int calcularDescuento(String fechaInscripcion) {
        return 0;
    }

    /**
     * Calcula el porcentaje de descuento aplicable considerando la fecha de inscripción
     * y el tipo de membresía del usuario.
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
    // Sobrecarga
    public int calcularDescuento(String fechaInscripcion, String membresia) {
        int base = calcularDescuento(fechaInscripcion);
        if (membresia.equals("Full"))   return base + 15;
        if (membresia.equals("Medio"))  return base + 10;
        if (membresia.equals("Basico")) return base + 5;
        return base;
    }

    /**
     * Retorna una representación en cadena de los datos del usuario.
     *
     * @return Cadena con el id, nombre, sexo, año de nacimiento, altura, peso,
     *         tipo de usuario, contacto y teléfono del usuario.
     */
    @Override
    public String toString() {
        return "\n********** USUARIO **********\n" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", sexo='" + sexo + '\'' +
                ", anioNacimiento=" + anioNacimiento +
                ", altura='" + altura + '\'' +
                ", peso=" + peso + '\'' +
                ", tipoDeUsuario=" + tipoDeUsuario +
                ", correo='" + correo + '\'' +
                ", telefono='" + telefono + '\'';
    }
}
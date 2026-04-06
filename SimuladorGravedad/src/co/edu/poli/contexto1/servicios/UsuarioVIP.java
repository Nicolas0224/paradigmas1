package co.edu.poli.contexto1.servicios;

import co.edu.poli.contexto1.modelo.Tipo_de_usuario;
import co.edu.poli.contexto1.modelo.UsuarioPersona;

/**
 * Representa un usuario de tipo VIP dentro del sistema de simulación.
 * Extiende la clase {@link UsuarioPersona} y agrega un nivel VIP que determina
 * descuentos adicionales sobre el costo de la sesión.
 * <p>
 * Los niveles VIP disponibles son: "Platino", "Oro" y "Plata", cada uno
 * con un porcentaje de descuento incremental sobre una base mínima del 30%.
 * El nivel VIP inicial se registra como constante de instancia y no puede modificarse.
 * </p>
 *
 * @author Nicolas_David_Atehortua_Duarte
 * @version 1.0
 * @since 2026-03-27
 * @see UsuarioPersona
 */
public class UsuarioVIP extends UsuarioPersona {

    /**
     * Nivel VIP asignado al momento de la creación del usuario.
     * Constante de instancia que no puede ser modificada posteriormente.
     */
    // PUNTO 3 - atributo que no se puede cambiar
    public final String nivelVipInicial;

    /** Nivel VIP actual del usuario (puede modificarse). */
    private String nivelVip;

    /**
     * Constructor de la clase UsuarioVIP.
     *
     * @param id              Identificador único del usuario.
     * @param nombre          Nombre completo del usuario.
     * @param sexo            Sexo del usuario.
     * @param anioNacimiento  Año de nacimiento del usuario.
     * @param altura          Altura del usuario.
     * @param tipoDeUsuario   Tipo de usuario que clasifica al usuario.
     * @param contacto        Información de contacto del usuario.
     * @param telefono        Número de teléfono del usuario.
     * @param peso            Peso del usuario en kilogramos.
     * @param ocupacion       Ocupación del usuario.
     * @param nivelEducativo  Nivel educativo del usuario.
     * @param numeroCedula    Número de cédula del usuario.
     * @param grupoSanguineo  Grupo sanguíneo del usuario.
     * @param nivelVip        Nivel VIP inicial del usuario ("Platino", "Oro" o "Plata").
     */
    public UsuarioVIP(String id, String nombre, String sexo, int anioNacimiento, String altura,
                      Tipo_de_usuario tipoDeUsuario, String contacto, String telefono, double peso,
                      String ocupacion, String nivelEducativo, String numeroCedula,
                      String grupoSanguineo, String nivelVip) {
        super(id, nombre, sexo, anioNacimiento, altura, tipoDeUsuario, contacto, telefono, peso,
              ocupacion, nivelEducativo, numeroCedula, grupoSanguineo);
        this.nivelVip = nivelVip;
        this.nivelVipInicial = nivelVip;
    }

    /**
     * Obtiene el nivel VIP actual del usuario.
     *
     * @return El nivel VIP actual ("Platino", "Oro" o "Plata").
     */
    public String getNivelVip() { return nivelVip; }

    /**
     * Establece el nivel VIP actual del usuario.
     *
     * @param nivelVip El nuevo nivel VIP del usuario.
     */
    public void setNivelVip(String nivelVip) { this.nivelVip = nivelVip; }

    /**
     * Calcula el costo de la sesión para el usuario VIP.
     * Parte de un costo base de $1.500.000 y aplica el descuento
     * calculado según el nivel VIP del usuario.
     *
     * @param fechaInscripcion Fecha de inscripción del usuario.
     * @return El costo total de la sesión luego de aplicar el descuento VIP.
     */
    //Metodo abstracto del padre
    @Override
    public double calcularCostoSesion(String fechaInscripcion) {
        double costoBase = 1500000;
        int descuento = calcularDescuento(fechaInscripcion);
        return costoBase - (costoBase * descuento / 100);
    }

    /**
     * Calcula el porcentaje de descuento para el usuario VIP según su nivel.
     * Parte de una base mínima del 30% con los siguientes incrementos:
     * <ul>
     *   <li>"Platino": base + 20% = 50%</li>
     *   <li>"Oro":     base + 10% = 40%</li>
     *   <li>"Plata":   base +  5% = 35%</li>
     * </ul>
     *
     * @param fechaInscripcion Fecha de inscripción del usuario.
     * @return Porcentaje de descuento total según el nivel VIP.
     */
    @Override
    public int calcularDescuento(String fechaInscripcion) {
        int base = 30;
        if (nivelVip.equals("Platino")) return base + 20;
        if (nivelVip.equals("Oro"))     return base + 10;
        if (nivelVip.equals("Plata"))   return base + 5;
        return base;
    }

    /**
     * Retorna una representación en cadena de los datos del usuario VIP.
     *
     * @return Cadena con el nivel VIP actual, el nivel VIP inicial
     *         y los datos heredados de {@link UsuarioPersona}.
     */
    @Override
    public String toString() {
        return "\n********** DATOS VIP **********\n" +
                "nivelVip='" + nivelVip + '\'' +
                ", nivelVipInicial='" + nivelVipInicial + '\'' +
                ", " + super.toString();
    }
}

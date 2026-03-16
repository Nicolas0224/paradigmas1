package co.edu.poli.contexto1.modelo;

public class UsuarioPersona extends Usuario {
    private String ocupacion;
    private String nivelEducativo;
    private String numeroCedula;
    private String grupoSanguineo;

    public UsuarioPersona(String id, String nombre, String sexo, int edad, String altura,
                          Tipo_de_usuario tipoDeUsuario, String contacto, String telefono,
                          String ocupacion, String nivelEducativo, String numeroCedula, String grupoSanguineo) {
        super(id, nombre, sexo, edad, altura, tipoDeUsuario, contacto, telefono);
        this.ocupacion = ocupacion;
        this.nivelEducativo = nivelEducativo;
        this.numeroCedula = numeroCedula;
        this.grupoSanguineo = grupoSanguineo;
    }

    public String getOcupacion() { return ocupacion; }
    public void setOcupacion(String ocupacion) { this.ocupacion = ocupacion; }

    public String getNivelEducativo() { return nivelEducativo; }
    public void setNivelEducativo(String nivelEducativo) { this.nivelEducativo = nivelEducativo; }

    public String getNumeroCedula() { return numeroCedula; }
    public void setNumeroCedula(String numeroCedula) { this.numeroCedula = numeroCedula; }

    public String getGrupoSanguineo() { return grupoSanguineo; }
    public void setGrupoSanguineo(String grupoSanguineo) { this.grupoSanguineo = grupoSanguineo; }

    @Override
    public   int calcularDescuento(String fechaInscripcion) {
        int base = super.calcularDescuento(fechaInscripcion);
        // Universitario 5%
        if (nivelEducativo.equals("Universitario")) {
            return base + 5;
        }
        return base;
    }
    public   int calcularDescuento(String fechaInscripcion, String membresia) {
        int base = calcularDescuento(fechaInscripcion);
        if (membresia.equals("Full"))   return base + 15;
        if (membresia.equals("Medio"))  return base + 10;
        if (membresia.equals("Basico")) return base + 5;
        return base;
    }
    
    
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
package co.edu.poli.contexto1.modelo;

public class UsuarioAnimal extends Usuario {
    private String especie;
    private String raza;
    private String tamaño;
    private boolean vacunado;

    public UsuarioAnimal(String id, String nombre, String sexo, int edad, String altura,
                         Tipo_de_usuario tipoDeUsuario, String contacto, String telefono,
                         String especie, String raza, String tamaño, boolean vacunado) {
        super(id, nombre, sexo, edad, altura, tipoDeUsuario, contacto, telefono);
        this.especie = especie;
        this.raza = raza;
        this.tamaño = tamaño;
        this.vacunado = vacunado;
    }

    public String getEspecie() { return especie; }
    public void setEspecie(String especie) { this.especie = especie; }

    public String getRaza() { return raza; }
    public void setRaza(String raza) { this.raza = raza; }

    public String getTamaño() { return tamaño; }
    public void setTamaño(String tamaño) { this.tamaño = tamaño; }

    public boolean isVacunado() { return vacunado; }
    public void setVacunado(boolean vacunado) { this.vacunado = vacunado; }

    @Override
    public int calcularDescuento(String fechaInscripcion) {
        if (vacunado) return 10;
        return 0;
    }

    @Override
    public String toString() {
        return "\n********** DATOS ANIMAL **********\n" +
                "especie='" + especie + '\'' +
                ", raza='" + raza + '\'' +
                ", tamaño='" + tamaño + '\'' +
                ", vacunado=" + vacunado +
                ", " + super.toString();
    }
}
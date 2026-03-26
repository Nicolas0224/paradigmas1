package co.edu.poli.contexto1.modelo;

public abstract class Usuario {
    private String id;
    private String nombre;
    private String sexo;
    private int anioNacimiento;
    private String altura;
    private Tipo_de_usuario tipoDeUsuario;
    private String contacto;
    private String telefono;
    private Enfermedad[] enfermedades;
    private double peso;

    public Usuario(String id, String nombre, String sexo, int anioNacimiento, String altura,
                   Tipo_de_usuario tipoDeUsuario, String contacto, String telefono, double peso) {
        this.id = id;
        this.nombre = nombre;
        this.sexo = sexo;
        this.anioNacimiento = anioNacimiento;
        this.altura = altura;
        this.tipoDeUsuario = tipoDeUsuario;
        this.contacto = contacto;
        this.telefono = telefono;
        this.peso = peso;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getSexo() { return sexo; }
    public void setSexo(String sexo) { this.sexo = sexo; }

    public int getAnioNacimiento() { return anioNacimiento; }
    public void setAnioNacimiento(int anioNacimiento) { this.anioNacimiento = anioNacimiento; }

    public String getAltura() { return altura; }
    public void setAltura(String altura) { this.altura = altura; }

    public Tipo_de_usuario getTipoDeUsuario() { return tipoDeUsuario; }
    public void setTipoDeUsuario(Tipo_de_usuario tipoDeUsuario) { this.tipoDeUsuario = tipoDeUsuario; }

    public String getContacto() { return contacto; }
    public void setContacto(String contacto) { this.contacto = contacto; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public Enfermedad[] getEnfermedades() { return enfermedades; } 
    public void setEnfermedades(Enfermedad[] enfermedades) { this.enfermedades = enfermedades; } 
    
    public double getPeso() { return peso; }
    public void setPeso(double peso) { this.peso = peso; }
    
   
    //Metodo abstracto que toma el desceunto 
    public abstract double calcularCostoSesion(String fechaInscripcion);
 
    protected int calcularEdad(int anioActual) {
        return anioActual - anioNacimiento;
    }
    

    protected double calcularIMC(double alturaM) {
        return getPeso () / (alturaM * alturaM);
    }

    // Sobrecarga
    public int calcularDescuento(String fechaInscripcion) {
        return 0;
    }
    

    // Sobrecarga
    public int calcularDescuento(String fechaInscripcion, String membresia) {
        int base = calcularDescuento(fechaInscripcion);
        if (membresia.equals("Full"))   return base + 15;
        if (membresia.equals("Medio"))  return base + 10;
        if (membresia.equals("Basico")) return base + 5;
        return base;
    }

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
                ", contacto='" + contacto + '\'' +
                ", telefono='" + telefono + '\'';
    }
}
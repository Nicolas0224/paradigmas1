package co.edu.poli.contexto1.modelo;

public class UsuarioAnimal extends Usuario {
   
    private boolean vacunado;

    public UsuarioAnimal(String id, String nombre, String sexo, int edad, String altura,
                         Tipo_de_usuario tipoDeUsuario, String contacto, String telefono, boolean vacunado) {
        super(id, nombre, sexo, edad, altura, tipoDeUsuario, contacto, telefono);
      
        this.vacunado = vacunado;
    }

    public boolean isVacunado() {
		return vacunado;
	}

	public void setVacunado(boolean vacunado) {
		this.vacunado = vacunado;
	}


	public String getEspecie() { return getTipoDeUsuario().getEspecie(); }
    public String getRaza()    { return getTipoDeUsuario().getRaza(); }
    public String getTamaño()  { return getTipoDeUsuario().getTamaño(); }
	
	
	@Override
    public int calcularDescuento(String fechaInscripcion) {
        if (vacunado) return 10;
        return 0;
    }

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
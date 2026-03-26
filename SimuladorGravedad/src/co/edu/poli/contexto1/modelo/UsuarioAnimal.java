package co.edu.poli.contexto1.modelo;

public class UsuarioAnimal extends Usuario {
   
    private boolean vacunado;

    public UsuarioAnimal(String id, String nombre, String sexo, int anioNacimiento, String altura,
                         Tipo_de_usuario tipoDeUsuario, String contacto, String telefono, double peso,boolean vacunado) {
        super(id, nombre, sexo, anioNacimiento, altura, tipoDeUsuario, contacto, telefono, peso);
      
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
	
   
    
    //Metodo abstracto del padre
    @Override
    public double calcularCostoSesion(String fechaInscripcion) { 
    		double costoBase = 3000000;
    		int descuento = calcularDescuento(fechaInscripcion);
    		return costoBase -(costoBase * descuento / 100);
    }
    
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
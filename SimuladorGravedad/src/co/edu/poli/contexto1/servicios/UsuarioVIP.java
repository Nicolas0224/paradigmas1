package co.edu.poli.contexto1.servicios;

import co.edu.poli.contexto1.modelo.Tipo_de_usuario;
import co.edu.poli.contexto1.modelo.UsuarioPersona;
 
public class UsuarioVIP extends UsuarioPersona {
 
    // PUNTO 3 - atributo que no se puede cambiar
    public final String nivelVipInicial;
 
    private String nivelVip;
 
    public UsuarioVIP(String id, String nombre, String sexo, int anioNacimiento, String altura,
                      Tipo_de_usuario tipoDeUsuario, String contacto, String telefono,
                      String ocupacion, String nivelEducativo, String numeroCedula,
                      String grupoSanguineo, String nivelVip) {
        super(id, nombre, sexo, anioNacimiento, altura, tipoDeUsuario, contacto, telefono,
              ocupacion, nivelEducativo, numeroCedula, grupoSanguineo);
        this.nivelVip = nivelVip;
        this.nivelVipInicial = nivelVip;
    }
 
    public String getNivelVip() { return nivelVip; }
    public void setNivelVip(String nivelVip) { this.nivelVip = nivelVip; }
 
   
    
    //Metodo abstracto del padre
    @Override
    public double calcularCostoSesion(String fechaInscripcion) { 
    		double costoBase = 1500000;
    		int descuento = calcularDescuento(fechaInscripcion);
    		return costoBase -(costoBase * descuento / 100);
    }
    
    @Override
    public int calcularDescuento(String fechaInscripcion) {
        int base = 30;
        if (nivelVip.equals("Platino")) return base + 20;
        if (nivelVip.equals("Oro"))     return base + 10;
        if (nivelVip.equals("Plata"))   return base + 5;
        return base;
    }
 
    @Override
    public String toString() {
        return "\n********** DATOS VIP **********\n" +
                "nivelVip='" + nivelVip + '\'' +
                ", nivelVipInicial='" + nivelVipInicial + '\'' +
                ", " + super.toString();
    }
}
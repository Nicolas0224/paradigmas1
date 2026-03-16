package co.edu.poli.contexto1.servicios;

import co.edu.poli.contexto1.modelo.Tipo_de_usuario;
import co.edu.poli.contexto1.modelo.UsuarioPersona;

public class UsuarioVIP extends UsuarioPersona {
    private String nivelMembresia;

    public UsuarioVIP(String id, String nombre, String sexo, int edad, String altura,
                      Tipo_de_usuario tipoDeUsuario, String contacto, String telefono,
                      String ocupacion, String nivelEducativo, String numeroCedula, String grupoSanguineo,
                      String nivelMembresia) {
        super(id, nombre, sexo, edad, altura, tipoDeUsuario, contacto, telefono,
              ocupacion, nivelEducativo, numeroCedula, grupoSanguineo);
        this.nivelMembresia = nivelMembresia;
    }

    public String getNivelMembresia() { return nivelMembresia; }
    public void setNivelMembresia(String nivelMembresia) { this.nivelMembresia = nivelMembresia; }

    @Override
    public  int calcularDescuento(String fechaInscripcion) {
        // VIP 30 garantizado
        int base = super.calcularDescuento(fechaInscripcion);
        int bonusMembresia;
        if (nivelMembresia.equals("Platino")) {
            bonusMembresia = 15;
        } else if (nivelMembresia.equals("Oro")) {
            bonusMembresia = 10;
        } else if (nivelMembresia.equals("Plata")) {
            bonusMembresia = 5;
        } else {
            bonusMembresia = 0;
        }
        return Math.max(base + bonusMembresia, 30);
    }

    @Override
    public String toString() {
        return "\n--------- DATOS VIP ---------\n" +
                "nivelMembresia='" + nivelMembresia + '\'' +
                ", " + super.toString();
    }
}
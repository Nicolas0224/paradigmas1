package co.edu.poli.contexto1.modelo;

public class Instructor {
    private String id;
    private String nombre;
    private String especialidad;
   

    public Instructor(String id, String nombre, String especialidad) {
        this.id = id;
        this.nombre = nombre;
      
        this.especialidad = especialidad;
        
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getEspecialidad() { return especialidad; }
    public void setEspecialidad(String especialidad) { this.especialidad = especialidad; }


    @Override
    public String toString() {
        return "\n********** INSTRUCTOR **********\n" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", especialidad='" + especialidad + '\'';
    }
}
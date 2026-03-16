package co.edu.poli.contexto1.modelo;

public class Tipo_de_usuario {
    private String id;
    private String especie;
    private String raza;
    private String tamaño;

    public Tipo_de_usuario(String id, String especie, String raza, String tamaño) {
        this.id = id;
        this.especie = especie;
        this.raza = raza;
        this.tamaño = tamaño;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getEspecie() { return especie; }
    public void setEspecie(String especie) { this.especie = especie; }

    public String getRaza() { return raza; }
    public void setRaza(String raza) { this.raza = raza; }

    public String getTamaño() { return tamaño; }
    public void setTamaño(String tamaño) { this.tamaño = tamaño; }

    @Override
    public String toString() {
        return "\n********** TIPO DE USUARIO **********\n" +
                "id='" + id + '\'' +
                ", especie='" + especie + '\'' +
                ", raza='" + raza + '\'' +
                ", tamaño='" + tamaño + '\'';
    }
}
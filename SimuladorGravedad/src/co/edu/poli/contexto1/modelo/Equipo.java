package co.edu.poli.contexto1.modelo;

public class Equipo {
    private String id;
    private String modelo;
    private String vidaUtil;
    private String tipo;
    private String marca;
    private double peso;
    private String dimension;

    public Equipo(String id, String modelo, String vidaUtil, String tipo, String marca,
                  double peso, String dimension) {
        this.id = id;
        this.modelo = modelo;
        this.vidaUtil = vidaUtil;
        this.tipo = tipo;
        this.marca = marca;
        this.peso = peso;
        this.dimension = dimension;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }

    public String getVidaUtil() { return vidaUtil; }
    public void setVidaUtil(String vidaUtil) { this.vidaUtil = vidaUtil; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }

    public double getPeso() { return peso; }
    public void setPeso(double peso) { this.peso = peso; }

    public String getDimension() { return dimension; }
    public void setDimension(String dimension) { this.dimension = dimension; }

    @Override
    public String toString() {
        return "\n********** EQUIPO **********\n" +
                "id='" + id + '\'' +
                ", modelo='" + modelo + '\'' +
                ", vidaUtil='" + vidaUtil + '\'' +
                ", tipo='" + tipo + '\'' +
                ", marca='" + marca + '\'' +
                ", peso=" + peso +
                ", dimension='" + dimension + '\'';
    }
}
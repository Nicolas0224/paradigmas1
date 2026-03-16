package co.edu.poli.contexto1.modelo;

public class Simulador {
    private String id;
    private int capacidad;
    private boolean esOperativo;
    private String marca;
    private String tipo;

    public static String fabricante = "Tesla";

    public Simulador(String id, int capacidad, boolean esOperativo, String marca, String tipo) {
        this.id = id;
        this.capacidad = capacidad;
        this.esOperativo = esOperativo;
        this.marca = marca;
        this.tipo = tipo;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public int getCapacidad() { return capacidad; }
    public void setCapacidad(int capacidad) { this.capacidad = capacidad; }

    public boolean isEsOperativo() { return esOperativo; }
    public void setEsOperativo(boolean esOperativo) { this.esOperativo = esOperativo; }

    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    @Override
    public String toString() {
        return "\n********** SIMULADOR **********\n" +
                "id='" + id + '\'' +
                ", capacidad=" + capacidad +
                ", esOperativo=" + esOperativo +
                ", marca='" + marca + '\'' +
                ", tipo='" + tipo + '\'';
    }
}
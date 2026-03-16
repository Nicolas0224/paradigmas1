package co.edu.poli.contexto1.modelo;

public class Simulador {
    private String id;
    private int capacidad;
    private boolean esOperativo;
    private String marca;
    private String tipo;

    public static String fabricante = "Tesla";

    // PUNTO 3 - atributo que no se puede cambiar
    public static final String VERSION = "v1.0";

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

    // PUNTO 3 - método que no se puede sobreescribir
    public final String obtenerInfo() {
        return "Simulador: " + id + " Versión: " + VERSION;
    }

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
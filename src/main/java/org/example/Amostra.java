package org.example;

public class Amostra {
    private int id;
    private String tipoMineral;
    private double peso;

    public Amostra(int id, String tipoMineral, double peso) {
        this.id = id;
        this.tipoMineral = tipoMineral;
        this.peso = peso;
    }

    public int getId() { return id; }
    public double getPeso() { return peso; }

    @Override
    public String toString() {
        return "ID: " + id + " | Mineral: " + tipoMineral + " | Peso: " + peso + "kg";
    }
}

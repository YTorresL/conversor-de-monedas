package com.torres.calculos;

public class ConvertirMoneda {
    private final double monedaBase;
    private final double monedaDestino;
    private final String nombreMonedaBase;
    private final String nombreMonedaDestino;
    private double resultado;

    public ConvertirMoneda(double monedaBase, double monedaDestino, String nombreMonedaBase, String nombreMonedaDestino) {
        this.monedaBase = monedaBase;
        this.monedaDestino = monedaDestino;
        this.nombreMonedaBase = nombreMonedaBase;
        this.nombreMonedaDestino = nombreMonedaDestino;
        this.convertirMoneda();
    }

    public void convertirMoneda() {
        resultado = monedaBase * monedaDestino;
    }

    @Override
    public String toString() {
        return "La cantidad de " + monedaBase + " "+ nombreMonedaBase + " que ingresaste equivale a " + resultado + " " + nombreMonedaDestino;
    }

}

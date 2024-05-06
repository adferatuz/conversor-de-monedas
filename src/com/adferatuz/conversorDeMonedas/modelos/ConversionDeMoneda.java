package com.adferatuz.conversorDeMonedas.modelos;

import java.util.Map;

public class ConversionDeMoneda {
    private String tipoMoneda;
    private  double cantidadAConvertir;
    private double valorFinal;
    private Map<String, Double> conversionRates;

    public String getTipoMoneda() {
        return tipoMoneda;
    }

    public  ConversionDeMoneda(MonedaConvertida monedaConvertida) {
        this.conversionRates = monedaConvertida.conversion_rates();
    }

    public Map<String, Double> getConversionRates() {
        return conversionRates;
    }

    public void setConversionRates(Map<String, Double> conversionRates) {
        this.conversionRates = conversionRates;
    }

    public void setTipoMoneda(String tipoMoneda) {
        this.tipoMoneda = tipoMoneda;
    }

    public double getCantidadAConvertir() {
        return cantidadAConvertir;
    }

    public void setCantidadAConvertir(double cantidadAConvertir) {
        this.cantidadAConvertir = cantidadAConvertir;
    }

    public double getValorFinal() {
        return valorFinal;
    }

    public void setValorFinal(double valorFinal) {
        this.valorFinal = valorFinal;
    }

    @Override
    public String toString() {
        return "La cantidad "+this.cantidadAConvertir+"["+this.tipoMoneda+"] equivalen a "+
                this.valorFinal+" ["+this.tipoMoneda+"]";
    }
}

package com.adferatuz.conversorDeMonedas.funcionalidaes;

import com.adferatuz.conversorDeMonedas.modelos.ConversionDeMoneda;

import java.util.Map;

public class MenuDeOpciones {
    public String elegirOpcion(int opcion){
        String opcionElegida;
        if (opcion == 1 || opcion == 3 || opcion == 5){
            return opcionElegida = "usd".toUpperCase();
        } else if (opcion == 2) {
            return opcionElegida = "ars".toUpperCase();
        } else if (opcion == 4) {
            return opcionElegida = "cop".toUpperCase();
        }else {
            return opcionElegida = "brl".toUpperCase();
        }
    }

    public void menu(){
        System.out.println("\nBIENVENIDO AL MENU DE CONVERSION DE MONEDAS\n****************************************\n");
        System.out.println("""
                OPCIONES:
                
                1). Dólar ==> Peso Argentino.
                2). Peso Argentino ==> Dólar.
                3). Dólar ==> Peso Colombiano.
                4). Peso Colombiano ==> Dólar.
                5). Dólar ==> Real Brasileño.
                6). Real Brasileño ==> Dólar.
                7). Salir
                Elija una opción válida:
                
                ****************************************                
                """);
    }

    public void resultadoTasaCambio(String opcionElegida,
                                      double valorAingresar,
                                      String opcionDeMonedaACambiar,
                                      ConversionDeMoneda conversion)
    {
        String mensaje;
        for (Map.Entry<String, Double> entry2 : conversion.getConversionRates().entrySet()) {
            if (entry2.getKey().equals(opcionDeMonedaACambiar)) {
                System.out.println("los [$"+valorAingresar+"] ["+opcionElegida+"] "+
                        "equivalen a [$"+valorAingresar * entry2.getValue()+"] ["+opcionDeMonedaACambiar+"]");
            }
        }
    }
}

package com.adferatuz.conversorDeMonedas.principal;

import com.adferatuz.conversorDeMonedas.conexion.ConsumirApi;
import com.adferatuz.conversorDeMonedas.funcionalidaes.MenuDeOpciones;
import com.adferatuz.conversorDeMonedas.modelos.ConversionDeMoneda;
import com.adferatuz.conversorDeMonedas.modelos.MonedaConvertida;

import java.util.Map;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        MenuDeOpciones menuDeOpciones = new MenuDeOpciones();
        ConsumirApi consultar = new ConsumirApi();
        String opcionElegida;
        String opcionDeMonedaACambiar;
        int opcion;
        double valorAingresar;

        while (true){
            try{
                menuDeOpciones.menu();
                System.out.println("Digite la opcion que desea utilizar:");
                opcion = lectura.nextInt();
                opcionElegida = menuDeOpciones.elegirOpcion(opcion);
                MonedaConvertida monedaConvertida = consultar.convertirMoneda(opcionElegida);
                ConversionDeMoneda conversion = new ConversionDeMoneda(monedaConvertida);

                System.out.println("Valores de conversionRates:");
                for (Map.Entry<String, Double> entry : conversion.getConversionRates().entrySet()) {
                    if (opcion == 1 || opcion == 3 || opcion == 5){
                        System.out.println("Digite el valor en ["+opcionElegida+"]:");
                        valorAingresar = lectura.nextDouble();
                        if (opcion == 1){
                            opcionDeMonedaACambiar = "ars".toUpperCase();
                            for (Map.Entry<String, Double> entry2 : conversion.getConversionRates().entrySet()) {
                                if (entry2.getKey().equals(opcionDeMonedaACambiar)) {

                                    System.out.println("Esta es la moneda ["+opcionDeMonedaACambiar+"] "+
                                            "y su valor actual en base al ["+opcionElegida+"] "+
                                            "es de: "+entry2.getValue()+"\ny el valor de la operacion es de: "+
                                            valorAingresar * entry2.getValue());
                                }

                            }
                        }

                    }
                    //System.out.println("\n"+entry.getKey() + ": " + entry.getValue());
                }

            }catch (Exception e){
                System.out.println("Error en la ejecucion de la aplicacion"+ e);
                lectura.nextLine();
            }

        }


    }


}

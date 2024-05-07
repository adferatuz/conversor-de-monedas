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

                if (opcion == 7){
                    System.out.println("Gracias por haber usado la aplicación; Hasta pronto 😊");
                    break;
                } else if (opcion > 7) {
                    System.out.println("Opcion incorrecta; Por favor digita nuevamente la opcion a elegir:");
                    continue;
                }

                for (Map.Entry<String, Double> entry : conversion.getConversionRates().entrySet()) {
                    if (opcion == 1 ){
                        System.out.println("Digite el valor en ["+opcionElegida+"]:");
                        valorAingresar = lectura.nextDouble();
                        opcionDeMonedaACambiar = "ars".toUpperCase();
                        menuDeOpciones.resultadoTasaCambio(opcionElegida,valorAingresar,opcionDeMonedaACambiar,conversion);
                        break;
                    }else if (opcion == 2){
                        System.out.println("Digite el valor en ["+opcionElegida+"]:");
                        valorAingresar = lectura.nextDouble();
                        opcionDeMonedaACambiar = "usd".toUpperCase();
                        menuDeOpciones.resultadoTasaCambio(opcionElegida,valorAingresar,opcionDeMonedaACambiar,conversion);
                        break;
                    }else if (opcion == 3){
                        System.out.println("Digite el valor en ["+opcionElegida+"]:");
                        valorAingresar = lectura.nextDouble();
                        opcionDeMonedaACambiar = "cop".toUpperCase();
                        menuDeOpciones.resultadoTasaCambio(opcionElegida,valorAingresar,opcionDeMonedaACambiar,conversion);
                        break;
                    }else if (opcion == 4){
                        System.out.println("Digite el valor en ["+opcionElegida+"]:");
                        valorAingresar = lectura.nextDouble();
                        opcionDeMonedaACambiar = "usd".toUpperCase();
                        menuDeOpciones.resultadoTasaCambio(opcionElegida,valorAingresar,opcionDeMonedaACambiar,conversion);
                        break;
                    }else if (opcion == 5){
                        System.out.println("Digite el valor en ["+opcionElegida+"]:");
                        valorAingresar = lectura.nextDouble();
                        opcionDeMonedaACambiar = "brl".toUpperCase();
                        menuDeOpciones.resultadoTasaCambio(opcionElegida,valorAingresar,opcionDeMonedaACambiar,conversion);
                        break;
                    }else if (opcion == 6){
                        System.out.println("Digite el valor en ["+opcionElegida+"]:");
                        valorAingresar = lectura.nextDouble();
                        opcionDeMonedaACambiar = "usd".toUpperCase();
                        menuDeOpciones.resultadoTasaCambio(opcionElegida,valorAingresar,opcionDeMonedaACambiar,conversion);
                        break;
                    }else {
                        System.out.println("Has ingresado una opcion incorrecta; Por favor ingresa nuevamente la "+
                                "opcion que deseas elegir:");
                        break;
                    }

                }

            }catch (Exception e){
                System.out.println("Error en la ejecucion de la aplicacion"+ e);
                lectura.nextLine();
            }

        }


    }


}

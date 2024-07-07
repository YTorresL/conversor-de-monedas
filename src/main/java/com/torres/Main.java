package com.torres;

import com.google.gson.Gson;
import com.torres.calculos.ConvertirMoneda;
import com.torres.models.ConversionRates;
import com.torres.services.SolicitudesAPI;

import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        boolean continuar = true;

        while (continuar) {
            System.out.println();
            System.out.println("************  Conversor de monedas  *******************");
            System.out.println("Bienvenido/a, escoge una moneda para convertir:");
            System.out.println();
            System.out.println("1. Dolar => Peso Argentino");
            System.out.println("2. Peso Argentino => Dolar");
            System.out.println("3. Dolar => Real brasilero");
            System.out.println("4. Real brasilero => Dolar");
            System.out.println("5. Dolar => Peso colombiano");
            System.out.println("6. Peso colombiano => Dolar");
            System.out.println("7. Salir");
            System.out.println();
            System.out.println("*******************************************************");
            System.out.println();
            System.out.println("Ingrese el número de la opción deseada: ");

            Scanner scanner = new Scanner(System.in);
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    dolarAPesoArgentino();
                    break;
                case 2:
                    pesoArgentinoADolar();
                    break;
                case 3:
                    dolarARealBrasilero();
                    break;
                case 4:
                    realBrasileroADolar();
                    break;
                case 5:
                    dolarAPesoColombiano();
                    break;
                case 6:
                    pesoColombianoADolar();
                    break;
                case 7:
                    continuar = false;
                    System.out.println("Gracias por usar nuestro conversor de monedas.");
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }}

    }

    private static void pesoColombianoADolar() {
        System.out.println("Ingrese la cantidad de pesos colombianos a convertir: ");
        Scanner scanner = new Scanner(System.in);
        double cantidad = scanner.nextDouble();
        String solicitud = null;

        try {
            solicitud = SolicitudesAPI.SolicitarAPI("COP");
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

        Gson gson = new Gson();
        ConversionRates conversionRates = gson.fromJson(solicitud, ConversionRates.class);
        Map<String, Double> tasasConversion = conversionRates.conversionRates();

        ConvertirMoneda convertirMoneda = new ConvertirMoneda(cantidad, tasasConversion.get("USD"), "COP", "USD");

        System.out.println(convertirMoneda.toString());
    }

    private static void dolarAPesoColombiano() {
        System.out.println("Ingrese la cantidad de dolares a convertir: ");
        Scanner scanner = new Scanner(System.in);
        double cantidad = scanner.nextDouble();
        String solicitud = null;

        try {
            solicitud = SolicitudesAPI.SolicitarAPI("USD");
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

        Gson gson = new Gson();
        ConversionRates conversionRates = gson.fromJson(solicitud, ConversionRates.class);
        Map<String, Double> tasasConversion = conversionRates.conversionRates();

        ConvertirMoneda convertirMoneda = new ConvertirMoneda(cantidad, tasasConversion.get("COP"), "USD", "COP");

        System.out.println(convertirMoneda.toString());
    }

    private static void realBrasileroADolar() {
        System.out.println("Ingrese la cantidad de reales brasileros a convertir: ");
        Scanner scanner = new Scanner(System.in);
        double cantidad = scanner.nextDouble();
        String solicitud = null;

        try {
            solicitud = SolicitudesAPI.SolicitarAPI("BRL");
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

        Gson gson = new Gson();
        ConversionRates conversionRates = gson.fromJson(solicitud, ConversionRates.class);
        Map<String, Double> tasasConversion = conversionRates.conversionRates();

        ConvertirMoneda convertirMoneda = new ConvertirMoneda(cantidad, tasasConversion.get("USD"), "BRL", "USD");

        System.out.println(convertirMoneda.toString());
    }

    private static void dolarARealBrasilero() {
        System.out.println("Ingrese la cantidad de dolares a convertir: ");
        Scanner scanner = new Scanner(System.in);
        double cantidad = scanner.nextDouble();
        String solicitud = null;

        try {
            solicitud = SolicitudesAPI.SolicitarAPI("USD");
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

        Gson gson = new Gson();
        ConversionRates conversionRates = gson.fromJson(solicitud, ConversionRates.class);
        Map<String, Double> tasasConversion = conversionRates.conversionRates();

        ConvertirMoneda convertirMoneda = new ConvertirMoneda(cantidad, tasasConversion.get("BRL"), "USD", "BRL");

        System.out.println(convertirMoneda.toString());


    }

    private static void pesoArgentinoADolar() {
        System.out.println("Ingrese la cantidad de pesos argentinos a convertir: ");
        Scanner scanner = new Scanner(System.in);
        double cantidad = scanner.nextDouble();
        String solicitud = null;

        try {
            solicitud = SolicitudesAPI.SolicitarAPI("ARS");
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

        Gson gson = new Gson();
        ConversionRates conversionRates = gson.fromJson(solicitud, ConversionRates.class);
        Map<String, Double> tasasConversion = conversionRates.conversionRates();

        ConvertirMoneda convertirMoneda = new ConvertirMoneda(cantidad, tasasConversion.get("USD"), "ARS", "USD");

        System.out.println(convertirMoneda.toString());

    }

    private static void dolarAPesoArgentino() {

        System.out.println("Ingrese la cantidad de dolares a convertir: ");
        Scanner scanner = new Scanner(System.in);
        double cantidad = scanner.nextDouble();
        String solicitud = null;

        try {
            solicitud =   SolicitudesAPI.SolicitarAPI("USD");
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

        Gson gson = new Gson();
        ConversionRates conversionRates = gson.fromJson(solicitud, ConversionRates.class);
        Map<String, Double> tasasConversion = conversionRates.conversionRates();

        ConvertirMoneda convertirMoneda = new ConvertirMoneda(cantidad, tasasConversion.get("ARS"), "USD", "ARS");

        System.out.println(convertirMoneda.toString());
    }
}


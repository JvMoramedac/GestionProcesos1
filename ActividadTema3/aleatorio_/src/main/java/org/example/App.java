package org.example;

import java.util.Random;

public class App {
    public static void main(String[] args) {

        //Creamos las variables necesarias para crear el programa, random para generar numeros y array para guardarlos
        Random aleatorio = new Random();
        int[] Numeros = new int[40];

        //Lo guardamos en el array aleatoriamente
        for (int i = 0; i < Numeros.length; i++) {
            Numeros[i] = aleatorio.nextInt(101); // Rango de número del aleatorio
            System.out.print(Numeros[i] + " ");
        }
    }
}
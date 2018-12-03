/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author javiershaka
 */
public class GaussSeidel {

    public void Seidel(double matriz[][], double error) {
        


             Scanner teclado = new Scanner(System.in);
        System.out.println("Gaus-Seidel Iteraciones");
        double matrizRaiz[][] =matriz;
        
        int filas = matrizRaiz.length;
        int columnas= matrizRaiz[0].length;
    
////        double matrizRaiz[][] = new double[filas][columnas];
//        System.out.println("LLENAR TODOS LOS CAMPOS DE LA MATRIZ");
//        for (int i = 0; i < filas; i++) {
//            for (int j = 0; j < columnas; j++) {
//                System.out.println("[" + i + "]" + "[" + j + "]");
//                matrizRaiz[i][j] = teclado.nextDouble();
//            }
//        }

        System.out.println("IMPRESION DE LA MATRIZ");
        for (int i = 0; i < filas; i++) {
            System.out.println("");
            for (int j = 0; j < columnas; j++) {
                System.out.print("|" + matrizRaiz[i][j]);
            }
        }
        double matrizB[] = new double[filas];
        for (int i = 0; i < filas; i++) {
            matrizB[i] = matrizRaiz[i][(columnas - 1)];
        }
        //comprovacion de matriz dominante

        double matrizReplicaDominante[][] = new double[filas][columnas];
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                matrizReplicaDominante[i][j] = matrizRaiz[i][j];
            }
        }
        while (true) {
            if (filas == 3) {
                if (Math.abs(matrizReplicaDominante[0][0]) < (Math.abs(matrizReplicaDominante[0][1]) + Math.abs(matrizReplicaDominante[0][2])) || Math.abs(matrizReplicaDominante[1][1]) < (Math.abs(matrizReplicaDominante[1][0]) + Math.abs(matrizReplicaDominante[1][2])) || Math.abs(matrizReplicaDominante[2][2]) < (Math.abs(matrizReplicaDominante[2][0]) + Math.abs(matrizReplicaDominante[2][1]))) {
                    matrizReplicaDominante[0][0] = matrizRaiz[1][0];
                    matrizReplicaDominante[0][1] = matrizRaiz[1][1];
                    matrizReplicaDominante[0][2] = matrizRaiz[1][2];
                    matrizReplicaDominante[0][3] = matrizRaiz[1][3];

                    matrizReplicaDominante[1][0] = matrizRaiz[0][0];
                    matrizReplicaDominante[1][1] = matrizRaiz[0][1];
                    matrizReplicaDominante[1][2] = matrizRaiz[0][2];
                    matrizReplicaDominante[1][3] = matrizRaiz[0][3];

                } else {
                    break;
                }
            }
            if (filas == 4) {
                if (Math.abs(matrizReplicaDominante[0][0]) < (Math.abs(matrizReplicaDominante[0][1]) + Math.abs(matrizReplicaDominante[0][2]) + Math.abs(matrizReplicaDominante[0][3])) || Math.abs(matrizReplicaDominante[1][1]) < (Math.abs(matrizReplicaDominante[1][0]) + Math.abs(matrizReplicaDominante[1][2]) + Math.abs(matrizReplicaDominante[1][3])) || Math.abs(matrizReplicaDominante[2][2]) < (Math.abs(matrizReplicaDominante[2][0]) + Math.abs(matrizReplicaDominante[2][1]) + Math.abs(matrizReplicaDominante[2][3])) || Math.abs(matrizReplicaDominante[3][3]) < (Math.abs(matrizReplicaDominante[3][0]) + Math.abs(matrizReplicaDominante[3][1]) + Math.abs(matrizReplicaDominante[3][2]))) {
                    matrizReplicaDominante[0][0] = matrizRaiz[1][0];
                    matrizReplicaDominante[0][1] = matrizRaiz[1][1];
                    matrizReplicaDominante[0][2] = matrizRaiz[1][2];
                    matrizReplicaDominante[0][3] = matrizRaiz[1][3];
                    matrizReplicaDominante[0][4] = matrizRaiz[1][4];

                    matrizReplicaDominante[1][0] = matrizRaiz[0][0];
                    matrizReplicaDominante[1][1] = matrizRaiz[0][1];
                    matrizReplicaDominante[1][2] = matrizRaiz[0][2];
                    matrizReplicaDominante[1][3] = matrizRaiz[0][3];
                    matrizReplicaDominante[1][4] = matrizRaiz[0][4];

                } else {
                    break;
                }

            }

        }
        System.out.println("");
        System.out.println("impresion de matriz diagonal dominante dominante");
        for (int i = 0; i < filas; i++) {
            System.out.println("");
            for (int j = 0; j < columnas; j++) {
                System.out.print("|" + matrizReplicaDominante[i][j]);
            }
        }
        System.out.println("");
        List<Double> iteracionesX = new ArrayList<Double>();
        List<Double> iteracionesY = new ArrayList<Double>();
        List<Double> iteracionesZ = new ArrayList<Double>();
        List<Double> iteracionesT = new ArrayList<Double>();
        iteracionesX.add(0.0);
        iteracionesY.add(0.0);
        iteracionesZ.add(0.0);
        iteracionesT.add(0.0);
        while (true) {

            if (filas == 3) {

                iteracionesX.add((matrizB[0] - ((matrizReplicaDominante[0][1]) * iteracionesY.get(iteracionesY.size() - 1)) - ((matrizReplicaDominante[0][2]) * iteracionesZ.get(iteracionesZ.size() - 1))) / matrizReplicaDominante[0][0]);
                iteracionesY.add((matrizB[1] - ((matrizReplicaDominante[1][0]) * iteracionesX.get(iteracionesX.size() - 1)) - ((matrizReplicaDominante[1][2]) * iteracionesZ.get(iteracionesZ.size() - 1))) / matrizReplicaDominante[1][1]);
                iteracionesZ.add((matrizB[2] - ((matrizReplicaDominante[2][0]) * iteracionesX.get(iteracionesX.size() - 1)) - ((matrizReplicaDominante[2][1]) * iteracionesY.get(iteracionesY.size() - 1))) / matrizReplicaDominante[2][2]);

                if (iteracionesX.size() == 7) {
                    break;
                }
            }
            if (filas == 4) {
                iteracionesX.add((matrizB[0] - ((matrizReplicaDominante[0][1]) * iteracionesY.get(iteracionesY.size() - 1)) - ((matrizReplicaDominante[0][2]) * iteracionesZ.get(iteracionesZ.size() - 1)) - ((matrizReplicaDominante[0][3]) * iteracionesT.get(iteracionesT.size() - 1))) / matrizReplicaDominante[0][0]);
                iteracionesY.add((matrizB[1] - ((matrizReplicaDominante[1][0]) * iteracionesX.get(iteracionesX.size() - 1)) - ((matrizReplicaDominante[1][2]) * iteracionesZ.get(iteracionesZ.size() - 1)) - ((matrizReplicaDominante[1][3]) * iteracionesT.get(iteracionesT.size() - 1))) / matrizReplicaDominante[1][1]);
                iteracionesZ.add((matrizB[2] - ((matrizReplicaDominante[2][0]) * iteracionesX.get(iteracionesX.size() - 1)) - ((matrizReplicaDominante[2][1]) * iteracionesY.get(iteracionesY.size() - 1)) - ((matrizReplicaDominante[2][3]) * iteracionesT.get(iteracionesT.size() - 1))) / matrizReplicaDominante[2][2]);
                iteracionesT.add((matrizB[3] - ((matrizReplicaDominante[3][0]) * iteracionesX.get(iteracionesX.size() - 1)) - ((matrizReplicaDominante[3][1]) * iteracionesY.get(iteracionesY.size() - 1)) - ((matrizReplicaDominante[3][2]) * iteracionesZ.get(iteracionesZ.size() - 1))) / matrizReplicaDominante[3][3]);

                if (iteracionesX.size() == 7) {
                    break;
                }
            }

        }
        List<Double> errorIteracionX = new ArrayList<Double>();
        List<Double> errorIteracionY = new ArrayList<Double>();
        List<Double> errorIteracionZ = new ArrayList<Double>();
        List<Double> errorIteracionT = new ArrayList<Double>();

        System.out.println("Iteracion  / x1 /x2 /x3     Error Relativo porcentual");
        System.out.println("|0|0|0|0");
        errorIteracionX.add(0.0);
        errorIteracionY.add(0.0);
        errorIteracionZ.add(0.0);
        errorIteracionT.add(0.0);
        if (filas == 3) {
            for (int i = 1; i < iteracionesX.size(); i++) {
                errorIteracionX.add((iteracionesX.get(i) - iteracionesX.get(i - 1)) * 100);
                errorIteracionY.add((iteracionesY.get(i) - iteracionesY.get(i - 1)) * 100);
                errorIteracionZ.add((iteracionesZ.get(i) - iteracionesZ.get(i - 1)) * 100);
            }
            for (int i = 1; i < iteracionesX.size(); i++) {
                System.out.println("" + i + "|" + iteracionesX.get(i) + "|" + iteracionesY.get(i) + "|" + iteracionesZ.get(i) + "|" + errorIteracionX.get(i) + "|" + errorIteracionY.get(i) + "|" + errorIteracionZ.get(i));
            }
        }
        if (filas == 4) {
            for (int i = 1; i < iteracionesX.size(); i++) {
                errorIteracionX.add((iteracionesX.get(i) - iteracionesX.get(i - 1) /iteracionesX.get(i) ) * 100);
                errorIteracionY.add((iteracionesY.get(i) - iteracionesY.get(i - 1)) * 100);
                errorIteracionZ.add((iteracionesZ.get(i) - iteracionesZ.get(i - 1)) * 100);
                errorIteracionT.add((iteracionesT.get(i) - iteracionesT.get(i - 1)) * 100);
            }
            for (int i = 1; i < iteracionesX.size(); i++) {
                System.out.println("" + i + "|" + iteracionesX.get(i) + "|" + iteracionesY.get(i) + "|" + iteracionesZ.get(i) + "|" + iteracionesT.get(i) + "|" + errorIteracionX.get(i) + "|" + errorIteracionY.get(i) + "|" + errorIteracionZ.get(i) + "|" + errorIteracionT.get(i));
            }

  

//          Scanner teclado = new Scanner(System.in);
//        System.out.println("Gaus-Seidel Iteraciones");
//        int filas;
//        int columnas;
//        
//        
//        double matrizRaiz[][] = matriz;
//        filas = matrizRaiz.length;
//        columnas = matrizRaiz[0].length;
//       
//////        double matrizRaiz[][] = new double[filas][columnas];
////        System.out.println("LLENAR TODOS LOS CAMPOS DE LA MATRIZ");
////        for (int i = 0; i < filas; i++) {
////            for (int j = 0; j < columnas; j++) {
////                System.out.println("[" + i + "]" + "[" + j + "]");
////                matrizRaiz[i][j] = teclado.nextDouble();
////            }
////        }
//
//        System.out.println("IMPRESION DE LA MATRIZ");
//        for (int i = 0; i < filas; i++) {
//            System.out.println("");
//            for (int j = 0; j < columnas; j++) {
//                System.out.print("|" + matrizRaiz[i][j]);
//            }
//        }
//        double matrizB[] = new double[filas];
//        for (int i = 0; i < filas; i++) {
//            matrizB[i] = matrizRaiz[i][(columnas - 1)];
//        }
//        //comprovacion de matriz dominante
//
//        double matrizReplicaDominante[][] = new double[filas][columnas];
//        for (int i = 0; i < filas; i++) {
//            for (int j = 0; j < columnas; j++) {
//                matrizReplicaDominante[i][j] = matrizRaiz[i][j];
//            }
//        }
//        while (true) {
//            if (filas == 3) {
//                if (Math.abs(matrizReplicaDominante[0][0]) < (Math.abs(matrizReplicaDominante[0][1]) + Math.abs(matrizReplicaDominante[0][2])) || Math.abs(matrizReplicaDominante[1][1]) < (Math.abs(matrizReplicaDominante[1][0]) + Math.abs(matrizReplicaDominante[1][2])) || Math.abs(matrizReplicaDominante[2][2]) < (Math.abs(matrizReplicaDominante[2][0]) + Math.abs(matrizReplicaDominante[2][1]))) {
//                    matrizReplicaDominante[0][0] = matrizRaiz[1][0];
//                    matrizReplicaDominante[0][1] = matrizRaiz[1][1];
//                    matrizReplicaDominante[0][2] = matrizRaiz[1][2];
//                    matrizReplicaDominante[0][3] = matrizRaiz[1][3];
//
//                    matrizReplicaDominante[1][0] = matrizRaiz[0][0];
//                    matrizReplicaDominante[1][1] = matrizRaiz[0][1];
//                    matrizReplicaDominante[1][2] = matrizRaiz[0][2];
//                    matrizReplicaDominante[1][3] = matrizRaiz[0][3];
//
//                } else {
//                    break;
//                }
//            }
//            if (filas == 4) {
//                if (Math.abs(matrizReplicaDominante[0][0]) < (Math.abs(matrizReplicaDominante[0][1]) + Math.abs(matrizReplicaDominante[0][2]) + Math.abs(matrizReplicaDominante[0][3])) || Math.abs(matrizReplicaDominante[1][1]) < (Math.abs(matrizReplicaDominante[1][0]) + Math.abs(matrizReplicaDominante[1][2]) + Math.abs(matrizReplicaDominante[1][3])) || Math.abs(matrizReplicaDominante[2][2]) < (Math.abs(matrizReplicaDominante[2][0]) + Math.abs(matrizReplicaDominante[2][1]) + Math.abs(matrizReplicaDominante[2][3])) || Math.abs(matrizReplicaDominante[3][3]) < (Math.abs(matrizReplicaDominante[3][0]) + Math.abs(matrizReplicaDominante[3][1]) + Math.abs(matrizReplicaDominante[3][2]))) {
//                    matrizReplicaDominante[0][0] = matrizRaiz[1][0];
//                    matrizReplicaDominante[0][1] = matrizRaiz[1][1];
//                    matrizReplicaDominante[0][2] = matrizRaiz[1][2];
//                    matrizReplicaDominante[0][3] = matrizRaiz[1][3];
//                    matrizReplicaDominante[0][4] = matrizRaiz[1][4];
//
//                    matrizReplicaDominante[1][0] = matrizRaiz[0][0];
//                    matrizReplicaDominante[1][1] = matrizRaiz[0][1];
//                    matrizReplicaDominante[1][2] = matrizRaiz[0][2];
//                    matrizReplicaDominante[1][3] = matrizRaiz[0][3];
//                    matrizReplicaDominante[1][4] = matrizRaiz[0][4];
//
//                } else {
//                    break;
//                }
//
//            }
//
//        }
//        System.out.println("");
//        System.out.println("impresion de matriz diagonal dominante dominante");
//        for (int i = 0; i < filas; i++) {
//            System.out.println("");
//            for (int j = 0; j < columnas; j++) {
//                System.out.print("|" + matrizReplicaDominante[i][j]);
//            }
//        }
//        System.out.println("");
//        List<Double> iteracionesX = new ArrayList<Double>();
//        List<Double> iteracionesY = new ArrayList<Double>();
//        List<Double> iteracionesZ = new ArrayList<Double>();
//        List<Double> iteracionesT = new ArrayList<Double>();
//        iteracionesX.add(0.0);
//        iteracionesY.add(0.0);
//        iteracionesZ.add(0.0);
//        iteracionesT.add(0.0);
//        while (true) {
//
//            if (filas == 3) {
//
//                iteracionesX.add((matrizB[0] - ((matrizReplicaDominante[0][1]) * iteracionesY.get(iteracionesY.size() - 1)) - ((matrizReplicaDominante[0][2]) * iteracionesZ.get(iteracionesZ.size() - 1))) / matrizReplicaDominante[0][0]);
//                iteracionesY.add((matrizB[1] - ((matrizReplicaDominante[1][0]) * iteracionesX.get(iteracionesX.size() - 1)) - ((matrizReplicaDominante[1][2]) * iteracionesZ.get(iteracionesZ.size() - 1))) / matrizReplicaDominante[1][1]);
//                iteracionesZ.add((matrizB[2] - ((matrizReplicaDominante[2][0]) * iteracionesX.get(iteracionesX.size() - 1)) - ((matrizReplicaDominante[2][1]) * iteracionesY.get(iteracionesY.size() - 1))) / matrizReplicaDominante[2][2]);
//
//                if (iteracionesX.size() == 7) {
//                    break;
//                }
//            }
//            if (filas == 4) {
//                iteracionesX.add((matrizB[0] - ((matrizReplicaDominante[0][1]) * iteracionesY.get(iteracionesY.size() - 1)) - ((matrizReplicaDominante[0][2]) * iteracionesZ.get(iteracionesZ.size() - 1)) - ((matrizReplicaDominante[0][3]) * iteracionesT.get(iteracionesT.size() - 1))) / matrizReplicaDominante[0][0]);
//                iteracionesY.add((matrizB[1] - ((matrizReplicaDominante[1][0]) * iteracionesX.get(iteracionesX.size() - 1)) - ((matrizReplicaDominante[1][2]) * iteracionesZ.get(iteracionesZ.size() - 1)) - ((matrizReplicaDominante[1][3]) * iteracionesT.get(iteracionesT.size() - 1))) / matrizReplicaDominante[1][1]);
//                iteracionesZ.add((matrizB[2] - ((matrizReplicaDominante[2][0]) * iteracionesX.get(iteracionesX.size() - 1)) - ((matrizReplicaDominante[2][1]) * iteracionesY.get(iteracionesY.size() - 1)) - ((matrizReplicaDominante[2][3]) * iteracionesT.get(iteracionesT.size() - 1))) / matrizReplicaDominante[2][2]);
//                iteracionesT.add((matrizB[3] - ((matrizReplicaDominante[3][0]) * iteracionesX.get(iteracionesX.size() - 1)) - ((matrizReplicaDominante[3][1]) * iteracionesY.get(iteracionesY.size() - 1)) - ((matrizReplicaDominante[3][2]) * iteracionesZ.get(iteracionesZ.size() - 1))) / matrizReplicaDominante[3][3]);
//
//                if (iteracionesX.size() == 7) {
//                    break;
//                }
//            }
//
//        }
//        List<Double> errorIteracionX = new ArrayList<Double>();
//        List<Double> errorIteracionY = new ArrayList<Double>();
//        List<Double> errorIteracionZ = new ArrayList<Double>();
//        List<Double> errorIteracionT = new ArrayList<Double>();
//
//        System.out.println("Iteracion  / x1 /x2 /x3     Error Relativo porcentual");
//        System.out.println("|0|0|0|0");
//        errorIteracionX.add(0.0);
//        errorIteracionY.add(0.0);
//        errorIteracionZ.add(0.0);
//        errorIteracionT.add(0.0);
//        if (filas == 3) {
//            for (int i = 1; i < iteracionesX.size(); i++) {
//                errorIteracionX.add((iteracionesX.get(i) - iteracionesX.get(i - 1)) * 100);
//                errorIteracionY.add((iteracionesY.get(i) - iteracionesY.get(i - 1)) * 100);
//                errorIteracionZ.add((iteracionesZ.get(i) - iteracionesZ.get(i - 1)) * 100);
//            }
//            for (int i = 1; i < iteracionesX.size(); i++) {
//                System.out.println("" + i + "|" + iteracionesX.get(i) + "|" + iteracionesY.get(i) + "|" + iteracionesZ.get(i) + "|" + errorIteracionX.get(i) + "|" + errorIteracionY.get(i) + "|" + errorIteracionZ.get(i));
//            }
//        }
//        if (filas == 4) {
//            for (int i = 1; i < iteracionesX.size(); i++) {
//                errorIteracionX.add((iteracionesX.get(i) - iteracionesX.get(i - 1) /iteracionesX.get(i) ) * 100);
//                errorIteracionY.add((iteracionesY.get(i) - iteracionesY.get(i - 1)) * 100);
//                errorIteracionZ.add((iteracionesZ.get(i) - iteracionesZ.get(i - 1)) * 100);
//                errorIteracionT.add((iteracionesT.get(i) - iteracionesT.get(i - 1)) * 100);
//            }
//            for (int i = 1; i < iteracionesX.size(); i++) {
//                System.out.println("" + i + "|" + iteracionesX.get(i) + "|" + iteracionesY.get(i) + "|" + iteracionesZ.get(i) + "|" + iteracionesT.get(i) + "|" + errorIteracionX.get(i) + "|" + errorIteracionY.get(i) + "|" + errorIteracionZ.get(i) + "|" + errorIteracionT.get(i));
//            }
//
//        }
        
//        System.out.println("asdasdasdasdad");
//        double matrizAux[][];
//        matrizAux = matriz;
//        List<Double> variableDominante = new ArrayList<Double>();
//        List<Double> reglonSumatoria = new ArrayList<Double>();
//        List<Double> matrizB = new ArrayList<Double>();
//        String fila = "";
//        double var = 0;
//        List<Double> iteracionesX = new ArrayList<Double>();
//        List<Double> iteracionesY = new ArrayList<Double>();
//        List<Double> iteracionesZ = new ArrayList<Double>();
//        List<Double> iteracionesT = new ArrayList<Double>();
//        List<Double> iteracionWes = new ArrayList<Double>();
//        iteracionesX.add(0.0);
//        iteracionesY.add(0.0);
//        iteracionesZ.add(0.0);
//        iteracionesT.add(0.0);
//        iteracionWes.add(0.0);
//        System.out.println("");
//        boolean dominante = true;
//        for (int i = 0; i < matrizAux.length; i++) {
//
//            matrizB.add(matrizAux[i][matrizAux[i].length - 1]);
//
//        }
//        while (true) {
//            for (int ic = 0; ic < matrizAux.length; ic++) {
//                variableDominante.add(Math.abs(matrizAux[ic][ic]));
//                for (int i = 0; i < matrizAux.length; i++) {
//
//                    var += Math.abs(matrizAux[ic][i]);
//
//                }
//                reglonSumatoria.add(var);
//                var = 0;
//            }
//            if (true) {
//                for (int i = 0; i < matrizAux.length; i++) {
//                    if (variableDominante.get(i) < reglonSumatoria.get(i) - variableDominante.get(i)) {
//                        dominante = false;
//                        fila = fila + i + ",";
//                    }
//                }
//            }
//            if (dominante == false) {
//
//                JOptionPane.showMessageDialog(null, "Unas de la siguientes filas no es dominante", "" + fila, JOptionPane.INFORMATION_MESSAGE);
//
//            } else {
//                break;
//            }
//
//        }
//        List<Double> errorIteracionX = new ArrayList<Double>();
//        List<Double> errorIteracionY = new ArrayList<Double>();
//        List<Double> errorIteracionZ = new ArrayList<Double>();
//        List<Double> errorIteracionT = new ArrayList<Double>();
//
//        System.out.println("|0|0|0|0");
//
//        if (dominante == true) {
//            while (dominante) {
//
//                errorIteracionX.add(0.0);
//                errorIteracionY.add(0.0);
//                errorIteracionZ.add(0.0);
//                errorIteracionT.add(0.0);
//                if (matrizAux.length == 3) {
//
//                    iteracionesX.add((matrizB.get(0) - ((matrizAux[0][1]) * iteracionesY.get(iteracionesY.size() - 1)) - ((matrizAux[0][2]) * iteracionesZ.get(iteracionesZ.size() - 1))) / matrizAux[0][0]);
//                    iteracionesY.add((matrizB.get(1) - ((matrizAux[1][0]) * iteracionesX.get(iteracionesX.size() - 1)) - ((matrizAux[1][2]) * iteracionesZ.get(iteracionesZ.size() - 1))) / matrizAux[1][1]);
//                    iteracionesZ.add((matrizB.get(2) - ((matrizAux[2][0]) * iteracionesX.get(iteracionesX.size() - 1)) - ((matrizAux[2][1]) * iteracionesY.get(iteracionesY.size() - 1))) / matrizAux[2][2]);
//
//                    if (iteracionesX.size() == 7) {
//                        break;
//                    }
//                }
//                if (matrizAux.length == 4) {
//                    iteracionesX.add((matrizB.get(0) - ((matrizAux[0][1]) * iteracionesY.get(iteracionesY.size() - 1)) - ((matrizAux[0][2]) * iteracionesZ.get(iteracionesZ.size() - 1)) - ((matrizAux[0][3]) * iteracionesT.get(iteracionesT.size() - 1))) / matrizAux[0][0]);
//                    iteracionesY.add((matrizB.get(1) - ((matrizAux[1][0]) * iteracionesX.get(iteracionesX.size() - 1)) - ((matrizAux[1][2]) * iteracionesZ.get(iteracionesZ.size() - 1)) - ((matrizAux[1][3]) * iteracionesT.get(iteracionesT.size() - 1))) / matrizAux[1][1]);
//                    iteracionesZ.add((matrizB.get(2) - ((matrizAux[2][0]) * iteracionesX.get(iteracionesX.size() - 1)) - ((matrizAux[2][1]) * iteracionesY.get(iteracionesY.size() - 1)) - ((matrizAux[2][3]) * iteracionesT.get(iteracionesT.size() - 1))) / matrizAux[2][2]);
//                    iteracionesT.add((matrizB.get(3) - ((matrizAux[3][0]) * iteracionesX.get(iteracionesX.size() - 1)) - ((matrizAux[3][1]) * iteracionesY.get(iteracionesY.size() - 1)) - ((matrizAux[3][2]) * iteracionesZ.get(iteracionesZ.size() - 1))) / matrizAux[3][3]);
//
//                }
//
//            }
//            if (matrizAux.length == 3) {
//                for (int i = 1; i < iteracionesX.size(); i++) {
//                    errorIteracionX.add((iteracionesX.get(i) - iteracionesX.get(i - 1)) * 100);
//                    errorIteracionY.add((iteracionesY.get(i) - iteracionesY.get(i - 1)) * 100);
//                    errorIteracionZ.add((iteracionesZ.get(i) - iteracionesZ.get(i - 1)) * 100);
//                }
//                for (int i = 1; i < iteracionesX.size(); i++) {
//                    System.out.println("" + i + "|" + iteracionesX.get(i) + "|" + iteracionesY.get(i) + "|" + iteracionesZ.get(i) + "|" + errorIteracionX.get(i) + "|" + errorIteracionY.get(i) + "|" + errorIteracionZ.get(i));
//                }
//            }
//            if (matrizAux.length == 4) {
//                for (int i = 1; i < iteracionesX.size(); i++) {
//                    errorIteracionX.add((iteracionesX.get(i) - iteracionesX.get(i - 1) / iteracionesX.get(i)) * 100);
//                    errorIteracionY.add((iteracionesY.get(i) - iteracionesY.get(i - 1)) * 100);
//                    errorIteracionZ.add((iteracionesZ.get(i) - iteracionesZ.get(i - 1)) * 100);
//                    errorIteracionT.add((iteracionesT.get(i) - iteracionesT.get(i - 1)) * 100);
//                }
//                for (int i = 1; i < iteracionesX.size(); i++) {
//                    System.out.println("" + i + "|" + iteracionesX.get(i) + "|" + iteracionesY.get(i) + "|" + iteracionesZ.get(i) + "|" + iteracionesT.get(i) + "|" + errorIteracionX.get(i) + "|" + errorIteracionY.get(i) + "|" + errorIteracionZ.get(i) + "|" + errorIteracionT.get(i));
//                }
//
//            }
//
//        }
//        errorIteracionX.add(0.0);
//        errorIteracionY.add(0.0);
//        errorIteracionZ.add(0.0);
//        errorIteracionT.add(0.0);
//        if (matrizAux.length == 3) {
//            for (int i = 1; i < iteracionesX.size(); i++) {
//                errorIteracionX.add((iteracionesX.get(i) - iteracionesX.get(i - 1)) * 100);
//                errorIteracionY.add((iteracionesY.get(i) - iteracionesY.get(i - 1)) * 100);
//                errorIteracionZ.add((iteracionesZ.get(i) - iteracionesZ.get(i - 1)) * 100);
//            }
//            for (int i = 1; i < iteracionesX.size(); i++) {
//                System.out.println("" + i + "|" + iteracionesX.get(i) + "|" + iteracionesY.get(i) + "|" + iteracionesZ.get(i) + "|" + errorIteracionX.get(i) + "|" + errorIteracionY.get(i) + "|" + errorIteracionZ.get(i));
//            }
//        }
//        if (matrizAux.length == 4) {
//            for (int i = 1; i < iteracionesX.size(); i++) {
//                errorIteracionX.add((iteracionesX.get(i) - iteracionesX.get(i - 1) /iteracionesX.get(i) ) * 100);
//                errorIteracionY.add((iteracionesY.get(i) - iteracionesY.get(i - 1)) * 100);
//                errorIteracionZ.add((iteracionesZ.get(i) - iteracionesZ.get(i - 1)) * 100);
//                errorIteracionT.add((iteracionesT.get(i) - iteracionesT.get(i - 1)) * 100);
//            }
//            for (int i = 1; i < iteracionesX.size(); i++) {
//                System.out.println("" + i + "|" + iteracionesX.get(i) + "|" + iteracionesY.get(i) + "|" + iteracionesZ.get(i) + "|" + iteracionesT.get(i) + "|" + errorIteracionX.get(i) + "|" + errorIteracionY.get(i) + "|" + errorIteracionZ.get(i) + "|" + errorIteracionT.get(i));
//            }
//
//        }

    }}

}

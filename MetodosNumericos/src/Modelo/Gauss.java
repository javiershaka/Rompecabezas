/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author javiershaka
 */
public class Gauss {

    public void guassiana(double matriz[][]) {

        double x;
        double y;
        double z;
        double duplicadorSuperior;
        double duplicadorInferior;
        double matrizAux[][] = matriz;

        for (int fila = 0; fila < matriz.length - 1; fila++) {
            for (int reglon = 1; reglon < matriz.length; reglon++) {
                duplicadorInferior = Math.abs(matrizAux[fila][fila]);
                duplicadorSuperior = Math.abs(matrizAux[reglon][fila]);
                for (int var = 0; var < matrizAux[0].length; var++) {

                    matrizAux[fila][var] = matrizAux[fila][var] * duplicadorSuperior;
                    matrizAux[reglon][var] = matrizAux[reglon][var] * duplicadorInferior;

                }

                if (matrizAux[fila][fila] == matrizAux[reglon][fila]) {

                    for (int i = 0; i < matrizAux[0].length; i++) {
                        matrizAux[fila][i] = matrizAux[fila][i] * -1;

                    }

                }
                System.out.println("" + matrizAux[reglon][fila]);

                for (int i = 0; i < matrizAux[0].length; i++) {
                    matrizAux[reglon][i] = matrizAux[reglon][i] + matrizAux[fila][i];

                }

                for (int var = 0; var < matrizAux[0].length; var++) {

                    matrizAux[fila][var] = matrizAux[fila][var] / duplicadorSuperior;

                }

            }

            for (int i = 0; i < matriz.length; i++) {
                System.out.println("");
                for (int j = 0; j < matriz[0].length; j++) {

                    System.out.print("#" + matrizAux[i][j]);
                }

            }

        }

        z = matrizAux[2][3] / matrizAux[2][2];
        y = (matrizAux[1][3] - (matrizAux[1][2] * z)) / matrizAux[1][1];
        x = (matrizAux[0][3] - (matrizAux[0][2] * z) - (matrizAux[0][1] * y)) / (matrizAux[0][0]);
        System.out.println("");
        System.out.println("z" + z);
        System.out.println("y" + y);
        System.out.println("x" + x);
        System.out.println("comprovacion");

        //a
    }

}

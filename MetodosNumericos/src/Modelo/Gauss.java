/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;
import java.util.List;
import metodosmaster.MenuPrincipal;

/**
 *
 * @author javiershaka
 */
public class Gauss {

    public void Guassiana(double matriz[][]) {

        double x;
        double y;
        double z;
        double t;
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

                for (int i = 0; i < matrizAux[0].length; i++) {
                    matrizAux[reglon][i] = matrizAux[reglon][i] + matrizAux[fila][i];

                }

                for (int var = 0; var < matrizAux[0].length; var++) {

                    matrizAux[fila][var] = matrizAux[fila][var] / duplicadorSuperior;

                }

            }
            for (int i = 0; i < matriz.length; i++) {
                MenuPrincipal.txtArea.setText(MenuPrincipal.txtArea.getText() + "\n");
                //System.out.println("");
                for (int j = 0; j < matriz[0].length; j++) {

                    MenuPrincipal.txtArea.setText(MenuPrincipal.txtArea.getText() + "" + matrizAux[i][j]);
                    //    System.out.print("#" + matrizAux[i][j]);
                }

            }

        }

        System.out.println("");

        
        if (matrizAux.length == 3) {
            z = matrizAux[2][3] / matrizAux[2][2];
            y = (matrizAux[1][3] - (matrizAux[1][2] * z)) / matrizAux[1][1];
            x = (matrizAux[0][3] - (matrizAux[0][2] * z) - (matrizAux[0][1] * y)) / (matrizAux[0][0]);
            MenuPrincipal.txtArea.setText(MenuPrincipal.txtArea.getText() + "\n");
            MenuPrincipal.txtArea.setText(MenuPrincipal.txtArea.getText() + "Valor de x: " +x);
            MenuPrincipal.txtArea.setText(MenuPrincipal.txtArea.getText() + "\n");
            MenuPrincipal.txtArea.setText(MenuPrincipal.txtArea.getText() + "Valor de y: " +y);
            MenuPrincipal.txtArea.setText(MenuPrincipal.txtArea.getText() + "\n");
            MenuPrincipal.txtArea.setText(MenuPrincipal.txtArea.getText() + "Valor de z: " +z);
        }
        if (matrizAux.length == 4) {
            t = matrizAux[3][4] / matrizAux[3][3];
            z = (matrizAux[2][4] - (matrizAux[2][3] * t)) / matrizAux[2][2];
            y = (matrizAux[1][4] - (matrizAux[1][3] * t) - (matrizAux[0][1] * z)) / (matrizAux[1][1]);
            x = (matrizAux[0][4] - (matrizAux[0][3] * t) - (matrizAux[0][2] * z) - (matrizAux[0][1] *y)) / (matrizAux[0][0]);
            MenuPrincipal.txtArea.setText(MenuPrincipal.txtArea.getText() + "\n");
            MenuPrincipal.txtArea.setText(MenuPrincipal.txtArea.getText() + "Valor de x: " +x);
            MenuPrincipal.txtArea.setText(MenuPrincipal.txtArea.getText() + "\n");
            MenuPrincipal.txtArea.setText(MenuPrincipal.txtArea.getText() + "Valor de y: " +y);
            MenuPrincipal.txtArea.setText(MenuPrincipal.txtArea.getText() + "\n");
            MenuPrincipal.txtArea.setText(MenuPrincipal.txtArea.getText() + "Valor de z: " +z);
            MenuPrincipal.txtArea.setText(MenuPrincipal.txtArea.getText() + "\n");
            MenuPrincipal.txtArea.setText(MenuPrincipal.txtArea.getText() + "Valor de t: " +t);
        }

        // System.out.println("comprovacion");
        //a
    }

}

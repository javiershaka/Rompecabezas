/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pruebas;

import Modelo.Gauss;

/**
 *
 * @author javiershaka
 */
public class pruebas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        double matrizh[][] = new double[3][4];
        matrizh[0][0] = 10;
        matrizh[0][1] = 3;
        matrizh[0][2] = 1;
        matrizh[0][3] = 14;
        matrizh[1][0] = 5;
        matrizh[1][1] = -10;
        matrizh[1][2] = 3;
        matrizh[1][3] = -5;
        matrizh[2][0] = 1;
        matrizh[2][1] = 3;
        matrizh[2][2] = 10;
        matrizh[2][3] = 14;
        Gauss g = new Gauss();
        g.guassiana(matrizh);
        
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.Scanner;
import metodosmaster.MenuPrincipal;

/**
 *
 * @author javiershaka
 */
public class GausJordan {

    public  void muestramatrizAux(double matrizAuxm[][], int var) {
        for (int x = 0; x < var; x++) {
            MenuPrincipal.txtArea.setText(MenuPrincipal.txtArea.getText() + "\n");
            for (int y = 0; y < (var + 1); y++) {
                MenuPrincipal.txtArea.setText(MenuPrincipal.txtArea.getText() + "" + matrizAuxm[x][y]);
             //   System.out.print(" " + matrizAuxm[x][y] + " |");
            }
       //     System.out.println("");
        }

    }

    public  void pivote(double matrizAuxp[][], int piv, int var) {
        double temp = 0;
        temp = matrizAuxp[piv][piv];
        for (int y = 0; y < (var + 1); y++) {

            matrizAuxp[piv][y] = matrizAuxp[piv][y] / temp;
        }
    }

    public  void hacerceros(double matrizAuxh[][], int piv, int var) {
        for (int x = 0; x < var; x++) {
            if (x != piv) {
                double c = matrizAuxh[x][piv];
                for (int z = 0; z < (var + 1); z++) {
                    matrizAuxh[x][z] = ((-1 * c) * matrizAuxh[piv][z]) + matrizAuxh[x][z];
                }
            }
        }
    }

    public  void matrizGaussJordan(double matriz[][]) {
       
      
        Scanner leer = new Scanner(System.in);
        int var = 0, piv = 0;
        double matrizAux[][];
    //    System.out.println("\t  Metodo de Gauss Jordan ");
      //  System.out.println("\n¿Cuantas variables tiene tu sistema?");
        //var = leer.nextInt();
        
        matrizAux = matriz;
        var = matrizAux.length;
        
        
//        System.out.println("variable "+var);
//        for (int x = 0; x < var; x++) {
//            System.out.println("variable "+var);
//            for (int y = 0; y < (var + 1); y++) { 
//                System.out.println("variable "+var);
//               // matrizAux[x][y] = matriz[x][y];
//               // System.out.println("Ingresa la constante de la posicion: A[" + (x + 1) + "][" + (y + 1) + "]");
//               // matrizAux[x][y] = leer.nextDouble();
//            }
//
//        }

       
        for (int a = 0; a < var; a++) {
            pivote(matrizAux, piv, var);

        //    System.out.println("\tRenglon " + (a + 1) + " entre el pivote");
            muestramatrizAux(matrizAux, var);

       //     System.out.println("");

         //   System.out.println("\tHaciendo ceros");
            hacerceros(matrizAux, piv, var);
         //   MenuPrincipal.txtArea.setText(MenuPrincipal.txtArea.getText() + "\n"+"HACIENDO 0");
            muestramatrizAux(matrizAux, var);
         //   System.out.println("");
            piv++;
        }
        for (int x = 0; x < var; x++) {
            MenuPrincipal.txtArea.setText(MenuPrincipal.txtArea.getText() + "\n"+(x + 1) + " es: " + matrizAux[x][var]);
           // System.out.println("La variable X" + (x + 1) + " es: " + matrizAux[x][var]);
        }
  
    }

}

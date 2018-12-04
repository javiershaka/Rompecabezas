/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodosnumericos;

import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author javiershaka
 */
public class MetodosNumericos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int matriz1filas;
        int matriz2filas;
        int matriz1Columas;
        int matriz2Columas;

        System.out.println("defina el tamaño de las matrices");
        Scanner teclado = new Scanner(System.in);

        System.out.println("matriz A, numero de filas ");
        matriz1filas = teclado.nextInt();
        System.out.println("matriz A, numero de columnas");
        matriz1Columas = teclado.nextInt();
        System.out.println("matriz B, numero de filas ");
        matriz2filas = teclado.nextInt();
        System.out.println("matriz B, numero de columnas");
        matriz2Columas = teclado.nextInt();
        int matriz1[][] = new int[matriz1filas][matriz1Columas];
        int[][] matriz2 = new int[matriz2filas][matriz2Columas];
        System.out.println("*************************************************************************");

        if (matriz1Columas == matriz2filas) {
            int matriz3[][] = new int[matriz1filas][matriz2Columas];
            System.out.println("");
            for (int var = 0; var < matriz1filas; var++) {
                for (int var2 = 0; var2 < matriz1Columas; var2++) {

                    System.out.println("matriz A  posiciones " + "[" + var + "]" + "[" + var2 + "]");
                    matriz1[var][var2] = teclado.nextInt();
                }

            }
            System.out.println("*************************************************************************");
            //para llenar datos matriz 2
            for (int var = 0; var < matriz2filas; var++) {
                for (int var2 = 0; var2 < matriz2Columas; var2++) {

                    System.out.println("matriz B  posiciones " + "[" + var + "]" + "[" + var2 + "]");
                    matriz2[var][var2] = teclado.nextInt();
                }

            }

            //multiplicacion
            int acumulador = 0;

            for (int re = 0; re < matriz1filas; re++) {
                // System.out.println("");
                for (int re2 = 0; re2 < matriz2Columas; re2++) {

                    for (int filas = 0; filas < matriz1filas; filas++) {
                        // System.out.println("");
                        for (int columnas = 0; columnas < matriz2Columas; columnas++) {
                            for (int compa = 0; compa < matriz1Columas; compa++) {
                                //System.out.println("multiplicacion " + (matriz1[filas][compa] * matriz2[compa][columnas]));
                                acumulador += (matriz1[filas][compa] * matriz2[compa][columnas]);
                                //System.out.println("acumulador " + acumulador);

                            }
                            //System.out.println("-----------------------------");
                            matriz3[filas][columnas] = acumulador;
                            acumulador = 0;

                        }

                    }

                }

            }
            //espacio reservado para las impresiones
            System.out.println("");
            System.out.println("*************************************************************************");
            System.out.println("Matriz A");
            //impresion matriz 1
            for (int i = 0; i < matriz1filas; i++) {
                System.out.println("");
                for (int i2 = 0; i2 < matriz1Columas; i2++) {
                    System.out.print("|" + matriz1[i][i2]);

                }

            }
            
            /// impresion matriz 2
            System.out.println("");
            System.out.println("*************************************************************************");
            System.out.println("Matriz B");
            for (int i = 0; i < matriz2filas; i++) {
                System.out.println("");
                for (int i2 = 0; i2 < matriz2Columas; i2++) {
                    System.out.print("|" + matriz2[i][i2]);

                }

            }
            //impresion matriz 3 o C
            System.out.println("");
            System.out.println("*************************************************************************");
            System.out.println("Matriz C");
            for (int re = 0; re < matriz1filas; re++) {
                System.out.println("");
                for (int re2 = 0; re2 < matriz2Columas; re2++) {
                    System.out.print("|" + matriz3[re][re2]);

                }

            }

        } else {
            System.out.println("no se puede realizar la multiplicacion");
        }  
        System.out.println("");


    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Vista.multiMatriz;
import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import metodosmaster.MenuPrincipal;

/**
 *
 * @author javiershaka
 */
public class MultiplicacionMatrices {

    public void multiMatriz(int fila1, int columna1, int fila2, int columna2) {
        try {
            int matriz1filas = fila1;
            int matriz2filas = fila2;
            int matriz1Columas = columna1;
            int matriz2Columas = columna2;
            System.out.println(" entro");
            // System.out.println("defina el tamaño de las matrices");
            // Scanner teclado = new Scanner(System.in);

//        System.out.println("matriz A, numero de filas ");
//        matriz1filas = teclado.nextInt();
//        System.out.println("matriz A, numero de columnas");
//        matriz1Columas = teclado.nextInt();
//        System.out.println("matriz B, numero de filas ");
//        matriz2filas = teclado.nextInt();
//        System.out.println("matriz B, numero de columnas");
//        matriz2Columas = teclado.nextInt();
            double matriz1[][] = new double[matriz1filas][matriz1Columas];
            double[][] matriz2 = new double[matriz2filas][matriz2Columas];
            // System.out.println("*************************************************************************");

            if (matriz1Columas == matriz2filas) {
                int matriz3[][] = new int[matriz1filas][matriz2Columas];
                //   System.out.println("");
                for (int var = 0; var < matriz1filas; var++) {
                    for (int var2 = 0; var2 < matriz1Columas; var2++) {

                        // System.out.println("matriz A  posiciones " + "[" + var + "]" + "[" + var2 + "]");
                        matriz1[var][var2] = Double.parseDouble(MenuPrincipal.tbMatriz1.getValueAt(var, var2).toString());
                    }

                }
                //    System.out.println("*************************************************************************");
                //para llenar datos matriz 2
                for (int var = 0; var < matriz2filas; var++) {
                    for (int var2 = 0; var2 < matriz2Columas; var2++) {
                        matriz2[var][var2] = Double.parseDouble(MenuPrincipal.tbMatriz2.getValueAt(var, var2).toString());

                        // System.out.println("matriz B  posiciones " + "[" + var + "]" + "[" + var2 + "]");
                        // matriz2[var][var2] = teclado.nextInt();
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
//            System.out.println("");
//            System.out.println("*************************************************************************");
//            System.out.println("Matriz A");
                //impresion matriz 1
//            for (int i = 0; i < matriz1filas; i++) {
//                System.out.println("");
//                for (int i2 = 0; i2 < matriz1Columas; i2++) {
//                    System.out.print("|" + matriz1[i][i2]);
//
//                }
//
//            }

                /// impresion matriz 2
//            System.out.println("");
//            System.out.println("*************************************************************************");
//            System.out.println("Matriz B");
//            for (int i = 0; i < matriz2filas; i++) {
//                System.out.println("");
//                for (int i2 = 0; i2 < matriz2Columas; i2++) {
//                    System.out.print("|" + matriz2[i][i2]);
//
//                }
//
//            }
                //impresion matriz 3 o C
//            System.out.println("");
//            System.out.println("*************************************************************************");
//            System.out.println("Matriz C");
                DefaultTableModel tb = new DefaultTableModel();
                tb.setRowCount(matriz3.length);
                tb.setColumnCount(matriz3[0].length);
                for (int re = 0; re < matriz1filas; re++) {
                    System.out.println("");
                    for (int re2 = 0; re2 < matriz2Columas; re2++) {
                        tb.setValueAt(matriz1[re][re2] + "", re, re2);
                        System.out.print("|" + matriz3[re][re2]);

                    }

                }
                System.out.println("a");
                multiMatriz vistamatriz = new multiMatriz();
              
                multiMatriz.tbMatrizC.setModel(tb);
                  vistamatriz.setVisible(true);
            } else {
                JOptionPane.showConfirmDialog(null,"necesita ser compatible entre las matrices","aviso", JOptionPane.INFORMATION_MESSAGE);
                //System.out.println("no se puede realizar la multiplicacion");
            }
            System.out.println("");

        } catch (Exception e) {
        }

    }

}

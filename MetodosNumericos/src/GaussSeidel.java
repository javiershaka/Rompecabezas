/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gauss.seidel;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author javiershaka
 */
public class GaussSeidel {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Scanner teclado = new Scanner(System.in);
        System.out.println("Gaus-Seidel Iteraciones");
        int filas;
        int columnas;
        System.out.println("DEFINE EL NUMERO DE FILAS");
        filas = teclado.nextInt();
        System.out.println("DEFINE EL NUMERO DE COLUMNAS");
        columnas = teclado.nextInt();
        double error = 0.0001;
        double matrizRaiz[][] = new double[3][4];
        matrizRaiz[0][0] = 10;
        matrizRaiz[0][1] = 3;
        matrizRaiz[0][2] = 1;
        matrizRaiz[0][3] = 14;
        matrizRaiz[1][0] = 5;
        matrizRaiz[1][1] = -10;
        matrizRaiz[1][2] = 3;
        matrizRaiz[1][3] = -5;
        matrizRaiz[2][0] = 1;
        matrizRaiz[2][1] = 3;
        matrizRaiz[2][2] = 10;
        matrizRaiz[2][3] = 14;
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

        }

    }
    
    //codigo ejemplo traducido del arabe al ingles
//    Implementation in C Codifo base
    ////Implementation of Jacobi's Method void JacobisMethod(int n, double x[n], double b[n], double a[n][n]){    double Nx[n]; //modified form of variables    int rootFound=0; //flag
//    int i, j;    while(!rootFound){        for(i=0; i<n; i++){              //calculation            Nx[i]=b[i];
//            for(j=0; j<n; j++){                if(i!=j) Nx[i] = Nx[i]-a[i][j]*x[j];            }            Nx[i] = Nx[i] / a[i][i];        }
//        rootFound=1;                    //verification        for(i=0; i<n; i++){            if(!( (Nx[i]-x[i])/x[i] > -0.000001 && (Nx[i]-x[i])/x[i] < 0.000001 )){                rootFound=0;                break;            }        }
//        for(i=0; i<n; i++){             //evaluation            x[i]=Nx[i];        }    }
//    return ; }
////Implementation of Gauss-Seidal Method void GaussSeidalMethod(int n, double x[n], double b[n], double a[n][n]){    double Nx[n]; //modified form of variables    int rootFound=0; //flag
//    int i, j;    for(i=0; i<n; i++){                  //initialization        Nx[i]=x[i];    }
//GoalKicker.com – Algorithms Notes for Professionals 215
//    while(!rootFound){        for(i=0; i<n; i++){              //calculation            Nx[i]=b[i];
//            for(j=0; j<n; j++){                if(i!=j) Nx[i] = Nx[i]-a[i][j]*Nx[j];            }            Nx[i] = Nx[i] / a[i][i];        }
//        rootFound=1;                    //verification        for(i=0; i<n; i++){            if(!( (Nx[i]-x[i])/x[i] > -0.000001 && (Nx[i]-x[i])/x[i] < 0.000001 )){                rootFound=0;                break;            }        }
//        for(i=0; i<n; i++){             //evaluation            x[i]=Nx[i];        }    }
//    return ; }
////Print array with comma separation void print(int n, double x[n]){    int i;    for(i=0; i<n; i++){        printf("%lf, ", x[i]);    }    printf("\n\n");
//    return ; }
//int main(){    //equation initialization    int n=3;    //number of variables
//    double x[n];    //variables
//    double b[n],    //constants        a[n][n];    //arguments
//    //assign values    a[0][0]=8; a[0][1]=2; a[0][2]=-2; b[0]=8;    //8x1+2x2-2x3+8=0    a[1][0]=1; a[1][1]=-8; a[1][2]=3; b[1]=-4;   //x1-8x2+3x3-4=0    a[2][0]=2; a[2][1]=1; a[2][2]=9; b[2]=12;    //2x1+x2+9x3+12=0
//    int i;
//    for(i=0; i<n; i++){                         //initialization        x[i]=0;    }    JacobisMethod(n, x, b, a);    print(n, x);
//    for(i=0; i<n; i++){                         //initialization
//GoalKicker.com – Algorithms Notes for Professionals 216
//        x[i]=0;    }    GaussSeidalMethod(n, x, b, a);    print(n, x);
//    return 0; 

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author javiershaka
 */
public class MinimosCuadra2 {

    public double getY(int x, double[] y) {
        double inc = 0;
        double var = 0;
        double eY = 0;
        double incY = 0;
        for (int i = 0; i < y.length; i++) {
            double x2 = i + 1;
            inc += x2;
            eY += y[i];
            incY += (x2 * y[i]);
            var += Math.pow(x2, 2);
        }
        double d = (y.length * var) - (Math.pow(inc, 2));
        double m = ((y.length * incY) - (inc * eY)) / d;
        double b = ((eY * var) - (inc * incY)) / d;
        double Y = (m * x) + b;
        return Y;
    }

}

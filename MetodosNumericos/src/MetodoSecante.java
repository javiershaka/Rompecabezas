/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodosecante;

/**
 *
 * @author Oscar Dena,Saul Rodríguez.
 */
public class MetodoSecante {
    public static double f(double x){
//        double e = 2.7182818285;
//        double resultado = Math.pow(e,-1*x ) - 2*x;
          double resultado = ((-2.5*(x*x*x))+17*(x*x)-22*x-11);
        return resultado;
    }
    
    public static double calcularErrorRelativo(double a, double b){
        double resultado = Math.abs(((a - b) / a) *100);
        return resultado;
    }
    
    public static double realizarFormulaSecante (double xi, double xiMenosUno){
        double xiMasUno = xi - ((f(xi) * (xiMenosUno - xi)) / (f(xiMenosUno) - f(xi)));
        return xiMasUno;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        double xi = 2, xiMenos1 = 3, xiMas1 = 0, errorMaximo = 0.004, errorActual = 0, errorAnterior, errorRelativo = 0;
        int iteraciones = 0;
        
        do {            
            errorAnterior = errorActual;
            
            xiMas1 = realizarFormulaSecante(xi, xiMenos1);
            errorActual = xiMas1;
            
            errorRelativo = calcularErrorRelativo(errorActual, errorAnterior);
                        System.out.println("Iteraciones: " + iteraciones + "\nxi-1: " + xiMenos1 + "\nxi: " + xi + "\nLa raíz se encuentra en: " + xiMas1 + "\nEl error relativo es: " + errorRelativo +  "\n-----------------");

            xiMenos1 = xi;
            xi = xiMas1;
            
            iteraciones++;
            
            
        } while (xi != xiMenos1 && errorRelativo > errorMaximo);
        
        
    }
    
}

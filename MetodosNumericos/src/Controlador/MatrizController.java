/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
import Modelo.GausJordan;
import Modelo.Gauss;

import Modelo.GaussSeidel;
import Modelo.Inversa;
import Modelo.MinimosCuadra2;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import metodosmaster.MenuPrincipal;

/**
 *
 * @author javiershaka
 */
public class MatrizController {

    public void ObtenerMatriz(int metodo) {
        try {
            
            int filas = MenuPrincipal.tblMat.getRowCount();
            int columnas = MenuPrincipal.tblMat.getColumnCount();
            double matrizTabla[][] = new double[MenuPrincipal.tblMat.getRowCount()][MenuPrincipal.tblMat.getColumnCount()];
            for (int i = 0; i < filas; i++) {
                for (int j = 0; j < columnas; j++) {
                    matrizTabla[i][j] = Double.parseDouble(MenuPrincipal.tblMat.getValueAt(i, j).toString());
                  //  System.out.println(""+i+j+MenuPrincipal.tblMat.getValueAt(i, j));
                }
            }

            if(metodo == 0){
                Gauss gassiana = new Gauss();
                gassiana.Guassiana(matrizTabla);
                
                
            }
            if (metodo == 1) {
                GausJordan gJordan = new GausJordan();
                gJordan.matrizGaussJordan(matrizTabla);
                
            }
            if (metodo == 2) {
                Inversa inversion = new Inversa();
                inversion.matrizInversa(matrizTabla);
                
            }
            if (metodo == 3) {
                GaussSeidel gss = new GaussSeidel();
                gss.Seidel(matrizTabla,Double.parseDouble(MenuPrincipal.txtError.getText()));
                
            }
            
        } catch (Exception e) {
            System.out.println(""+e);
        }

    }
    public void ObtenerCuadrados(){
        double lista[] = new double[MenuPrincipal.tbDatos.getRowCount()+1];
        
        MinimosCuadra2 mini = new MinimosCuadra2();
        for (int i = 0; i < MenuPrincipal.tbDatos.getRowCount(); i++) {
            lista[i] = Double.parseDouble(MenuPrincipal.tbDatos.getValueAt(i, 0).toString());
            
        }
        MenuPrincipal.txtPredic.setText(""+mini.getY(Integer.parseInt(MenuPrincipal.txtX.getText()), lista));
        
        
        
        
    }

}


package metodosmaster;


public class Secante {
  
    double Zen[]= new double[50];
    //Dua seria x1 y Era x0
    double Dua, Era;
    //esta es 
    double Chopy;
    //este es el error
    double E = 10;
    
   Secante (double Dua, double Era){
  //Estos son los valores iniciales de x1 y x2
   Zen[0] = Dua;
   Zen[1] = Era;
   
   }
   //Este metodo te define una ecuación de segundo grado a resolver
   double fo(double x){
       double y;
       y = (2*x*x)-5;
       return y;
       
   }
    //Este es basicamente el metodo que te hace el calculo
   double calularRaiz(){
   int i = 1;
   while(E>0.001){
       Zen[i+1] = Zen[i]-( (fo(Zen[i])*(Zen[i-1]-Zen[i]))/(fo(Zen[i-1])-fo(Zen[i])) );
       
    E=Math.abs((Zen[i+1]-Zen[i])/(Zen[i+1]))*100;
    
    System.out.println(Zen[i+1]+ " \t " +E+"\n");
    
    i++;
   
   
   }
   return Zen[i];
   }
    
    
    
}



import java.util.*;

public class Inversa {

    public static void main(String[] args) {
      Scanner Lee = new Scanner(System.in); 
      
    
    
   int i,vec=0,se,s,co,q,y,j;
   int w,t,x,z,conta,so,sc,de=0,web=0;

  int Leilani[][];
   int Kailani[][];
   Leilani=new int[3][4];
   Kailani=new int[3][4];

   for(i=0;i<=2;i++){
       for(j=0;j<=3;j++){
           System.out.print("numero matriz"+"("+i+"-"+j+")");
            Kailani[i][j]=Lee.nextInt();
          
       }
   }
       i=0; 
      for( j=0;j<=2;j++){
            co=0;
            se=1;
            s=1; 
             for(int k=1;k<=2;k++){
               for(int m=0;m<=2;m++){
                   
               
                if( m!=j){
                   co=co+1;
                if(co==1 || co==4){
                   se=se*Kailani[k][m]; 
                }
                if(co==2 || co==3){
                   s=s*Kailani[k][m];
            }
        if(i+j==1){
          vec= -(se-s)*Kailani[i][j];
        }
        if(i+j!=1){
          vec= (se-s)*Kailani[i][j];
        }
    
                }
           } 
       }
        web=vec+web;
  }
   
    for(q=0;q<=2;q++){
        for(y=0;y<=2;y++){
           Leilani[q][y]=Kailani[y][q];
        }
       
    }
 System.out.println("determinante de la matriz es "+web);

    System.out.println("la matriz adjunta de la transpuesta ");

           for(w=0;w<=2;w++){
              for(t=0;t<=2;t++){
        
              conta=0;
              so=1;
              sc=1;
               
           for(x=0;x<=2;x++){
                 for(z=0;z<=2;z++){
               
              if(x!=w && z!=t){
                   conta=conta+1;
                   
                    if(conta ==1  || conta==4){
                       so=so*Leilani[x][z];
                   }
                    if(conta ==2  || conta==3){
                        sc=sc*Leilani[x][z];
                   }
                   
                    if(w+t==1 || w+t==3){
                        de = -(so-sc);
                  }
                  if((w+t)%2==0){
                        de=(so-sc);
                  }
               }
             }
          }
        System.out.print("("+de+")"+",");
      }
    }
        
        
        
        
    }
    
}

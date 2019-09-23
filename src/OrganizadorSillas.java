/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;


/**
 *
 * @author VivianaM
 */
public class OrganizadorSillas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner   leer = new Scanner(System.in);
        
        //entrada de las familias
        String [] familias = leer.nextLine().split(",");
        int fml []= new int[familias.length];
        
        for (int i = 0; i < familias.length; i++) 
            fml[i]=Integer.parseInt(familias[i]);
        // entrada e las n mesas 
        int mesas = Integer.parseInt(leer.nextLine());
        
        
        
        System.out.println(contarFormas(fml, mesas));
        
        
    }
    
    //metodo
   public static int contarFormas(int[] a, int k){
         int comb=1, n=1, r=1, j=0, aux=1, aux2=1;
        
         //numero de posibilidades individual familias
         while (j < a.length){
             aux= (int) Math.pow(2, (int) Array.get(a, j));
             comb=comb*aux;
             j++;
         }
          //posibilidades juntas
         if(a.length>k){
             n=a.length;
             r=n-k;
             int fn=1, fr=1;
             while(n!=0){
                 fn=fn*n;
                 n--;
             }
             while(r!=0){
                 fr=fr*r;
                 r--;
             }
             aux2=fn/fr;
             comb=(comb*2)+aux2;
         }
         else{
             aux2=a.length-1;
//sumatoria * numero mesas
             comb =(comb+aux2)*k;
         }
         return comb;
     }
 
    
}

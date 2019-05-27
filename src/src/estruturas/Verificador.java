/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package estruturas;

import automato.Transicao;
import java.util.ArrayList;

/**
 *
 * @author Michael
 */
public class Verificador {
    
    ArrayList<Transicao> t;
    
    public static Transicao verificador(ArrayList<Transicao> t, char s, char p, char lambda){
        
        
        
        
        int i =0;
        while(t.get(i).getDesempilha() != p||  t.get(i).getDesempilha() != lambda){  
            i++;
        }
        return t.get(i);
        
    
}
}



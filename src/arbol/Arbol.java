package arbol;

import Logica.Decifrador;
import Logica.Expresion;
import Logica.Operacion;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

//Por ahora solo soporta las cuatro operaciones basicas, no soportara potencias o raices, por ahora
public class Arbol {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        Expresion exp = new Expresion();
        String a = "((5+3)/2)+((1-5)*2)";
        String b = "(5+4*(7-6*8)/2)+(4*(9-8)/4)";
        exp.setExpre(b);
        exp.Contar();
        Decifrador dec = new Decifrador();
        dec.setDescompuesta(exp);
       
        dec.Decifrar();
       
        String nada = "";
        for(String i:dec.descompuesta){
            nada = nada+i;
            System.out.println(nada);
        }
        Queue<Operacion> ops = dec.getOpes();
        Operacion temp = new Operacion();
    
        
       nada = "";
        /*
        do {
            temp = ops.poll();
            String i = temp.valor;
            System.out.println("operacion: ");
            System.out.println(i);

        }while(temp!=null);*/
        for(String i:dec.descompuesta){
            nada = nada+i;
            
        }
      System.out.println(nada);
    }
}

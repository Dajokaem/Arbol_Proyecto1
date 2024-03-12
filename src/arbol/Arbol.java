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
        
        exp.setExpre("((5+3)/2)+((1-5)*2)");
        exp.Contar();
        Decifrador dec = new Decifrador();
        dec.setDescompuesta(exp);
        dec.Decifrar(exp.getExpre());
        Queue<Operacion> ops = dec.getOpes();
        Operacion temp = new Operacion();
    
        
        System.out.println(dec.descompuesta.get(0));
        
        do {
            temp = ops.poll();
            String i = temp.nombre;
            System.out.println("operacion: ");
            System.out.println(i);

        }while(true);
      
    }
}

package arbol;

import Logica.Expresion;
import java.util.Scanner;

//Por ahora solo soporta las cuatro operaciones basicas
public class Arbol {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        Expresion exp = new Expresion();
        exp.setExpre("((5+3)/2)+((1-5)*2)");
        exp.Contar();
        int nada = exp.ContarHastaMitad();
        System.out.println(nada);
    }
}

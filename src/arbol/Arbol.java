package arbol;

import Logica.ArbolExpresion;
import Logica.Calculadora;
import Logica.Decifrador;
import Logica.Expresion;
import Logica.Operacion;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

/*Por ahora solo soporta las cuatro operaciones basicas, no soportara potencias o raices, por ahora
Ademas de requerir expresar la multiplicacion de manera explicita, tal como: 4(5) como 4*(5), 
En una expresion mas compleja, se veria, 7+5(4+6), debe ingresarse, 7+5*(4+6), de lo contrario, no podra resolver, 
Solo soporta valores numericos de una sola cifra, es decir, si se ingresa, 14+5 lo mostrara como 9 no como 19, 
*/
public class Arbol {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        Expresion exp = new Expresion();
        Calculadora calc = new Calculadora();        
        Decifrador dec = new Decifrador();
        ArbolExpresion arbol = new ArbolExpresion();
        System.out.println("Dame la expresion a Evaluar");
        String operacion = leer.next();
        exp.setExpre(operacion);
        dec.setDescompuesta(exp);
        dec.Decifrar();
        calc.setOperaciones(dec.getOpes());
        double resultado = calc.Calcular();
        System.out.println("El resultado es: "+resultado);
       

    }
}

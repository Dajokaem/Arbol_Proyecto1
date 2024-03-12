package Logica;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Decifrador {

    public Queue<Operacion> opes = new LinkedList<Operacion>();
    public List<String> descompuesta = new ArrayList<String>();
    String abecedario = "abcdefghijklmnopqrstuvwxyz";
    String[] variables = abecedario.split("");
    int varind = 0;

    public Decifrador() {
    }

    public Queue<Operacion> getOpes() {
        return opes;
    }

    public void setDescompuesta(Expresion expresion) {
        String[] descom = expresion.expre.split("");
        for (String i : descom) {
            this.descompuesta.add(i);
        }

    }

    public void Decifrar(String expresion) {
        for (int i = 0; i < 3; i++) {
            if (descompuesta.get(i).equals("(")) {
                Parentesis(i);
                System.out.println(i);
            }
        }
    }

    public void Parentesis(int indice) {
        String parte = "";
        for (int j = indice + 1; j < descompuesta.size()-1; j++) {
            if (descompuesta.get(j).equals("(")) {
                Parentesis(j);
                System.out.println("a");
            }
            if (descompuesta.get(j).equals(")")) {
                int k = 0;
                for (k = indice + 1; k < j-1; k++) {
                    System.out.println("b");
                }
                if (k > 4) {

                } else {
                    if (k == 4) {
                        for (int l = indice + 1; l < indice + 3; l++) {
                            parte = parte + descompuesta.remove(l);
                            System.out.println("c");
                        }
                        Operacion op = new Operacion();

                        op.setNombre(variables[varind]);
                        op.setValor(parte);
                        this.varind++;
                        opes.add(op);
                        //descompuesta.add(indice, op.nombre);
                    }else{
                        
                    }
                    
                }
            }
        }
    }

}

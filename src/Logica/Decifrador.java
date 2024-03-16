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
    int contrecursion = 0;

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

    public void Decifrar() {
        int i = 0;
        int j;
        do {
            j = 0;
            if (descompuesta.get(i).equals("(")) {
                Parentesis(i);
                System.out.println("nalgas");
                i = 0;
            }
            if ((descompuesta.get(i).equals("*")) || (descompuesta.get(i).equals("/"))) {
                MultiDiv(i);
                i = 0;
            }
            if ((descompuesta.get(i).equals("+")) || (descompuesta.get(i).equals("-"))) {
                SumaResta(i);
                i = 0;
            }
            i++;
        } while (descompuesta.size() > 3);
    }

    public String Decifrar(String expresion) {
        String[] deshecha = expresion.split("");
        List<String> subdescompuesta = new ArrayList<String>();
        for (String a : deshecha) { //Descompone la expresion en un Array y lo convierte a List para un manejo organico y facil
            subdescompuesta.add(a);
        }
        int i = 0;
        String parte = "", p = "";
        do {

            if ((subdescompuesta.get(i).equals("*")) || (subdescompuesta.get(i).equals("/"))) {
                if (subdescompuesta.size() == 3) {
                    parte = parte + subdescompuesta.remove(i - 1);
                    parte = parte + subdescompuesta.remove(i);
                    parte = parte + subdescompuesta.remove(i - 1);
                    Operacion op = new Operacion();
                    op.setNombre(variables[varind]);
                    op.setValor(parte);
                    varind++;
                    subdescompuesta.add(i - 1, op.getNombre());
                    opes.add(op);
                    i = 0;
                    parte = "";
                } else {
                    parte = parte + subdescompuesta.remove(i - 1);
                    parte = parte + subdescompuesta.remove(i + 1);
                    parte = parte + subdescompuesta.remove(i);
                    Operacion op = new Operacion();
                    op.setNombre(variables[varind]);
                    op.setValor(parte);
                    varind++;
                    subdescompuesta.add(i - 1, op.getNombre());
                    opes.add(op);
                    i = 0;
                    parte = "";
                }
            }
            if ((subdescompuesta.get(i).equals("+")) || (subdescompuesta.get(i).equals("-"))) {
                if (subdescompuesta.size() == 3) {
                    parte = parte + subdescompuesta.remove(i - 1);
                    parte = parte + subdescompuesta.remove(i);
                    parte = parte + subdescompuesta.remove(i - 1);
                    Operacion op = new Operacion();
                    op.setNombre(variables[varind]);
                    op.setValor(parte);
                    varind++;
                    subdescompuesta.add(i - 1, op.getNombre());
                    opes.add(op);
                    i = 0;
                    parte = "";
                } else {
                    parte = parte + subdescompuesta.remove(i - 1);
                    parte = parte + subdescompuesta.remove(i + 1);
                    parte = parte + subdescompuesta.remove(i);
                    Operacion op = new Operacion();
                    op.setNombre(variables[varind]);
                    op.setValor(parte);
                    varind++;
                    subdescompuesta.add(i - 1, op.getNombre());
                    opes.add(op);
                    i = 0;
                    parte = "";
                }
            }
            i++;
            p = "";
        } while (subdescompuesta.size() > 1);
        return subdescompuesta.get(0);
    }

    public void Parentesis(int indice) {
        String parte = "", algo = "";
        int j;
        contrecursion++;
        System.out.println(contrecursion + "°");
        for (int nada = indice; nada < descompuesta.size(); nada++) {
            algo = algo + descompuesta.get(nada);
        }
        System.out.println("Formula: " + " " + algo);
        for (j = indice + 1; j < descompuesta.size(); j++) {
            parte = "";
            //System.out.println("inicio algoritmo");
            if (descompuesta.get(j).equals("(")) {
                // System.out.println("recursion");
                Parentesis(j);
                //System.out.println("final recursion");

            } else {

                //System.out.println(j);
                if (descompuesta.get(j).equals(")")) {
                    int k = j - (indice + 1);

                    if (k > 3) {
                        System.out.println("Parentesis tipo (a+b+c)");
                        String tempParte = "";
                        for (int l = indice + 1; l < j; l++) {
                            tempParte = tempParte + descompuesta.remove(indice + 1);
                        }
                        System.out.println(tempParte);
                        parte = Decifrar(tempParte);
                        descompuesta.add(indice + 1, parte);
                        Parentesis(0);
                    } else {
                        System.out.println("Separacion");

                        if (k == 3) {
                            System.out.println("Parentesis comun");
                            for (int l = indice + 1; l < j; l++) {

                                parte = parte + descompuesta.remove(indice + 1);

                            }
                            System.out.println(parte);
                            Operacion op = new Operacion();

                            op.setNombre(variables[varind]);
                            op.setValor(parte);
                            this.varind++;
                            opes.add(op);
                            descompuesta.add(indice + 1, op.nombre);

                            //formula
                            for (int nada = indice; nada < descompuesta.size() - 1; nada++) {
                                algo = algo + descompuesta.get(nada);
                            }
                            Parentesis(0);
                            //System.out.println("final recursion");
                        } else {
                            //Remover parentesis de formas (a) => a
                            if (k == 1) {

                                System.out.println("Remover (a)");
                                //System.out.println(j);
                                //System.out.println(descompuesta.size());
                                if ((indice != 0) && (j != descompuesta.size() - 1)) {
                                    //System.out.println(contrecursion + "°");
                                    algo = "";
                                    for (int nada = 0; nada < descompuesta.size(); nada++) {
                                        algo = algo + descompuesta.get(nada);
                                    }
                                    System.out.println("Formula: " + " " + algo);
                                    // System.out.println(descompuesta.size());
                                    descompuesta.remove(indice );
                                    descompuesta.remove(indice+1 );

                                    //formula
                                    Parentesis(0);
                                    //System.out.println("final recursion");
                                } else {
                                    System.out.println("Remover (b)");
                                    descompuesta.remove(indice);
                                    descompuesta.remove(indice + 1);

                                    //formula
                                    for (int nada = indice; nada < descompuesta.size() - 1; nada++) {
                                        algo = algo + descompuesta.get(nada);
                                    }
                                    Parentesis(0);
                                    //System.out.println("final recursion");
                                }
                            }
                            //Multiplicaciones del tipo b(a)
                        }

                    }
                }
            }
        }
        
    }

    private void MultiDiv(int indice) {
        int i = indice;
        String parte = "";
        if (descompuesta.size() == 3) {
            parte = parte + descompuesta.remove(i - 1);
            parte = parte + descompuesta.remove(i);
            parte = parte + descompuesta.remove(i - 1);
            Operacion op = new Operacion();
            op.setNombre(variables[varind]);
            op.setValor(parte);
            varind++;
            descompuesta.add(i - 1, op.getNombre());
            opes.add(op);
            
            parte = "";
        } else {
            parte = parte + descompuesta.remove(i - 1);
            parte = parte + descompuesta.remove(i + 1);
            parte = parte + descompuesta.remove(i);
            Operacion op = new Operacion();
            op.setNombre(variables[varind]);
            op.setValor(parte);
            varind++;
            descompuesta.add(i - 1, op.getNombre());
            opes.add(op);
            
            parte = "";
        }
    }

    private void SumaResta(int indice) {
        int i = indice;
        String parte = "";
        if (descompuesta.size() == 3) {
            parte = parte + descompuesta.remove(i - 1);
            parte = parte + descompuesta.remove(i);
            parte = parte + descompuesta.remove(i - 1);
            Operacion op = new Operacion();
            op.setNombre(variables[varind]);
            op.setValor(parte);
            varind++;
            descompuesta.add(i - 1, op.getNombre());
            opes.add(op);
            
            parte = "";
        } else {
            parte = parte + descompuesta.remove(i - 1);
            parte = parte + descompuesta.remove(i + 1);
            parte = parte + descompuesta.remove(i);
            Operacion op = new Operacion();
            op.setNombre(variables[varind]);
            op.setValor(parte);
            varind++;
            descompuesta.add(i - 1, op.getNombre());
            opes.add(op);
            
            parte = "";
        }
    }

}

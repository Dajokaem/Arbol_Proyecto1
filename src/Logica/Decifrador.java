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

    public void Decifrar(String expresion) {
        int i = 0;
        int j;
        do {
            j = 0;
            if (descompuesta.get(i).equals("(")) {
                Parentesis(j);
                System.out.println("nalgas");
                i = 0;
            }/*
            if((descompuesta.get(i).equals("*"))||(descompuesta.get(i).equals("/"))){
                MultiDiv(i);
            }
            if((descompuesta.get(i).equals("+"))||(descompuesta.get(i).equals("-"))){
                SumaResta(i);
            }*/
            i++;
        } while (descompuesta.size() > 3);
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

                    if (k > 4) {
                        //Parentesis tipo (a+b....+n)
                    } else {
                        //System.out.println("Separacion");

                        if (k == 3) {
                            //System.out.println("Parentesis comun");
                            for (int l = indice + 1; l < j; l++) {

                                parte = parte + descompuesta.remove(indice + 1);

                            }
                            //System.out.println(parte);
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

                                //System.out.println("Remover (a)");
                                //System.out.println(j);
                                //System.out.println(descompuesta.size());
                                if ((indice != 0) && (j != descompuesta.size()-1)) {
                                    //System.out.println(contrecursion + "°");
                                    algo = "";
                                    for (int nada = 0; nada < descompuesta.size(); nada++) {
                                        algo = algo + descompuesta.get(nada);
                                    }
                                    System.out.println("Formula: " + " " + algo);
                                   // System.out.println(descompuesta.size());
                                    descompuesta.remove(indice - 1);
                                    descompuesta.remove(indice + 1);

                                    //formula
                                    Parentesis(0);
                                    //System.out.println("final recursion");
                                } else {
                                    //System.out.println("Remover (b)");
                                    descompuesta.remove(indice);
                                    descompuesta.remove(indice + 1);

                                    //formula
                                    for (int nada = indice; nada < descompuesta.size() - 1; nada++) {
                                        algo = algo + descompuesta.get(nada);
                                    }
                                    Parentesis(0);
                                    System.out.println("final recursion");
                                }
                            }
                            //Multiplicaciones del tipo b(a)
                        }

                    }
                }
            }
        }
       //System.out.println("final Decifrar");
        algo = "";
        for (int nada = 0; nada < descompuesta.size(); nada++) {
            algo = algo + descompuesta.get(nada);
        }
        //System.out.println("Formula: " + " " + algo);

    }

    private void MultiDiv(int indice) {
        if (descompuesta.get(indice).equals("*")) {
            String parte = "";
            parte = parte + descompuesta.remove(indice - 1);
            parte = parte + descompuesta.remove(indice);
            parte = parte + descompuesta.remove(indice);
            Operacion op = new Operacion();
            op.setNombre(variables[varind]);
            op.setValor(parte);
            this.varind++;
            opes.add(op);
            descompuesta.add(indice, op.nombre);

        } else {
            if (descompuesta.get(indice).equals("/")) {
                String parte = "";
                parte = parte + descompuesta.remove(indice - 1);
                parte = parte + descompuesta.remove(indice);
                parte = parte + descompuesta.remove(indice);
                Operacion op = new Operacion();
                op.setNombre(variables[varind]);
                op.setValor(parte);
                this.varind++;
                opes.add(op);
                descompuesta.add(indice, op.nombre);

            }
        }
    }

    private void SumaResta(int indice) {
        if (descompuesta.get(indice).equals("+")) {
            String parte = "";
            parte = parte + descompuesta.remove(indice - 1);
            parte = parte + descompuesta.remove(indice);
            parte = parte + descompuesta.remove(indice);
            Operacion op = new Operacion();
            op.setNombre(variables[varind]);
            op.setValor(parte);
            this.varind++;
            opes.add(op);
            descompuesta.add(indice, op.nombre);

        } else {
            if (descompuesta.get(indice).equals("-")) {
                String parte = "";
                parte = parte + descompuesta.remove(indice - 1);
                parte = parte + descompuesta.remove(indice);
                parte = parte + descompuesta.remove(indice);
                Operacion op = new Operacion();
                op.setNombre(variables[varind]);
                op.setValor(parte);
                this.varind++;
                opes.add(op);
                descompuesta.add(indice, op.nombre);

            }
        }
    }

}

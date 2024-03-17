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
    String ultima;
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
        String parte = "";
        int i = 0;
        int j;
        do {

            if (descompuesta.get(i).equals("(")) {
                Parentesis(i);
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
        try{
            parte = parte + descompuesta.remove(0);
            parte = parte + descompuesta.remove(0);
            parte = parte + descompuesta.remove(0);
            Operacion op = new Operacion();
            op.setNombre(variables[varind]);
            op.setValor(parte);
            opes.add(op);
            this.ultima = op.getValor();
        }catch(Exception ex){
            
        }
    }

    public String Decifrar(String expresion) {
        String[] deshecha = expresion.split("");
        List<String> subdescompuesta = new ArrayList<String>();
        for (String a : deshecha) { //Descompone la expresion en un Array y lo convierte a List para un manejo organico y facil
            subdescompuesta.add(a);
        }

        String parte = "", p = "";
        do {
            for (int i = 0; i < subdescompuesta.size(); i++) {
                if ((subdescompuesta.get(i).equals("*")) || (subdescompuesta.get(i).equals("/"))) {
                    if (subdescompuesta.size() == 3) {
                        parte = parte + subdescompuesta.remove(i - 1);
                        parte = parte + subdescompuesta.remove(i - 1);
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
                        parte = parte + subdescompuesta.remove(i - 1);
                        parte = parte + subdescompuesta.remove(i - 1);
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
            }
            for (int i = 0; i < subdescompuesta.size(); i++) {
                if ((subdescompuesta.get(i).equals("+")) || (subdescompuesta.get(i).equals("-"))) {
                    if (subdescompuesta.size() == 3) {
                        parte = parte + subdescompuesta.remove(i - 1);
                        parte = parte + subdescompuesta.remove(i - 1);
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
                        parte = parte + subdescompuesta.remove(i - 1);
                        parte = parte + subdescompuesta.remove(i - 1);
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
            }

            p = "";
        } while (subdescompuesta.size() > 1);
        return subdescompuesta.get(0);
    }

    public void Parentesis(int indice) {
        String parte = "", algo = "";
        int j;

        for (j = indice + 1; j < descompuesta.size(); j++) {
            parte = "";

            if (descompuesta.get(j).equals("(")) {

                Parentesis(j);

            } else {

                if (descompuesta.get(j).equals(")")) {
                    int k = j - (indice + 1);//Contenido del Parentesis

                    if (k > 3) {//Parentesis (a+b+c)

                        String tempParte = "";
                        for (int l = indice + 1; l < j; l++) {
                            tempParte = tempParte + descompuesta.remove(indice + 1);
                        }

                        parte = Decifrar(tempParte);

                        descompuesta.add(indice + 1, parte);
                        Parentesis(0);
                    } else {

                        if (k == 3) {//Parentesis Comun

                            for (int l = indice + 1; l < j; l++) {

                                parte = parte + descompuesta.remove(indice + 1);

                            }

                            Operacion op = new Operacion();

                            op.setNombre(variables[varind]);
                            op.setValor(parte);
                            this.varind++;

                            opes.add(op);
                            descompuesta.add(indice + 1, op.nombre);

                            for (int nada = indice; nada < descompuesta.size() - 1; nada++) {
                                algo = algo + descompuesta.get(nada);
                            }
                            Parentesis(0);

                        } else {
                            //Remover parentesis de formas (a) => a
                            if (k == 1) {

                                if ((indice != 0) && (j != descompuesta.size() - 1)) {

                                    descompuesta.remove(indice);
                                    descompuesta.remove(indice + 1);

                                    Parentesis(0);

                                } else {

                                    descompuesta.remove(indice);
                                    descompuesta.remove(indice + 1);

                                    Parentesis(0);

                                }
                            }

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
            parte = parte + descompuesta.remove(i - 1);
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
            parte = parte + descompuesta.remove(i - 1);
            parte = parte + descompuesta.remove(i - 1);
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
            parte = parte + descompuesta.remove(i - 1);
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
            parte = parte + descompuesta.remove(i - 1);
            parte = parte + descompuesta.remove(i - 1);
            Operacion op = new Operacion();
            op.setNombre(variables[varind]);
            op.setValor(parte);
            varind++;
            descompuesta.add(i - 1, op.getNombre());

            opes.add(op);

            parte = "";
        }
    }

    public String getUltima() {
        return this.ultima;
    }

}

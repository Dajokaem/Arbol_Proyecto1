package Logica;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Calculadora {

    public Queue<Operacion> Operaciones = new LinkedList<Operacion>();
    Queue<Operacion> izqOperaciones = new LinkedList<Operacion>();
    Queue<Operacion> derOperaciones = new LinkedList<Operacion>();
    String nums = "1234567890";
    String[] numeros = nums.split("");
    String abecedario = "abcdefghijklmnopqrstuvwxyz";
    String[] variables = abecedario.split("");
    String[] formulaGeneral;

    public Calculadora() {
    }

    public void setOperaciones(Queue<Operacion> opes) {
        this.Operaciones = opes;
        Queue<Operacion> Paralelo = new LinkedList<Operacion>();
        Paralelo = opes;
        List<Operacion> temp = new ArrayList<Operacion>();
        for (Operacion op : Paralelo) {

            temp.add(op);
        }

        this.formulaGeneral = temp.get(temp.size() - 1).getValor().split("");

    }

    public void setFormulaGeneral(String formulaGeneral) {
        this.formulaGeneral = formulaGeneral.split("");
    }

    public double Calcular() {
        double resultado = 0;
        Separador();

        double resIzq = CalcularIzq();
        double resDer = CalcularDer();
        if (Operaciones.isEmpty()) {
            switch (formulaGeneral[1]) {
                case "*":
                    resultado = resultado + (resIzq * resDer);
                    break;
                case "/":
                    resultado = resultado + (resIzq / resDer);
                    break;
                case "+":
                    resultado = resultado + (resIzq + resDer);
                    break;
                case "-":
                    resultado = resultado + (resIzq - resDer);
                    break;
            }

            return resultado;
        } else {
            switch (formulaGeneral[1]) {
                case "*":
                    resultado = resultado + (resIzq * Double.parseDouble(formulaGeneral[2]));
                    break;
                case "/":
                    resultado = resultado + (resIzq / Double.parseDouble(formulaGeneral[2]));
                    break;
                case "+":
                    resultado = resultado + (resIzq + Double.parseDouble(formulaGeneral[2]));
                    break;
                case "-":
                    resultado = resultado + (resIzq - Double.parseDouble(formulaGeneral[2]));
                    break;
            }
            return resultado;
        }
    }

    public double CalcularDer() {
        int i = 0, k = 0;
        double res = 0;
        String formula[];
        do {
            try {
                formula = derOperaciones.poll().getValor().split("");
            } catch (Exception ex) {
                return 0;
            }
            for (i = 0; i < abecedario.length(); i++) {

                if (variables[i].equals(formula[0])) {
                    k = 10;
                    break;
                }
                if (variables[i].equals(formula[2])) {
                    k = 1;
                    break;
                }
                if (i == abecedario.length() - 1) {
                    k = 20;
                    break;
                }

            }

            switch (k) {
                case 10:
                    if (formula[1].equals("*")) {
                        double der = Double.parseDouble(formula[2]);
                        res = res * der;
                    }
                    if (formula[1].equals("/")) {
                        double der = Double.parseDouble(formula[2]);
                        res = res / der;
                    }
                    if (formula[1].equals("+")) {
                        double der = Double.parseDouble(formula[2]);
                        res = res + der;
                    }
                    if (formula[1].equals("-")) {
                        double der = Double.parseDouble(formula[2]);
                        res = res - der;
                    }
                    break;
                case 1:
                    if (formula[1].equals("*")) {
                        double izq = Double.parseDouble(formula[0]);
                        res = izq * res;
                    }
                    if (formula[1].equals("/")) {
                        double izq = Double.parseDouble(formula[0]);
                        res = izq / res;
                    }
                    if (formula[1].equals("+")) {
                        double izq = Double.parseDouble(formula[0]);
                        res = izq + res;
                    }
                    if (formula[1].equals("-")) {
                        double izq = Double.parseDouble(formula[0]);
                        res = izq - res;
                    }
                    break;
                case 20:
                    if (formula[1].equals("*")) {
                        double izq = Double.parseDouble(formula[0]);
                        double der = Double.parseDouble(formula[2]);
                        res = res + (izq * der);
                    }
                    if (formula[1].equals("/")) {
                        double izq = Double.parseDouble(formula[0]);
                        double der = Double.parseDouble(formula[2]);
                        res = res + (izq / der);
                    }
                    if (formula[1].equals("+")) {
                        double izq = Double.parseDouble(formula[0]);
                        double der = Double.parseDouble(formula[2]);
                        res = res + (izq + der);
                    }
                    if (formula[1].equals("-")) {
                        double izq = Double.parseDouble(formula[0]);
                        double der = Double.parseDouble(formula[2]);
                        res = res + (izq - der);
                    }
                    break;
            }

        } while (derOperaciones.size() > 1);
        return res;

    }

    public double CalcularIzq() {
        int i = 0, k = 0;
        double res = 0;
        String formula[];
        do {

            formula = izqOperaciones.poll().getValor().split("");

            for (i = 0; i < abecedario.length(); i++) {

                if (variables[i].equals(formula[0])) {
                    k = 10;
                    break;
                }
                if (variables[i].equals(formula[2])) {
                    k = 1;
                    break;
                }
                if (i == abecedario.length() - 1) {
                    k = 20;
                    break;
                }

            }

            switch (k) {
                case 10:
                    if (formula[1].equals("*")) {
                        double der = Double.parseDouble(formula[2]);
                        res = res * der;
                    }
                    if (formula[1].equals("/")) {
                        double der = Double.parseDouble(formula[2]);
                        res = res / der;
                    }
                    if (formula[1].equals("+")) {
                        double der = Double.parseDouble(formula[2]);
                        res = res + der;
                    }
                    if (formula[1].equals("-")) {
                        double der = Double.parseDouble(formula[2]);
                        res = res - der;
                    }
                    break;
                case 1:
                    if (formula[1].equals("*")) {
                        double izq = Double.parseDouble(formula[0]);
                        res = izq * res;
                    }
                    if (formula[1].equals("/")) {
                        double izq = Double.parseDouble(formula[0]);
                        res = izq / res;
                    }
                    if (formula[1].equals("+")) {
                        double izq = Double.parseDouble(formula[0]);
                        res = izq + res;
                    }
                    if (formula[1].equals("-")) {
                        double izq = Double.parseDouble(formula[0]);
                        res = izq - res;
                    }
                    break;
                case 20:
                    if (formula[1].equals("*")) {
                        double izq = Double.parseDouble(formula[0]);
                        double der = Double.parseDouble(formula[2]);
                        res = res + (izq * der);
                    }
                    if (formula[1].equals("/")) {
                        double izq = Double.parseDouble(formula[0]);
                        double der = Double.parseDouble(formula[2]);
                        res = res + (izq / der);
                    }
                    if (formula[1].equals("+")) {
                        double izq = Double.parseDouble(formula[0]);
                        double der = Double.parseDouble(formula[2]);
                        res = res + (izq + der);
                    }
                    if (formula[1].equals("-")) {
                        double izq = Double.parseDouble(formula[0]);
                        double der = Double.parseDouble(formula[2]);
                        res = res + (izq - der);
                    }
                    break;
            }

        } while (!izqOperaciones.isEmpty());
        return res;
    }

    public void Separador() {
        int finIzq = 0, i = 0;
        int finDer = 0;
        String[] formula = this.formulaGeneral;
        for (Operacion temp : Operaciones) {

            if (temp.getNombre().equals(formula[0])) {

                finIzq = i;
                break;
            }
            i++;
        }
        for (int j = 0; j < finIzq + 1; j++) {
            izqOperaciones.add(Operaciones.poll());
        }
        if (Operaciones.size() != 1) {
            while (!Operaciones.isEmpty()) {
                derOperaciones.add(Operaciones.poll());
            }
        }
    }
}

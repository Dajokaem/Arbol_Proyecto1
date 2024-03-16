package Logica;

import java.util.LinkedList;
import java.util.Queue;

public class Calculadora {

    public Queue<Operacion> Operaciones = new LinkedList<Operacion>();
    Queue<Operacion> izqOperaciones = new LinkedList<Operacion>();
    Queue<Operacion> derOperaciones = new LinkedList<Operacion>();
    String nums = "1234567890";
    String[] numeros = nums.split("");
    String abecedario = "abcdefghijklmnopqrstuvwxyz";
    String[] variables = abecedario.split("");

    public Calculadora() {
    }

    public void setOperaciones(Queue<Operacion> opes) {
        this.Operaciones = opes;

    }

    public double Calcular() {
        double resultado = 0;

        return 0;
    }

    public double CalcularDer() {
        int i = 0, k = 0;
        double res = 0;
        String formula[];
        do {
            formula = derOperaciones.poll().getValor().split("");
            do {
                if (variables[i].equals(formula[0])) {
                    k = 10;
                }
                if (variables[i].equals(formula[2])) {
                    k = 1;
                }
                if (i == abecedario.length()) {
                    k = 20;
                }
                i++;
            } while (k == 0);

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

    public double CalcularIzq() {
        int i = 0, k = 0;
        double res = 0;
        String formula[];
        do {
            formula = izqOperaciones.poll().getValor().split("");
            do {
                if (variables[i].equals(formula[0])) {
                    k = 10;
                }
                if (variables[i].equals(formula[2])) {
                    k = 1;
                }
                if (i == abecedario.length()) {
                    k = 20;
                }
                i++;
            } while (k == 0);

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
        String[] formula = Operaciones.peek().getValor().split("");
        for (Operacion temp : Operaciones) {
            if (temp.getNombre().equals(formula[0])) {
                finIzq = i;
            }
            i++;
        }
        for (int j = 0; j < finIzq + 1; j++) {
            izqOperaciones.add(Operaciones.poll());
        }
        derOperaciones=Operaciones;
        
    }
}

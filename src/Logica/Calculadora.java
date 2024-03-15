package Logica;

import java.util.LinkedList;
import java.util.Queue;

public class Calculadora {

    public Queue<Operacion> Operaciones = new LinkedList<Operacion>();
    String abecedario = "abcdefghijklmnopqrstuvwxyz";
    String[] variables = abecedario.split("");
    double resultado = 0.0;
    public Calculadora() {
    }
    
    public void setOperaciones (Queue<Operacion> opes){
        this.Operaciones = opes;
    }
    public double Calcular(){
        Operacion op = new Operacion();
        do{
            op = Operaciones.poll();
        }while(!Operaciones.isEmpty());
        return resultado;
    }
}
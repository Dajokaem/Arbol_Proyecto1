package Logica;

import java.util.ArrayList;
import java.util.List;

public class Expresion {

    public String expre;
    public int tamaño;
    public int mitad;
    private final String[] operaciones = new String[]{"+", "-", "/", "*"};
    public List<Integer> posiciones = new ArrayList<Integer>();

    public Expresion() {
    }

    public void Contar() {

        String[] descom = this.expre.split("");
        int tam = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < this.expre.length(); j++) {
                if (descom[j].equals(operaciones[i])) {
                    this.posiciones.add(j);
                    tam = tam + 1;
                }
            }
        }
        this.tamaño = tam;
    }

    public int ContarHasta(int fin, String expo) {
        int tam = 0;

        String[] descom = expo.split("");

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < expo.length(); j++) {
                if (descom[j].equals(operaciones[i])) {
                    tam = tam + 1;
                    if (tam == fin) {
                        return tam;
                    }
                }
            }

        }
        return tam;

    }

    public int ContarHastaMitad() {
        List<Integer> tam = new ArrayList<Integer>();
        String[] descom = this.expre.split("");
        String[] parentesis = new String[]{"(", ")"};
        if (FalsaMitad()) {
            for (int j : posiciones) {
                if ((descom[j - 1].equals(parentesis[1])) && (descom[j + 1].equals(parentesis[0]))) {
                    tam.add(j);
                }
            }

            return tam.get(0);
        }else{
            int l = 0;
            for (int j : posiciones) {
                if ((descom[j - 1].equals(parentesis[1])) && (descom[j + 1].equals(parentesis[0]))) {
                    tam.add(j);
                }
            }
            if(Tipo(tam.size())){
                l = tam.size()/2;
                int p = tam.get(l);
                
            }
            
            return tam.get(0);
        }
    }

    public boolean FalsaMitad() {
        int tam = 0;
        boolean x = false;
        String[] descom = this.expre.split("");
        String[] parentesis = new String[]{"(", ")"};

        for (int j : posiciones) {
            if ((descom[j - 1].equals(parentesis[1])) && (descom[j + 1].equals(parentesis[0]))) {
                tam = tam + 1;
            }
        }
        if (tam == 1) {
            x = true;
        }
        return x;
    }

    public boolean Tipo(int y) {
        boolean x = false;
        
        if (y % 2 == 0) {
            x = true;
        }
        return x;
    }

    public String getExpre() {
        return expre;
    }

    public void setExpre(String exp) {
        this.expre = exp;
    }

}

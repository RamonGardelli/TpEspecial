package com.Teoria;

import java.util.Vector;

public class Main {

    public static void main(String[] args) {


        TrabajoEspecial tp = new TrabajoEspecial();
        Vector<Tupla> r = tp.Calcular_CoefCorrelacion();
        tp.ej2();
    /*
        Vector<Tupla> r = tp.Calcular_CoefCorrelacion();
        System.out.println("r["+ r.elementAt(0).getNombre() +"]: " + r.elementAt(0).getFactor() + "");
        System.out.println("r["+ r.elementAt(1).getNombre() +"]: " + r.elementAt(1).getFactor() + "");
        System.out.println("r["+ r.elementAt(2).getNombre() +"]: " + r.elementAt(2).getFactor() + "");
        System.out.println("r["+ r.elementAt(3).getNombre() +"]: " + r.elementAt(3).getFactor() + "");
        System.out.println("r["+ r.elementAt(4).getNombre() +"]: " + r.elementAt(4).getFactor() + "");
    */
    /*
        float[] ej2a = new float[] {0.385f, 0.154f, 0.128f, 0.154f, 0.179f};
        Huffman prueba = new Huffman();
        String[] code = prueba.do_Huffman(ej2a);

        for (int i = 0; i < code.length; i++)
            System.out.println(" S "+i+" = "+code[i]+"");
    */
    }
}

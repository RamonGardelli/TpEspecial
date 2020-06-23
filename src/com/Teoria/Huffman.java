package com.Teoria;

import java.util.Arrays;

public class Huffman {

    private Nodo_Huff punt_Huffman;
    private Nodo_Huff[] orden_Huff;

    class Nodo_Huff implements Comparable<Nodo_Huff> {

        private float p;
        private int c;
        private Nodo_Huff izq;
        private Nodo_Huff der;

        public Nodo_Huff() {
        }

        public Nodo_Huff(float p_hoja, int c) {
            this.c = c;
            this.izq = null;
            this.der = null;
        }

        public Nodo_Huff(float p, Nodo_Huff izqh, Nodo_Huff derh) {
            this.p = p;
            this.izq = izqh;
            this.der = derh;
        }

        public float get_Probabilidad() {
            return this.p;
        }

        public int get_simbolo() {
            return c;
        }

        public Nodo_Huff get_der() {
            return this.der;
        }

        public Nodo_Huff get_izq() {
            return this.izq;
        }

        boolean es_Hoja() {
            return ((this.izq == null) && (this.der == null));
        }

        public int compareTo(Nodo_Huff otro_nh) {
            if (this.p < otro_nh.get_Probabilidad())
                return -1;
            else if (this.p > otro_nh.get_Probabilidad())
                return 1;
            return 0;
        }

    }

    public Huffman() {
    }

    private void shift2_array() {
        for (int i = 2; i < orden_Huff.length; i++)
            this.orden_Huff[i - 2] = this.orden_Huff[i];
    }

    private void arbol_Huffman(String[] ch, String code, Nodo_Huff nh) {
        if (nh.es_Hoja())
            ch[nh.get_simbolo()] = new String(code);
        else {
            arbol_Huffman(ch, code + "0", nh.get_izq());
            arbol_Huffman(ch, code + "1", nh.get_der());
        }
    }
    public int mover_ArbolDerecha(){
        this.punt_Huffman = punt_Huffman.get_der();
        if(punt_Huffman.es_Hoja()){
            int simb = punt_Huffman.get_simbolo();
            punt_Huffman = orden_Huff[0];
            return simb;
        }
        return -1;
    }
    public int mover_ArbolIzquierda(){
        this.punt_Huffman = punt_Huffman.get_izq();
        if(punt_Huffman.es_Hoja()){
            int simb = punt_Huffman.get_simbolo();
            punt_Huffman = orden_Huff[0];
            return simb;
        }
        return -1;
    }


    public String[] do_Huffman(float[] dist) {

        int ult_pos = dist.length - 1;
        this.orden_Huff = new Nodo_Huff[dist.length];
        for (int i = 0; i < dist.length; i++)
            this.orden_Huff[i] = new Nodo_Huff(dist[i], i);
        Arrays.sort(orden_Huff);
        while (!(orden_Huff[0].get_Probabilidad() == 1)) {
            float h3 = orden_Huff[0].get_Probabilidad() + orden_Huff[1].get_Probabilidad();
            Nodo_Huff nh3 = new Nodo_Huff(h3, orden_Huff[0], orden_Huff[1]);
            shift2_array();
            orden_Huff[ult_pos] = null;
            ult_pos--;
            orden_Huff[ult_pos] = nh3;
            Arrays.sort(orden_Huff, 0, ult_pos + 1);
        }
        String[] codigo_Huffman = new String[dist.length];
        this.punt_Huffman = orden_Huff[0];
        arbol_Huffman(codigo_Huffman, "", orden_Huff[0]);
        return codigo_Huffman;
    }



}
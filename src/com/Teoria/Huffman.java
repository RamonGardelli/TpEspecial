package com.Teoria;

import java.util.Arrays;
import java.util.Vector;

public class Huffman {

    //private Nodo_Huff raiz_Huffman; // RAÍZ
    private Nodo_Huff[] orden_Huff; // Hojas del árbol, las cuales corresponden a cada símbolo c, y su prob. p

    class Nodo_Huff implements Comparable<Nodo_Huff> {

        private float p; // P(c)
        private int c; // Símbolo c que corresponderá a la posición c del arreglo de hojas
        private Nodo_Huff izq; // Hijos tq
        private Nodo_Huff der; // P(hijo_izq) <= P(hijo_der)

        public Nodo_Huff() {
        }

        public Nodo_Huff(float p_hoja, int c) { // Inicializa hojas
            this.p = p_hoja;
            this.c = c;
            this.izq = null;
            this.der = null;
        }

        public Nodo_Huff(float p, Nodo_Huff izqh, Nodo_Huff derh) { // Inicializa nodos intermedios
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

        public int compareTo(Nodo_Huff otro_nh) { // Solución a: ¿Cómo comparo dos Objetos Hojas?
            if (this.p < otro_nh.get_Probabilidad())
                return -1;
            else if (this.p > otro_nh.get_Probabilidad())
                return 1;
            return 0;
        }

    }

    public Huffman() {
    }

    private void shift2_array() { // Corrimiento a izquierda 2 posiciones, que son los nodos con menor probabilidad que ya usé
        for (int i = 2; i < orden_Huff.length; i++)
            this.orden_Huff[i - 2] = this.orden_Huff[i];
    }

    private void arbol_Huffman(String[] ch, String code, Nodo_Huff nh) { // Arma la codificación, desde raíz hasta las hojas
        if (nh.es_Hoja())
            ch[nh.get_simbolo()] = new String(code); // Llegué a un símbolo, tengo su código por recursión
        else {
            arbol_Huffman(ch, code + "0", nh.get_izq()); // Convención de asignación 0-1
            arbol_Huffman(ch, code + "1", nh.get_der()); //
        }
    }


    public String[] do_Huffman(float[] dist) {

        int ult_pos = dist.length - 1;
        this.orden_Huff = new Nodo_Huff[dist.length];
        for (int i = 0; i < dist.length; i++)
            this.orden_Huff[i] = new Nodo_Huff(dist[i], i);

        Arrays.sort(orden_Huff); // ordeno de forma ascendente mis hojas según su prob.

		/*for (int i = 0; i < orden_Huff.length; i++)
			if (orden_Huff[i] != null)
				System.out.print(" p["+i+"] = "+orden_Huff[i].get_Probabilidad()+" ");
		System.out.println(" ");*/

        while (!(orden_Huff[0].get_Probabilidad() == 1)) { // corto cuando armé P(orden_Huff[0]) = 1
            float h3 = orden_Huff[0].get_Probabilidad() + orden_Huff[1].get_Probabilidad(); // sumo mis dos probabilidades más chicas
            Nodo_Huff nh3 = new Nodo_Huff(h3, orden_Huff[0], orden_Huff[1]); // creo el nodo

            // Esto comentado, si no se entiende, recomiendo graficar a lo prog2 xd
            //this.raiz_Huffman = nh3; // digo que ese último nodo es la raíz, más que nada para cuando termina el while, se retornaría la raíz como el último nodo agregado // Lo puse así para no poder un if horrible.
            shift2_array(); // elimino los nodos ya utilizados
            orden_Huff[ult_pos] = null; // elimino dos probabilidades y agrego 1 (h3), la última pos de mi arreglo me sobra =>
            ult_pos--; // corro mi última posición de arreglo de hojas una pos.
            orden_Huff[ult_pos] = nh3; // mi última pos válida, ahora apunta al último nodo calculado
            Arrays.sort(orden_Huff, 0, ult_pos + 1); // ordeno de forma ascendente. // ult_pos+1, "+1" -> es un parche.
            ////// ojo con los pasajes de ult_pos, compilador pospone asignación? //////
			
			/*for (int i = 0; i < orden_Huff.length; i++)
				if (orden_Huff[i] != null)
					System.out.print(" p["+i+"] = "+orden_Huff[i].get_Probabilidad()+" ");
				else
					System.out.print(" p["+i+"] = null ");
			System.out.print("   "+"ult_pos = "+ult_pos);
			System.out.println(" ");*/
        }
        String[] codigo_Huffman = new String[dist.length];
        arbol_Huffman(codigo_Huffman, "", orden_Huff[0]); // va creando Strings que se desechan, a costa de simplicidad. Messi.
        return codigo_Huffman; // retorna la codificación correspondiente a cada simbolo
    }







}
package com.Teoria;

import java.util.Vector;

public class Helper {


    public int get_posicion_del_simbolo(int[] simbolos, int rgb) {
        for (int i = 0; i < simbolos.length; i++)
            if (simbolos[i] == rgb)
                return i;
        return -1;
    }


    public int[] recuperar_simbolos_decodificados(int[] simbolos, Vector<Integer> seqrecuperada) {
        int[] retornasimbolo = new int[seqrecuperada.size()];
        for (int i = 0; i < seqrecuperada.size(); i++) {
            retornasimbolo[i] = simbolos[seqrecuperada.elementAt(i)];
        }
        return retornasimbolo;
    }

    public int[] arrayHelperPosicion(float[] arregloprob) {

        Vector<Integer> helper = new Vector<>();


        for (int i = 0; i < arregloprob.length; i++) {
            if (arregloprob[i] != 0) {
                helper.add(i);
            }
        }
        int[] retorno = new int[helper.size()];

        for (int j = 0; j < helper.size(); j++) {
            retorno[j] = helper.elementAt(j);
        }
        return retorno;
    }

    public float[] arrayHelperProbabilidad(float[] arregloprob) {

        Vector<Float> helper = new Vector<>();


        for (int i = 0; i < arregloprob.length; i++) {
            if (arregloprob[i] != 0) {
                helper.add(arregloprob[i]);
            }
        }

        float[] retorno = new float[helper.size()];
        for (int j = 0; j < helper.size(); j++) {
            retorno[j] = helper.elementAt(j);
        }

        return retorno;
    }

    public int[] arrayHelperFrecuencia(int[] arreglofrec) {

        Vector<Integer> helper = new Vector<>();


        for (int i = 0; i < arreglofrec.length; i++) {
            if (arreglofrec[i] != 0) {
                helper.add(arreglofrec[i]);
            }
        }

        int[] retorno = new int[helper.size()];
        for (int j = 0; j < helper.size(); j++) {
            retorno[j] = helper.elementAt(j);
        }

        return retorno;
    }


}

package com.Teoria;

import javafx.util.Pair;

import java.util.HashMap;
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

    public int[][] matHelperFrecuencia(int[][] matfrec){
        Vector<Integer> posiciones = new Vector<>();

        for(int i=0;i<matfrec.length;i++){
            int j=0;
            while(j<matfrec[0].length){
                if(matfrec[i][j] != 0){
                    posiciones.add(i);
                    j=matfrec[0].length;
                }
                j++;
            }
        }

        int[][] matRetorno = new int[posiciones.size()][matfrec[0].length];

        for (int i = 0; i <posiciones.size() ; i++) {
            for (int j = 0; j <matfrec[0].length ; j++) {
                matRetorno[i][j] = matfrec[posiciones.elementAt(i)][j];
            }
        }

        return matRetorno;
    }

    public float[][] calcular_MatrizAcumulada(float[][] mat_Transicion){

        float[][] mat_Retornada = new float[mat_Transicion.length][mat_Transicion[0].length];
        for (int i = 0; i < mat_Retornada[0].length; i++) {
            float suma = 0;
            for (int j = 0; j <mat_Retornada.length ; j++) {
                mat_Retornada[j][i] = (suma + mat_Transicion[j][i]);
                suma = mat_Transicion[j][i];
            }
        }
        return mat_Retornada;
    }

    public float[] calcular_ProbabilidadesAcumuladas(float[] distribucion){
        float[] array_Retornado = new float[distribucion.length];
        float suma=0;
        for (int i = 0; i < array_Retornado.length; i++) {
            array_Retornado[i] = (suma + distribucion[i]);
            suma = distribucion[i];
        }
        return array_Retornado;
    }





}

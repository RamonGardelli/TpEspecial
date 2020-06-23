package com.Teoria;

import java.io.Serializable;

public class Encabezado implements Serializable{


    private int[] frecuencia;
    private int[] simbolos;
    private int ancho;
    private int alto;
    private int longsimbolos;
    private int pixels;
    private int sizemap;
    private byte[] r;
    private byte[] g;
    private byte[] b;

    public int getPixels() {
        return pixels;
    }

    public void setPixels(int pixels) {
        this.pixels = pixels;
    }

    public int getSizemap() {
        return sizemap;
    }

    public void setSizemap(int sizemap) {
        this.sizemap = sizemap;
    }

    public byte[] getR() {
        byte [] aux = r.clone();
        return aux;
    }

    public void setR(byte[] r) {
        this.r = r;
    }

    public byte[] getG() {
        byte [] aux = g.clone();
        return aux;
    }

    public void setG(byte[] g) {
        this.g = g;
    }

    public byte[] getB() {
        byte [] aux = b.clone();
        return aux;
    }

    public void setB(byte[] b) {
        this.b = b;
    }

    public Encabezado() {

    }

    public int getFrecuenciaInt(int pos){
        return this.frecuencia[pos];
    }

    public int getDimFrecuencia(){
        return this.frecuencia.length;
    }
    public void setFrecuencia(int[] frecuencia) {
        this.frecuencia = frecuencia;
    }

    public int getDimSimbolos(){
        return this.simbolos.length;
    }
    public int getSimbolosInt(int pos){
        return this.simbolos[pos];
    }

    public void setSimbolos(int[] simbolos) {
        this.simbolos = simbolos;
    }

    public int getAncho() {
        return ancho;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    public int getAlto() {
        return alto;
    }

    public void setAlto(int alto) {
        this.alto = alto;
    }


    public void setLongsimbolos(int longsimbolos) {
        this.longsimbolos = longsimbolos;
    }
}

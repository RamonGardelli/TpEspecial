package com.Teoria;

public class Desvio_Estandar{

    private float de;
    private int muestras;
    private float media;
    private long suma, suma2;

    public Desvio_Estandar(){
        this.de = 0f;
        this.muestras = 0;
        this.media = 0f;
        this.suma = 0;
        this.suma2 = 0;
    }

    float get_Desvio_Estandar(){
        return this.de;
    }

    void Calcular_Desvio_Estandar(int s){
        this.suma = this.suma + s;
        this.suma2 = this.suma2 + (s*s);
        this.muestras++;
        this.media = (float) this.suma / this.muestras;
        float mediaaux = this.suma2 / this.muestras;

        float varianza = mediaaux - (float) Math.pow(this.media,2);
        this.de = (float) Math.sqrt(varianza);
    }
}

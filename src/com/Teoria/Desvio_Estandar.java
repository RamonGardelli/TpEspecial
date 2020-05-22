package com.Teoria;

public class Desvio_Estandar{

    private float de;
    //private int muestras;
    //private float media;
    private Media media;
    private Media mediaaux;
    //private long suma, suma2;

    public Desvio_Estandar(){
        this.de = 0f;
        //this.muestras = 0;
        this.media = new Media();
        this.mediaaux = new Media();
        //this.media = 0f;
       //this.suma = 0;
        //this.suma2 = 0;
    }

    float get_Desvio_Estandar(){
        return this.de;
    }

    void Calcular_Desvio_Estandar(int s){
        //this.suma = this.suma + s;
       // this.suma2 = this.suma2 + (s*s);
        //this.muestras++;
        this.media.Calcular_Media(s);
       // this.media = (float) this.suma / this.muestras;
        this.mediaaux.Calcular_Media(s*s);

        float varianza = mediaaux.get_Media() - (float) Math.pow(this.media.get_Media(),2);
        this.de = (float) Math.sqrt(varianza);
    }
}

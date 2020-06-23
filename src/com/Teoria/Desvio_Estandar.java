package com.Teoria;

public class Desvio_Estandar{

    private float de;

    private Media media;
    private Media mediaaux;

    public Desvio_Estandar(){
        this.de = 0f;
        this.media = new Media();
        this.mediaaux = new Media();

    }

    float get_Desvio_Estandar(){
        return this.de;
    }

    void Calcular_Desvio_Estandar(int s){

        this.media.Calcular_Media(s);
        this.mediaaux.Calcular_Media(s*s);

        float varianza = mediaaux.get_Media() - (float) Math.pow(this.media.get_Media(),2);
        this.de = (float) Math.sqrt(varianza);
    }
    float get_MediaPrueba(){return media.get_Media();}
}

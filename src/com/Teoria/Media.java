package com.Teoria;

public class Media{
    private int muestras;
    private long suma;
    private float med;

    public Media(){
        this.muestras = 0;
        this.suma = 0;
        this.med = 0f;
    }

    public float get_Media(){
        return med;
    }
    public void Calcular_Media(int b){
        this.suma = this.suma + b;
        this.muestras++;
        this.med = (float) suma / muestras;

    }
}

package com.Teoria;

public  class Covarianza{

    private float cov;
    private int muestras;
    private long suma, suma2,conj;
    private float mediaa,mediab,mediaconj;
    Media mediaa;

    public Covarianza(){
        this.cov=0f;
        this.muestras=0;
        this.suma=0;
        this.suma2=0;
        this.conj=0;
        this.mediaa=0f;
        this.mediab=0f;
        this.mediaconj=0f;
    }

    float get_Covarianza(){
        return this.cov;
    }

    float Calcular_Covarianza(int a,int b){
        this.suma= this.suma + a;
        this.suma2= this.suma2 + b;
        this.conj= this.conj + (a*b);
        this.muestras++;
        this.mediaa= (float) this.suma / muestras;
        this.mediab= (float) this.suma2 /muestras;
        this.mediaconj= (float) this.conj/muestras;
        float temp = mediaa*mediab;
        cov = mediaconj - temp;
        return cov;
    }

}

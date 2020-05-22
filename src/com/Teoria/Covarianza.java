package com.Teoria;

public  class Covarianza{

    private float cov;
    private int muestras;
    //private long suma, suma2,conj;
    //private float mediaa,mediab,mediaconj;

    private Media mediaa;
    private Media mediab;
    private Media mediaconj;

    public Covarianza(){
        this.cov=0f;
        //this.muestras=0;
        //this.suma=0;
       // this.suma2=0;
        //this.conj=0;
        //this.mediaa=0f;
        //this.mediab=0f;
       // this.mediaconj=0f;
        this.mediaa = new Media();
        this.mediab = new Media();
        this.mediaconj = new Media();
    }

    float get_Covarianza(){
        return this.cov;
    }

    float Calcular_Covarianza(int a,int b){
        //this.suma= this.suma + a;
        //this.suma2= this.suma2 + b;
        //this.conj= this.conj + (a*b);
        //this.muestras++;

        this.mediaa.Calcular_Media(a);
        this.mediab.Calcular_Media(b);
        this.mediaconj.Calcular_Media(a*b);
        float temp = mediaa.get_Media()*mediab.get_Media();
        cov = mediaconj.get_Media() - temp;
        return cov;
    }

}

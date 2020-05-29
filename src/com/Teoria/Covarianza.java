package com.Teoria;

public  class Covarianza{

    private float cov;
    private int muestras;

    private Media mediaa;
    private Media mediab;
    private Media mediaconj;

    public Covarianza(){
        this.cov=0f;
        this.mediaa = new Media();
        this.mediab = new Media();
        this.mediaconj = new Media();
    }

    float get_Covarianza(){
        return this.cov;
    }

    float Calcular_Covarianza(int a,int b){

        this.mediaa.Calcular_Media(a);
        this.mediab.Calcular_Media(b);
        this.mediaconj.Calcular_Media(a*b);
        float temp = mediaa.get_Media()*mediab.get_Media();
        cov = mediaconj.get_Media() - temp;
        return cov;
    }

}

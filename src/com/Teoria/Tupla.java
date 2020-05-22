package com.Teoria;

public class Tupla implements Comparable<Tupla> {

    private float factor;
    private String nombre;

    public Tupla(float factor, String nombre){
        this.factor=factor;
        this.nombre=nombre;
    }

    public float getFactor() {
        return factor;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public int compareTo(Tupla t2) {
        if(this.factor < t2.getFactor())
            return -1;
        else if(this.factor > t2.getFactor())
            return 1;
        return 0;
    }
}

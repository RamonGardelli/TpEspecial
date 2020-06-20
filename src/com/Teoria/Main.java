package com.Teoria;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class Main {

    public static void main(String[] args) {

        //MIGRADO A INTERFAZ.. APP

        //Defino unica instancia.
        TrabajoEspecial tpe = new TrabajoEspecial();
        tpe.Ejercicio1();
        tpe.Ejercicio2();

        BufferedImage Img_Canal2 = tpe.getImg_Canal2();

        /*
        tpe.CalcularMatrizTransicion(Img_Canal2,"Matriz Transicion Canal2");


        //Es necesario correr el ejercicio 1 para saber cual es la img mas parecida y ya tener toda la info
        tpe.Ejercicio1();

        //Obtengo imagenes relevantes junto a sus distribuciones y frecuencias.
        BufferedImage Img_Original = tpe.getImg_Original();
        BufferedImage Img_Policia = tpe.getImg_Policia();
        BufferedImage Img_MasParecida = tpe.getimagenEjercicio1();

        float[] distribucionImagenOriginal = tpe.getDistribucionImagenOriginal();
        float[] distribucionImagenPolicia = tpe.getDistribucionImagenPolicia();
        float[] distribucionImagenMasParecida = tpe.getDistribucionImagenEj1();

        int[] frecuenciasImagenOriginal = tpe.getFrecuenciasImagenOriginal();
        int[] frecuenciasImagenPolicia = tpe.getFrecuenciasImagenPolicia();
        int[] frecuenciasImagenMasParecida = tpe.getFrecuenciasImagenEj1();
        //

        //Ejercicio

        tpe.Ejercicio2();

        tpe.Compresor(distribucionImagenOriginal,frecuenciasImagenOriginal,Img_Original,"ImagenOriginalComprimida");

        tpe.Descompresor("ImagenOriginalDescomprimida","ImagenOriginalComprimida");
        */
    }
}

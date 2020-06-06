package com.Teoria;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Vector;

public class Main {

    public static void main(String[] args) {





        TrabajoEspecial tp = new TrabajoEspecial();
        tp.Ejercicio1();
        float[] distribucionImagenOriginal = new float[256];
        float[] distribucionImagenPolicia = new float[256];
        float[] distribucionImagenEj1 = new float[256];

        int[] frecuenciasImagenOriginal = new int[256];
        int[] frecuenciasImagenPolicia = new int[256];
        int[] frecuenciasImagenEj1 = new int[256];

        BufferedImage img = tp.getImg_Original();

        int m=0;
        for (int x = 0; x < img.getWidth(); x++) {
            for (int y = 0; y < img.getHeight(); y++) {
                int rgb_ImgOriginal = img.getRGB(x, y);

                Color color = new Color(rgb_ImgOriginal, true);

                rgb_ImgOriginal = color.getRed();

                frecuenciasImagenOriginal[rgb_ImgOriginal]++;
                m++;
            }
        }
        for (int i = 0; i < distribucionImagenOriginal.length; i++) {
            distribucionImagenOriginal[i] = (float) frecuenciasImagenOriginal[i] / m;
        }

        tp.Ejercicio2();

        tp.Compresor(distribucionImagenOriginal,frecuenciasImagenOriginal,img,"ImagenOriginalComprimida");

        tp.Descompresor("ImagenOriginalDescomprimida","ImagenOriginalComprimida");

    }
}

package com.Teoria;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.Vector;



public class TrabajoEspecial{
    private BufferedImage imgoriginal;
    private BufferedImage img_1;
    private BufferedImage img_2;
    private BufferedImage img_3;
    private BufferedImage img_4;
    private BufferedImage img_5;
    private BufferedImage img_ej2;
    private float[] dist_o;
    private float[] dist_pol;
    private BufferedImage puntej1;


    public TrabajoEspecial(){
        //CARGAR IMAGEN
        try{
            this.imgoriginal = ImageIO.read(new File("src\\com\\Teoria\\Will(Original).bmp"));
            this.img_1 = ImageIO.read(new File("src\\com\\Teoria\\Will_1.bmp"));
            this.img_2 = ImageIO.read(new File("src\\com\\Teoria\\Will_2.bmp"));
            this.img_3 = ImageIO.read(new File("src\\com\\Teoria\\Will_3.bmp"));
            this.img_4 = ImageIO.read(new File("src\\com\\Teoria\\Will_4.bmp"));
            this.img_5 = ImageIO.read(new File("src\\com\\Teoria\\Will_5.bmp"));
            this.img_ej2 = ImageIO.read(new File("src\\com\\Teoria\\Will_ej2.bmp"));
        } catch(IOException e){
            System.out.println(e.getMessage());
        }
    }


    public Vector<Tupla> Calcular_CoefCorrelacion(){

        Desvio_Estandar imgoriginal_de = new Desvio_Estandar();
        Desvio_Estandar img_1_de = new Desvio_Estandar();
        Desvio_Estandar img_2_de = new Desvio_Estandar();
        Desvio_Estandar img_3_de = new Desvio_Estandar();
        Desvio_Estandar img_4_de = new Desvio_Estandar();
        Desvio_Estandar img_5_de = new Desvio_Estandar();

        Covarianza imgo_cov_1 = new Covarianza();
        Covarianza imgo_cov_2 = new Covarianza();
        Covarianza imgo_cov_3 = new Covarianza();
        Covarianza imgo_cov_4 = new Covarianza();
        Covarianza imgo_cov_5 = new Covarianza();
        Vector<Tupla> r = new Vector<>(5);

        //LEER IMAGEN
        for (int x = 0; x < imgoriginal.getWidth(); x++) {
            for (int y = 0; y < imgoriginal.getHeight(); y++) {
                int rgb_original = imgoriginal.getRGB(x, y);
                int rgb_1 = img_1.getRGB(x, y);
                int rgb_2 = img_2.getRGB(x, y);
                int rgb_3 = img_3.getRGB(x, y);
                int rgb_4 = img_4.getRGB(x, y);
                int rgb_5 = img_5.getRGB(x, y);
                Color color = new Color(rgb_original,true);
                Color color1 = new Color(rgb_1,true);
                Color color2 = new Color(rgb_2,true);
                Color color3 = new Color(rgb_3,true);
                Color color4 = new Color(rgb_4,true);
                Color color5 = new Color(rgb_5,true);
                rgb_original = color.getRed();
                rgb_1 = color1.getRed();
                rgb_2 = color2.getRed();
                rgb_3 = color3.getRed();
                rgb_4 = color4.getRed();
                rgb_5 = color5.getRed();

                //LO QUE SIGUE ES EL CALCULO DEL INCISO 1
                //ACA CALCULAMOS DESVIO ORIGINAL
                imgoriginal_de.Calcular_Desvio_Estandar(rgb_original);

                // ACA CALCULAMOS EL DESVIO DE LA IMAGEN i
                img_1_de.Calcular_Desvio_Estandar(rgb_1);
                img_2_de.Calcular_Desvio_Estandar(rgb_2);
                img_3_de.Calcular_Desvio_Estandar(rgb_3);
                img_4_de.Calcular_Desvio_Estandar(rgb_4);
                img_5_de.Calcular_Desvio_Estandar(rgb_5);


                // COVARIANZA ACUMULADA
                imgo_cov_1.Calcular_Covarianza(rgb_original,rgb_1);
                imgo_cov_2.Calcular_Covarianza(rgb_original,rgb_2);
                imgo_cov_3.Calcular_Covarianza(rgb_original,rgb_3);
                imgo_cov_4.Calcular_Covarianza(rgb_original,rgb_4);
                imgo_cov_5.Calcular_Covarianza(rgb_original,rgb_5);
            }

        }
        // r = CovAB / (desvio(A)*desvio(B))


        r.add(0, new Tupla (imgo_cov_1.get_Covarianza() / (imgoriginal_de.get_Desvio_Estandar() * img_1_de.get_Desvio_Estandar()),"Img1"));
        r.add(1, new Tupla(imgo_cov_2.get_Covarianza() / (imgoriginal_de.get_Desvio_Estandar() * img_2_de.get_Desvio_Estandar()),"Img2"));
        r.add(2, new Tupla(imgo_cov_3.get_Covarianza() / (imgoriginal_de.get_Desvio_Estandar() * img_3_de.get_Desvio_Estandar()),"Img3"));
        r.add(3, new Tupla(imgo_cov_4.get_Covarianza() / (imgoriginal_de.get_Desvio_Estandar() * img_4_de.get_Desvio_Estandar()),"Img4"));
        r.add(4, new Tupla(imgo_cov_5.get_Covarianza() / (imgoriginal_de.get_Desvio_Estandar() * img_5_de.get_Desvio_Estandar()),"Img5"));
        Collections.sort(r);
        Collections.reverse(r);

        if(r.elementAt(0).getNombre() == "Img1")
            this.puntej1 = this.img_1;
        else if(r.elementAt(0).getNombre() == "Img2")
            this.puntej1 = this.img_2;
        else if(r.elementAt(0).getNombre() == "Img3")
            this.puntej1 = this.img_3;
        else if(r.elementAt(0).getNombre() == "Img4")
            this.puntej1 = this.img_4;
        else if(r.elementAt(0).getNombre() == "Img5")
            this.puntej1 = this.img_5;



        try {
            File outFile = new File(System.getProperty("user.dir") + "/" + "Factores Ejercicio 1" + ".txt");
            if (outFile.exists()) {
                outFile.delete();
                outFile.createNewFile();
            }
            FileWriter writer = new FileWriter(outFile);
            writer.write( r.elementAt(0).getNombre() +": " + r.elementAt(0).getFactor() + "\n");
            writer.write( r.elementAt(1).getNombre() +": " + r.elementAt(1).getFactor() + "\n");
            writer.write( r.elementAt(2).getNombre() +": " + r.elementAt(2).getFactor() + "\n");
            writer.write( r.elementAt(3).getNombre() +": " + r.elementAt(3).getFactor() + "\n");
            writer.write( r.elementAt(4).getNombre() +": " + r.elementAt(4).getFactor() + "\n");
            writer.close();

        } catch (Exception e) {
        }



        return r;
    }



    public void ej2(){

        float[] p_original = new float[256];
        float[] p_ej1 = new float[256];
        float[] p_ej2 = new float[256];
        int[] exitos_original = new int[256];
        int[] exitos_1 = new int[256];
        int[] exitos_ej2 = new int[256];
        for (int i = 0; i < p_original.length; i++){
            p_original[i] = 0f;
            p_ej1[i] = 0f;
            p_ej2[i] = 0f;
            exitos_original[i] = 0;
            exitos_1[i] = 0;
            exitos_ej2[i] = 0;
        }
        int m = 0;

        Media media_o = new Media();
        Media media_ej1 = new Media();
        Media media_ej2 = new Media();

        Desvio_Estandar imgoriginal_de = new Desvio_Estandar();
        Desvio_Estandar img_ej1_de = new Desvio_Estandar();
        Desvio_Estandar img_ej2_de = new Desvio_Estandar();

        for (int x = 0; x < imgoriginal.getWidth(); x++) {
            for (int y = 0; y < imgoriginal.getHeight(); y++) {
                int rgb_original = imgoriginal.getRGB(x, y);
                int rgb_1 = puntej1.getRGB(x, y);
                int rgb_ej2 = img_ej2.getRGB(x, y);
                Color color = new Color(rgb_original,true);
                Color color1 = new Color(rgb_1,true);
                Color color2 = new Color(rgb_ej2,true);
                rgb_original = color.getRed();
                rgb_1 = color1.getRed();
                rgb_ej2 = color2.getRed();

                exitos_original[rgb_original]++;
                exitos_1[rgb_1]++;
                exitos_ej2[rgb_ej2]++;
                m++;

                for (int i = 0; i < p_original.length; i++){
                    p_original[i] = (float) exitos_original[i] / m;
                    p_ej1[i] = (float) exitos_1[i] / m;
                    p_ej2[i] = (float) exitos_ej2[i] / m;
                }

                media_o.Calcular_Media(rgb_original);
                media_ej1.Calcular_Media(rgb_1);
                media_ej2.Calcular_Media(rgb_ej2);

                imgoriginal_de.Calcular_Desvio_Estandar(rgb_original);
                img_ej1_de.Calcular_Desvio_Estandar(rgb_1);
                img_ej2_de.Calcular_Desvio_Estandar(rgb_ej2);

            }
        }
        // Distribucion Histograma

        for (int i = 0; i < p_original.length; i++){
            p_original[i] = (float) exitos_original[i] / m;
            p_ej1[i] = (float) exitos_1[i] / m;
            p_ej2[i] = (float) exitos_ej2[i] / m;

        }
        //distribucion de las imagenes
        this.dist_o = p_original;
        this.dist_pol = p_ej2;

        Histograma prueba = new Histograma(p_original,"original");
        prueba.Ver_Histograma();


        try {
            File outFile = new File(System.getProperty("user.dir") + "/" + "Desvios y Medias Ejercicio 2" + ".txt");
            if (outFile.exists()) {
                outFile.delete();
                outFile.createNewFile();
            }
            FileWriter writer = new FileWriter(outFile);
            writer.write( "ORIGINAL - Media: "+media_o.get_Media()+"  Desvio Estandar: "+imgoriginal_de.get_Desvio_Estandar()+ "\n");
            writer.write( "IMG1 - Media : "+media_ej1.get_Media()+"  Desvio Estandar: "+img_ej1_de.get_Desvio_Estandar()+ "\n");
            writer.write( "EJ2 - Media: "+media_ej2.get_Media()+"  Desvio Estandar: "+img_ej2_de.get_Desvio_Estandar()+ "\n");
            writer.close();

        } catch (Exception e) {
        }

    }


}

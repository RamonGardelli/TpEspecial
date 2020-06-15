package com.Teoria;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class App {
    private JPanel panel1;
    private JLabel textup;
    private JButton factorDeAutocorrelacionButton;
    private JButton distribucionMediaYDesvioButton;
    private JButton matricesDeTransicionButton;
    private JButton graficosDeErrorYButton;
    private JButton compresionButton;
    private JButton descompresorButton;
    private JLabel textend;


    //Defino unica instancia.
    TrabajoEspecial tpe = new TrabajoEspecial();

    //Obtengo imagenes relevantes junto a sus distribuciones y frecuencias.
    BufferedImage Img_Original = tpe.getImg_Original();
    BufferedImage Img_Policia = tpe.getImg_Policia();
    BufferedImage Img_MasParecida;

    float[] distribucionImagenOriginal;
    float[] distribucionImagenPolicia;
    float[] distribucionImagenMasParecida;

    int[] frecuenciasImagenOriginal;
    int[] frecuenciasImagenPolicia;
    int[] frecuenciasImagenMasParecida;
    //


    public App() {
        factorDeAutocorrelacionButton.addActionListener(new ActionListener() {
            @Override

            public void actionPerformed(ActionEvent e) {
                tpe.Ejercicio1();
                JOptionPane.showMessageDialog(null,"Los resultados pueden ser visualizados en la carpeta Resultados.");

                Img_MasParecida = tpe.getimagenEjercicio1();

            }
        });
        distribucionMediaYDesvioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    tpe.Ejercicio2();
                    JOptionPane.showMessageDialog(null,"Los resultados pueden ser visualizados en la carpeta Resultados.");

                    distribucionImagenOriginal = tpe.getDistribucionImagenOriginal();
                    distribucionImagenPolicia = tpe.getDistribucionImagenPolicia();
                    distribucionImagenMasParecida = tpe.getDistribucionImagenEj1();

                    frecuenciasImagenOriginal = tpe.getFrecuenciasImagenOriginal();
                    frecuenciasImagenPolicia = tpe.getFrecuenciasImagenPolicia();
                    frecuenciasImagenMasParecida = tpe.getFrecuenciasImagenEj1();
                }
                catch(Exception error){
                    JOptionPane.showMessageDialog(null,"Debe ejecutar el factor de correlacion primero, asi decidir que imagen es mas parecida.");
                }

            }
        });
        compresionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    //a)
                    tpe.Compresor(distribucionImagenOriginal, frecuenciasImagenOriginal, Img_Original, "ImagenOriginalComprimida");
                    //b)
                    tpe.Compresor(distribucionImagenOriginal, frecuenciasImagenOriginal, Img_MasParecida, "ImagenMasParecidaComprimidaConOriginal");
                    //c)
                    tpe.Compresor(distribucionImagenOriginal, frecuenciasImagenOriginal, Img_Policia, "ImagenPoliciaComprimidaConOriginal");
                    //d)
                    tpe.Compresor(distribucionImagenPolicia, frecuenciasImagenPolicia, Img_Policia, "ImagenPoliciaComprimida");

                    JOptionPane.showMessageDialog(null, "Compresion exitosa!.");
                }
                catch (Exception error){
                    JOptionPane.showMessageDialog(null, "Es necesario ejecutar el Ejercicio 2 para obtener las distribuciones de las imagenes.");

                }

            }
        });
        descompresorButton.addActionListener(new ActionListener() {
            @Override

            public void actionPerformed(ActionEvent e) {
                try {
                    //de a)
                    tpe.Descompresor("ImagenOriginalDescomprimida", "ImagenOriginalComprimida");
                    //de b)
                    tpe.Descompresor("ImagenMasParecida(CodifImagenOriginal)Descomprimida", "ImagenMasParecidaComprimidaConOriginal");
                    //de c)
                    tpe.Descompresor("ImagenPolicia(CodifImagenOriginal)Descomprimida", "ImagenPoliciaComprimidaConOriginal");
                    //de d)
                    tpe.Descompresor("ImagenPoliciaDescomprimida", "ImagenPoliciaComprimida");

                    JOptionPane.showMessageDialog(null,"Descompresion exitosa! la imagen puede encontrarse en la carpeta Resultados");

                }
                catch(IOException exec){
                    JOptionPane.showMessageDialog(null,"No hay compresiones para descomprimir.");
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Trabajo Especial Teoria de la Informacion");
        frame.setContentPane(new App().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setPreferredSize(new Dimension(400, 400));
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);
    }




    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}

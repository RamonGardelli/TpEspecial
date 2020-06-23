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
    private BufferedImage Img_Original = tpe.getImg_Original();
    private BufferedImage Img_Policia = tpe.getImg_Policia();
    private BufferedImage Img_Canal2 = tpe.getImg_Canal2();
    private BufferedImage Img_Canal8 = tpe.getImg_Canal8();
    private BufferedImage Img_Canal10 = tpe.getImg_Canal10();
    private BufferedImage Img_MasParecida;

    private float[] distribucionImagenOriginal;
    private float[] distribucionImagenPolicia;
    private float[] distribucionImagenMasParecida;

    private int[] frecuenciasImagenOriginal;
    private int[] frecuenciasImagenPolicia;
    private int[] frecuenciasImagenMasParecida;
    //

    //Matrices de transicion
    private float[][] mat_Transicion_Canal2;
    private float[][] mat_Transicion_Canal8;
    private float[][] mat_Transicion_Canal10;

    //Ruidos EJ4
    private float ruido_Canal2;
    private float ruido_Canal8;
    private float ruido_Canal10;


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
                    tpe.Descompresor("Imagen Original Descomprimida", "ImagenOriginalComprimida");
                    //de b)
                    tpe.Descompresor("Imagen Mas Parecida (CodifImagenOriginal) Descomprimida", "ImagenMasParecidaComprimidaConOriginal");
                    //de c)
                    tpe.Descompresor("ImagenPolicia (CodifImagenOriginal) Descomprimida", "ImagenPoliciaComprimidaConOriginal");
                    //de d)
                    tpe.Descompresor("Imagen Policia Descomprimida", "ImagenPoliciaComprimida");

                    JOptionPane.showMessageDialog(null,"Descompresion exitosa! la imagen puede encontrarse en la carpeta Resultados");

                }
                catch(IOException exec){
                    JOptionPane.showMessageDialog(null,"No hay compresiones para descomprimir.");
                }
            }
        });
        matricesDeTransicionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    tpe.CalcularMatrizTransicion(Img_Canal2,"Matriz Transicion Canal2");
                    mat_Transicion_Canal2 = tpe.getMat_Transicion_Ejercicio4();
                    ruido_Canal2 = tpe.getRuido_Ejercicio4();
                    tpe.CalcularMatrizTransicion(Img_Canal8,"Matriz Transicion Canal8");
                    mat_Transicion_Canal8 = tpe.getMat_Transicion_Ejercicio4();
                    ruido_Canal8 = tpe.getRuido_Ejercicio4();
                    tpe.CalcularMatrizTransicion(Img_Canal10,"Matriz Transicion Canal10");
                    mat_Transicion_Canal10 = tpe.getMat_Transicion_Ejercicio4();
                    ruido_Canal10 = tpe.getRuido_Ejercicio4();
                    JOptionPane.showMessageDialog(null,"Las matrices pueden visualizarse en la carpeta de Resultados.");

                }
                catch (Exception exep){
                    JOptionPane.showMessageDialog(null,"Debe ejecutarse el ejercicio 2 para obtener las distribuciones y frecuencias de la imagen original. ");

                }
            }
        });
        graficosDeErrorYButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String Epsilon = JOptionPane.showInputDialog("Ingrese Epsilon");
                    String MIN_MUESTRAS = JOptionPane.showInputDialog("Ingrese minimo de muestras");
                    tpe.CalcularRuido_Muestreo(mat_Transicion_Canal2, "Error del Ruido Canal 2" + " Epsilon= " + Epsilon + " MinMuestras= "+ MIN_MUESTRAS, ruido_Canal2, Float.parseFloat(Epsilon), Integer.parseInt(MIN_MUESTRAS));
                    tpe.CalcularRuido_Muestreo(mat_Transicion_Canal8, "Error del Ruido Canal 8"+ " Epsilon= " + Epsilon + " MinMuestras= "+ MIN_MUESTRAS, ruido_Canal8, Float.parseFloat(Epsilon), Integer.parseInt(MIN_MUESTRAS));
                    tpe.CalcularRuido_Muestreo(mat_Transicion_Canal10, "Error del Ruido Canal 10"+ " Epsilon= " + Epsilon + " MinMuestras= "+MIN_MUESTRAS, ruido_Canal10, Float.parseFloat(Epsilon), Integer.parseInt(MIN_MUESTRAS));
                    JOptionPane.showMessageDialog(null,"Los resultados pueden ser visualizados en la carpeta Resultados.");

                }
                catch (Exception error){
                    JOptionPane.showMessageDialog(null,"Debe ejecutarse el ejercicio 3 asi obtener el ruido analitico y poder comparar. ");

                }
            }
        });
     ;}

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

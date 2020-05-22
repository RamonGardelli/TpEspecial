package com.Teoria;


import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.util.PublicCloneable;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

class Histograma {

    private int[] vectorhistograma;
    private String titulo;


    public Histograma(int[] vector, String titulo) {
        this.vectorhistograma = vector;
        this.titulo = titulo;
    }

    public void Ver_Histograma() {
        this.Crear_Histograma();
    }

    private void Crear_Histograma() {

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        String numpix = "#Pixeles";

        for (int i = 0; i < this.vectorhistograma.length; i++) {
            if (vectorhistograma[i] != 0) {
                dataset.addValue(this.vectorhistograma[i], numpix, "" + i);
            }

        }

        JFreeChart chart = ChartFactory.createBarChart("Histograma: " + this.titulo, null, null, dataset, PlotOrientation.VERTICAL, true, true, false);

        CategoryPlot plot = (CategoryPlot) chart.getPlot();
        BarRenderer renderer = (BarRenderer) plot.getRenderer();
        renderer.setSeriesPaint(0, Color.black);
        chart.setAntiAlias(true);
        chart.setBackgroundPaint(new Color(144, 144, 144));


        JFrame main = new JFrame("Histograma");
        main.setLayout(new BorderLayout(4, 4));
        main.setVisible(true);
        main.setSize(1300, 700);

        JPanel panel = new JPanel();

        main.add(panel);

        panel.removeAll();
        panel.repaint();
        panel.setLayout(new java.awt.BorderLayout());
        panel.add(new ChartPanel(chart));
        panel.validate();
        panel.setVisible(true);

        try {
            BufferedImage outHistograma = chart.createBufferedImage(800, 800);
            File outFile = new File(System.getProperty("user.dir") + "/" + this.titulo + ".png");
            if (outFile.exists()) {
                outFile.delete();
                outFile.createNewFile();
            }
            ImageIO.write(outHistograma, "png", outFile);
        } catch (Exception e) {
        }
    }

}
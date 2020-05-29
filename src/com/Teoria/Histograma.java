package com.Teoria;


import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.StandardXYBarPainter;
import org.jfree.chart.renderer.xy.XYBarRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

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

        XYSeries set = new XYSeries("#Pixeles");

        for (int i = 0; i < this.vectorhistograma.length; i++) {
                set.add(i,this.vectorhistograma[i]);
        }
        final XYSeriesCollection dataset = new XYSeriesCollection(set);

        JFreeChart chart = ChartFactory.createXYBarChart("Histograma: " + this.titulo, "Escala de grises",false, "Probabilidad", dataset, PlotOrientation.VERTICAL, true, true, false);


        XYPlot plot = (XYPlot) chart.getPlot();
        ValueAxis axis = plot.getDomainAxis();
        axis.setLowerBound(0);
        XYBarRenderer r = (XYBarRenderer) plot.getRenderer();
        r.setBarPainter(new StandardXYBarPainter());
        r.setSeriesPaint(0, Color.black);
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
        panel.setLayout(new BorderLayout());
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
package com.Teoria;


import org.jfree.chart.*;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.chart.renderer.xy.StandardXYBarPainter;
import org.jfree.chart.renderer.xy.XYBarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.text.DecimalFormat;
import java.util.Vector;

class Histograma {

    private int[] vectorhistograma;
    private String titulo;


    public Histograma(int[] vector, String titulo) {
        this.vectorhistograma = vector;
        this.titulo = titulo;
    }
    public Histograma(String titulo) {
        this.titulo = titulo;
    }

    public  void Ver_GraficoError(Vector<Float> errores) throws Exception {
        DefaultCategoryDataset line_chart_dataset = new DefaultCategoryDataset();

        for (int i = 0; i < errores.size(); i++) {
            line_chart_dataset.addValue(errores.elementAt(i),"Error",""+(Math.log(i)/Math.log(2)));
        }

        JFreeChart grafico = ChartFactory.createLineChart(
                this.titulo,"Error",
                "Valor",
                line_chart_dataset,PlotOrientation.VERTICAL,
                true,true,false);
        CategoryPlot plot = grafico.getCategoryPlot();
        LineAndShapeRenderer renderer = (LineAndShapeRenderer) plot.getRenderer();

        ChartFrame frame = new ChartFrame("Analisis de la convergencia ", grafico);
        frame.pack();
        frame.setSize(1300,700);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        CategoryAxis range = plot.getDomainAxis();
        range.setVisible(false);

        try {
            File directorio = new File( System.getProperty("user.dir")+"/resultados/Ejercicio4/");
            if(!directorio.exists()) {
                directorio.mkdirs();
            }
            BufferedImage outHistograma = grafico.createBufferedImage(800, 800);
            String subtitulo = this.titulo.substring(16,this.titulo.length());
            File outFile = new File(System.getProperty("user.dir") + "/resultados/Ejercicio4/" + "Grafico de convergencia "+ subtitulo + ".png");
            if (outFile.exists()) {
                outFile.delete();
                outFile.createNewFile();
            }
            ImageIO.write(outHistograma, "png", outFile);
        } catch (Exception e) {
        }


    }



    public void Ver_Histograma(String texto) {
        this.Crear_Histograma(texto);
    }

    private void Crear_Histograma(String texto) {

        XYSeries set = new XYSeries(texto);

        for (int i = 0; i < this.vectorhistograma.length; i++) {
                set.add(i,this.vectorhistograma[i]);
        }
        final XYSeriesCollection dataset = new XYSeriesCollection(set);

        JFreeChart chart = ChartFactory.createXYBarChart("" + this.titulo, "Escala de grises",false, "Frecuencias", dataset, PlotOrientation.VERTICAL, true, true, false);


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
        main.setLocationRelativeTo(null);

        JPanel panel = new JPanel();

        main.add(panel);

        panel.removeAll();
        panel.repaint();
        panel.setLayout(new BorderLayout());
        panel.add(new ChartPanel(chart));

        panel.validate();
        panel.setVisible(true);

        try {
            File directorio = new File( System.getProperty("user.dir")+"/resultados/Ejercicio2/");
            if(!directorio.exists()) {
                directorio.mkdirs();
            }
            BufferedImage outHistograma = chart.createBufferedImage(800, 800);
            File outFile = new File(System.getProperty("user.dir") + "/resultados/Ejercicio2/" + this.titulo + ".png");
            if (outFile.exists()) {
                outFile.delete();
                outFile.createNewFile();
            }
            ImageIO.write(outHistograma, "png", outFile);
        } catch (Exception e) {
        }
    }

}
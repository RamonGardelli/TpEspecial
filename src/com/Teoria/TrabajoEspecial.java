package com.Teoria;


import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.IndexColorModel;
import java.awt.image.WritableRaster;
import java.io.*;
import java.nio.ByteBuffer;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.Collections;
import java.util.Vector;


public class TrabajoEspecial {
    private BufferedImage Img_Canal2;
    private BufferedImage Img_Canal8;
    private BufferedImage Img_Canal10;
    private BufferedImage Img_Original;
    private BufferedImage Img_1;
    private BufferedImage Img_2;
    private BufferedImage Img_3;
    private BufferedImage Img_4;
    private BufferedImage Img_5;
    private BufferedImage Img_Policia;
    private BufferedImage imagenEjercicio1;

    private float[] distribucionImagenOriginal;
    private float[] distribucionImagenPolicia;
    private float[] distribucionImagenEj1;

    private int[] frecuenciasImagenOriginal;
    private int[] frecuenciasImagenPolicia;
    private int[] frecuenciasImagenEj1;

    private float[][] mat_Transicion_Ejercicio4;

    private float ruido_Ejercicio4;

    public float getRuido_Ejercicio4() {
        return ruido_Ejercicio4;
    }

    public BufferedImage getImg_Canal2() {
        ColorModel cm = Img_Canal2.getColorModel();
        boolean isAlphaPremultiplied = cm.isAlphaPremultiplied();
        WritableRaster raster = Img_Canal2.copyData(null);
        return new BufferedImage(cm, raster, isAlphaPremultiplied, null);
    }

    public BufferedImage getImg_Canal8() {
        ColorModel cm = Img_Canal8.getColorModel();
        boolean isAlphaPremultiplied = cm.isAlphaPremultiplied();
        WritableRaster raster = Img_Canal8.copyData(null);
        return new BufferedImage(cm, raster, isAlphaPremultiplied, null);
    }

    public BufferedImage getImg_Canal10() {
        ColorModel cm = Img_Canal10.getColorModel();
        boolean isAlphaPremultiplied = cm.isAlphaPremultiplied();
        WritableRaster raster = Img_Canal10.copyData(null);
        return new BufferedImage(cm, raster, isAlphaPremultiplied, null);
    }

    public BufferedImage getImg_Original() {
        ColorModel cm = Img_Original.getColorModel();
        boolean isAlphaPremultiplied = cm.isAlphaPremultiplied();
        WritableRaster raster = Img_Original.copyData(null);
        return new BufferedImage(cm, raster, isAlphaPremultiplied, null);
    }

    public BufferedImage getImg_Policia() {
        ColorModel cm = Img_Policia.getColorModel();
        boolean isAlphaPremultiplied = cm.isAlphaPremultiplied();
        WritableRaster raster = Img_Policia.copyData(null);
        return new BufferedImage(cm, raster, isAlphaPremultiplied, null);
    }

    public BufferedImage getimagenEjercicio1() {
        ColorModel cm = imagenEjercicio1.getColorModel();
        boolean isAlphaPremultiplied = cm.isAlphaPremultiplied();
        WritableRaster raster = imagenEjercicio1.copyData(null);
        return new BufferedImage(cm, raster, isAlphaPremultiplied, null);
    }

    public float[] getDistribucionImagenOriginal() {
        return Arrays.copyOf(distribucionImagenOriginal, distribucionImagenOriginal.length);
    }

    public float[] getDistribucionImagenPolicia() {
        return Arrays.copyOf(distribucionImagenPolicia, distribucionImagenPolicia.length);
    }

    public float[] getDistribucionImagenEj1() {
        return Arrays.copyOf(distribucionImagenEj1, distribucionImagenEj1.length);
    }

    public int[] getFrecuenciasImagenOriginal() {
        return Arrays.copyOf(frecuenciasImagenOriginal, frecuenciasImagenOriginal.length);
    }

    public int[] getFrecuenciasImagenPolicia() {
        return Arrays.copyOf(frecuenciasImagenPolicia, frecuenciasImagenPolicia.length);
    }

    public int[] getFrecuenciasImagenEj1() {
        return Arrays.copyOf(frecuenciasImagenEj1, frecuenciasImagenEj1.length);
    }

    public float[][] getMat_Transicion_Ejercicio4() {
        float[][] resultado = new float[mat_Transicion_Ejercicio4.length][];
        for (int i = 0; i < mat_Transicion_Ejercicio4.length; i++) {
            resultado[i] = Arrays.copyOf(mat_Transicion_Ejercicio4[i], mat_Transicion_Ejercicio4[i].length);
        }
        return resultado;
    }

    public TrabajoEspecial() {
        try {
            this.Img_Original = ImageIO.read(new File("img\\Will(Original).bmp"));
            this.Img_1 = ImageIO.read(new File("img\\Will_1.bmp"));
            this.Img_2 = ImageIO.read(new File("img\\Will_2.bmp"));
            this.Img_3 = ImageIO.read(new File("img\\Will_3.bmp"));
            this.Img_4 = ImageIO.read(new File("img\\Will_4.bmp"));
            this.Img_5 = ImageIO.read(new File("img\\Will_5.bmp"));
            this.Img_Policia = ImageIO.read(new File("img\\Will_ej2.bmp"));
            this.Img_Canal2 = ImageIO.read(new File("img\\Will_Canal2.bmp"));
            this.Img_Canal8 = ImageIO.read(new File("img\\Will_Canal8.bmp"));
            this.Img_Canal10 = ImageIO.read(new File("img\\Will_Canal10.bmp"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }


    public void Ejercicio1() {

        Desvio_Estandar De_ImgOriginal = new Desvio_Estandar();
        Desvio_Estandar De_Img1 = new Desvio_Estandar();
        Desvio_Estandar De_Img2 = new Desvio_Estandar();
        Desvio_Estandar De_Img3 = new Desvio_Estandar();
        Desvio_Estandar De_Img4 = new Desvio_Estandar();
        Desvio_Estandar De_Img5 = new Desvio_Estandar();

        Covarianza ImgOrig_Cov_Img1 = new Covarianza();
        Covarianza ImgOrig_Cov_Img2 = new Covarianza();
        Covarianza ImgOrig_Cov_Img3 = new Covarianza();
        Covarianza ImgOrig_Cov_Img4 = new Covarianza();
        Covarianza ImgOrig_Cov_Img5 = new Covarianza();
        Vector<Tupla> r = new Vector<>(5);

        for (int x = 0; x < Img_Original.getWidth(); x++) {
            for (int y = 0; y < Img_Original.getHeight(); y++) {
                int rgb_ImgOriginal = Img_Original.getRGB(x, y);
                int rgb_Img1 = Img_1.getRGB(x, y);
                int rgb_Img2 = Img_2.getRGB(x, y);
                int rgb_Img3 = Img_3.getRGB(x, y);
                int rgb_Img4 = Img_4.getRGB(x, y);
                int rgb_Img5 = Img_5.getRGB(x, y);
                Color color = new Color(rgb_ImgOriginal, true);
                Color color1 = new Color(rgb_Img1, true);
                Color color2 = new Color(rgb_Img2, true);
                Color color3 = new Color(rgb_Img3, true);
                Color color4 = new Color(rgb_Img4, true);
                Color color5 = new Color(rgb_Img5, true);
                rgb_ImgOriginal = color.getRed();
                rgb_Img1 = color1.getRed();
                rgb_Img2 = color2.getRed();
                rgb_Img3 = color3.getRed();
                rgb_Img4 = color4.getRed();
                rgb_Img5 = color5.getRed();


                De_ImgOriginal.Calcular_Desvio_Estandar(rgb_ImgOriginal);

                De_Img1.Calcular_Desvio_Estandar(rgb_Img1);
                De_Img2.Calcular_Desvio_Estandar(rgb_Img2);
                De_Img3.Calcular_Desvio_Estandar(rgb_Img3);
                De_Img4.Calcular_Desvio_Estandar(rgb_Img4);
                De_Img5.Calcular_Desvio_Estandar(rgb_Img5);


                ImgOrig_Cov_Img1.Calcular_Covarianza(rgb_ImgOriginal, rgb_Img1);
                ImgOrig_Cov_Img2.Calcular_Covarianza(rgb_ImgOriginal, rgb_Img2);
                ImgOrig_Cov_Img3.Calcular_Covarianza(rgb_ImgOriginal, rgb_Img3);
                ImgOrig_Cov_Img4.Calcular_Covarianza(rgb_ImgOriginal, rgb_Img4);
                ImgOrig_Cov_Img5.Calcular_Covarianza(rgb_ImgOriginal, rgb_Img5);
            }

        }


        r.add(0, new Tupla(ImgOrig_Cov_Img1.get_Covarianza() / (De_ImgOriginal.get_Desvio_Estandar() * De_Img1.get_Desvio_Estandar()), "Img1"));
        r.add(1, new Tupla(ImgOrig_Cov_Img2.get_Covarianza() / (De_ImgOriginal.get_Desvio_Estandar() * De_Img2.get_Desvio_Estandar()), "Img2"));
        r.add(2, new Tupla(ImgOrig_Cov_Img3.get_Covarianza() / (De_ImgOriginal.get_Desvio_Estandar() * De_Img3.get_Desvio_Estandar()), "Img3"));
        r.add(3, new Tupla(ImgOrig_Cov_Img4.get_Covarianza() / (De_ImgOriginal.get_Desvio_Estandar() * De_Img4.get_Desvio_Estandar()), "Img4"));
        r.add(4, new Tupla(ImgOrig_Cov_Img5.get_Covarianza() / (De_ImgOriginal.get_Desvio_Estandar() * De_Img5.get_Desvio_Estandar()), "Img5"));
        Collections.sort(r);
        Collections.reverse(r);

        if (r.elementAt(0).getNombre() == "Img1")
            this.imagenEjercicio1 = this.Img_1;
        else if (r.elementAt(0).getNombre() == "Img2")
            this.imagenEjercicio1 = this.Img_2;
        else if (r.elementAt(0).getNombre() == "Img3")
            this.imagenEjercicio1 = this.Img_3;
        else if (r.elementAt(0).getNombre() == "Img4")
            this.imagenEjercicio1 = this.Img_4;
        else if (r.elementAt(0).getNombre() == "Img5")
            this.imagenEjercicio1 = this.Img_5;

        try {
            File directorio = new File( System.getProperty("user.dir")+"/resultados/Ejercicio1/");
            if(!directorio.exists()) {
                directorio.mkdirs();
            }
            File outFile = new File(System.getProperty("user.dir") + "/resultados/Ejercicio1/" + "Factores de correlacion Ejercicio 1" + ".txt");
            if (outFile.exists()) {
                outFile.delete();
                outFile.createNewFile();
            }
            FileWriter writer = new FileWriter(outFile);
            writer.write("Factor de correlacion entre imagen original e imagen 1" + ": " + r.elementAt(0).getFactor() + "\n");
            writer.write("Factor de correlacion entre imagen original e imagen 2" + ": " + r.elementAt(1).getFactor() + "\n");
            writer.write("Factor de correlacion entre imagen original e imagen 3" + ": " + r.elementAt(2).getFactor() + "\n");
            writer.write("Factor de correlacion entre imagen original e imagen 4" + ": " + r.elementAt(3).getFactor() + "\n");
            writer.write("Factor de correlacion entre imagen original e imagen 5" + ": " + r.elementAt(4).getFactor() + "\n");
            writer.close();


        } catch (Exception e) {
        }
    }


    public void Ejercicio2() {


        float[] probabilidad_ImgOriginal = new float[256];
        float[] probabilidad_ImgEj1 = new float[256];
        float[] probabilidad_ImgPolicia = new float[256];
        int[] exitos_ImgOriginal = new int[256];
        int[] exitos_ImgEj1 = new int[256];
        int[] exitos_ImgPolicia = new int[256];
        for (int i = 0; i < probabilidad_ImgOriginal.length; i++) {
            probabilidad_ImgOriginal[i] = 0f;
            probabilidad_ImgEj1[i] = 0f;
            probabilidad_ImgPolicia[i] = 0f;
            exitos_ImgOriginal[i] = 0;
            exitos_ImgEj1[i] = 0;
            exitos_ImgPolicia[i] = 0;
        }
        int m = 0;

        Media media_ImgOriginal = new Media();
        Media media_ImgEj1 = new Media();
        Media media_ImgPolicia = new Media();

        Desvio_Estandar De_ImgOriginal = new Desvio_Estandar();
        Desvio_Estandar De_ImgEj1 = new Desvio_Estandar();
        Desvio_Estandar De_ImgPolicia = new Desvio_Estandar();

        for (int x = 0; x < Img_Original.getWidth(); x++) {
            for (int y = 0; y < Img_Original.getHeight(); y++) {
                int rgb_ImgOriginal = Img_Original.getRGB(x, y);
                int rgb_ImgEj1 = imagenEjercicio1.getRGB(x, y);
                int rgb_ImgPolicia = Img_Policia.getRGB(x, y);
                Color color = new Color(rgb_ImgOriginal, true);
                Color color1 = new Color(rgb_ImgEj1, true);
                Color color2 = new Color(rgb_ImgPolicia, true);
                rgb_ImgOriginal = color.getRed();
                rgb_ImgEj1 = color1.getRed();
                rgb_ImgPolicia = color2.getRed();

                exitos_ImgOriginal[rgb_ImgOriginal]++;
                exitos_ImgEj1[rgb_ImgEj1]++;
                exitos_ImgPolicia[rgb_ImgPolicia]++;
                m++;


                media_ImgOriginal.Calcular_Media(rgb_ImgOriginal);
                media_ImgEj1.Calcular_Media(rgb_ImgEj1);
                media_ImgPolicia.Calcular_Media(rgb_ImgPolicia);

                De_ImgOriginal.Calcular_Desvio_Estandar(rgb_ImgOriginal);
                De_ImgEj1.Calcular_Desvio_Estandar(rgb_ImgEj1);
                De_ImgPolicia.Calcular_Desvio_Estandar(rgb_ImgPolicia);

            }
        }

        for (int i = 0; i < probabilidad_ImgOriginal.length; i++) {
            probabilidad_ImgOriginal[i] = (float) exitos_ImgOriginal[i] / m;
            probabilidad_ImgEj1[i] = (float) exitos_ImgEj1[i] / m;
            probabilidad_ImgPolicia[i] = (float) exitos_ImgPolicia[i] / m;

        }

        distribucionImagenOriginal = probabilidad_ImgOriginal;
        distribucionImagenPolicia = probabilidad_ImgPolicia;
        distribucionImagenEj1 = probabilidad_ImgEj1;
        frecuenciasImagenOriginal = exitos_ImgOriginal;
        frecuenciasImagenPolicia = exitos_ImgPolicia;
        frecuenciasImagenEj1 = exitos_ImgEj1;


        String text_ImgOriginal = "Imagen Original - Media: " + media_ImgOriginal.get_Media() + "  Desvio Estandar: " + De_ImgOriginal.get_Desvio_Estandar();

        String text_ImgMasParecida ="Imagen mas parecida  - Media : " + media_ImgEj1.get_Media() + "  Desvio Estandar: " + De_ImgEj1.get_Desvio_Estandar();

        String text_ImgPolicia = "Imagen del Policia - Media: " + media_ImgPolicia.get_Media() + "  Desvio Estandar: " + De_ImgPolicia.get_Desvio_Estandar();


        Histograma hist_ImgOriginal = new Histograma(exitos_ImgOriginal, "Histograma de Imagen original");
        Histograma hist_ImgPolicia = new Histograma(exitos_ImgPolicia, "Histograma de Imagen del Policia");
        Histograma hist_ImgEj1 = new Histograma(exitos_ImgEj1, "Histograma Imagen mas parecida");
        hist_ImgOriginal.Ver_Histograma(text_ImgOriginal);
        hist_ImgPolicia.Ver_Histograma(text_ImgPolicia);
        hist_ImgEj1.Ver_Histograma(text_ImgMasParecida);




        try {
            File directorio = new File( System.getProperty("user.dir")+"/resultados/Ejercicio2/");
            if(!directorio.exists()) {
                directorio.mkdirs();
            }
            File outFile = new File(System.getProperty("user.dir") + "/resultados/Ejercicio2/" + "Desvios y Medias Ejercicio 2" + ".txt");
            if (outFile.exists()) {
                outFile.delete();
                outFile.createNewFile();
            }
            FileWriter writer = new FileWriter(outFile);
            writer.write(text_ImgOriginal + "\n");
            writer.write(text_ImgMasParecida + "\n");
            writer.write(text_ImgPolicia + "\n");
            writer.close();

        } catch (Exception e) {
        }

    }


    public void Compresor(float[] distribucionImg, int[] frecuenciasImg, BufferedImage Imagen, String nombreArchivo) {

        Helper helperCompresor = new Helper();
        Huffman Huff_Ej3 = new Huffman();
        int[] Simbolos = helperCompresor.arrayHelperPosicion(distribucionImg);
        float[] Probabilidad = helperCompresor.arrayHelperProbabilidad(distribucionImg);
        String[] Codigo_Huffman = Huff_Ej3.do_Huffman(Probabilidad);

        Vector<Byte> Mensaje_Comprimido = new Vector<>();
        int pos_buffer = 0;
        byte to_add = 0;
        for (int x = 0; x < Imagen.getWidth(); x++) {
            for (int y = 0; y < Imagen.getHeight(); y++) {
                int rgb = Imagen.getRGB(x, y);
                Color Color_Img = new Color(rgb, true);
                rgb = Color_Img.getRed();
                String buffer = Codigo_Huffman[helperCompresor.get_posicion_del_simbolo(Simbolos, rgb)];
                for (int i = 0; i < buffer.length(); i++) {
                    to_add = (byte) (to_add << 1);
                    pos_buffer++;
                    if (buffer.charAt(i) == '1')
                        to_add = (byte) (to_add | 1);

                    if (pos_buffer == 8) {
                        pos_buffer = 0;
                        Mensaje_Comprimido.add(to_add);
                        to_add = 0;
                    }
                }

            }
        }
        if (pos_buffer != 0) {
            Mensaje_Comprimido.add(to_add);
        }
        byte[] Mensaje_en_Bytes = new byte[Mensaje_Comprimido.size()];
        for (int i = 0; i < Mensaje_en_Bytes.length; i++)
            Mensaje_en_Bytes[i] = Mensaje_Comprimido.get(i);

        try {
            File directorio = new File( System.getProperty("user.dir")+"/resultados/Ejercicio3/");
            if(!directorio.exists()) {
                directorio.mkdirs();
            }
            File outFile = new File(System.getProperty("user.dir") + "/resultados/Ejercicio3/" + nombreArchivo + ".bin");
            if (outFile.exists()) {
                outFile.delete();
                outFile.createNewFile();
            }

            FileOutputStream out = new FileOutputStream(outFile);
            DataOutputStream writer = new DataOutputStream(out);

            Encabezado Encabezado_Img = new Encabezado();
            Encabezado_Img.setAlto(Imagen.getHeight());
            Encabezado_Img.setAncho(Imagen.getWidth());
            Encabezado_Img.setLongsimbolos(Simbolos.length);
            Encabezado_Img.setSimbolos(Simbolos);
            Encabezado_Img.setFrecuencia(helperCompresor.arrayHelperFrecuencia(frecuenciasImg));

            IndexColorModel Color_Model_Img = (IndexColorModel) Imagen.getColorModel();

            byte[] r = new byte[Color_Model_Img.getMapSize()];
            byte[] g = new byte[Color_Model_Img.getMapSize()];
            byte[] b = new byte[Color_Model_Img.getMapSize()];
            Color_Model_Img.getReds(r);
            Color_Model_Img.getGreens(g);
            Color_Model_Img.getBlues(b);

            Encabezado_Img.setPixels(Color_Model_Img.getPixelSize());
            Encabezado_Img.setSizemap(Color_Model_Img.getMapSize());
            Encabezado_Img.setR(r);
            Encabezado_Img.setG(g);
            Encabezado_Img.setB(b);


            ByteArrayOutputStream streamer = new ByteArrayOutputStream();
            ObjectOutputStream os = new ObjectOutputStream(streamer);
            os.writeObject(Encabezado_Img);
            os.close();
            byte[] Encabezado_en_Bytes = streamer.toByteArray();


            writer.writeInt(Encabezado_en_Bytes.length);
            writer.write(Encabezado_en_Bytes);
            writer.write(Mensaje_en_Bytes);
            writer.close();

            outFile.length();

        } catch (Exception e) {
        }

    }


    public void Descompresor(String nombreArchivo, String archivoComprimido) throws IOException {

        try {
            byte[] Mensaje_Decodificado = Files.readAllBytes(new File("resultados\\Ejercicio3\\" + archivoComprimido + ".bin").toPath());
            int Dim_Encabezado = ByteBuffer.wrap(Mensaje_Decodificado, 0, 4).getInt();
            byte[] Encabezado_Decodificado = new byte[Dim_Encabezado];
            for (int i = 0; i < Dim_Encabezado; i++) {
                Encabezado_Decodificado[i] = Mensaje_Decodificado[i + 4];
            }

            ByteArrayInputStream BufferBytes = new ByteArrayInputStream(Encabezado_Decodificado);
            ObjectInputStream InputStreamEncabezado = new ObjectInputStream(BufferBytes);
            Encabezado Encabezado_Img = (Encabezado) InputStreamEncabezado.readObject();
            InputStreamEncabezado.close();
            int[] Simbolos = new int[Encabezado_Img.getDimSimbolos()];
            for (int i = 0; i < Simbolos.length; i++) {
                Simbolos[i] = Encabezado_Img.getSimbolosInt(i);
            }

            float[] Probabilidades = new float[Encabezado_Img.getDimFrecuencia()];
            for (int i = 0; i < Probabilidades.length; i++) {
                Probabilidades[i] = (float) Encabezado_Img.getFrecuenciaInt(i) / (Encabezado_Img.getAlto() * Encabezado_Img.getAncho());
            }

            Huffman Huff_Decodificado = new Huffman();
            String[] Codigo_Huffman = Huff_Decodificado.do_Huffman(Probabilidades);

            Vector<Integer> Secuencia_Recuperada = new Vector<>();

            int bufferLength = 8;
            byte Mascara = (byte) (1 << bufferLength - 1);
            int bufferPos = 0;

            int i = Dim_Encabezado + 4;
            while (i < Mensaje_Decodificado.length) {
                byte buffer = Mensaje_Decodificado[i];
                while (bufferPos < bufferLength) {

                    if ((buffer & Mascara) == Mascara) {
                        int arbolder = Huff_Decodificado.mover_ArbolDerecha();
                        if (arbolder != -1) {
                            Secuencia_Recuperada.add(arbolder);
                        }

                    } else {
                        int arbolizq = Huff_Decodificado.mover_ArbolIzquierda();
                        if (arbolizq != -1) {
                            Secuencia_Recuperada.add(arbolizq);
                        }
                    }
                    buffer = (byte) (buffer << 1);
                    bufferPos++;

                }
                i++;
                bufferPos = 0;
            }

            Helper Decode_Helper = new Helper();

            int[] Simbolos_Decodificados = Decode_Helper.recuperar_simbolos_decodificados(Simbolos, Secuencia_Recuperada);


            IndexColorModel Icm_Imagen = new IndexColorModel(Encabezado_Img.getPixels(), Encabezado_Img.getSizemap(), Encabezado_Img.getR(), Encabezado_Img.getG(), Encabezado_Img.getB());

            BufferedImage Imagen_Decodificada = new BufferedImage(Encabezado_Img.getAncho(), Encabezado_Img.getAlto(), BufferedImage.TYPE_BYTE_BINARY, Icm_Imagen);
            int j = 0;
            for (int x = 0; x < Encabezado_Img.getAncho(); x++) {
                for (int y = 0; y < Encabezado_Img.getAlto(); y++) {
                    Color rgb = new Color(Simbolos_Decodificados[j], Simbolos_Decodificados[j], Simbolos_Decodificados[j]);
                    Imagen_Decodificada.setRGB(x, y, rgb.getRGB());
                    j++;
                }

            }


            try {
                File directorio = new File( System.getProperty("user.dir")+"/resultados/Ejercicio3/");
                if(!directorio.exists()) {
                    directorio.mkdirs();
                }
                File outFile = new File(System.getProperty("user.dir") + "/resultados/Ejercicio3/" + nombreArchivo + ".bmp");
                boolean dirCreated = outFile.mkdir();
                if (outFile.exists()) {
                    outFile.delete();
                    outFile.createNewFile();
                }
                ImageIO.write(Imagen_Decodificada, "BMP", outFile);


            } catch (Exception e) {

            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }


    public void CalcularMatrizTransicion(BufferedImage Img_Canal, String nombreArchivo) {

        Helper helper_Canales = new Helper();
        int[] Simbolos_ImgOriginal = helper_Canales.arrayHelperPosicion(distribucionImagenOriginal);
        int[][] mat_Transicion_Frecuencias = new int[distribucionImagenOriginal.length][Simbolos_ImgOriginal.length];

        for (int i = 0; i < mat_Transicion_Frecuencias.length; i++) {
            for (int j = 0; j < mat_Transicion_Frecuencias[0].length; j++) {
                mat_Transicion_Frecuencias[i][j] = 0;
            }
        }

        for (int x = 0; x < Img_Canal.getWidth(); x++) {
            for (int y = 0; y < Img_Canal.getHeight(); y++) {
                int rgb_Img_Canal = Img_Canal.getRGB(x, y);
                int rgb_Img_Original = Img_Original.getRGB(x, y);
                Color color_Canal = new Color(rgb_Img_Canal, true);
                Color color_Policia = new Color(rgb_Img_Original, true);
                rgb_Img_Canal = color_Canal.getRed();
                rgb_Img_Original = color_Policia.getRed();
                int rgb_posicion_Original = helper_Canales.get_posicion_del_simbolo(Simbolos_ImgOriginal, rgb_Img_Original);
                mat_Transicion_Frecuencias[rgb_Img_Canal][rgb_posicion_Original]++;
            }
        }


        int[][] mat_SinCeros = helper_Canales.matHelperFrecuencia(mat_Transicion_Frecuencias);
        int[] frecuencias_SinCeros = helper_Canales.arrayHelperFrecuencia(frecuenciasImagenOriginal);

        float[][] mat_Transicion = new float[mat_SinCeros.length][mat_SinCeros[0].length];

        for (int i = 0; i < mat_Transicion[0].length; i++) {
            for (int j = 0; j < mat_Transicion.length; j++) {
                mat_Transicion[j][i] = (float) mat_SinCeros[j][i] / frecuencias_SinCeros[i];
            }
        }

        float[] probabilidades_SinCeros = helper_Canales.arrayHelperProbabilidad(distribucionImagenOriginal);

        this.ruido_Ejercicio4 = this.CalcularRuido_Analitico(probabilidades_SinCeros,mat_Transicion);

        this.mat_Transicion_Ejercicio4 = mat_Transicion;

        String mat_Transicion_Retornada = "";

        for (int i = 0; i < mat_Transicion[0].length; i++) {
            for (int j = 0; j < mat_Transicion.length; j++) {
                mat_Transicion_Retornada += (String.format("%.3f", mat_Transicion[i][j]) + "  ");
            }
            mat_Transicion_Retornada += "\n";
        }


        try {
            File directorio = new File( System.getProperty("user.dir")+"/resultados/Ejercicio4/");
            if(!directorio.exists()) {
                directorio.mkdirs();
            }
            File outFile = new File(System.getProperty("user.dir") + "/resultados/Ejercicio4/" + nombreArchivo + ".txt");
            if (outFile.exists()) {
                outFile.delete();
                outFile.createNewFile();
            }
            FileOutputStream out = new FileOutputStream(outFile);
            DataOutputStream writer = new DataOutputStream(out);

            writer.writeBytes(mat_Transicion_Retornada);
            writer.close();

        } catch (Exception e) {

        }

    }


    public float CalcularRuido_Analitico(float[] probabilidades,float[][] mat_Transicion){

        float Entropia=0f;
        for (int i = 0; i <mat_Transicion[0].length ; i++) {
            float Entropia_Columna=0f;
            for (int j = 0; j < mat_Transicion.length; j++) {
                if(mat_Transicion[j][i] != 0)
                    Entropia_Columna -= mat_Transicion[j][i] * (float) (Math.log(mat_Transicion[j][i]) / Math.log(2));
            }
            Entropia += probabilidades[i] * Entropia_Columna;
        }
        return Entropia;
    }


    public int Simular_Entrada(float[] probabilidades) {

        float p = (float) Math.random();
        for (int i = 0; i < probabilidades.length; i++) {
            if (p < probabilidades[i]) {
                return i;
            }
        }
        return -1;
    }

    public int Simular_Salida(float[][] mat_Acumulada, int entrada) {

        float p = (float) Math.random();
        for (int i = 0; i < mat_Acumulada.length; i++) {
            if (p < mat_Acumulada[i][entrada])
                return i;
        }
        return -1;
    }

    public void CalcularRuido_Muestreo(float[][] mat_Transicion, String nombreArchivo,float ruido_Analitico, float Epsilon, int MIN_MUESTRAS) throws Exception {

        Helper helper_Ruido = new Helper();
        int Muestras = 0;
        float ruido_Act = 0;
        float ruido_Ant = -1;
        int[] Simbolos_Original = helper_Ruido.arrayHelperPosicion(distribucionImagenOriginal);
        float[] Distribucion_Original = helper_Ruido.arrayHelperProbabilidad(distribucionImagenOriginal);

        float[] probabilidades_Acumuladas = helper_Ruido.calcular_ProbabilidadesAcumuladas(Distribucion_Original);
        float[][] mat_Transicion_Acumulada_Canal = helper_Ruido.calcular_MatrizAcumulada(mat_Transicion);
        int entrada = 0;
        int salida = 0;

        int[] frecuencias_Muestreo = new int[probabilidades_Acumuladas.length];
        float[] probabilidades_Muestreo = new float[probabilidades_Acumuladas.length];
        for (int i = 0; i < frecuencias_Muestreo.length; i++) {
            frecuencias_Muestreo[i] = 0;
            probabilidades_Muestreo[i]=0;
        }
        int[][] mat_Transicion_Frecuencias_Muestreo = new int[mat_Transicion_Acumulada_Canal.length][mat_Transicion_Acumulada_Canal[0].length];

        float[][] mat_Transicion_Probabilidades_Muestreo = new float[mat_Transicion_Acumulada_Canal.length][mat_Transicion_Acumulada_Canal[0].length];

        for (int i = 0; i < mat_Transicion_Frecuencias_Muestreo.length ; i++) {
            for (int j = 0; j < mat_Transicion_Frecuencias_Muestreo[0].length; j++) {
                mat_Transicion_Probabilidades_Muestreo[i][j]=0f;
                mat_Transicion_Frecuencias_Muestreo[i][j]=0;
            }
        }
        Vector<Float> errores = new Vector<>();


        while (!this.Converge(ruido_Act, ruido_Ant, Epsilon) || Muestras < MIN_MUESTRAS) {
            entrada = Simular_Entrada(probabilidades_Acumuladas);
            salida = Simular_Salida(mat_Transicion_Acumulada_Canal, entrada);
            Muestras++;

            frecuencias_Muestreo[entrada]++;

            for (int i = 0; i < probabilidades_Muestreo.length; i++) {
                probabilidades_Muestreo[i] = (float) frecuencias_Muestreo[i]/Muestras;
            }

            mat_Transicion_Frecuencias_Muestreo[salida][entrada]++;

            for (int i = 0; i < mat_Transicion_Probabilidades_Muestreo.length; i++) {
                mat_Transicion_Probabilidades_Muestreo[i][entrada] = (float) mat_Transicion_Frecuencias_Muestreo[i][entrada]/frecuencias_Muestreo[entrada];
            }


            ruido_Ant = ruido_Act;
            ruido_Act =0;
            for (int i = 0; i < mat_Transicion_Probabilidades_Muestreo[0].length ; i++) {
                float entropia_Condicional = 0f;
                for (int j = 0; j <mat_Transicion_Probabilidades_Muestreo.length ; j++) {
                    if(mat_Transicion_Probabilidades_Muestreo[j][i] != 0)
                        entropia_Condicional -=  mat_Transicion_Probabilidades_Muestreo[j][i] * (float) (Math.log(mat_Transicion_Probabilidades_Muestreo[j][i])/Math.log(2));
                }

                ruido_Act += probabilidades_Muestreo[i] * entropia_Condicional;
            }
            errores.add(Math.abs(ruido_Act));

        }


        Histograma hist_Ruido = new Histograma(nombreArchivo);
        hist_Ruido.Ver_GraficoError(errores);

        try {
            File directorio = new File( System.getProperty("user.dir")+"/resultados/Ejercicio4/");
            if(!directorio.exists()) {
                directorio.mkdirs();
            }
            File outFile = new File(System.getProperty("user.dir") + "/resultados/Ejercicio4/" + nombreArchivo + ".txt");
            if (outFile.exists()) {
                outFile.delete();
                outFile.createNewFile();
            }

            FileWriter writer = new FileWriter(outFile);

            writer.write("Ruido del canal calculado analiticamente: " + ruido_Analitico +"\n");
            writer.write("Ruido del canal calculado por muestreo: " + ruido_Act +"\n");
            writer.write("Epsilon utilizado: " + Epsilon +"\n");
            writer.write("Muestras necesarias para convergencia: " + Muestras +"\n");
            writer.write("Error del Ruido: " + (ruido_Analitico -ruido_Act) +"\n");

            writer.close();


        } catch (Exception e) {
        }

    }

    private boolean Converge(float a, float b, float Epsilon) {
        return (Math.abs(a - b) < Epsilon);
    }


}






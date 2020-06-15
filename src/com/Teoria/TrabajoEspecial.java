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
import java.nio.file.NoSuchFileException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Vector;


public class TrabajoEspecial {
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

    public TrabajoEspecial() {
        //CARGAR IMAGEN
        try {
            this.Img_Original = ImageIO.read(new File("img\\Will(Original).bmp"));
            this.Img_1 = ImageIO.read(new File("img\\Will_1.bmp"));
            this.Img_2 = ImageIO.read(new File("img\\Will_2.bmp"));
            this.Img_3 = ImageIO.read(new File("img\\Will_3.bmp"));
            this.Img_4 = ImageIO.read(new File("img\\Will_4.bmp"));
            this.Img_5 = ImageIO.read(new File("img\\Will_5.bmp"));
            this.Img_Policia = ImageIO.read(new File("img\\Will_ej2.bmp"));
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

        //LEER IMAGEN
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

                //LO QUE SIGUE ES EL CALCULO DEL INCISO 1
                //ACA CALCULAMOS DESVIO ORIGINAL
                De_ImgOriginal.Calcular_Desvio_Estandar(rgb_ImgOriginal);

                // ACA CALCULAMOS EL DESVIO DE LA IMAGEN i
                De_Img1.Calcular_Desvio_Estandar(rgb_Img1);
                De_Img2.Calcular_Desvio_Estandar(rgb_Img2);
                De_Img3.Calcular_Desvio_Estandar(rgb_Img3);
                De_Img4.Calcular_Desvio_Estandar(rgb_Img4);
                De_Img5.Calcular_Desvio_Estandar(rgb_Img5);


                // COVARIANZA ACUMULADA
                ImgOrig_Cov_Img1.Calcular_Covarianza(rgb_ImgOriginal, rgb_Img1);
                ImgOrig_Cov_Img2.Calcular_Covarianza(rgb_ImgOriginal, rgb_Img2);
                ImgOrig_Cov_Img3.Calcular_Covarianza(rgb_ImgOriginal, rgb_Img3);
                ImgOrig_Cov_Img4.Calcular_Covarianza(rgb_ImgOriginal, rgb_Img4);
                ImgOrig_Cov_Img5.Calcular_Covarianza(rgb_ImgOriginal, rgb_Img5);
            }

        }
        // r = CovAB / (desvio(A)*desvio(B))


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
            File outFile = new File(System.getProperty("user.dir") + "/resultados/" + "Factores de correlacion Ejercicio 1" + ".txt");
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
        // Distribucion Histograma

        for (int i = 0; i < probabilidad_ImgOriginal.length; i++) {
            probabilidad_ImgOriginal[i] = (float) exitos_ImgOriginal[i] / m;
            probabilidad_ImgEj1[i] = (float) exitos_ImgEj1[i] / m;
            probabilidad_ImgPolicia[i] = (float) exitos_ImgPolicia[i] / m;

        }

        //distribuciones y frecuencias de las imagenes/////////////////////////////////////
        distribucionImagenOriginal = probabilidad_ImgOriginal;
        distribucionImagenPolicia = probabilidad_ImgPolicia;
        distribucionImagenEj1 = probabilidad_ImgEj1;
        frecuenciasImagenOriginal = exitos_ImgOriginal;
        frecuenciasImagenPolicia = exitos_ImgPolicia;
        frecuenciasImagenEj1 = exitos_ImgEj1;

        //////////////////////////////
        Histograma hist_ImgOriginal = new Histograma(exitos_ImgOriginal, "Histograma de Imagen original");
        Histograma hist_ImgPolicia = new Histograma(exitos_ImgPolicia, "Histograma de Imagen del Policia");
        Histograma hist_ImgEj1 = new Histograma(exitos_ImgEj1, "Histograma Imagen mas parecida");
        hist_ImgOriginal.Ver_Histograma();
        hist_ImgPolicia.Ver_Histograma();
        hist_ImgEj1.Ver_Histograma();


        try {
            File outFile = new File(System.getProperty("user.dir") + "/resultados/" + "Desvios y Medias Ejercicio 2" + ".txt");
            if (outFile.exists()) {
                outFile.delete();
                outFile.createNewFile();
            }
            FileWriter writer = new FileWriter(outFile);
            writer.write("Imagen Original - Media: " + media_ImgOriginal.get_Media() + "  Desvio Estandar: " + De_ImgOriginal.get_Desvio_Estandar() + "\n");
            writer.write("Imagen mas parecida  - Media : " + media_ImgEj1.get_Media() + "  Desvio Estandar: " + De_ImgEj1.get_Desvio_Estandar() + "\n");
            writer.write("Imagen del Policia - Media: " + media_ImgPolicia.get_Media() + "  Desvio Estandar: " + De_ImgPolicia.get_Desvio_Estandar() + "\n");
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
            File outFile = new File(System.getProperty("user.dir") + "/resultados/" + nombreArchivo + ".bin");
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


            //crea streamer para object to byte[]
            ByteArrayOutputStream streamer = new ByteArrayOutputStream();
            ObjectOutputStream os = new ObjectOutputStream(streamer);
            os.writeObject(Encabezado_Img);
            os.close();
            byte[] Encabezado_en_Bytes = streamer.toByteArray();


            writer.writeInt(Encabezado_en_Bytes.length);
            writer.write(Encabezado_en_Bytes);//escribe encabezado
            writer.write(Mensaje_en_Bytes);
            writer.close();

        } catch (Exception e) {
        }

    }


    public void Descompresor(String nombreArchivo, String archivoComprimido) throws IOException {

        try {
            byte[] Mensaje_Decodificado = Files.readAllBytes(new File("resultados\\" + archivoComprimido + ".bin").toPath());
            int Dim_Encabezado = ByteBuffer.wrap(Mensaje_Decodificado, 0, 4).getInt();
            byte[] Encabezado_Decodificado = new byte[Dim_Encabezado];
            for (int i = 0; i < Dim_Encabezado; i++) {
                Encabezado_Decodificado[i] = Mensaje_Decodificado[i + 4];
            }

            ByteArrayInputStream BufferBytes = new ByteArrayInputStream(Encabezado_Decodificado); // bytes es el byte[]
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
            byte Mascara = (byte) (1 << bufferLength - 1); // Mascara: 10000000
            int bufferPos = 0;

            int i = Dim_Encabezado + 4;
            while (i < Mensaje_Decodificado.length) {
                byte buffer = Mensaje_Decodificado[i];
                while (bufferPos < bufferLength) {

                    if ((buffer & Mascara) == Mascara) {  // 10000000 /si es 1
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
                File outFile = new File(System.getProperty("user.dir") + "/resultados/" + nombreArchivo + ".bmp");
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
}

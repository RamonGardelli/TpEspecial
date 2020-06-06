package com.Teoria;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App {
    private JPanel panel1;
    private JLabel textup;
    private JButton factorDeAutocorrelacionButton;
    private JButton distribucionMediaYDesvioButton;
    private JButton button3;
    private JButton button4;
    private JButton comprimirButton;
    private JButton descomprimirButton;
    private JLabel textend;

    public App() {
        TrabajoEspecial tp = new TrabajoEspecial();
        factorDeAutocorrelacionButton.addActionListener(new ActionListener() {
            @Override

            public void actionPerformed(ActionEvent e) {
                tp.Ejercicio1();

            }
        });
        distribucionMediaYDesvioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    //tp.Ejercicio2();
                }
                catch(Exception error){
                    JOptionPane.showMessageDialog(null,"Debe ejecutar el factor de correlacion primero, asi decidir que imagen es mas parecida");
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

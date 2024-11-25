package com.mycompany.p1integrador;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class P2integrador {

    public static void main(String[] args) {
       JFrame frame = new JFrame("Calculadora Binaria");
        frame.setSize(400, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JLabel label1 = new JLabel("Introduce el primer número binario:");
        label1.setBounds(50, 20, 300, 30);
        JTextField campo1 = new JTextField();
        campo1.setBounds(50, 50, 300, 30);

        JLabel label2 = new JLabel("Introduce el segundo número binario:");
        label2.setBounds(50, 90, 300, 30);
        JTextField campo2 = new JTextField();
        campo2.setBounds(50, 120, 300, 30);

        JButton botonSumar = new JButton("Sumar");
        botonSumar.setBounds(80, 160, 100, 30);
        JButton botonRestar = new JButton("Restar");
        botonRestar.setBounds(210, 160, 100, 30);
        JButton botonLimpiar = new JButton("Limpiar");
        botonLimpiar.setBounds(80, 200, 100, 30);
        JButton botonSalir = new JButton("Salir");
        botonSalir.setBounds(210, 200, 100, 30);

        JTextArea resultado = new JTextArea();
        resultado.setBounds(50, 250, 300, 50);
        resultado.setEditable(false);

        frame.add(label1);
        frame.add(campo1);
        frame.add(label2);
        frame.add(campo2);
        frame.add(botonSumar);
        frame.add(botonRestar);
        frame.add(botonLimpiar);
        frame.add(botonSalir);
        frame.add(resultado);

        botonSumar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String binario1 = campo1.getText();
                String binario2 = campo2.getText();
                String suma = sumaBinaria(binario1, binario2);
                resultado.setText("Resultado de la suma: " + suma);
            }
        });

        botonRestar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String binario1 = campo1.getText();
                String binario2 = campo2.getText();
                if (esMayorOIgual(binario1, binario2)) {
                    String resta = restaBinaria(binario1, binario2);
                    resultado.setText("Resultado de la resta: " + resta);
                } else {
                    resultado.setText("No se puede realizar la resta: el primer número debe ser mayor o igual que el segundo.");
                }
            }
        });

        // Acción para el botón de limpiar
        botonLimpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                campo1.setText("");
                campo2.setText("");
                resultado.setText("");
            }
        });

        botonSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        frame.setVisible(true);
    }

    public static String sumaBinaria(String bin1, String bin2) {
        int maxLen = Math.max(bin1.length(), bin2.length());
        bin1 = agregarCeros(bin1, maxLen);
        bin2 = agregarCeros(bin2, maxLen);

        StringBuilder resultado = new StringBuilder();
        int acarreo = 0;

        for (int i = maxLen - 1; i >= 0; i--) {
            int bit1 = bin1.charAt(i) - '0';
            int bit2 = bin2.charAt(i) - '0';

            int suma = bit1 + bit2 + acarreo;
            if (suma == 0) {
                resultado.insert(0, '0');
                acarreo = 0;
            } else if (suma == 1) {
                resultado.insert(0, '1');
                acarreo = 0;
            } else if (suma == 2) {
                resultado.insert(0, '0');
                acarreo = 1;
            } else {
                resultado.insert(0, '1');
                acarreo = 1;
            }
        }

        if (acarreo != 0) {
            resultado.insert(0, '1');
        }

        return resultado.toString();
    }

    public static String restaBinaria(String bin1, String bin2) {
        int maxLen = Math.max(bin1.length(), bin2.length());
        bin1 = agregarCeros(bin1, maxLen);
        bin2 = agregarCeros(bin2, maxLen);

        StringBuilder resultado = new StringBuilder();
        int prestado = 0;

        for (int i = maxLen - 1; i >= 0; i--) {
            int bit1 = bin1.charAt(i) - '0';
            int bit2 = bin2.charAt(i) - '0';

            int resta = bit1 - bit2 - prestado;
            if (resta == 1) {
                resultado.insert(0, '1');
                prestado = 0;
            } else if (resta == 0) {
                resultado.insert(0, '0');
                prestado = 0;
            } else {
                resultado.insert(0, '1');
                prestado = 1;
            }
        }

        while (resultado.length() > 1 && resultado.charAt(0) == '0') {
            resultado.deleteCharAt(0);
        }

        return resultado.toString();
    }

    public static String agregarCeros(String bin, int longitud) {
        StringBuilder sb = new StringBuilder(bin);
        while (sb.length() < longitud) {
            sb.insert(0, '0');
        }
        return sb.toString();
    }

    public static boolean esMayorOIgual(String bin1, String bin2) {
        int maxLen = Math.max(bin1.length(), bin2.length());
        bin1 = agregarCeros(bin1, maxLen);
        bin2 = agregarCeros(bin2, maxLen);

        return bin1.compareTo(bin2) >= 0;
    }
}

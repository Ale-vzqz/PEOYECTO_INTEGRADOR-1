package com.mycompany.p1integrador; // Paquete de la aplicación

import javax.swing.*; // Importar componentes Swing
import javax.swing.event.DocumentEvent; // Para manejar eventos de documentos
import javax.swing.event.DocumentListener; // Interfaz para escuchar cambios en el documento
import java.awt.*; // Para trabajar con la interfaz gráfica
import java.awt.event.MouseAdapter; // Para manejar eventos de mouse
import java.awt.event.MouseEvent; // Para manejar eventos de mouse
import javax.swing.border.LineBorder; // Para crear bordes en componentes

// Clase principal de la aplicación
public class P1integrador {

    // Método principal
    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculadora Binaria"); // Crear ventana
        frame.setSize(550, 600); // Establecer tamaño de la ventana
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Cerrar aplicación al cerrar ventana
        frame.setLayout(null); // No usar layout manager
        
        // Establecer el color de fondo gris
        frame.getContentPane().setBackground(Color.darkGray);

        // Crear un panel para el encabezado
        JPanel encabezado = new JPanel();
        encabezado.setLayout(new FlowLayout()); // Usar FlowLayout para el encabezado
        encabezado.setBounds(0, 0, 500, 80); // Establecer posición y tamaño del encabezado
        encabezado.setBackground(Color.darkGray); // Fondo del encabezado

        // Cargar los logos
        JLabel logo1 = crearLogo("src/imgs/li1.png"); // Cargar primer logo
        JLabel logo2 = crearLogo("src/imgs/logo1.png"); // Cargar segundo logo
        encabezado.add(logo1); // Agregar primer logo al encabezado
        encabezado.add(logo2); // Agregar segundo logo al encabezado

        frame.add(encabezado); // Agregar encabezado a la ventana

        // Crear y configurar etiquetas (labels)
        JLabel label1 = new JLabel("Introduce el primer número binario:"); // Etiqueta para primer número
        label1.setBounds(150, 100, 300, 30); // Establecer posición y tamaño
        label1.setForeground(Color.WHITE); // Color de texto blanco

        JTextField campo1 = new JTextField(); // Campo de texto para primer número
        campo1.setBounds(150, 130, 150, 30); // Establecer posición y tamaño
        campo1.setBorder(new LineBorder(Color.BLACK, 2)); // Borde del campo

        JLabel resultadoDecimal1 = new JLabel("Decimal: 0"); // Etiqueta para resultado decimal
        resultadoDecimal1.setBounds(350, 130, 200, 30); // Establecer posición y tamaño
        resultadoDecimal1.setForeground(Color.WHITE); // Color de texto blanco

        JLabel label2 = new JLabel("Introduce el segundo número binario:"); // Etiqueta para segundo número
        label2.setBounds(150, 170, 300, 30); // Establecer posición y tamaño
        label2.setForeground(Color.WHITE); // Color de texto blanco

        JTextField campo2 = new JTextField(); // Campo de texto para segundo número
        campo2.setBounds(150, 200, 150, 30); // Establecer posición y tamaño
        campo2.setBorder(new LineBorder(Color.BLACK, 2)); // Borde del campo

        JLabel resultadoDecimal2 = new JLabel("Decimal: 0"); // Etiqueta para resultado decimal
        resultadoDecimal2.setBounds(350, 200, 200, 30); // Establecer posición y tamaño
        resultadoDecimal2.setForeground(Color.WHITE); // Color de texto blanco

        // Área para mostrar el resultado
        JTextArea resultado = new JTextArea(); // Crear área de texto para mostrar resultados
        resultado.setBounds(150, 330, 300, 50); // Establecer posición y tamaño
        resultado.setEditable(false); // Hacer área no editable
        resultado.setBorder(new LineBorder(Color.BLACK, 2)); // Borde del área
        resultado.setBackground(Color.WHITE); // Fondo blanco para el área de texto

        // JLabel para mostrar el resultado decimal
        JLabel resultadoDecimal = new JLabel("Resultado Decimal: 0"); // Etiqueta para resultado decimal
        resultadoDecimal.setBounds(150, 390, 300, 30); // Establecer posición y tamaño
        resultadoDecimal.setForeground(Color.WHITE); // Color de texto blanco

        // Crear botones (sumar, restar, limpiar, salir)
        JButton botonSumar = crearBoton("Sumar", Color.GREEN); // Botón para sumar
        JButton botonRestar = crearBoton("Restar", Color.GREEN); // Botón para restar
        JButton botonLimpiar = crearBoton("Limpiar", Color.CYAN); // Botón para limpiar
        JButton botonSalir = crearBoton("Salir", Color.RED); // Botón para salir

        // Establecer posición y tamaño de los botones
        botonSumar.setBounds(150, 240, 100, 30);
        botonRestar.setBounds(280, 240, 100, 30);
        botonLimpiar.setBounds(150, 280, 100, 30);
        botonSalir.setBounds(280, 280, 100, 30);

        // Agregar componentes al marco
        frame.add(label1);
        frame.add(campo1);
        frame.add(resultadoDecimal1);
        frame.add(label2);
        frame.add(campo2);
        frame.add(resultadoDecimal2);
        frame.add(resultado);
        frame.add(resultadoDecimal);
        frame.add(botonSumar);
        frame.add(botonRestar);
        frame.add(botonLimpiar);
        frame.add(botonSalir);
        frame.add(encabezado); // Agregar el encabezado al marco

        // DocumentListener para actualizar el valor decimal al escribir
        campo1.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                actualizarDecimal(campo1.getText(), resultadoDecimal1); // Actualizar decimal al insertar
                actualizarResultado(resultado, resultadoDecimal, campo1.getText(), campo2.getText(), "sumar"); // Actualizar resultado
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                actualizarDecimal(campo1.getText(), resultadoDecimal1); // Actualizar decimal al eliminar
                actualizarResultado(resultado, resultadoDecimal, campo1.getText(), campo2.getText(), "sumar"); // Actualizar resultado
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                actualizarDecimal(campo1.getText(), resultadoDecimal1); // Actualizar decimal si cambia
                actualizarResultado(resultado, resultadoDecimal, campo1.getText(), campo2.getText(), "sumar"); // Actualizar resultado
            }
        });

        // Similar DocumentListener para el segundo campo
        campo2.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                actualizarDecimal(campo2.getText(), resultadoDecimal2);
                actualizarResultado(resultado, resultadoDecimal, campo1.getText(), campo2.getText(), "sumar");
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                actualizarDecimal(campo2.getText(), resultadoDecimal2);
                actualizarResultado(resultado, resultadoDecimal, campo1.getText(), campo2.getText(), "sumar");
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                actualizarDecimal(campo2.getText(), resultadoDecimal2);
                actualizarResultado(resultado, resultadoDecimal, campo1.getText(), campo2.getText(), "sumar");
            }
        });

        // Acciones de los botones
        botonSumar.addActionListener(e -> {
            // Verificar si ambos campos tienen datos
            if (camposObligatorios(campo1, campo2)) {
                // Validar que solo contenga números binarios
                if (validarEntrada(campo1.getText()) && validarEntrada(campo2.getText())) {
                    String binario1 = campo1.getText(); // Obtener primer número
                    String binario2 = campo2.getText(); // Obtener segundo número
                    String suma = sumaBinaria(binario1, binario2); // Calcular suma
                    resultado.setText("Resultado de la suma: " + suma); // Mostrar resultado
                    resultadoDecimal.setText("Resultado Decimal: " + Integer.parseInt(suma, 2)); // Mostrar decimal
                } else {
                    // Mostrar mensaje de error si la entrada es inválida
                    JOptionPane.showMessageDialog(frame, "Por favor, ingresa solo números binarios (0s y 1s).", "Entrada inválida", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        botonRestar.addActionListener(e -> {
            // Verificar si ambos campos tienen datos
            if (camposObligatorios(campo1, campo2)) {
                // Validar que solo contenga números binarios
                if (validarEntrada(campo1.getText()) && validarEntrada(campo2.getText())) {
                    String binario1 = campo1.getText(); // Obtener primer número
                    String binario2 = campo2.getText(); // Obtener segundo número
                    // Verificar que el primer número sea mayor o igual que el segundo
                    if (esMayorOIgual(binario1, binario2)) {
                        String resta = restaBinaria(binario1, binario2); // Calcular resta
                        resultado.setText("Resultado de la resta: " + resta); // Mostrar resultado
                        resultadoDecimal.setText("Resultado Decimal: " + Integer.parseInt(resta, 2)); // Mostrar decimal
                    } else {
                        // Mostrar mensaje de error si la resta no es válida
                        resultado.setText("No se puede realizar la resta: el primer número debe ser mayor o igual que el segundo.");
                        resultadoDecimal.setText("Resultado Decimal: Error");
                    }
                } else {
                    // Mostrar mensaje de error si la entrada es inválida
                    JOptionPane.showMessageDialog(frame, "Por favor, ingresa solo números binarios (0s y 1s).", "Entrada inválida", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Limpiar campos y resultados
        botonLimpiar.addActionListener(e -> {
            campo1.setText(""); // Limpiar primer campo
            campo2.setText(""); // Limpiar segundo campo
            resultado.setText(""); // Limpiar área de resultados
            resultadoDecimal.setText("Resultado Decimal: 0"); // Reiniciar resultado decimal
            resultadoDecimal1.setText("Decimal: 0"); // Reiniciar primer decimal
            resultadoDecimal2.setText("Decimal: 0"); // Reiniciar segundo decimal
        });

        // Salir de la aplicación
        botonSalir.addActionListener(e -> System.exit(0));

        // Crear un JLabel para la imagen en la parte inferior
        JLabel imagenInferior = crearLogo("src/imgs/sisbin1.png"); // Cargar imagen
        imagenInferior.setBounds(10, 450, 500, 100); // Ajustar posición y tamaño
        frame.add(imagenInferior); // Agregar la imagen al marco

        frame.setVisible(true); // Hacer visible la ventana
    }

    // Método para crear un JLabel con una imagen
    private static JLabel crearLogo(String path) {
        ImageIcon icon = new ImageIcon(path); // Cargar la imagen
        JLabel logo = new JLabel(icon); // Crear JLabel con la imagen
        logo.setPreferredSize(new Dimension(100, 60)); // Ajustar tamaño según sea necesario
        return logo; // Retornar el JLabel
    }

    // Método para crear un botón con texto y color
    private static JButton crearBoton(String texto, Color color) {
        JButton boton = new JButton(texto); // Crear botón
        boton.setBackground(color); // Establecer color de fondo
        boton.setForeground(Color.BLACK); // Texto negro por defecto
        boton.setBorder(new LineBorder(Color.GRAY, 2)); // Borde gris
        boton.setFocusPainted(false); // Desactivar el foco pintado
        agregarMouseHoverEffect(boton); // Agregar efecto de hover
        return boton; // Retornar el botón
    }

    // Método para agregar efecto al pasar el mouse sobre el botón
    private static void agregarMouseHoverEffect(JButton boton) {
        boton.addMouseListener(new MouseAdapter() { // Escuchar eventos del mouse
            @Override
            public void mouseEntered(MouseEvent e) {
                boton.setBorder(new LineBorder(Color.YELLOW, 2)); // Borde amarillo al pasar el mouse
                boton.setForeground(Color.WHITE); // Cambiar texto a blanco al pasar el mouse
            }

            @Override
            public void mouseExited(MouseEvent e) {
                boton.setBorder(new LineBorder(Color.GRAY, 2)); // Borde gris al salir el mouse
                boton.setForeground(Color.BLACK); // Volver texto a negro al salir el mouse
            }
        });
    }

    // Método para actualizar el resultado decimal basado en la entrada binaria
    private static void actualizarDecimal(String binario, JLabel resultadoDecimal) {
        if (validarEntrada(binario)) { // Validar entrada
            int decimal = Integer.parseInt(binario, 2); // Convertir a decimal
            resultadoDecimal.setText("Decimal: " + decimal); // Mostrar resultado decimal
        } else {
            resultadoDecimal.setText("Decimal: Error"); // Mostrar error si la entrada es inválida
        }
    }

    // Método para actualizar el resultado basado en la operación seleccionada
    private static void actualizarResultado(JTextArea resultado, JLabel resultadoDecimal, String binario1, String binario2, String operacion) {
        if (validarEntrada(binario1) && validarEntrada(binario2)) { // Validar entradas
            if (operacion.equals("sumar")) { // Si la operación es suma
                String suma = sumaBinaria(binario1, binario2); // Calcular suma
                resultado.setText("Resultado de la suma: " + suma); // Mostrar resultado
                resultadoDecimal.setText("Resultado Decimal: " + Integer.parseInt(suma, 2)); // Mostrar decimal
            }
        } else {
            resultado.setText("Entrada inválida para operación."); // Mensaje de error
            resultadoDecimal.setText("Resultado Decimal: Error"); // Mensaje de error
        }
    }

    // Método para sumar dos números binarios
    public static String sumaBinaria(String bin1, String bin2) {
        int maxLen = Math.max(bin1.length(), bin2.length()); // Obtener la longitud máxima
        bin1 = agregarCeros(bin1, maxLen); // Agregar ceros a la izquierda si es necesario
        bin2 = agregarCeros(bin2, maxLen); // Agregar ceros a la izquierda si es necesario

        StringBuilder resultado = new StringBuilder(); // Crear un StringBuilder para el resultado
        int acarreo = 0; // Inicializar acarreo

        // Sumar bit a bit desde el final
        for (int i = maxLen - 1; i >= 0; i--) {
            int bit1 = bin1.charAt(i) - '0'; // Obtener bit del primer número
            int bit2 = bin2.charAt(i) - '0'; // Obtener bit del segundo número

            int suma = bit1 + bit2 + acarreo; // Sumar bits y acarreo
            if (suma == 0) {
                resultado.insert(0, '0'); // No hay acarreo
                acarreo = 0; // Reiniciar acarreo
            } else if (suma == 1) {
                resultado.insert(0, '1'); // Resultado es 1
                acarreo = 0; // Reiniciar acarreo
            } else if (suma == 2) {
                resultado.insert(0, '0'); // Resultado es 0, hay acarreo
                acarreo = 1; // Establecer acarreo
            } else {
                resultado.insert(0, '1'); // Resultado es 1, hay acarreo
                acarreo = 1; // Establecer acarreo
            }
        }

        // Si hay acarreo al final, agregarlo
        if (acarreo != 0) {
            resultado.insert(0, '1');
        }

        return resultado.toString(); // Retornar resultado
    }

    // Método para restar dos números binarios
    public static String restaBinaria(String bin1, String bin2) {
        int maxLen = Math.max(bin1.length(), bin2.length()); // Obtener longitud máxima
        bin1 = agregarCeros(bin1, maxLen); // Agregar ceros a la izquierda si es necesario
        bin2 = agregarCeros(bin2, maxLen); // Agregar ceros a la izquierda si es necesario

        StringBuilder resultado = new StringBuilder(); // Crear un StringBuilder para el resultado
        int prestado = 0; // Inicializar prestado

        // Restar bit a bit desde el final
        for (int i = maxLen - 1; i >= 0; i--) {
            int bit1 = bin1.charAt(i) - '0'; // Obtener bit del primer número
            int bit2 = bin2.charAt(i) - '0'; // Obtener bit del segundo número

            int resta = bit1 - bit2 - prestado; // Restar bit2 y el prestado
            if (resta == 1) {
                resultado.insert(0, '1'); // Resultado es 1
                prestado = 0; // Reiniciar prestado
            } else if (resta == 0) {
                resultado.insert(0, '0'); // Resultado es 0
                prestado = 0; // Reiniciar prestado
            } else {
                resultado.insert(0, '1'); // Resultado es 1, se necesita un prestado
                prestado = 1; // Establecer prestado
            }
        }

        // Eliminar ceros a la izquierda
        while (resultado.length() > 1 && resultado.charAt(0) == '0') {
            resultado.deleteCharAt(0);
        }

        return resultado.toString(); // Retornar resultado
    }

    // Método para agregar ceros a la izquierda hasta alcanzar la longitud deseada
    public static String agregarCeros(String bin, int longitud) {
        StringBuilder sb = new StringBuilder(bin); // Crear un StringBuilder con el número binario
        while (sb.length() < longitud) {
            sb.insert(0, '0'); // Agregar ceros a la izquierda
        }
        return sb.toString(); // Retornar resultado
    }

    // Método para verificar si un número binario es mayor o igual a otro
    public static boolean esMayorOIgual(String bin1, String bin2) {
        int maxLen = Math.max(bin1.length(), bin2.length()); // Obtener longitud máxima
        bin1 = agregarCeros(bin1, maxLen); // Agregar ceros a la izquierda si es necesario
        bin2 = agregarCeros(bin2, maxLen); // Agregar ceros a la izquierda si es necesario

        return bin1.compareTo(bin2) >= 0; // Comparar los dos números binarios
    }

    // Método para validar que la entrada solo contenga 0s y 1s
    public static boolean validarEntrada(String entrada) {
        return entrada.matches("[01]*"); // Solo permite 0s y 1s
    }

    // Método para verificar si ambos campos son obligatorios
    public static boolean camposObligatorios(JTextField campo1, JTextField campo2) {
        if (campo1.getText().isEmpty() || campo2.getText().isEmpty()) { // Comprobar si alguno está vacío
            JOptionPane.showMessageDialog(null, "Ambos campos son obligatorios.", "Campo vacío", JOptionPane.WARNING_MESSAGE);
            return false; // Retornar falso si hay campos vacíos
        }
        return true; // Retornar verdadero si ambos campos están llenos
    }
}
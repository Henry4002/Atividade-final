package display;

import javax.swing.*;
import java.awt.*;

public class Estilo {

    public static void configurarJanela(JFrame janela, String titulo, int largura, int altura){

        janela.setTitle(titulo);
        janela.setSize(largura, altura);
        janela.setLocationRelativeTo(null);
        janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }


    public static void configurarPainel(JPanel painel){

        painel.setBorder(
                BorderFactory.createEmptyBorder(20,20,20,20)
        );

    }


    public static void configurarCampo(JTextField campo){

        campo.setFont(new Font("Arial", Font.PLAIN, 14));
        campo.setPreferredSize(new Dimension(200,30));

    }


    public static JLabel criarLabel(String texto){

        JLabel label = new JLabel(texto);

        label.setFont(
                new Font("Arial", Font.BOLD,14)
        );

        return label;
    }


    public static JTextArea criarArea(){

        JTextArea area = new JTextArea();

        area.setFont(
                new Font("Arial", Font.PLAIN,14)
        );

        area.setEditable(false);

        area.setLineWrap(true);

        area.setWrapStyleWord(true);

        return area;
    }

}
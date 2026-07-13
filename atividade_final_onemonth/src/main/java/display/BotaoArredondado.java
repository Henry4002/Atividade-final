package display;

import javax.swing.*;
import java.awt.*;

public class BotaoArredondado extends JButton {

    public BotaoArredondado(String texto) {
        super(texto);

        setFocusPainted(false);
        setContentAreaFilled(false);
        setBorderPainted(false);
        setOpaque(false);

        setFont(new Font("Arial", Font.BOLD, 14));
        setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    @Override
    protected void paintComponent(Graphics g) {

        Graphics2D g2 = (Graphics2D) g.create();

        g2.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON
        );

        g2.setColor(new Color(0, 123, 255));
        g2.fillRoundRect(
                0,
                0,
                getWidth(),
                getHeight(),
                30,
                30
        );

        g2.dispose();

        super.paintComponent(g);
    }

    @Override
    public void paintBorder(Graphics g) {
        // Remove a borda padrão
    }
}
package test.window;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Window extends JPanel {
    private JFrame frame;
    private boolean clear;
    private List<Double> data;

    public static Window create() {
        Window w = new Window();
        w.setVisible(true);
        return w;
    }

    public Window() {
        clear = false;
        frame = new JFrame("Fenin lab1");
        frame.setMinimumSize(new Dimension(1280, 720));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().add(this);
        frame.pack();
        frame.setVisible(true);
    }

    public void paintWithClear() {
    }

    public void paint(List<Double> a, double mo, double disp) {
        data = new ArrayList<>();
        for (Double c : a) {
            data.add(c * 100);
        }
        frame.repaint();
        JLabel label = new JLabel("Мат.Ожидание:" + mo + " Дисперсия:" + disp);
        label.setBounds(800, 100, frame.getWidth(), 1100);
        this.add(label);
    }

    @Override
    protected void paintComponent(Graphics g) {
        if (clear) {
            super.paintComponent(g);
        }
        drawXY(g);
        g.setColor(Color.RED);
        for (int i = 1; i < data.size(); i++) {
            int j = i + 1;
            g.drawLine(j * 15, y(data.get(i - 1)), (j + 1) * 15,
                    y(data.get(i)));
        }
    }

    private int y(double a) {
        double yhalf = frame.getBounds().height / 2;
        return (int) Math.round(yhalf - a);
    }

    private void drawXY(Graphics g) {
        int xmax = frame.getWidth();
        int ymax = frame.getHeight();
        g.drawLine(0, ymax / 2, xmax, ymax / 2);
        g.drawLine(30, 0, 30, ymax);
        for (int i = 0; i < ymax; i += 100) {
            g.drawLine(20, i, 40, i);
        }
    }
}
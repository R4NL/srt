package test.window;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Window extends JPanel {
    private JFrame frame;
    private List<List<Double>> data;
    private boolean xy;
    private List<Color> color;

    public static Window create() {
        Window w = new Window();
        w.setVisible(true);
        return w;
    }

    public Window() {
        xy = true;
        frame = new JFrame("Fenin lab1");
        frame.setMinimumSize(new Dimension(1280, 720));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().add(this);
        frame.pack();
        frame.setVisible(true);

    }

    public void paint(List<List<Double>> lists, double mo, double disp, List<Color> color) {
        this.color = color;
        data = new ArrayList<>();
        for (List<Double> list : lists) {
            List<Double> buffer = new ArrayList<>();
            for (Double value : list) {
                buffer.add(value * 150);
            }
            data.add(buffer);
        }
        frame.repaint();
        JLabel label = new JLabel("Мат.Ожидание:" + mo + " Дисперсия:" + disp);
        label.setBounds(800, 100, frame.getWidth(), 1100);
        this.add(label);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(2.0f));
        drawXY(g);
        for (List<Double> data : this.data) {
            g.setColor(color.get(this.data.indexOf(data)));
            for (int i = 1; i < data.size(); i++) {
                int j = i + 1;
                g.drawLine(j * 15, y(data.get(i - 1)), (j + 1) * 15,
                        y(data.get(i)));
            }
        }
    }

    private int y(double a) {
        double yhalf = frame.getBounds().height / 2;
        return (int) Math.round(yhalf - a);
    }

    private void drawXY(Graphics g) {
        g.setColor(Color.black);
        int xmax = frame.getWidth();
        int ymax = frame.getHeight();
        g.drawLine(0, ymax / 2, xmax, ymax / 2);
        g.drawLine(30, 0, 30, ymax);
        for (int i = 0; i < ymax; i += 100) {
            g.drawLine(20, i, 40, i);
        }
    }
}
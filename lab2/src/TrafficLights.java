import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.GeneralPath;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class TrafficLights extends JPanel implements ActionListener {

    private static int maxWidth;
    private static int maxHeight;

    Timer timer;
    // Для анімації повороту
    private double rotation_angle = 1;
    // Для анімації руху
    private int centerX = 200;
    private int centerY = 200;
    private int radius = 100;
    private double moving_angle = 1;

    public TrafficLights(){
        timer = new Timer(10, this);
        timer.start();
    }

    // Всі дії, пов'язані з малюванням, виконуються в цьому методі
    public void paint(Graphics g) {
// Оскільки Java2D є надбудовою над старішою бібліотекою, необхідно робити це приведення

        Graphics2D g2d = (Graphics2D) g;

        RenderingHints rh =
                new RenderingHints(RenderingHints.KEY_ANTIALIASING,
                        RenderingHints.VALUE_ANTIALIAS_ON);
        rh.put(RenderingHints.KEY_RENDERING,
                RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setRenderingHints(rh);


        g2d.setBackground(Color.GRAY);
        g2d.clearRect(0, 0, maxWidth, maxHeight);

        g2d.setColor(Color.WHITE);
        BasicStroke bs = new BasicStroke(5, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
        g2d.setStroke(bs);
        g2d.drawRect(20, 20, maxWidth - 45, maxHeight - 45);

        // Перетворення для анімації руху.
        double x = centerX + radius * Math.cos(moving_angle);
        double y = centerY + radius * Math.sin(moving_angle);
        g2d.translate(x, y);

        // Перетворення для анімації повороту. Якщо не задати 2 та 3 параметри – поворот відбудеться відносно центру координат

        g2d.rotate(rotation_angle, 250, 170);

        int[] xValues2 = {200, 150, 250};
        int[] yValues2 = {70, 170, 170};
        Polygon baseTriangle = new Polygon(xValues2, yValues2, 3);
        g2d.fillPolygon(baseTriangle);

        g2d.setColor(Color.RED);
        g2d.setStroke(new BasicStroke(7));
        double[][] pointsForOutline = {
                { 200, 70 }, { 150, 170 }, { 250, 170 }, { 200, 70 }
        };
        GeneralPath outline = new GeneralPath();
        g2d.translate(0, 0);
        outline.moveTo(pointsForOutline[0][0], pointsForOutline[0][1]);
        for (int k = 1; k < pointsForOutline.length; k++)
            outline.lineTo(pointsForOutline[k][0], pointsForOutline[k][1]);
        outline.closePath();
        g2d.draw(outline);

        g2d.fillOval(190, 95, 20, 20);

        g2d.setColor(Color.YELLOW);
        g2d.fillOval(190, 120, 20, 20);

        g2d.setColor(Color.GREEN);
        g2d.fillOval(190, 145, 20, 20);

        GradientPaint gp = new GradientPaint(5, 25, Color.WHITE, 20, 2, Color.BLACK, true);
        g2d.setPaint(gp);
        g2d.fillRect(195, 174, 15, 100);

    }


    public static void main(String[] args) {
// Створюємо нове графічне вікно (формочка). Параметр конструктора - заголовок вікна.
        JFrame frame = new JFrame("Лабораторна №2");
        frame.add(new TrafficLights());
// Визначаємо поведінку програми при закритті вікна (ЛКМ на "хрестик")
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
// Визначаємо розмір вікна
        frame.setSize(800, 800);
// Якщо позиція прив'язана до null, вікно з'явиться в центрі екрану
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

// Забороняємо змінювати розміри вікна
        frame.setResizable(false);
// Додаємо до вікна панель, що й описується даним класом
// Зауважте, що точка входу в програму - метод main, може бути й в іншому класі
// Показуємо форму. Важливо додати всі компоненти на форму до того, як зробити її видимою.
        Dimension size = frame.getSize();
        Insets insets = frame.getInsets();
        maxWidth = size.width - insets.left - insets.right - 1;
        maxHeight = size.height - insets.top - insets.bottom - 1;
    }

    public void actionPerformed(ActionEvent e) {

        moving_angle -= 0.01;
        rotation_angle += 0.01;

        repaint();
    }
}


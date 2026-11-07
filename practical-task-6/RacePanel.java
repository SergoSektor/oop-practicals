import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JPanel;

public class RacePanel extends JPanel {
    private static final Color TOP = new Color(38, 45, 74);
    private static final Color BOTTOM = new Color(14, 17, 29);

    private final List<EmojiRunner> runners = new ArrayList<>();
    private final double[][] stars = new double[46][2];

    public RacePanel() {
        setBackground(BOTTOM);
        Random random = new Random(7);
        for (double[] star : stars) {
            star[0] = random.nextDouble();
            star[1] = random.nextDouble();
            star[0] = 0.03 + star[0] * 0.94;
            star[1] = 0.03 + star[1] * 0.94;
        }
    }

    public void addEmoji(BufferedImage image, String name,
            double x, double y, double dx, double dy, double size) {
        runners.add(new EmojiRunner(this, image, name, x, y, dx, dy, size));
    }

    public void startAll() {
        for (EmojiRunner runner : runners) {
            runner.start();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
                RenderingHints.VALUE_INTERPOLATION_BILINEAR);

        int width = getWidth();
        int height = getHeight();
        g2.setPaint(new GradientPaint(0, 0, TOP, 0, height, BOTTOM));
        g2.fillRect(0, 0, width, height);

        g2.setColor(new Color(255, 255, 255, 22));
        for (double[] star : stars) {
            int x = (int) (star[0] * width);
            int y = (int) (star[1] * height);
            g2.fillOval(x, y, 2, 2);
        }

        for (EmojiRunner runner : runners) {
            int w = (int) Math.round(runner.getWidth());
            int h = (int) Math.round(runner.getHeight());
            int x = (int) Math.round(runner.getX() - runner.getWidth() / 2);
            int y = (int) Math.round(runner.getY() - runner.getHeight() / 2);
            g2.drawImage(runner.getImage(), x, y, w, h, null);
        }

        g2.dispose();
    }
}

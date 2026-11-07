import java.awt.image.BufferedImage;

public class EmojiRunner extends Thread {
    private static final int PAUSE = 16;

    private final RacePanel panel;
    private final BufferedImage image;
    private final double width;
    private final double height;

    private volatile double x;
    private volatile double y;
    private double dx;
    private double dy;

    public EmojiRunner(RacePanel panel, BufferedImage image, String name,
            double x, double y, double dx, double dy, double size) {
        super(name);
        this.panel = panel;
        this.image = image;
        this.x = x;
        this.y = y;
        this.dx = dx;
        this.dy = dy;

        double scale = size / Math.max(image.getWidth(), image.getHeight());
        this.width = image.getWidth() * scale;
        this.height = image.getHeight() * scale;
        setDaemon(true);
    }

    public BufferedImage getImage() {
        return image;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    @Override
    public void run() {
        while (!isInterrupted()) {
            int panelWidth = panel.getWidth();
            int panelHeight = panel.getHeight();
            if (panelWidth <= 0 || panelHeight <= 0) {
                sleepQuietly();
                continue;
            }

            double halfWidth = width / 2;
            double halfHeight = height / 2;
            double nextX = x + dx;
            double nextY = y + dy;

            if (nextX < halfWidth) {
                nextX = halfWidth;
                dx = Math.abs(dx);
            }
            if (nextX > panelWidth - halfWidth) {
                nextX = panelWidth - halfWidth;
                dx = -Math.abs(dx);
            }
            if (nextY < halfHeight) {
                nextY = halfHeight;
                dy = Math.abs(dy);
            }
            if (nextY > panelHeight - halfHeight) {
                nextY = panelHeight - halfHeight;
                dy = -Math.abs(dy);
            }

            x = nextX;
            y = nextY;
            panel.repaint();
            sleepQuietly();
        }
    }

    private void sleepQuietly() {
        try {
            Thread.sleep(PAUSE);
        } catch (InterruptedException ex) {
            interrupt();
        }
    }
}

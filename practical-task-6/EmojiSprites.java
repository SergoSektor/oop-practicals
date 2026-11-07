import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;

public final class EmojiSprites {
    private EmojiSprites() {
    }

    public static BufferedImage load(String name) {
        String resource = "/emoji/" + name + ".png";
        try (InputStream in = EmojiSprites.class.getResourceAsStream(resource)) {
            if (in == null) {
                throw new IllegalStateException("Не найден ресурс " + resource);
            }
            return ImageIO.read(in);
        } catch (IOException ex) {
            throw new IllegalStateException("Не удалось загрузить " + resource, ex);
        }
    }
}

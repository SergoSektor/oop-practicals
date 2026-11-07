import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class Main {
    private static final Color BACKGROUND = new Color(14, 17, 29);
    private static final Color TITLE = new Color(242, 245, 255);
    private static final Color MUTED = new Color(150, 160, 190);
    private static final Color ACCENT = new Color(120, 200, 255);

    public static void main(String[] args) throws Exception {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        SwingUtilities.invokeLater(Main::createAndShow);
    }

    private static void createAndShow() {
        JFrame frame = new JFrame("Это моё окно");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(760, 540);
        frame.setLocation(400, 250);
        frame.setLayout(new BorderLayout());
        frame.getContentPane().setBackground(BACKGROUND);

        JLabel title = new JLabel("Эмодзи в движении");
        title.setFont(new Font("Dialog", Font.BOLD, 22));
        title.setForeground(TITLE);

        JLabel subtitle = new JLabel("Четыре объекта — четыре независимых потока");
        subtitle.setFont(new Font("Dialog", Font.PLAIN, 13));
        subtitle.setForeground(MUTED);

        JPanel titles = new JPanel();
        titles.setOpaque(false);
        titles.setLayout(new BoxLayout(titles, BoxLayout.Y_AXIS));
        titles.add(title);
        titles.add(subtitle);

        JLabel threads = new JLabel("4 × Thread");
        threads.setFont(new Font("Consolas", Font.BOLD, 14));
        threads.setForeground(ACCENT);

        JPanel header = new JPanel(new BorderLayout());
        header.setBackground(BACKGROUND);
        header.setBorder(BorderFactory.createEmptyBorder(16, 20, 12, 20));
        header.add(titles, BorderLayout.WEST);
        header.add(threads, BorderLayout.EAST);

        RacePanel racePanel = new RacePanel();
        racePanel.setBorder(BorderFactory.createLineBorder(new Color(72, 86, 124)));

        JPanel center = new JPanel(new BorderLayout());
        center.setBackground(BACKGROUND);
        center.setBorder(BorderFactory.createEmptyBorder(0, 18, 0, 18));
        center.add(racePanel, BorderLayout.CENTER);

        JLabel hint = new JLabel("Каждый эмодзи движется и отражается от границ в своём потоке");
        hint.setFont(new Font("Dialog", Font.PLAIN, 12));
        hint.setForeground(MUTED);
        hint.setBorder(BorderFactory.createEmptyBorder(10, 20, 14, 20));

        frame.add(header, BorderLayout.NORTH);
        frame.add(center, BorderLayout.CENTER);
        frame.add(hint, BorderLayout.SOUTH);
        frame.setVisible(true);

        racePanel.addEmoji(EmojiSprites.load("cat"), "Кот",
                140, 130, 2.4, 1.8, 60);
        racePanel.addEmoji(EmojiSprites.load("dog"), "Пёс",
                560, 110, -2.1, 2.3, 62);
        racePanel.addEmoji(EmojiSprites.load("rocket"), "Ракета",
                300, 330, 2.9, -2.2, 56);
        racePanel.addEmoji(EmojiSprites.load("frog"), "Лягушка",
                480, 300, -2.6, -1.9, 54);
        racePanel.startAll();
    }
}

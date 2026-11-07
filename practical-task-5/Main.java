import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class Main {
    private static final Font TEXT_FONT = new Font("Dialog", Font.PLAIN, 15);
    private static final Font HINT_FONT = new Font("Dialog", Font.PLAIN, 12);

    public static void main(String[] args) throws Exception {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

        JFrame frame = new JFrame("Это моё окно");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(560, 320);
        frame.setLocation(400, 250);
        frame.setLayout(new BorderLayout());

        JLabel arrayLabel = new JLabel("Массив: " + ArrayInfo.asText());
        arrayLabel.setFont(TEXT_FONT);

        JTextField input = new JTextField();
        input.setFont(TEXT_FONT);
        JButton show = new JButton("Показать");
        show.setFont(TEXT_FONT);

        ResultField result = new ResultField();
        result.showEmpty();

        LookupListener listener = new LookupListener(input, result);
        input.addActionListener(listener);
        show.addActionListener(listener);

        JPanel indexRow = new JPanel(new BorderLayout(8, 0));
        JLabel indexLabel = new JLabel("Индекс:");
        indexLabel.setFont(TEXT_FONT);
        indexRow.add(indexLabel, BorderLayout.WEST);
        indexRow.add(input, BorderLayout.CENTER);
        indexRow.add(show, BorderLayout.EAST);

        JPanel center = new JPanel(new GridLayout(3, 1, 0, 10));
        center.setBorder(BorderFactory.createEmptyBorder(14, 14, 14, 14));
        center.add(arrayLabel);
        center.add(indexRow);
        center.add(result);

        JLabel hint = new JLabel("Допустимые индексы: 0…" + (ArrayInfo.VALUES.length - 1));
        hint.setFont(HINT_FONT);
        hint.setForeground(Color.GRAY);
        hint.setBorder(BorderFactory.createEmptyBorder(0, 14, 10, 0));

        frame.add(center, BorderLayout.CENTER);
        frame.add(hint, BorderLayout.SOUTH);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowActivated(WindowEvent e) {
                input.requestFocusInWindow();
            }
        });
        frame.setVisible(true);
        SwingUtilities.invokeLater(input::requestFocusInWindow);
    }
}

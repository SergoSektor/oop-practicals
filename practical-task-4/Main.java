import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
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
        frame.setSize(560, 420);
        frame.setLocation(400, 250);
        frame.setLayout(new BorderLayout());

        JComboBox<Integer> box = new JComboBox<>(NumberInfo.NUMBERS);
        box.setFont(TEXT_FONT);
        ResultField comboResult = new ResultField();
        comboResult.showNumber(NumberInfo.NUMBERS[0]);
        box.addActionListener(new ComboListener(box, comboResult));

        JCheckBox check = new JCheckBox("Разрешить ввод", true);
        check.setFont(TEXT_FONT);

        JTextField input = new JTextField();
        input.setFont(TEXT_FONT);
        ResultField inputResult = new ResultField();
        inputResult.showEmpty();
        input.addKeyListener(new TypingListener(input, inputResult));

        JLabel status = new JLabel("Ввод разрешён");
        status.setFont(HINT_FONT);
        status.setForeground(new Color(0, 128, 0));

        check.addActionListener(new CheckListener(status, box, input));

        JPanel sections = new JPanel(new GridLayout(3, 1, 0, 8));
        sections.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        sections.add(comboSection(box, comboResult));
        sections.add(checkSection(check, status));
        sections.add(typingSection(input, inputResult));

        frame.add(sections, BorderLayout.CENTER);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowActivated(WindowEvent e) {
                box.requestFocusInWindow();
            }
        });
        frame.setVisible(true);
        SwingUtilities.invokeLater(box::requestFocusInWindow);
    }

    private static JPanel comboSection(JComboBox<Integer> box, ResultField result) {
        JPanel panel = titled("1. Список (ComboBox)");
        panel.setLayout(new GridLayout(2, 1, 0, 6));
        panel.add(box);
        panel.add(result);
        return panel;
    }

    private static JPanel checkSection(JCheckBox check, JLabel status) {
        JPanel panel = titled("2. Флажок (CheckBox)");
        panel.setLayout(new BorderLayout(0, 2));
        panel.add(check, BorderLayout.NORTH);
        panel.add(status, BorderLayout.SOUTH);
        return panel;
    }

    private static JPanel typingSection(JTextField input, ResultField result) {
        JPanel panel = titled("3. Ввод с клавиатуры (KeyListener)");
        panel.setLayout(new GridLayout(2, 1, 0, 6));

        JPanel row = new JPanel(new BorderLayout(8, 0));
        JLabel label = new JLabel("Число:");
        label.setFont(TEXT_FONT);
        row.add(label, BorderLayout.WEST);
        row.add(input, BorderLayout.CENTER);

        panel.add(row);
        panel.add(result);
        return panel;
    }

    private static JPanel titled(String title) {
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createTitledBorder(title));
        return panel;
    }
}

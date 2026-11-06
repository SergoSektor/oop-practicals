import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JTextField;

public class TypingListener extends KeyAdapter {
    private final JTextField input;
    private final ResultField result;

    public TypingListener(JTextField input, ResultField result) {
        this.input = input;
        this.result = result;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        String text = input.getText().trim();
        if (text.isEmpty() || text.equals("-")) {
            result.showEmpty();
            return;
        }
        try {
            result.showNumber(Integer.parseInt(text));
        } catch (NumberFormatException ex) {
            result.showError();
        }
    }
}

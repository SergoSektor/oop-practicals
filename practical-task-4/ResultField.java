import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;

public class ResultField extends JTextField {
    private static final Color POSITIVE = new Color(200, 240, 200);
    private static final Color NEGATIVE = new Color(255, 205, 205);
    private static final Color ZERO = new Color(228, 228, 228);
    private static final Color ERROR = new Color(255, 244, 180);
    private static final Color EMPTY = new Color(240, 240, 240);

    public ResultField() {
        setEditable(false);
        setFocusable(false);
        setHorizontalAlignment(JTextField.CENTER);
        setFont(new Font("Dialog", Font.BOLD, 14));
        setBackground(EMPTY);
    }

    public void showNumber(int number) {
        setText(NumberInfo.describe(number));
        if (number > 0) {
            setBackground(POSITIVE);
        } else if (number < 0) {
            setBackground(NEGATIVE);
        } else {
            setBackground(ZERO);
        }
    }

    public void showEmpty() {
        setText("Введите целое число");
        setBackground(EMPTY);
    }

    public void showError() {
        setText("Это не целое число");
        setBackground(ERROR);
    }
}

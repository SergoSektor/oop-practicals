import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;

public class ResultField extends JTextField {
    private static final Color SUCCESS = new Color(200, 240, 200);
    private static final Color ERROR = new Color(255, 205, 205);
    private static final Color EMPTY = new Color(240, 240, 240);

    public ResultField() {
        setEditable(false);
        setFocusable(false);
        setHorizontalAlignment(JTextField.CENTER);
        setFont(new Font("Dialog", Font.BOLD, 15));
        setBackground(EMPTY);
    }

    public void showValue(int value) {
        setText("Значение: " + value);
        setBackground(SUCCESS);
    }

    public void showError() {
        setText("Ошибка: значение не найдено");
        setBackground(ERROR);
    }

    public void showEmpty() {
        setText("Введите индекс и нажмите Enter");
        setBackground(EMPTY);
    }
}

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class LookupListener implements ActionListener {
    private final JTextField input;
    private final ResultField result;

    public LookupListener(JTextField input, ResultField result) {
        this.input = input;
        this.result = result;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            int index = Integer.parseInt(input.getText().trim());
            result.showValue(ArrayInfo.VALUES[index]);
        } catch (NumberFormatException ex) {
            result.showError();
            JOptionPane.showMessageDialog(input, "NumberFormatException: " + ex.getMessage(),
                    "Ошибка", JOptionPane.ERROR_MESSAGE);
        } catch (ArrayIndexOutOfBoundsException ex) {
            result.showError();
            JOptionPane.showMessageDialog(input, "ArrayIndexOutOfBoundsException: " + ex.getMessage(),
                    "Ошибка", JOptionPane.ERROR_MESSAGE);
        }
        input.selectAll();
        input.requestFocusInWindow();
    }
}

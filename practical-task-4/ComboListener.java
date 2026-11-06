import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;

public class ComboListener implements ActionListener {
    private final JComboBox<Integer> box;
    private final ResultField result;

    public ComboListener(JComboBox<Integer> box, ResultField result) {
        this.box = box;
        this.result = result;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        result.showNumber((Integer) box.getSelectedItem());
    }
}

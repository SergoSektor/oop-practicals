import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JLabel;

public class CheckListener implements ActionListener {
    private static final Color ENABLED = new Color(0, 128, 0);
    private static final Color DISABLED = new Color(180, 0, 0);

    private final JLabel status;
    private final JComponent[] components;

    public CheckListener(JLabel status, JComponent... components) {
        this.status = status;
        this.components = components;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        boolean selected = ((JCheckBox) e.getSource()).isSelected();
        for (JComponent component : components) {
            component.setEnabled(selected);
        }
        status.setText(selected ? "Ввод разрешён" : "Ввод заблокирован");
        status.setForeground(selected ? ENABLED : DISABLED);
    }
}

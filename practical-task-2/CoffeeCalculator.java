import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

public class CoffeeCalculator extends JFrame {
    private static final double SUGAR_PRICE = 10;
    private static final double CREAM_PRICE = 30;

    private final JSpinner cupsSpinner = new JSpinner(new SpinnerNumberModel(1, 1, 20, 1));
    private final JComboBox<CoffeeType> coffeeTypeBox = new JComboBox<>(CoffeeType.values());
    private final JCheckBox sugarCheckBox = new JCheckBox("Сахар (+10 ₽ за чашку)");
    private final JCheckBox creamCheckBox = new JCheckBox("Сливки (+30 ₽ за чашку)");
    private final JLabel resultLabel = new JLabel("Итого: 0,00 ₽", SwingConstants.CENTER);

    public CoffeeCalculator() {
        super("Калькулятор стоимости кофе");

        JPanel formPanel = new JPanel(new GridLayout(0, 2, 8, 8));
        formPanel.add(new JLabel("Тип кофе:"));
        formPanel.add(coffeeTypeBox);
        formPanel.add(new JLabel("Количество чашек:"));
        formPanel.add(cupsSpinner);
        formPanel.add(new JLabel("Дополнительно:"));
        formPanel.add(sugarCheckBox);
        formPanel.add(new JLabel(""));
        formPanel.add(creamCheckBox);

        JButton calculateButton = new JButton("Рассчитать");
        calculateButton.addActionListener(event -> calculate());

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(calculateButton);

        resultLabel.setFont(resultLabel.getFont().deriveFont(Font.BOLD, 16f));

        JPanel contentPanel = new JPanel(new BorderLayout(10, 10));
        contentPanel.setBorder(BorderFactory.createEmptyBorder(12, 12, 12, 12));
        contentPanel.add(formPanel, BorderLayout.NORTH);
        contentPanel.add(buttonPanel, BorderLayout.CENTER);
        contentPanel.add(resultLabel, BorderLayout.SOUTH);

        setContentPane(contentPanel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setResizable(false);
        setLocationRelativeTo(null);
    }

    private void calculate() {
        int cups = (Integer) cupsSpinner.getValue();
        CoffeeType coffeeType = (CoffeeType) coffeeTypeBox.getSelectedItem();

        double pricePerCup = coffeeType.getPrice();
        if (sugarCheckBox.isSelected()) {
            pricePerCup += SUGAR_PRICE;
        }
        if (creamCheckBox.isSelected()) {
            pricePerCup += CREAM_PRICE;
        }

        double total = pricePerCup * cups;
        resultLabel.setText(String.format("Итого: %.2f ₽", total));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CoffeeCalculator().setVisible(true));
    }
}

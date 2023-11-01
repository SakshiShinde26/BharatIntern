import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TemperatureConverterGUI extends JFrame {
    private JTextField celsiusField;
    private JLabel resultLabel;

    public TemperatureConverterGUI() {
        setTitle("Temperature Converter");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1));

        JLabel celsiusLabel = new JLabel("Enter temperature in Celsius:");
        celsiusLabel.setFont(new Font("Arial", Font.PLAIN, 16));

        celsiusField = new JTextField();
        celsiusField.setFont(new Font("Arial", Font.PLAIN, 16));

        JButton convertButton = new JButton("Convert");
        convertButton.setFont(new Font("Arial", Font.PLAIN, 16)); 
        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                convertTemperature();
            }
        });

        resultLabel = new JLabel("", JLabel.CENTER);
        resultLabel.setFont(new Font("Arial", Font.BOLD, 18)); 
        
        panel.add(celsiusLabel);
        panel.add(celsiusField);
        panel.add(convertButton);

        add(panel, BorderLayout.CENTER);
        add(resultLabel, BorderLayout.SOUTH);
    }

    private void convertTemperature() {
        try {
            double celsius = Double.parseDouble(celsiusField.getText());
            double fahrenheit = (celsius * 9 / 5) + 32;
            resultLabel.setText(celsius + " degrees Celsius is equal to " + fahrenheit + " degrees Fahrenheit.");
            resultLabel.setForeground(Color.BLUE);
        } catch (NumberFormatException ex) {
            resultLabel.setText("Invalid input. Please enter a number.");
            resultLabel.setForeground(Color.RED);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TemperatureConverterGUI converter = new TemperatureConverterGUI();
            converter.setVisible(true);
        });
    }
}

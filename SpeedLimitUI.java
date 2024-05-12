import javax.swing.*;

public class SpeedLimitUI {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Speed Limit Calculator");
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel firstLabel = new JLabel("Second odometer:");
        JTextField firstField = new JTextField(10);
        JPanel firstPanel = new JPanel();
        firstPanel.add(firstLabel);
        firstPanel.add(firstField);

        JLabel secondLabel = new JLabel("First odometer:");
        JTextField secondField = new JTextField(10);
        JPanel secondPanel = new JPanel();
        secondPanel.add(secondLabel);
        secondPanel.add(secondField);

        JLabel speedLabel = new JLabel("Speed:");
        JTextField speedField = new JTextField(10);
        JPanel speedPanel = new JPanel();
        speedPanel.add(speedLabel);
        speedPanel.add(speedField);

        JButton calculateButton = new JButton("Calculate");
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(calculateButton);

        JTextArea resultArea = new JTextArea(5, 20);
        resultArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultArea);

        panel.add(firstPanel);
        panel.add(secondPanel);
        panel.add(speedPanel);
        panel.add(buttonPanel);
        panel.add(scrollPane);

        calculateButton.addActionListener(e -> {
            int first = Integer.parseInt(firstField.getText());
            int second = Integer.parseInt(secondField.getText());
            int speed = Integer.parseInt(speedField.getText());

            int totalTimeInMinutes = ((first - second) * 60 / speed);
            int hours = totalTimeInMinutes / 60;
            int minutes = totalTimeInMinutes % 60;

            resultArea.setText(hours + " hours " + minutes + " minutes");
        });

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }
}

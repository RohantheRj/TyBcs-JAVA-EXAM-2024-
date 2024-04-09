import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class NumberDisplay extends JFrame {
    private JTextField textField;
    private JButton startButton;
    private boolean running = false;

    public NumberDisplay() {
        setTitle("Number Display");
        setSize(300, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        textField = new JTextField(10);
        textField.setEditable(false);

        startButton = new JButton("Start");
        startButton.addActionListener(new StartButtonListener());

        JPanel panel = new JPanel();
        panel.add(textField);
        panel.add(startButton);

        add(panel);
    }

    private class NumberRunnable implements Runnable {
        @Override
        public void run() {
            int number = 1;
            while (running && number <= 100) {
                try {
                    SwingUtilities.invokeLater(() -> textField.setText(String.valueOf(number)));
                    Thread.sleep(500); // Update every 500 milliseconds (0.5 seconds)
                    number++;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private class StartButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (!running) {
                running = true;
                new Thread(new NumberRunnable()).start();
                startButton.setText("Stop");
            } else {
                running = false;
                startButton.setText("Start");
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            NumberDisplay numberDisplay = new NumberDisplay();
            numberDisplay.setVisible(true);
        });
    }
}


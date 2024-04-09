import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BlinkingText implements Runnable {
    private JLabel label;
    private boolean isBlinking;

    public BlinkingText() {
        label = new JLabel("Blinking Text");
        label.setFont(new Font("Arial", Font.BOLD, 20));
        isBlinking = true;
    }

    @Override
    public void run() {
        while (isBlinking) {
            try {
                label.setVisible(!label.isVisible());
                Thread.sleep(500); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void stopBlinking() {
        isBlinking = false;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Blinking Text");
            BlinkingText blinkingText = new BlinkingText();
            Thread thread = new Thread(blinkingText);

            JPanel panel = new JPanel();
            panel.setLayout(new FlowLayout());
            panel.add(blinkingText.label);

            JButton stopButton = new JButton("Stop Blinking");
            stopButton.addActionListener(e -> {
                blinkingText.stopBlinking();
                stopButton.setEnabled(false);
            });
            panel.add(stopButton);

            frame.add(panel);
            frame.setSize(300, 100);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);

            thread.start();
        });
    }
}


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BlinkingImage extends JFrame {
    private ImageIcon[] images;
    private JLabel imageLabel;
    private int currentIndex;
    private Timer timer;

    public BlinkingImage() {
        setTitle("Blinking Image");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);


        images = new ImageIcon[2];
        images[0] = new ImageIcon("image1.png"); 
        images[1] = new ImageIcon("image2.png");  

        imageLabel = new JLabel(images[0]);  

        add(imageLabel, BorderLayout.CENTER);


        timer = new Timer(500, new TimerListener());
        timer.start();
    }

    private class TimerListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            currentIndex = (currentIndex + 1) % images.length;  
            imageLabel.setIcon(images[currentIndex]);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            BlinkingImage blinkingImage = new BlinkingImage();
            blinkingImage.setVisible(true);
        });
    }
}


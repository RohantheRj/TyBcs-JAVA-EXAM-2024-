import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BallMovementGUI {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new BallMovementFrame();
        });
    }

    static class BallMovementFrame extends JFrame {
        private JPanel ballPanel;
        private JButton startButton;
        private Thread ballThread;

        public BallMovementFrame() {
            setTitle("Ball Movement");
            setSize(400, 400);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            ballPanel = new JPanel() {
                private int ballY = 180;

                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    g.setColor(Color.RED);
                    g.fillOval(175, ballY, 50, 50);
                }

                public void moveBall() {
                    ballY -= 5;
                    if (ballY < 0) {
                        ballY = 180;
                    }
                    repaint();
                }
            };

            startButton = new JButton("Start");
            startButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (ballThread == null || !ballThread.isAlive()) {
                        ballThread = new Thread(() -> {
                            while (true) {
                                ballPanel.moveBall();
                                try {
                                    Thread.sleep(50);
                                } catch (InterruptedException ex) {
                                    ex.printStackTrace();
                                }
                            }
                        });
                        ballThread.start();
                    }
                }
            });

            setLayout(new BorderLayout());
            add(ballPanel, BorderLayout.CENTER);
            add(startButton, BorderLayout.SOUTH);

            setVisible(true);
        }
    }
}


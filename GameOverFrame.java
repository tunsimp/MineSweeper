import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameOverFrame extends JFrame {

    public GameOverFrame() {
        setTitle("Game Over!");

        setSize(300, 200);

        // Center the frame on the screen
        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        setLayout(new BorderLayout());

        JLabel label = new JLabel("Game Over!", SwingConstants.CENTER);
        label.setFont(new Font("Cambria", Font.BOLD, 24));
        add(label, BorderLayout.CENTER);

        // Create a panel to hold the buttons
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));

        JButton undoButton = new JButton("Undo");
        buttonPanel.add(undoButton);

        JButton restartButton = new JButton("Restart");
        buttonPanel.add(restartButton);

        // Add the button panel to the frame
        add(buttonPanel, BorderLayout.SOUTH);

        undoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                BoardPanel.undoLastMove();
            }
        });

        restartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                BoardPanel.restartGame();
            }
        });

        setVisible(true);
    }
}

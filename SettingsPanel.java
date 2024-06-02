import javax.swing.*;
import java.awt.*;

public class SettingsPanel extends JPanel {
    public SettingsPanel() {
        // Set layout for the settings panel
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // padding

        // Create buttons for difficulty levels
        JButton easyButton = new JButton("Easy 8x8");
        JButton mediumButton = new JButton("Medium 12x12");
        JButton hardButton = new JButton("Hard 16x16");

        // Set preferred size for buttons to make them larger
        Dimension buttonSize = new Dimension(200, 50);
        easyButton.setPreferredSize(buttonSize);
        mediumButton.setPreferredSize(buttonSize);
        hardButton.setPreferredSize(buttonSize);

        // Set font for buttons
        Font buttonFont = new Font("Cambria", Font.BOLD, 18);
        easyButton.setFont(buttonFont);
        mediumButton.setFont(buttonFont);
        hardButton.setFont(buttonFont);

        // Position easy button
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        this.add(easyButton, gbc);

        // Position medium button
        gbc.gridx = 0;
        gbc.gridy = 1;
        this.add(mediumButton, gbc);

        // Position hard button
        gbc.gridx = 0;
        gbc.gridy = 2;
        this.add(hardButton, gbc);

        // Add action listeners for the buttons (optional, for handling button clicks)
        easyButton.addActionListener(e -> System.out.println("Easy button clicked"));
        mediumButton.addActionListener(e -> System.out.println("Medium button clicked"));
        hardButton.addActionListener(e -> System.out.println("Hard button clicked"));
    }
}

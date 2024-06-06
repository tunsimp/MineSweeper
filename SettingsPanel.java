import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingsPanel extends JPanel {
    private MineSweeper game;
    public SettingsPanel(MineSweeper game) {
        this.game=game;
        // Set layout for the settings panel
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // padding

        // Create buttons for difficulty levels
        JButton easyButton = new JButton("Easy 9x9");
        JButton mediumButton = new JButton("Medium 12x12");
        JButton hardButton = new JButton("Hard 15x15");

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
        easyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BoardPanel easyBoard = new BoardPanel(getGame(),8,8,10);
                game.setBoardPanel(easyBoard);
                game.showBoardPanel();
            }
        });
        mediumButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BoardPanel mediumBoard = new BoardPanel(getGame(),12,12,20);
                game.setBoardPanel(mediumBoard);
                game.showBoardPanel();
            }
        });
        hardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BoardPanel hardBoard = new BoardPanel(getGame(),16,16,40);
                game.setBoardPanel(hardBoard);
                game.showBoardPanel();
            }
        });
    }

    public MineSweeper getGame() {
        return this.game;
    }
}

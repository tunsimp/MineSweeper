import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class SettingsMenu extends JMenuBar {

    MineSweeperFrame game;
    JMenu settingsMenu;
    JMenuItem settingsMenuItem;

    SettingsMenu(MineSweeperFrame game) {
        this.game = game;

        // Set the layout of the menu bar
        setLayout(new FlowLayout(FlowLayout.LEFT));

        settingsMenu = new JMenu("⚙️️");

        // Create a font with a larger size
        Font menuFont = new Font("San Serif", Font.BOLD, 18); // Change the size as needed
        settingsMenu.setFont(menuFont);

        // Create a menu item for "⚙️" to add action listener
        settingsMenuItem = new JMenuItem("Difficulty Levels");
        settingsMenuItem.setFont(menuFont);
        settingsMenu.add(settingsMenuItem);

        // Add the settings menu to the menu bar
        add(settingsMenu);

        // Add action listener to the settings menu item
        settingsMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.showSettingsPanel();
            }
        });
    }
}

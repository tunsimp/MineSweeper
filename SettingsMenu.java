import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class SettingsMenu extends JMenuBar {

    MineSweeperFrame game;
    JMenu settingMenu;
    JMenuItem settingsMenuItem;

    SettingsMenu(MineSweeperFrame game) {
        this.game = game;

        // Create a panel with BorderLayout
        JPanel menuPanel = new JPanel(new BorderLayout());
        settingMenu = new JMenu("⚙️");

        // Create a font with a larger size
        Font menuFont = new Font("Times New Romans", Font.BOLD, 18); // Change the size as needed
        settingMenu.setFont(menuFont);

        // Create a menu item for "⚙️" to add action listener
        settingsMenuItem = new JMenuItem("Settings");
        settingsMenuItem.setFont(menuFont);
        settingMenu.add(settingsMenuItem);

        // Create a menu bar with BoxLayout
        JMenuBar leftMenuBar = new JMenuBar();
        leftMenuBar.setLayout(new BoxLayout(leftMenuBar, BoxLayout.X_AXIS));
        leftMenuBar.add(Box.createHorizontalGlue());
        leftMenuBar.add(settingMenu);
        menuPanel.add(leftMenuBar, BorderLayout.EAST);

        add(menuPanel);

        // Add action listener to the settings menu item
        settingsMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.showSettingsPanel();
            }
        });
    }
}
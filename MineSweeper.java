import javax.swing.*;
import java.awt.*;

public class MineSweeper extends JFrame {

    int boardWidth = 1280;
    int boardHeight = 720;

    JFrame frame = new JFrame("Minesweeper");
    private final TextPanel textPanel;
    private BoardPanel boardPanel;
    private final SettingsPanel settingsPanel;


    MineSweeper() {
//        frame.setVisible(true);

        // Sets size to declare the dimension of the frame, in order to call setLocationRelativeTo() method later
        frame.setSize(boardWidth, boardHeight);
        // Centers a frame relative a component, in this case, it is centered on the screen
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // BorderLayout lets the frame places up to five areas: top, bot, left, right, cent
        frame.setLayout(new BorderLayout());

        // Initialize the textPanel
        textPanel = new TextPanel();
        frame.add(textPanel, BorderLayout.NORTH);

        // Initialize the settingsMenu
        SettingsMenu settingsMenu = new SettingsMenu(this);

        settingsPanel = new SettingsPanel(this);
        // Set the menu bar
        frame.setJMenuBar(settingsMenu);


        // Initialize the boardPanel
        boardPanel = new BoardPanel(this,8,8,10);
        frame.add(boardPanel, BorderLayout.CENTER);

    }

    void play() {
        frame.setVisible(true);
    }

    public void showSettingsPanel() {
        frame.remove(boardPanel);
        frame.add(settingsPanel, BorderLayout.CENTER);
        frame.revalidate();
        frame.repaint();
    }

    public void showBoardPanel() {
        frame.remove(settingsPanel);
        frame.add(boardPanel, BorderLayout.CENTER);
        frame.revalidate();
        frame.repaint();
    }
    public void setTextPanel(String text){
        this.textPanel.setTextLabel(text);
    }

    public void setBoardPanel(BoardPanel boardPanel) {
        this.boardPanel = boardPanel;
    }
}

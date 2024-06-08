import javax.swing.*;
import java.awt.*;

public class MineSweeper extends JFrame {

    int boardWidth = 1280;
    int boardHeight = 720;

//    JFrame frame = new JFrame("Minesweeper");
    private final TextPanel textPanel;
    private BoardPanel boardPanel;
    private final SettingsPanel settingsPanel;


    MineSweeper() {
//        setVisible(true);

        // Sets size to declare the dimension of the frame, in order to call setLocationRelativeTo() method later
//        setSize(boardWidth, boardHeight);
        // Centers a frame relative a component, in this case, it is centered on the screen
        setLocation(0,0);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // BorderLayout lets the frame places up to five areas: top, bot, left, right, cent
        setLayout(new BorderLayout());

        // Initialize the textPanel
        textPanel = new TextPanel();
        add(textPanel, BorderLayout.NORTH);

        // Initialize the settingsMenu

        SettingsMenu settingsMenu = new SettingsMenu(this);

        settingsPanel = new SettingsPanel(this);
        // Set the menu bar
        setJMenuBar(settingsMenu);


        // Initialize the boardPanel
        boardPanel = new BoardPanel(this,9,9,10);
        add(boardPanel, BorderLayout.CENTER);

        setTitle("MineSweeper");
        pack();

    }

    void play() {
        setVisible(true);
    }

    public void showSettingsPanel() {
        remove(boardPanel);
        add(settingsPanel, BorderLayout.CENTER);
        revalidate();
        repaint();
    }

    public void showBoardPanel() {
        remove(settingsPanel);
        add(boardPanel, BorderLayout.CENTER);
        pack();
        revalidate();
        repaint();
    }
    public void setTextPanel(String text){
        this.textPanel.setTextLabel(text);
    }

    public void setBoardPanel(BoardPanel boardPanel) {
        this.boardPanel = boardPanel;
    }
}

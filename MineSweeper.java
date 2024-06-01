import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;


public class MineSweeper {
    //this class is created because we need to add more properties to the clickable JButtons on grid
    //such as the row and col number of it to know where the button is when clicking it

    int tileSize = 70;
    int numRows = 8;
    int numCols = numRows;
    int boardWidth = numCols * tileSize;
    int boardHeight = numRows * tileSize;

    JFrame frame = new JFrame("Minesweeper");
    TextPanel textPanel;
    BoardPanel boardPanel;

    int mineCount = 10;
    //2d array to store each mine tile so that we know where each is
    MineTile[][] board = new MineTile[numRows][numCols];
    ArrayList<MineTile> mineList;
    Random random = new Random();

    int tilesClicked = 0;
    boolean gameOver = false;

    MineSweeper() {
//        frame.setVisible(true);

        //sets size to declare the dimension of the frame, in order to call setLocationRelativeTo() method later
        frame.setSize(boardWidth, boardHeight);
        //centers a frame relative a component, in this case, it is centered on the screen
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //BorderLayout lets the frame places up to five areas: top, bot, left, right, cent
        frame.setLayout(new BorderLayout());

        // Initialize the textPanel
        textPanel = new TextPanel();
        textPanel.setTextLabel("Minesweeper: " + mineCount);
        frame.add(textPanel, BorderLayout.NORTH);

        // Initialize the mineList
        mineList = new ArrayList<>();

        // Initialize the BoardPanel
        boardPanel = new BoardPanel(this, numRows, numCols, board, mineList);
        frame.add(boardPanel, BorderLayout.CENTER);

    }

    void play() {
        setMines();
        frame.setVisible(true);
    }

    void setMines() {
        mineList.clear();
        int mineLeft = mineCount;
        while (mineLeft > 0) {
            int r = random.nextInt(numRows);
            int c = random.nextInt(numCols);

            MineTile tile = board[r][c];
            if (!mineList.contains(tile)) {
                mineList.add(tile);
                mineLeft -= 1;
            }
        }
    }

    void revealMines() {
        for (MineTile tile : mineList) {
            tile.setText("💣");
        }
        gameOver = true;
        textPanel.setTextLabel("Game Over");
    }

    void checkMine(int r, int c) {
        if (r < 0 || r >= numRows || c < 0 || c >= numCols) {
            return;
        }

        MineTile tile = board[r][c];
        if (!tile.isEnabled()) {
            return;
        }

        tile.setEnabled(false);
        tilesClicked += 1;

        int minesFound = 0;
        minesFound += countMine(r - 1, c - 1);
        minesFound += countMine(r - 1, c);
        minesFound += countMine(r - 1, c + 1);
        minesFound += countMine(r, c - 1);
        minesFound += countMine(r, c + 1);
        minesFound += countMine(r + 1, c - 1);
        minesFound += countMine(r + 1, c);
        minesFound += countMine(r + 1, c + 1);

        if (minesFound > 0) {
            tile.setText(Integer.toString(minesFound));
        } else {
            tile.setText("");
            checkMine(r - 1, c - 1);
            checkMine(r - 1, c);
            checkMine(r - 1, c + 1);
            checkMine(r, c - 1);
            checkMine(r, c + 1);
            checkMine(r + 1, c - 1);
            checkMine(r + 1, c);
            checkMine(r + 1, c + 1);
        }

        if (tilesClicked == numRows * numCols - mineList.size()) {
            gameOver = true;
            textPanel.setTextLabel("Mines Cleared!");
        }
    }

    int countMine(int r, int c) {
        if (r < 0 || r >= numRows || c < 0 || c >= numCols) {
            return 0;
        }
        if (mineList.contains(board[r][c])) {
            return 1;
        }
        return 0;
    }
}

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;

public class BoardPanel extends JPanel {
    private MineSweeper game;
    private final int numRows;
    private final int numCols;
    // 2d array to store each mine tile so that we know where each is
    private final MineTile[][] board;
    private final ArrayList<MineTile> mineList;

    private final int mineCount;

    private final Random random = new Random();

    private int tilesClicked = 0;
    private boolean gameOver = false;

    public BoardPanel(MineSweeper mineSweeper, int numRows, int numCols,int mineCount) {
        this.game = mineSweeper;
        this.numRows = numRows;
        this.numCols = numCols;
        this.board = new MineTile[numRows][numCols];
        this.mineList = new ArrayList<>();
        this.mineCount=mineCount;

        game.setTextPanel("MineSweeper");
        setLayout(new GridLayout(numRows, numCols));
        setBackground(Color.pink);

        for (int r = 0; r < numRows; r++) {
            for (int c = 0; c < numCols; c++) {
                MineTile tile = new MineTile(r, c);
                board[r][c] = tile;

                tile.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        if (gameOver) {
                            return;
                        }
                        MineTile tile = (MineTile) e.getSource();

                        if (e.getButton() == MouseEvent.BUTTON1) {
                            if (tile.getText().isEmpty()) {
                                if (tilesClicked == 0) {
                                        setMines(tile);
                                        checkMine(tile.r, tile.c);
                                } else if (mineList.contains(tile)) {
                                    revealMines();
                                } else {
                                    checkMine(tile.r, tile.c);
                                }
                            }
                        } else if (e.getButton() == MouseEvent.BUTTON3) {
                            if (tile.getText().isEmpty() && tile.isEnabled()) {
                                tile.setText("🚩");
                            } else if (tile.getText().equals("🚩")) {
                                tile.setText("");
                            }
                        }
                    }
                });
                add(tile);
            }
        }
    }

    public void setMines() {
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

    public void revealMines() {
        for (MineTile tile : mineList) {
            tile.setText("💣");
        }
        gameOver = true;
        game.setTextPanel("Game Over");
    }

    public void checkMine(int r, int c) {
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
            game.setTextPanel(
                    "Mines Cleared!");
        }
    }


    public void setMines(MineTile firstTile) {
        mineList.clear();
        int mineLeft = mineCount;
        while (mineLeft > 0) {
            int r = random.nextInt(numRows);
            int c = random.nextInt(numCols);
            MineTile tile = board[r][c];
            if (!mineList.contains(tile) && tile != firstTile && !isAdjacent(firstTile, tile)) {
                mineList.add(tile);
                mineLeft -= 1;
            }
        }
    }

    public boolean isAdjacent(MineTile tile1, MineTile tile2) {
        int r1 = tile1.r, c1 = tile1.c;
        int r2 = tile2.r, c2 = tile2.c;
        return Math.abs(r1 - r2) <= 1 && Math.abs(c1 - c2) <= 1; //true if 2 tile are adjacent
    }


    public int countMine(int r, int c) {
        if (r < 0 || r >= numRows || c < 0 || c >= numCols) {
            return 0;
        }
        if (mineList.contains(board[r][c])) {
            return 1;
        }
        return 0;
    }

    public boolean isGameOver() {
        return gameOver;
    }
}

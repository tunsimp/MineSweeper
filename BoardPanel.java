import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class BoardPanel extends JPanel {
    private MineSweeper mineSweeper;
    private int numRows;
    private int numCols;
    private MineTile[][] board;
    private ArrayList<MineTile> mineList;

    public BoardPanel(MineSweeper mineSweeper, int numRows, int numCols, MineTile[][] board, ArrayList<MineTile> mineList) {
        this.mineSweeper = mineSweeper;
        this.numRows = numRows;
        this.numCols = numCols;
        this.board = board;
        this.mineList = mineList;

        setLayout(new GridLayout(numRows, numCols));
        setBackground(Color.pink);

        for (int r = 0; r < numRows; r++) {
            for (int c = 0; c < numCols; c++) {
                MineTile tile = new MineTile(r, c);
                board[r][c] = tile;

                tile.setFocusable(false);
                tile.setMargin(new Insets(0, 0, 0, 0));
                tile.setFont(new Font("Arial Unicode MS", Font.PLAIN, 45));

                tile.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        if (mineSweeper.gameOver) {
                            return;
                        }
                        MineTile tile = (MineTile) e.getSource();

                        if (e.getButton() == MouseEvent.BUTTON1) {
                            if (tile.getText().equals("")) {
                                if (mineSweeper.tilesClicked == 0) {
                                    if (mineList.contains(tile)) {
                                        mineSweeper.setMines();
                                    }
                                }
                                if (mineList.contains(tile)) {
                                    mineSweeper.revealMines();
                                } else {
                                    mineSweeper.checkMine(tile.r, tile.c);
                                }
                            }
                        } else if (e.getButton() == MouseEvent.BUTTON3) {
                            if (tile.getText().equals("") && tile.isEnabled()) {
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
}

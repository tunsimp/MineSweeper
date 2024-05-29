import java.awt.*;
import java.awt.event.*;
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
    JLabel textLabel = new JLabel();
    JPanel textPanel = new JPanel();
    JPanel boardPanel = new JPanel();

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


        textLabel.setFont(new Font("Cambria", Font.BOLD, 25));
        //centers the text label, horizontally
        textLabel.setHorizontalAlignment(JLabel.CENTER);
        textLabel.setText("Minesweeper: " + Integer.toString(mineCount));
        //setOpaque paints every pixel within textLabel bounds, let it nontransparent
        textLabel.setOpaque(false);


        textPanel.setLayout(new BorderLayout());
        textPanel.add(textLabel);

        frame.add(textLabel, BorderLayout.NORTH);


        //GridLayout makes tiles equal in size, displays tiles in requested numRows, numCols
        boardPanel.setLayout(new GridLayout(numRows, numCols)); //8x8
        boardPanel.setBackground(Color.pink);
        frame.add(boardPanel);

        for (int r = 0; r < numRows; r++) {
            for (int c = 0; c < numCols; c++) {
                MineTile tile = new MineTile(r, c);
                board[r][c] = tile;

                //set false to let the tile unable to receive keyboard input
                tile.setFocusable(false);
                //set tile margin compare to the numbers/emoji within it
                tile.setMargin(new Insets(0, 0, 0, 0));
                tile.setFont(new Font("Arial Unicode MS", Font.PLAIN, 45));

                //listens to mouse click
                tile.addMouseListener(new MouseAdapter() {
                    @Override
                    //runs when mouse is clicked
                    public void mousePressed(MouseEvent e) {

                        if(gameOver){ //check if the game is over or not, if yes then stop the game
                            return;
                        }
                        //get the clicked tile by getting a mouse click event
                        MineTile tile = (MineTile) e.getSource();

                        //left click: open tile, right click: set flag
                        //left click
                        if (e.getButton() == MouseEvent.BUTTON1) {
                            //check if the tile hasn't been opened
                            if (tile.getText() == "") {
                                if(tilesClicked==0){ //check to prevent the player click the bomb at the first move
                                    if(mineList.contains(tile)){ //if the first click is the bomb so set the new Mine
                                        setMines();
                                    }
                                }
                                //check if the tile has mine in
                                if (mineList.contains(tile)) {
                                    revealMines();
                                }
                                //if the clicked tile doesn't contain mine, check for mines around it
                                else {
                                    checkMine(tile.r, tile.c);
                                }
                            }
                        }

                        //right click
                        else if (e.getButton() == MouseEvent.BUTTON3) {
                            //sets flag, if the tile is opened, cannot set flag on it, also remove the flag on it
                            if (tile.getText() == "" && tile.isEnabled()) {
                                tile.setText("🚩");
                            }

                            //undo setting flag
                            else if (tile.getText() == "🚩") {
                                tile.setText("");
                            }
                        }

                    }
                });
                boardPanel.add(tile);

            }
        }

    }
    void play(){
        setMines();
        frame.setVisible(true);
    }

    void setMines() {
        mineList = new ArrayList<MineTile>();


        int mineLeft = mineCount;
        while (mineLeft > 0) {
            int r = random.nextInt(numRows); //0-7
            int c = random.nextInt(numCols);

            MineTile tile = board[r][c];
            if (!mineList.contains(tile)) {
                mineList.add(tile);
                mineLeft -= 1;
            }
        }
    }

    //iterate through the arraylist containing all tiles with mine, then set mine
    void revealMines(){
        for (MineTile tile : mineList) {
            tile.setText("💣");
        }

        gameOver=true;//this is triggered only if revealMines method is called
        textLabel.setText("Game Over");//set the notification
    }

    void checkMine(int r, int c) {
        //base case 1: check if the tiles is in the boundary of the board
        if (r < 0 || r >= numRows || c < 0 || c >= numCols){
            return;}

        MineTile tile = board[r][c];

        //base case 2: if the tile is clicked, that means it is disabled, so stop when it reaches an opened tile
        if (!tile.isEnabled()) {
            return;
        }
        //make the checked mine unable to click again
        tile.setEnabled(false);
        tilesClicked += 1;

        int minesFound = 0;

        //top 3
        minesFound += countMine(r-1, c-1); //top left
        minesFound += countMine(r-1, c); //top
        minesFound += countMine(r-1, c+1); //top right

        //left and right
        minesFound += countMine(r, c - 1); //left
        minesFound += countMine(r, c + 1); //right

        //bottom 3
        minesFound += countMine(r + 1, c - 1); //bottom left
        minesFound += countMine(r + 1, c); //bottom
        minesFound += countMine(r + 1, c + 1); //bottom right

        if (minesFound > 0) {
            //sets the text inside tile = number of mines around it
            tile.setText(Integer.toString(minesFound));
        }
        else {
            //if there's no mines around, the tile is empty
            tile.setText("");

            //recursion part to check mine
            //top 3
            checkMine(r - 1, c - 1);
            checkMine(r - 1, c);
            checkMine(r - 1, c + 1);

            //left and right
            checkMine(r, c - 1);
            checkMine(r, c + 1);

            //bottom
            checkMine(r + 1, c - 1);
            checkMine(r + 1, c);
            checkMine(r + 1, c + 1);
        }

        if (tilesClicked == numRows * numCols - mineList.size()) {
            gameOver = true;
            textLabel.setText("Mines Cleared!");
        }
    }

    int countMine(int r, int c) {
        //check if the tile is in the boundary of the board
        if (r < 0 || r >= numRows || c < 0 || c >= numCols)
            return 0;
        //check if the tile has mine, then return 1
        if (mineList.contains(board[r][c]))
            return 1;
        return 0;

    }

}


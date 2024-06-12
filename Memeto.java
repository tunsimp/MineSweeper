public class Memeto {
    private MineTile[][] boardState;
    private int tileClickedState;
    private boolean gameOverState;
    public Memeto(MineTile[][] inputBoardState, int tileClickedState, boolean gameOverState){
        this.tileClickedState=tileClickedState;
        this.gameOverState=gameOverState;
        this.boardState=new MineTile[inputBoardState.length][];
        for(int r=0;r<inputBoardState.length;r++){
            this.boardState[r]=new MineTile[inputBoardState[r].length];
            for(int c=0;c<inputBoardState[r].length;c++){
                this.boardState[r][c]=new MineTile(r,c);
                this.boardState[r][c].setText(inputBoardState[r][c].getText());
                this.boardState[r][c].setEnabled(inputBoardState[r][c].isEnabled());
            }
        }
    }

    public int getTileClickedState() {
        return tileClickedState;
    }

    public MineTile[][] getBoardState() {
        return boardState;
    }

    public boolean isGameOverState() {
        return gameOverState;
    }
}

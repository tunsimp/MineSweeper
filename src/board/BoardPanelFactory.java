package src.board;

import src.ui.MineSweeperFrame;

public class BoardPanelFactory implements IBoardPanel {
    private final MineSweeperFrame mineSweeperFrame;

    public BoardPanelFactory(MineSweeperFrame mineSweeperFrame) {
        this.mineSweeperFrame = mineSweeperFrame;
    }

    @Override
    public BoardPanel createBoardPanel(int level) {
        switch (level) {
            case 1:
                return new BoardPanel(this.mineSweeperFrame, 8, 8, 10,level,3);
            case 2:
                return new BoardPanel(this.mineSweeperFrame, 15, 15, 40,level,2);
            case 3:
                return new BoardPanel(this.mineSweeperFrame, 16, 30, 99,level,1);
            default:
                throw new IllegalArgumentException("Invalid difficulty level: " + level);
        }
    }
}

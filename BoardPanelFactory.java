public class BoardPanelFactory implements IBoardPanel {
    private final MineSweeperFrame mineSweeperFrame;

    public BoardPanelFactory(MineSweeperFrame mineSweeperFrame) {
        this.mineSweeperFrame = mineSweeperFrame;
    }

    @Override
    public BoardPanel createBoardPanel(int level) {
        switch (level) {
            case 1:
                return new BoardPanel(this.mineSweeperFrame, 8, 8, 10,level);
            case 2:
                return new BoardPanel(this.mineSweeperFrame, 12, 12, 20,level);
            case 3:
                return new BoardPanel(this.mineSweeperFrame, 16, 16, 40,level);
            default:
                throw new IllegalArgumentException("Invalid difficulty level: " + level);
        }
    }
}

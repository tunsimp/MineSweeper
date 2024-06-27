package src.main;

import src.ui.MineSweeperFrame;

public class App {
    public static void main(String[] args) {
        MineSweeperFrame mineSweeperFrame = MineSweeperFrame.getInstance();
        mineSweeperFrame.play();
    }
}

import javax.swing.*;

public class MineTile extends JButton {
    int r;
    int c;

    public MineTile(int r, int c) {
        //passes in row & col numbers and assigns them to the member variables
        this.r = r;
        this.c = c;
    }
}
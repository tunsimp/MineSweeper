import javax.swing.*;
import java.awt.*;

public class MineTile extends JButton {
    int r;
    int c;

    public MineTile(int r, int c) {
        //passes in row & col numbers and assigns them to the member variables
        this.r = r;
        this.c = c;
        setFocusable(false);
        setMargin(new Insets(0, 0, 0, 0));
        setFont(new Font("Arial Unicode MS", Font.PLAIN, 30));
        setPreferredSize(new Dimension(40, 40));
    }
}
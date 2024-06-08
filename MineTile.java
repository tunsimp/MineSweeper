import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MineTile extends JButton {
    int r;
    int c;

    public MineTile(int r, int c) {
        //passes in row & col numbers and assigns them to the member variables
        this.r = r;
        this.c = c;

        setFocusable(false);
        setMargin(new Insets(0, 0, 0, 0));
        setFont(new Font("Arial Unicode MS", Font.PLAIN, 25));
        setPreferredSize(new Dimension(35,35));

    }
}
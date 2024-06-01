import java.awt.*;
import javax.swing.*;

public class TextPanel extends JPanel{
    private JLabel textLabel;

    public TextPanel(){
        setLayout(new BorderLayout());

        textLabel = new JLabel();
        textLabel.setFont(new Font("Cambria", Font.BOLD, 25));
        textLabel.setHorizontalAlignment(JLabel.CENTER);
        textLabel.setOpaque(false);

        add(textLabel,BorderLayout.CENTER);
    }

    public void setTextLabel(String text){
        textLabel.setText(text);
    }

    public JLabel getTextLabel(){
        return textLabel;
    }
}

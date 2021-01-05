package Assignment2.Shapes;

import Assignment2.Constants;

import javax.swing.*;
import java.awt.*;

public abstract class Shape {

    public abstract void draw(JPanel main);

    public JLabel makeLabel(Color colour) {
        JLabel label = new JLabel();
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setPreferredSize(new Dimension(Constants.GRID_WIDTH, Constants.GRID_HEIGHT));
        label.setBackground(colour);
        label.setOpaque(true);
        label.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));
        return label;
    }
}

package Assignment2.Shapes;

import Assignment2.Constants;

import javax.swing.*;
import java.awt.*;

public abstract class Shape {

    /**
     * abstract void draw()
     * Abstract method that all sub-classes should implement
     *
     * @param main - JPanel to be drawn to
     */
    public abstract void draw(JPanel main);

    /**
     * JLabel makeLabel()
     * Default implementation of the makeLabel method
     * Improves re-usability of code
     *
     * @param colour - Colour for the label
     * @return - Styled JLabel
     */
    public JLabel makeLabel(Color colour) {
        JLabel label = new JLabel();
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setPreferredSize(new Dimension(Constants.GRID_WIDTH, Constants.GRID_HEIGHT));
        label.setBackground(colour);
        label.setOpaque(true);
//        label.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));
        return label;
    }
}

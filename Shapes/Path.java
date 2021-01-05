package Assignment2.Shapes;

import Assignment2.Constants;

import javax.swing.*;
import java.awt.*;

public class Path extends Shape {
    final Color COLOUR = Color.WHITE;

    @Override
    public void draw(JPanel main) {
        main.add(makeLabel(Constants.PATH_COLOUR));
    }
}

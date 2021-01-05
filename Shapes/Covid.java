package Assignment2.Shapes;

import Assignment2.Constants;

import javax.swing.*;

public class Covid extends Shape {

    @Override
    public void draw(JPanel main) {
        main.add(makeLabel(Constants.ZOMBIE_COLOUR));
    }
}

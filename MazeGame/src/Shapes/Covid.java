package Shapes;

import javax.swing.*;

import Configuration.Constants;

public class Covid extends Shape {
    @Override
    public void draw(JPanel main) {
        main.add(makeLabel(Constants.ZOMBIE_COLOUR));
    }
}

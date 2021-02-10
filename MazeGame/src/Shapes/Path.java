package Shapes;

import javax.swing.*;

import Configuration.Constants;

public class Path extends Shape {
    @Override
    public void draw(JPanel main) {
        main.add(makeLabel(Constants.PATH_COLOUR));
    }
}

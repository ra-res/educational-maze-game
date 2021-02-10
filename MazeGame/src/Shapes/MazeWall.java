package Shapes;

import javax.swing.*;

import Configuration.Constants;

public class MazeWall extends Shape {
    @Override
    public void draw(JPanel main) {
        main.add(makeLabel(Constants.WALL_COLOUR));
    }
}
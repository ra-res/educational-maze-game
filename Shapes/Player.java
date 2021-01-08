package Assignment2.Shapes;

import Assignment2.Constants;

import javax.swing.*;

public class Player extends Shape {
    @Override
    public void draw(JPanel main) {
        main.add(makeLabel(Constants.PLAYER_COLOUR));
    }
}

package Shapes;

import javax.swing.*;

import Configuration.Constants;

public class Player extends Shape {
    @Override
    public void draw(JPanel main) {
        main.add(makeLabel(Constants.PLAYER_COLOUR));
    }
}

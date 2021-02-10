package Shapes;

import javax.swing.*;

import Configuration.Constants;

public class EscapeGate extends Shape {
    @Override
    public void draw(JPanel main) {
        main.add(makeLabel(Constants.GATE_COLOUR));
    }
}
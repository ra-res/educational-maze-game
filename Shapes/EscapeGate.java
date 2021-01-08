package Assignment2.Shapes;

import Assignment2.Constants;

import javax.swing.*;

public class EscapeGate extends Shape {
    @Override
    public void draw(JPanel main) {
        main.add(makeLabel(Constants.GATE_COLOUR));
    }
}

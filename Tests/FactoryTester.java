package Assignment2.Tests;

import Assignment2.Constants;
import Assignment2.Game.Maze;

import javax.swing.*;
import java.awt.*;

public class FactoryTester extends JFrame {
    public FactoryTester() {
        Maze maze = new Maze();
        JPanel grid_panel = new JPanel(new GridLayout(maze.getMazeRow(), maze.getMazeCol()));
        maze.draw(grid_panel);

        add(grid_panel);
        pack();
        setSize(new Dimension(Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new FactoryTester();
    }
}


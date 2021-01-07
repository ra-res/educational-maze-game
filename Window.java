package Assignment2;

import Assignment2.Game.Maze;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
    JPanel mazePanel;
    JPanel score;
    Maze maze;

    public Window() {
        maze = new Maze();
        setLayout(new BorderLayout());
        initLifeBar();
        initMazePanel();
        addKeyListener(new KeyboardListener(this, maze));
        pack();
        setMinimumSize(new Dimension(Constants.WINDOW_WIDTH_MIN, Constants.WINDOW_HEIGHT_MIN));
        setSize(new Dimension(Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void initLifeBar() {
        score = new JPanel();
        score.add(new JLabel("Health"));
        score.setBackground(Color.GREEN);
//        score.setSize(new Dimension(100, Constants.WINDOW_HEIGHT - 500));
        add(score, BorderLayout.NORTH);
    }

    public void initMazePanel() {
        mazePanel = new JPanel(new GridLayout(maze.getMazeRow(), maze.getMazeCol()));
        maze.draw(mazePanel);
        add(mazePanel, BorderLayout.CENTER);
    }

    public void resetMazePanel() {
        remove(mazePanel);
        initMazePanel();
        revalidate();
        repaint();
    }

    public static void main(String[] args) {
        new Window();
    }
}

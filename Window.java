package Assignment2;

import Assignment2.Game.Maze;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
    JPanel mainPanel;
    JPanel score;
    JPanel gameLostPanel;
    Maze maze;
    KeyboardListener keyboardListener;

    public Window() {
        maze = new Maze();
        keyboardListener = new KeyboardListener(this, maze);
        addKeyListener(keyboardListener);
        setLayout(new BorderLayout());
        initMazePanel();
        pack();
        setMinimumSize(new Dimension(Constants.WINDOW_WIDTH_MIN, Constants.WINDOW_HEIGHT_MIN));
        setSize(new Dimension(Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void initMazePanel() {
        mainPanel = new JPanel(new GridLayout(maze.getMazeRow(), maze.getMazeCol()));
        maze.draw(mainPanel);
        add(mainPanel, BorderLayout.CENTER);
    }

    public void resetMazePanel() {
        remove(mainPanel);
        initMazePanel();
        revalidate();
        repaint();
    }

    public void gameLostScreen() {
        remove(mainPanel);
        removeKeyListener(keyboardListener);
        mainPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        mainPanel.setBackground(Color.BLACK);
        JLabel label = new JLabel("YOU LOST");
        label.setFont(new Font("Serif", Font.BOLD, 45));
        label.setForeground(Color.WHITE);
        mainPanel.add(label);
        add(mainPanel);
        revalidate();
        repaint();
    }

    public static void main(String[] args) {
        new Window();
    }
}

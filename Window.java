package Assignment2;

import Assignment2.ActionListeners.KeyboardListener;
import Assignment2.ActionListeners.MouseClickListener;
import Assignment2.Game.Maze;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;

public class Window extends JFrame {
    private JPanel mainPanel;
    private final Maze maze;
    private final KeyboardListener keyboardListener;
    private final MouseClickListener mouseClickListener;
    private boolean isKeyListenerOn = false;
    JButton startGameButton;

    public Window() {
        maze = new Maze();
        keyboardListener = new KeyboardListener(this, maze);
        mouseClickListener = new MouseClickListener(this);
        init();
    }

    public void init() {
        setLayout(new BorderLayout());
        initWelcomeScreen();
        pack();
        setMinimumSize(new Dimension(Constants.WINDOW_WIDTH_MIN, Constants.WINDOW_HEIGHT_MIN));
        setSize(new Dimension(Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void initWelcomeScreen() {
        mainPanel = new JPanel(new GridLayout(10, 1));
        addLabels(mainPanel, new String[]{"Welcome to the game!!!",
                "Rules:",
                "Stay away from Covid Patients",
                "If a Covid Patient touches you, you lose.",
                "Finish the maze to win!",
        });

        startGameButton = styleStartGameButton(new JButton("Start Game"));
        new JButton("Start Game");
        startGameButton.addMouseListener(mouseClickListener);
        mainPanel.add(startGameButton);
        mainPanel.setBackground(Constants.PANEL_BACKGROUND_COLOUR);
        add(mainPanel);
    }

    public JButton styleStartGameButton(JButton startGameButton) {
        startGameButton.setFocusable(false);
        startGameButton.setBackground(Constants.WALL_COLOUR);
        startGameButton.setForeground(Constants.PANEL_BACKGROUND_COLOUR);
        Border line = new LineBorder(Color.BLACK);
        Border margin = new EmptyBorder(5, 15, 5, 15);
        Border compound = new CompoundBorder(line, margin);
        startGameButton.setBorder(compound);
        return startGameButton;
    }

    public void addLabels(JPanel panel, String[] str) {
        for (String s : str) {
            panel.add(styleLabel(new JLabel(s), Constants.FONT_COLOUR));
        }
    }

    public JLabel styleLabel(JLabel label, Color JLabelColor) {
        label.setFont(Constants.FONT);
        label.setForeground(JLabelColor);
        return label;
    }

    public void initMazePanel() {
        if (mainPanel != null) {
            remove(mainPanel);
        }
        if (!isKeyListenerOn) {
            addKeyListener(keyboardListener);
            isKeyListenerOn = true;
        }
        mainPanel = new JPanel(new GridLayout(maze.getMazeRow(), maze.getMazeCol()));
        maze.draw(mainPanel);
        add(mainPanel, BorderLayout.CENTER);
        revalidate();
        repaint();
    }

    public void gameLostPanel(String exceptionMessage) {
        endGameScreen(exceptionMessage);
    }

    public void gameWonScreen(String exceptionMessage) {
        endGameScreen(exceptionMessage);
    }

    public void endGameScreen(String endGameMessage) {
        remove(mainPanel);
        removeKeyListener(keyboardListener);
        mainPanel = new JPanel(new GridLayout(9, 1));
        mainPanel.setBackground(Constants.PANEL_BACKGROUND_COLOUR);
        JLabel label = styleLabel(new JLabel(
                String.format(
                        "<html><div style=\"width:%dpx;\">%s</div></html>",
                        Constants.WINDOW_WIDTH_MIN,
                        endGameMessage
                )), Constants.FONT_COLOUR);
        mainPanel.add(label);

        int[] topScores = Constants.SCORE_MANAGER.getTopNScores(5);
        mainPanel.add(styleLabel(new JLabel("TOP SCORES"), Color.YELLOW));
        int counter = 1;
        for (int score : topScores) {
            mainPanel.add(styleLabel(new JLabel(String.format("%d)   %d", counter++, score)), Color.WHITE));
        }

        add(mainPanel);
        revalidate();
        repaint();
    }


    public static void main(String[] args) {
        new Window();
    }

}

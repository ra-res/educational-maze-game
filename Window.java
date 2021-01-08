package Assignment2;

import Assignment2.Game.Maze;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {

    private JPanel mainPanel;
    //    JPanel[] panels = new JPanel[]{mainPanel, welcomePanel, gameLostPanel};
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
        mainPanel = new JPanel();
        addLabels(mainPanel, new String[]{"Welcome to the game!!!",
                "Rules:",
                "Stay away from Covid Patients",
                "(Green squares)",
                "If a Covid Patient touches you, you lose.",
                "Finish the maze to win!",
        });

        startGameButton = new JButton("Start Game");
        startGameButton.setFocusable(false);
        startGameButton.addMouseListener(mouseClickListener);
        mainPanel.add(startGameButton);
        mainPanel.setBackground(Color.BLACK);
        add(mainPanel);
    }

    public void addLabels(JPanel panel, String[] str) {
        for (String s : str) {
            panel.add(styleLabel(new JLabel(s)));
        }
    }

    public JLabel styleLabel(JLabel label) {
        label.setFont(Constants.FONT);
        label.setForeground(Color.BLUE);
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

    public void gameLostPanel() {
        remove(mainPanel);
        removeKeyListener(keyboardListener);
        mainPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        mainPanel.setBackground(Color.BLACK);
        JLabel label = styleLabel(new JLabel("YOU LOST"));
        mainPanel.add(label);
        add(mainPanel);
        revalidate();
        repaint();
    }

    public static void main(String[] args) {
        new Window();
    }
}

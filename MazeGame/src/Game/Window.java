package Game;

import ActionListeners.KeyboardListener;
import ActionListeners.MouseClickListener;
import Configuration.Constants;
import Exceptions.PlayerWonException;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.*;

public class Window extends JFrame {
    private JPanel mainPanel;
    private JPanel gameDataPanel;
    private final Maze maze;
    private final KeyboardListener keyboardListener;
    private final MouseClickListener mouseClickListener;
    private boolean isKeyListenerOn = false;
    JButton startGameButton;

    /**
     * public Window() Constructor for Window class Initialises Maze and the
     * listener classes
     */
    public Window() {
        maze = new Maze();
        keyboardListener = new KeyboardListener(this, maze);
        mouseClickListener = new MouseClickListener(this);
        init();
    }

    /**
     * void init() Configuration method for the JFrame
     */
    public void init() {
        setTitle("1904362");
        setLayout(new BorderLayout());
        initWelcomeScreen();
        pack();
        setMinimumSize(new Dimension(Constants.WINDOW_WIDTH_MIN, Constants.WINDOW_HEIGHT_MIN));
        setSize(new Dimension(Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    /**
     * void initWelcomeScreen() Content for the welcome screen of the game Creates a
     * button and adds a listener to it
     */
    public void initWelcomeScreen() {
        mainPanel = new JPanel(new GridLayout(10, 1));
        addLabels(mainPanel,
                new String[] { "Hello World!", "Socially distance yourself", "from other people (green square).",
                        "You lose if you get too close.", "Keep mask on!",
                        "Taking mask off will increase virus spread.", "Finish the maze to win!", });

        startGameButton = styleStartGameButton(new JButton("Start Game"));
        new JButton("Start Game");
        startGameButton.addMouseListener(mouseClickListener);
        mainPanel.add(startGameButton);
        mainPanel.setBackground(Constants.PANEL_BACKGROUND_COLOUR);
        add(mainPanel);
    }

    /**
     * JButton styleStartGameButton() Styles a button passed as argument
     *
     * @param startGameButton - Button to be styled
     * @return - styled JButton
     */
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

    /**
     * void addLabels() Loops through an array of string. For every string it
     * creates a label and adds it to the panel
     *
     * @param panel -JPanel to add labels to
     * @param str   - String on the label
     */
    public void addLabels(JPanel panel, String[] str) {
        for (String s : str) {
            panel.add(styleLabel(new JLabel(s), Constants.FONT_COLOUR));
        }
    }

    /**
     * JLabel styleLabel() Styles a label passed as argument
     *
     * @param label        - JLabel to be styles
     * @param JLabelColour - Colour for the label
     * @return - styles JLabel
     */
    public JLabel styleLabel(JLabel label, Color JLabelColour) {
        label.setFont(Constants.FONT);
        label.setForeground(JLabelColour);
        return label;
    }

    /**
     * void initMazePanel() Creates a JPanel Calls the Maze.draw() method Adds
     * JPanel to JFrame
     */
    public void initMazePanel() {
        if (mainPanel != null) {
            remove(mainPanel);
        }
        if (gameDataPanel != null) {
            remove(gameDataPanel);
        }
        if (!isKeyListenerOn) {
            addKeyListener(keyboardListener);
            isKeyListenerOn = true;
        }
        mainPanel = new JPanel(new GridLayout(maze.getMazeRow(), maze.getMazeCol()));
        maze.draw(mainPanel);
        initTopLayout();
        add(mainPanel, BorderLayout.CENTER);
        revalidate();
        repaint();
    }

    /**
     * void initTopLayout() Draws a layout that can be clicked Clicking this will
     * add game objects on the map arbitrarily;
     */
    void initTopLayout() {
        String warning = "Keep mask ON to prevent the virus from spreading!!";
        String mask = String.format("MASK ON: %b", Constants.MASK_ON);

        if (gameDataPanel != null) {
            remove(gameDataPanel);
        }

        gameDataPanel = new JPanel(new GridLayout(2, 1));
        Color backgroundColour = Constants.MASK_ON ? Color.GREEN : Color.RED;
        gameDataPanel.setBackground(backgroundColour);
        JLabel warningLabel = new JLabel(warning);
        warningLabel.setHorizontalAlignment(JLabel.CENTER);
        JLabel maskLabel = new JLabel(mask);
        maskLabel.setHorizontalAlignment(JLabel.CENTER);
        gameDataPanel.add(warningLabel);
        gameDataPanel.add(maskLabel);
        gameDataPanel.setFocusable(false);
        gameDataPanel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Constants.MASK_ON = !Constants.MASK_ON;
                if (!Constants.MASK_ON) {
                    maze.addCovid();
                    initMazePanel();
                }
                initTopLayout();
                revalidate();
                repaint();
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
        add(gameDataPanel, BorderLayout.NORTH);
    }

    /**
     * void gameLostPanel() Screen shown when game was lost.
     *
     * @param exceptionMessage - message to be displayed on screen
     * @param runtimeException - passing the exception down allows to identify
     *                         whether player won or lost
     */
    public void gameLostPanel(String exceptionMessage, RuntimeException runtimeException) {
        endGameScreen(exceptionMessage, runtimeException);
    }

    /**
     * void gameWonScreen() Screen shown when game was won.
     *
     * @param exceptionMessage - message to be displayed on screen
     * @param runtimeException - passing the exception down allows to identify
     *                         whether player won or lost
     */
    public void gameWonScreen(String exceptionMessage, RuntimeException runtimeException) {
        endGameScreen(exceptionMessage, runtimeException);
    }

    /**
     * void endGameScreen() Configures the end screen Draws the scores to the screen
     *
     * @param endGameMessage   - message to be displayed on screen
     * @param runtimeException - passing the exception down allows to identify
     *                         whether player won or lost
     */
    public void endGameScreen(String endGameMessage, RuntimeException runtimeException) {
        remove(gameDataPanel);
        remove(mainPanel);
        removeKeyListener(keyboardListener);
        mainPanel = new JPanel(new GridLayout(9, 1));
        mainPanel.setBackground(Constants.PANEL_BACKGROUND_COLOUR);
        JLabel label = styleLabel(new JLabel(String.format("<html><div style=\"width:%dpx;\">%s</div></html>",
                Constants.WINDOW_WIDTH_MIN, endGameMessage)), Constants.FONT_COLOUR);
        mainPanel.add(label);

        int[] topScores = Constants.SCORE_MANAGER.getTopNScores(5);
        mainPanel.add(styleLabel(new JLabel("TOP SCORES"), Color.YELLOW));
        int counter = 1;
        boolean labeled = false;
        // if (!isNull(topScores)) {
        if (topScores != null) {
            for (int score : topScores) {
                if (score == Constants.TIMER.getTimeInMilliseconds() && !labeled
                        && runtimeException instanceof PlayerWonException) {
                    mainPanel.add(
                            styleLabel(new JLabel(String.format("%d)   %d seconds <-  your score", counter++, score)),
                                    Color.YELLOW));
                    labeled = true;
                } else {
                    mainPanel.add(
                            styleLabel(new JLabel(String.format("%d)   %d seconds", counter++, score)), Color.WHITE));
                }
            }
        } else {
            mainPanel.add(styleLabel(new JLabel("No scores available yet"), Color.WHITE));
        }

        add(mainPanel);
        revalidate();
        repaint();
    }
}

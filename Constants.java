package Assignment2;

import Assignment2.Shapes.ShapeFactory;

import java.awt.*;

/**
 * Class Constants is used to store public final variables
 * Mostly used for the configuration side of the game (like a settings panel)
 * Allows to easily edit the different aspects of the game such as colour theme etc
 */
public class Constants {
    static public final String SCORE_PATH = "score.txt";
    static public final ShapeFactory SHAPE_FACTORY = new ShapeFactory();
    static public final ScoreManager SCORE_MANAGER = new ScoreManager();

    static public final int WINDOW_WIDTH = 1920 / 2;
    static public final int WINDOW_HEIGHT = 1920 / 2;
    static public final int WINDOW_WIDTH_MIN = 1920 / 3;
    static public final int WINDOW_HEIGHT_MIN = 1920 / 3;
    static public final int GRID_WIDTH = 20;
    static public final int GRID_HEIGHT = 20;
    static public final Font FONT = new Font("Courier", Font.PLAIN, 45);
    static public final String GAME_WON_MESSAGE = "Congratulations, you WON!";
    static public final String GAME_LOST_MESSAGE = "Unfortunately, you LOST!";
    static public final Color FONT_COLOUR = Color.decode("#00cc00");
    static public final Color PANEL_BACKGROUND_COLOUR = Color.decode("#0f0f23");

    static public final Color WALL_COLOUR = Color.decode("#5bac6c");
    static public final Color ZOMBIE_COLOUR = Color.decode("#00cc00");
    static public final Color PLAYER_COLOUR = Color.BLUE;
    static public final Color PATH_COLOUR = Color.BLACK;
    static public final Color GATE_COLOUR = Color.YELLOW;

    static public final char[][] INITIAL_MAZE_CONFIG = new char[][]
            {{'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},
                    {'#', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', '#'},
                    {'#', ' ', ' ', 'C', ' ', ' ', '#', ' ', ' ', 'C', ' ', ' ', '#', ' ', ' ', 'C', ' ', ' ', '#'},
                    {'#', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', '#'},
                    {'#', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', '#', ' ', ' ', '#'},
                    {'#', ' ', ' ', '#', ' ', ' ', '#', ' ', ' ', '#', ' ', ' ', '#', ' ', ' ', '#', ' ', ' ', '#'},
                    {'#', ' ', ' ', '#', ' ', ' ', '#', ' ', ' ', '#', ' ', ' ', '#', ' ', ' ', '#', ' ', ' ', '#'},
                    {'#', ' ', ' ', '#', ' ', ' ', '#', ' ', '#', '#', ' ', ' ', '#', ' ', ' ', '#', ' ', ' ', '#'},
                    {'#', ' ', ' ', '#', ' ', ' ', '#', ' ', ' ', '#', ' ', ' ', '#', ' ', ' ', '#', ' ', ' ', '#'},
                    {'#', ' ', ' ', '#', ' ', ' ', '#', ' ', ' ', '#', ' ', ' ', '#', ' ', '#', '#', '#', ' ', '#'},
                    {'#', ' ', ' ', '#', ' ', ' ', '#', ' ', ' ', '#', ' ', ' ', '#', ' ', ' ', '#', ' ', ' ', '#'},
                    {'#', ' ', ' ', '#', ' ', ' ', '#', ' ', ' ', '#', '#', ' ', '#', ' ', ' ', '#', ' ', ' ', '#'},
                    {'#', ' ', ' ', '#', ' ', ' ', '#', ' ', ' ', '#', ' ', ' ', '#', ' ', ' ', '#', ' ', ' ', '#'},
                    {'#', ' ', ' ', '#', ' ', '#', '#', ' ', ' ', '#', ' ', ' ', '#', ' ', ' ', '#', ' ', ' ', '#'},
                    {'#', ' ', ' ', '#', ' ', ' ', '#', ' ', ' ', '#', ' ', ' ', '#', ' ', ' ', '#', ' ', ' ', '#'},
                    {'#', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', '#'},
                    {'#', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', '#'},
                    {'#', ' ', ' ', '#', ' ', ' ', 'C', ' ', ' ', '#', ' ', ' ', 'C', ' ', ' ', '#', ' ', ' ', '#'},
                    {'#', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', '#'},
                    {'#', 'X', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', 'G', 'G', '#'},
            };
    ;
    static public final int PLAYER_ROW_START_POSITION = INITIAL_MAZE_CONFIG.length - 1;
    static public final int PLAYER_COL_START_POSITION = 1;

}

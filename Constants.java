package Assignment2;

import Assignment2.Shapes.ShapeFactory;

import java.awt.*;

public class Constants {
    static public final ShapeFactory SHAPE_FACTORY = new ShapeFactory();
    static public final int WINDOW_WIDTH = 1920 / 2;
    static public final int WINDOW_HEIGHT = 1920 / 2;
    static public final int WINDOW_WIDTH_MIN = 1920 / 3;
    static public final int WINDOW_HEIGHT_MIN = 1920 / 3;
    static public final int GRID_WIDTH = 20;
    static public final int GRID_HEIGHT = 20;
    static public final Color WALL_COLOUR = Color.BLACK;
    static public final Color ZOMBIE_COLOUR = Color.GREEN;
    static public final Color PLAYER_COLOUR = Color.BLUE;
    static public final Color PATH_COLOUR = Color.WHITE;
    static public final char[][] INITIAL_MAZE_CONFIG = new char[][]
            {{'#', '#', '#', '#', '#', ' ', ' ', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},
                    {'#', ' ', ' ', ' ', '#', ' ', '#', '#', '#', '#', ' ', ' ', '#', '#', '#', '#', '#'},
                    {'#', '#', ' ', '#', '#', ' ', '#', ' ', ' ', '#', ' ', '#', '#', '#', '#', '#', '#'},
                    {'#', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', '#', '#', '#', '#', '#'},
                    {'#', ' ', '#', ' ', ' ', '#', '#', '#', '#', ' ', '#', '#', '#', '#', '#', '#', '#'},
                    {'#', '#', '#', ' ', '#', 'C', ' ', ' ', ' ', 'C', ' ', ' ', '#', '#', '#', '#', '#'},
                    {'#', ' ', ' ', ' ', ' ', '#', '#', ' ', ' ', '#', '#', '#', '#', '#', '#', '#', '#'},
                    {'#', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', '#', ' ', '#', '#', '#', '#', '#', '#'},
                    {'#', ' ', '#', ' ', ' ', ' ', '#', '#', ' ', ' ', ' ', ' ', '#', '#', '#', '#', '#'},
                    {'#', 'C', '#', '#', ' ', ' ', '#', ' ', '#', ' ', '#', ' ', '#', '#', '#', '#', '#'},
                    {'#', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', 'C', '#', '#', '#', '#', '#', '#', '#'},
                    {'#', ' ', '#', '#', '#', ' ', '#', ' ', '#', ' ', ' ', '#', '#', '#', '#', '#', '#'},
                    {'#', ' ', ' ', ' ', ' ', ' ', '#', ' ', '#', ' ', ' ', ' ', '#', '#', '#', '#', '#'},
                    {'#', ' ', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},
                    {'#', ' ', ' ', ' ', ' ', ' ', '#', ' ', '#', ' ', ' ', ' ', '#', '#', '#', '#', '#'},
                    {'#', ' ', ' ', ' ', ' ', ' ', '#', ' ', '#', ' ', ' ', ' ', '#', '#', '#', '#', '#'},
                    {'#', ' ', ' ', ' ', ' ', ' ', '#', ' ', '#', ' ', ' ', ' ', '#', '#', '#', '#', '#'},
                    {'#', ' ', ' ', ' ', ' ', ' ', '#', ' ', '#', ' ', ' ', ' ', '#', '#', '#', '#', '#'},
                    {'#', ' ', ' ', ' ', ' ', ' ', '#', ' ', '#', ' ', ' ', ' ', '#', '#', '#', '#', '#'},
                    {'#', 'X', ' ', ' ', ' ', ' ', '#', ' ', '#', ' ', ' ', ' ', '#', '#', '#', '#', '#'},
            };
    ;
    static public final int MAZE_ROW_LENGTH = INITIAL_MAZE_CONFIG.length;
    static public final int MAZE_COL_LENGTH = INITIAL_MAZE_CONFIG[0].length;
    static public final int PLAYER_ROW_START_POSITION = INITIAL_MAZE_CONFIG.length - 1;
    static public final int PLAYER_COL_START_POSITION = 1;

}

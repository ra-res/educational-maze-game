package Assignment2.Game;

import Assignment2.Constants;

import javax.swing.*;

public class Maze {

    private char[][] currentMaze;

    private int playerRow;
    private int playerCol;


    public Maze() {
        currentMaze = Constants.INITIAL_MAZE_CONFIG.clone();
        playerRow = Constants.PLAYER_ROW_START_POSITION;
        playerCol = Constants.PLAYER_COL_START_POSITION;

        assert currentMaze != Constants.INITIAL_MAZE_CONFIG;
    }

    public void draw(JPanel main) {
        for (char[] chars : currentMaze) {
            for (char aChar : chars) {
                Constants.SHAPE_FACTORY.getShape(aChar).draw(main);
            }
        }
    }

    public void movePlayerUp() {
        currentMaze[playerRow][playerCol] = ' ';
        currentMaze[--playerRow][playerCol] = 'X';
    }

    public void movePlayerDown() {
        currentMaze[playerRow][playerCol] = ' ';
        currentMaze[++playerRow][playerCol] = 'X';
    }

    public void movePlayerLeft() {
        currentMaze[playerRow][playerCol] = ' ';
        currentMaze[playerRow][--playerCol] = 'X';
    }

    public void movePlayerRight() {
        currentMaze[playerRow][playerCol] = ' ';
        currentMaze[playerRow][++playerCol] = 'X';
    }

    @Override
    public char[][] clone() throws CloneNotSupportedException {
        return (char[][]) super.clone();
    }

    public char[][] getCurrentMaze() {
        return currentMaze;
    }

    public char[][] getInitialMaze() {
        return Constants.INITIAL_MAZE_CONFIG;
    }

    public int getMazeRow() {
        return currentMaze.length;
    }

    public int getMazeCol() {
        return currentMaze.length;
    }

}



package Assignment2.Game;

import Assignment2.Constants;
import Assignment2.Shapes.Covid;
import Assignment2.Shapes.MazeWall;
import Assignment2.Shapes.Shape;

import javax.swing.*;

public class Maze {

    private final Shape[][] currentMaze;
    private int playerRow;
    private int playerCol;


    public Maze() {
        int y = Constants.INITIAL_MAZE_CONFIG.length;
        int x = Constants.INITIAL_MAZE_CONFIG[0].length;

        currentMaze = new Shape[y][x];

        for (int row = 0; row < y; row++) {
            for (int col = 0; col < x; col++) {
                currentMaze[row][col] = Constants.SHAPE_FACTORY.getShape(
                        Constants.INITIAL_MAZE_CONFIG[row][col]
                );
            }
        }
        playerRow = Constants.PLAYER_ROW_START_POSITION;
        playerCol = Constants.PLAYER_COL_START_POSITION;
    }

    public void draw(JPanel main) {
        for (Shape[] shapes : currentMaze) {
            for (Shape shape : shapes) {
                shape.draw(main);
            }
        }
    }

    public boolean inBounds(int row, int col) {
        return (row >= 0 && row <= currentMaze.length && col >= 0 && col <= currentMaze[0].length);
    }

    public boolean checkIfMoveLegal(int row, int col) {
        return !((currentMaze[row][col] instanceof Covid) || (currentMaze[row][col] instanceof MazeWall));
    }

    public void swapPosition(int newRow, int newCol) {
        currentMaze[playerRow][playerCol] = Constants.SHAPE_FACTORY.getShape(' ');
        currentMaze[newRow][newCol] = Constants.SHAPE_FACTORY.getShape('X');
    }

    public void movePlayerUp() {
        try {
            int newRow = playerRow - 1;
            int newCol = playerCol;
            if (inBounds(newRow, newCol) && checkIfMoveLegal(newRow, newCol)) {
                swapPosition(--playerRow, playerCol);
                currentMaze[playerRow][playerCol] = Constants.SHAPE_FACTORY.getShape(' ');
                currentMaze[--playerRow][playerCol] = Constants.SHAPE_FACTORY.getShape('X');
            } else {
                throw new ArrayIndexOutOfBoundsException("out of bounds");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
    }

    public void movePlayerDown() {
        try {
            int newRow = playerRow + 1;
            int newCol = playerCol;
            if (inBounds(newRow, newCol) && checkIfMoveLegal(newRow, newCol)) {
                currentMaze[playerRow][playerCol] = Constants.SHAPE_FACTORY.getShape(' ');
                currentMaze[++playerRow][playerCol] = Constants.SHAPE_FACTORY.getShape('X');
            } else {
                throw new ArrayIndexOutOfBoundsException("out of bounds");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }

    }

    public void movePlayerLeft() {
        try {
            int newRow = playerRow;
            int newCol = playerCol - 1;
            if (inBounds(newRow, newCol) && checkIfMoveLegal(newRow, newCol)) {
                currentMaze[playerRow][playerCol] = Constants.SHAPE_FACTORY.getShape(' ');
                currentMaze[playerRow][--playerCol] = Constants.SHAPE_FACTORY.getShape('X');
            } else {
                throw new ArrayIndexOutOfBoundsException("out of bounds");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
    }

    public void movePlayerRight() {
        try {
            int newRow = playerRow;
            int newCol = playerCol + 1;
            if (inBounds(newRow, newCol) && checkIfMoveLegal(newRow, newCol)) {
                currentMaze[playerRow][playerCol] = Constants.SHAPE_FACTORY.getShape(' ');
                currentMaze[playerRow][++playerCol] = Constants.SHAPE_FACTORY.getShape('X');
            } else {
                throw new ArrayIndexOutOfBoundsException("out of bounds");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public char[][] clone() throws CloneNotSupportedException {
        return (char[][]) super.clone();
    }

    public Shape[][] getCurrentMaze() {
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



package Assignment2.Game;

import Assignment2.Constants;
import Assignment2.Exceptions.CovidInfectionExeption;
import Assignment2.Exceptions.IllegalMoveException;
import Assignment2.Exceptions.PlayerDiedException;
import Assignment2.Exceptions.PlayerWonException;
import Assignment2.Shapes.Covid;
import Assignment2.Shapes.EscapeGate;
import Assignment2.Shapes.MazeWall;
import Assignment2.Shapes.Shape;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;

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

    public int generateRandom() {
        return (int) (Math.random() * 8);
    }

    public void getPossibleMoves(ArrayList<Integer[]> possibleMoves, int row, int col) {
        possibleMoves.add(new Integer[]{row + 1, col});
        possibleMoves.add(new Integer[]{row - 1, col});
        possibleMoves.add(new Integer[]{row, col + 1});
        possibleMoves.add(new Integer[]{row, col - 1});
        possibleMoves.add(new Integer[]{row + 1, col + 1});
        possibleMoves.add(new Integer[]{row - 1, col - 1});
        possibleMoves.add(new Integer[]{row - 1, col + 1});
        possibleMoves.add(new Integer[]{row + 1, col - 1});
    }

    public void randomlyMoveCovid() {
        ArrayList<Integer[]> possibleMoves;
        Integer[] nextMove;
        HashMap<Shape, Integer[]> covid = new HashMap<>();

        for (int row = 0; row < currentMaze.length; row++) {
            for (int col = 0; col < currentMaze[0].length; col++) {
                if (currentMaze[row][col] instanceof Covid) {
                    covid.put(currentMaze[row][col], new Integer[]{row, col});
                }
            }
        }

        for (Shape key : covid.keySet()) {
            Integer[] curCovid = covid.get(key);
            try {
                int curRow = curCovid[0];
                int curCol = curCovid[1];
                possibleMoves = new ArrayList<>();
                getPossibleMoves(possibleMoves, curRow, curCol);
                System.out.println(generateRandom());
                nextMove = possibleMoves.get(generateRandom());
                validateMove(nextMove[0], nextMove[1]);
                if (nextMove[0] == playerRow && nextMove[1] == playerCol) {
                    currentMaze[playerRow][playerCol] = Constants.SHAPE_FACTORY.getShape(' ');
                    currentMaze[curRow][curCol] = Constants.SHAPE_FACTORY.getShape(' ');
                    throw new PlayerDiedException("Player got covid");
                }
                swap(curRow, curCol, nextMove[0], nextMove[1]);
            } catch (
                    IllegalMoveException
                            | IndexOutOfBoundsException
                            | CovidInfectionExeption
                            | PlayerWonException
                            ifExceptionsOccurCovidPatientDoesNotMove) {
            }
        }

    }

    public void validateMove(int row, int col) {
        if (!(row >= 0 && row < currentMaze.length && col >= 0 && col < currentMaze[0].length)) {
            throw new IndexOutOfBoundsException("out of bounds");
        }
        if (currentMaze[row][col] instanceof Covid) {
            throw new CovidInfectionExeption("Covid");
        }
        if (currentMaze[row][col] instanceof MazeWall) {
            throw new IllegalMoveException("Wall");
        }
        if (currentMaze[row][col] instanceof EscapeGate) {
            throw new PlayerWonException("You won!");
        }
    }

    public void movePlayerUp() {
        int newRow = playerRow - 1;
        int newCol = playerCol;
        validateMove(newRow, newCol);
        swap(playerRow, playerCol, newRow, newCol);
        --playerRow;
//        currentMaze[playerRow][playerCol] = Constants.SHAPE_FACTORY.getShape(' ');
//        currentMaze[--playerRow][playerCol] = Constants.SHAPE_FACTORY.getShape('X');
    }

    public void movePlayerDown() throws IllegalMoveException {
        int newRow = playerRow + 1;
        int newCol = playerCol;
        validateMove(newRow, newCol);
        swap(playerRow, playerCol, newRow, newCol);
        ++playerRow;
//        currentMaze[playerRow][playerCol] = Constants.SHAPE_FACTORY.getShape(' ');
//        currentMaze[++playerRow][playerCol] = Constants.SHAPE_FACTORY.getShape('X');
    }

    public void movePlayerLeft() {
        int newRow = playerRow;
        int newCol = playerCol - 1;
        validateMove(newRow, newCol);
        swap(playerRow, playerCol, newRow, newCol);
        --playerCol;
//        currentMaze[playerRow][playerCol] = Constants.SHAPE_FACTORY.getShape(' ');
//        currentMaze[playerRow][--playerCol] = Constants.SHAPE_FACTORY.getShape('X');
    }

    public void movePlayerRight() {
        int newRow = playerRow;
        int newCol = playerCol + 1;
        validateMove(newRow, newCol);
        swap(playerRow, playerCol, newRow, newCol);
        ++playerCol;
//        currentMaze[playerRow][playerCol] = Constants.SHAPE_FACTORY.getShape(' ');
//        currentMaze[playerRow][++playerCol] = Constants.SHAPE_FACTORY.getShape('X');
    }

    public void swap(int row, int col, int newRow, int newCol) {
        Shape temp = currentMaze[row][col];
        currentMaze[row][col] = currentMaze[newRow][newCol];
        currentMaze[newRow][newCol] = temp;
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



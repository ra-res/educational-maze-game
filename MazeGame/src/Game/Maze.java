package Game;

import Exceptions.CovidInfectionException;
import Exceptions.IllegalMoveException;
import Exceptions.PlayerDiedException;
import Exceptions.PlayerWonException;
import Shapes.*;

import javax.swing.*;

import Configuration.Constants;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Class Maze This class holds a collection of game objects Has methods that
 * edits the game objects
 */
public class Maze {
    private final Shape[][] currentMaze;
    private int playerRow;
    private int playerCol;

    /**
     * Constructor Maze Loops through the initial maze configuration stored in
     * Constants class Calls Shape Factory at every iteration generating a game
     * objects It then stores the game object inside the currentMaze 2d array
     */
    public Maze() {
        int y = Constants.INITIAL_MAZE_CONFIG.length;
        int x = Constants.INITIAL_MAZE_CONFIG[0].length;

        currentMaze = new Shape[y][x];

        for (int row = 0; row < y; row++) {
            for (int col = 0; col < x; col++) {
                currentMaze[row][col] = Constants.SHAPE_FACTORY.getShape(Constants.INITIAL_MAZE_CONFIG[row][col]);
            }
        }
        playerRow = Constants.PLAYER_ROW_START_POSITION;
        playerCol = Constants.PLAYER_COL_START_POSITION;
    }

    /**
     * Loops through the currentMaze array At every iteration calls the draw method
     * of every shape
     *
     * @param main - JPanel to be passed down to the draw method of every object
     */
    public void draw(JPanel main) {
        for (Shape[] shapes : currentMaze) {
            for (Shape shape : shapes) {
                shape.draw(main);
            }
        }
    }

    /**
     * int generateRandom() Generates a random number using the Math library
     *
     * @param n - random int from 0 to n exclusive
     * @return - random int between 0-7
     */
    public int generateRandom(int n) {
        return (int) (Math.random() * n);
    }

    /**
     * void getPossibleMoves() Calculates every possible move from a set of
     * coordinates Stores all possible moves inside an array passed as reference
     *
     * @param possibleMoves - ArrayList as reference
     * @param row           - int
     * @param col           - int
     */
    public void getPossibleMoves(ArrayList<Integer[]> possibleMoves, int row, int col) {
        possibleMoves.add(new Integer[] { row + 1, col });
        possibleMoves.add(new Integer[] { row - 1, col });
        possibleMoves.add(new Integer[] { row, col + 1 });
        possibleMoves.add(new Integer[] { row, col - 1 });
        possibleMoves.add(new Integer[] { row + 1, col + 1 });
        possibleMoves.add(new Integer[] { row - 1, col - 1 });
        possibleMoves.add(new Integer[] { row - 1, col + 1 });
        possibleMoves.add(new Integer[] { row + 1, col - 1 });
    }

    /**
     * void addCovid() Randomly Swaps 2 Path instances with 2 Covid instances
     */
    public void addCovid() {
        // if (isNull(currentMaze)) {
        if (currentMaze == null) {
            return;
        }

        ArrayList<Integer[]> paths = new ArrayList<>();
        for (int i = 0; i < currentMaze.length; i++) {
            for (int j = 0; j < currentMaze[0].length; j++) {
                if (currentMaze[i][j] instanceof Path) {
                    paths.add(new Integer[] { i, j });
                }
            }
        }
        for (int newCovid = 0; newCovid < 2; newCovid++) {
            Integer[] cur = paths.get(generateRandom(paths.size()));
            currentMaze[cur[0]][cur[1]] = new Covid();
        }

    }

    /**
     * void randomlyMoveCovid() Randomly moves the covid game objects on the game
     * board. Loops through current maze storing all Covid objects inside a hashmap
     * together with their coordinates. It then loops through the hashmap moving
     * them on the game board.
     */
    public void randomlyMoveCovid() {
        ArrayList<Integer[]> possibleMoves;
        Integer[] nextMove;
        HashMap<Shape, Integer[]> covid = new HashMap<>();

        for (int row = 0; row < currentMaze.length; row++) {
            for (int col = 0; col < currentMaze[0].length; col++) {
                if (currentMaze[row][col] instanceof Covid) {
                    covid.put(currentMaze[row][col], new Integer[] { row, col });
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
                nextMove = possibleMoves.get(generateRandom(8));
                if (currentMaze[nextMove[0]][nextMove[1]] instanceof Covid) {
                    throw new IllegalMoveException("");
                }
                validateMove(nextMove[0], nextMove[1]);
                swap(curRow, curCol, nextMove[0], nextMove[1]);
            } catch (IllegalMoveException | IndexOutOfBoundsException | CovidInfectionException
                    | PlayerWonException ifExceptionsOccurCovidPatientDoesNotMove) {
            }
        }
    }

    /**
     * void validateMove() Validator method used to validate moves on the board.
     * Throws custom exceptions accordingly when a move is illegal.
     *
     * @param row - Y coordinate of the game object to be moved
     * @param col - X coordinate of the game object to be moved
     * @throws IndexOutOfBoundsException - if move is out of bounds
     * @throws IllegalMoveException      - if move is illegal (e.g. player hits a
     *                                   wall)
     * @throws PlayerWonException        - if player finished the maze
     * @throws PlayerDiedException       - if player died
     */
    public void validateMove(int row, int col)
            throws IndexOutOfBoundsException, IllegalMoveException, PlayerWonException, PlayerDiedException {
        if (!(row >= 0 && row < currentMaze.length && col >= 0 && col < currentMaze[0].length)) {
            throw new IndexOutOfBoundsException("");
        }
        if (currentMaze[row][col] instanceof MazeWall) {
            throw new IllegalMoveException("");
        }
        if (currentMaze[row][col] instanceof EscapeGate) {
            throw new PlayerWonException(Constants.GAME_WON_MESSAGE);
        }
        if (currentMaze[row][col] instanceof Player) {
            throw new PlayerDiedException(Constants.GAME_LOST_MESSAGE);
        }
        if (currentMaze[row][col] instanceof Covid) {
            throw new PlayerDiedException(Constants.GAME_LOST_MESSAGE);
        }
    }

    /**
     * void movePlayerUp() Stores the potential new coordinate of the player It
     * validates the move If valid, calls the swap method an updates the player's
     * position
     */
    public void movePlayerUp() {
        int newRow = playerRow - 1;
        int newCol = playerCol;
        validateMove(newRow, newCol);
        swap(playerRow, playerCol, newRow, newCol);
        --playerRow;
    }

    /**
     * void movePlayerDown() Stores the potential new coordinate of the player It
     * validates the move If valid, calls the swap method an updates the player's
     * position
     */
    public void movePlayerDown() {
        int newRow = playerRow + 1;
        int newCol = playerCol;
        validateMove(newRow, newCol);
        swap(playerRow, playerCol, newRow, newCol);
        ++playerRow;
    }

    /**
     * void movePlayerLeft() Stores the potential new coordinate of the player It
     * validates the move If valid, calls the swap method an updates the player's
     * position
     */
    public void movePlayerLeft() {
        int newRow = playerRow;
        int newCol = playerCol - 1;
        validateMove(newRow, newCol);
        swap(playerRow, playerCol, newRow, newCol);
        --playerCol;
    }

    /**
     * void movePlayerRight() Stores the potential new coordinate of the player It
     * validates the move If valid, calls the swap method an updates the player's
     * position
     */
    public void movePlayerRight() {
        int newRow = playerRow;
        int newCol = playerCol + 1;
        validateMove(newRow, newCol);
        swap(playerRow, playerCol, newRow, newCol);
        ++playerCol;
    }

    /**
     * void swap() Given two set of coordinates, swaps the objects at those
     * coordinates
     *
     * @param row    - current Y coordinate
     * @param col    - current X coordinate
     * @param newRow - new Y coordinate
     * @param newCol - new X coordinate
     */
    public void swap(int row, int col, int newRow, int newCol) {
        Shape temp = currentMaze[row][col];
        currentMaze[row][col] = currentMaze[newRow][newCol];
        currentMaze[newRow][newCol] = temp;
    }

    /**
     * char[][] clone() Overrides the clone method returns a cloned 2d char array
     *
     * @return - cloned char[][]
     * @throws CloneNotSupportedException - if clone is not supported
     */
    @Override
    public char[][] clone() throws CloneNotSupportedException {
        return (char[][]) super.clone();
    }

    /**
     * Shape[][] getCurrentMaze() Getter method
     *
     * @return - current maze configuration
     */
    public Shape[][] getCurrentMaze() {
        return currentMaze;
    }

    /**
     * int getMazeRow()
     *
     * @return - number of rows in the currentMaze array
     */
    public int getMazeRow() {
        return currentMaze.length;
    }

    /**
     * int getMazeCol()
     *
     * @return - number of columns in the currentMaze array
     */
    public int getMazeCol() {
        return currentMaze.length;
    }
}

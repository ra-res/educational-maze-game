package ActionListeners;

import Exceptions.CovidInfectionException;
import Exceptions.IllegalMoveException;
import Exceptions.PlayerDiedException;
import Exceptions.PlayerWonException;
import Game.Maze;
import Game.Window;
import Configuration.Constants;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardListener implements KeyListener {
    Maze maze;
    Window window;

    /**
     * public KeyboardListener Constructor of KeyboardListerner class
     *
     * @param window - Window class that extends JFrame - Allows us to update the
     *               window after a change is made in the game
     * @param maze   - Game configuration class - Gives us access to the methods
     *               that edits the game state
     */
    public KeyboardListener(Window window, Maze maze) {
        this.window = window;
        this.maze = maze;
    }

    /**
     * public void keyPressed Method overrides the KeyListener method keyPressed
     * Listens to a keyboard event and identifies which key it is. Everything is
     * inside a Try/Catch block as exceptions are used for the logic of the game.
     *
     * @param e - Keyboard event
     */
    @Override
    public void keyPressed(KeyEvent e) {
        try {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_UP:
                    maze.movePlayerUp();
                    maze.randomlyMoveCovid();
                    window.initMazePanel();
                    break;
                case KeyEvent.VK_DOWN:
                    maze.movePlayerDown();
                    maze.randomlyMoveCovid();
                    window.initMazePanel();
                    break;
                case KeyEvent.VK_LEFT:
                    maze.movePlayerLeft();
                    maze.randomlyMoveCovid();
                    window.initMazePanel();
                    break;
                case KeyEvent.VK_RIGHT:
                    maze.movePlayerRight();
                    maze.randomlyMoveCovid();
                    window.initMazePanel();
                    break;
                default:
                    break;
            }
        } catch (IllegalMoveException | IndexOutOfBoundsException
                | CovidInfectionException ifExceptionsOccurIgnoreMove) {
            // Empty catch block.
        } catch (PlayerDiedException playerDiedException) {
            Constants.GAME_ROUND.endGame(playerDiedException);
            window.initMazePanel();
            window.gameLostPanel(playerDiedException.getMessage(), playerDiedException);
        } catch (PlayerWonException playerWonException) {
            Constants.GAME_ROUND.endGame(playerWonException);
            window.gameWonScreen(playerWonException.getMessage(), playerWonException);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}

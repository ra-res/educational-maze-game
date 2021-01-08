package Assignment2.ActionListeners;

import Assignment2.Constants;
import Assignment2.Exceptions.CovidInfectionException;
import Assignment2.Exceptions.IllegalMoveException;
import Assignment2.Exceptions.PlayerDiedException;
import Assignment2.Exceptions.PlayerWonException;
import Assignment2.Game.Maze;
import Assignment2.Window;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardListener implements KeyListener {

    Maze maze;
    Window window;

    public KeyboardListener(Window window, Maze maze) {
        this.window = window;
        this.maze = maze;
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

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
        } catch (IllegalMoveException
                | IndexOutOfBoundsException
                | CovidInfectionException
                ifExceptionsOccurIgnoreMove
        ) {

        } catch (PlayerDiedException playerDiedException) {
            window.initMazePanel();
            window.gameLostPanel(playerDiedException.getMessage());
            Constants.SCORE_MANAGER.saveScores();
        } catch (PlayerWonException playerWonException) {
            window.gameWonScreen(playerWonException.getMessage());
            Constants.SCORE_MANAGER.saveScores();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}

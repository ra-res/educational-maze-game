package Assignment2;

import Assignment2.Exceptions.CovidInfectionExeption;
import Assignment2.Exceptions.IllegalMoveException;
import Assignment2.Exceptions.PlayerDiedException;
import Assignment2.Exceptions.PlayerWonException;
import Assignment2.Game.Maze;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.concurrent.TimeUnit;

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
                    System.out.println("pressed key");
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
                case KeyEvent.VK_SPACE:
                    System.out.println("Spacebar");
//                this.game.initialise();
//                this.game.repaint();
//                this.game.revalidate(); // repaints node children, rather than node
                    break;
                default:
                    break;
            }
        } catch (IllegalMoveException
                | IndexOutOfBoundsException
                | CovidInfectionExeption event) {

        } catch (PlayerDiedException event) {
            try {
                window.initMazePanel();
                TimeUnit.SECONDS.sleep(1);
                window.gameLostPanel();
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
        } catch (PlayerWonException event) {
            System.out.println("you won dude");
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}

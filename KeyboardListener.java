package Assignment2;

import Assignment2.Exceptions.CovidInfectionExeption;
import Assignment2.Exceptions.IllegalMoveException;
import Assignment2.Exceptions.PlayerDiedException;
import Assignment2.Game.Maze;

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
                    window.resetMazePanel();
                    break;
                case KeyEvent.VK_DOWN:
                    maze.movePlayerDown();
                    maze.randomlyMoveCovid();
                    window.resetMazePanel();
                    break;
                case KeyEvent.VK_LEFT:
                    maze.movePlayerLeft();
                    maze.randomlyMoveCovid();
                    window.resetMazePanel();
                    break;
                case KeyEvent.VK_RIGHT:
                    maze.movePlayerRight();
                    maze.randomlyMoveCovid();
                    window.resetMazePanel();
                    break;
                case KeyEvent.VK_SPACE:
                    System.out.println("Spacebar");
//                this.game.initialise();
//                this.game.repaint();
//                this.game.revalidate(); // repaints node children, rather than node
                    break;
                default:
                    System.out.println("Other");
                    break;
            }
        } catch (IllegalMoveException event) {
            System.out.println(event.getMessage());
        } catch (IndexOutOfBoundsException event) {
            System.out.println(event.getMessage());
        } catch (CovidInfectionExeption event) {
            System.out.println(event.getMessage());
        } catch (PlayerDiedException event) {
            window.gameLostScreen();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}

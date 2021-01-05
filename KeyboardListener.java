package Assignment2;

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
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                maze.movePlayerUp();
                window.resetMazePanel();
                break;
            case KeyEvent.VK_DOWN:
                maze.movePlayerDown();
                window.resetMazePanel();
                break;
            case KeyEvent.VK_LEFT:
                maze.movePlayerLeft();
                window.resetMazePanel();
                break;
            case KeyEvent.VK_RIGHT:
                maze.movePlayerRight();
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
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}

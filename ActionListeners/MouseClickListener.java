package Assignment2.ActionListeners;

import Assignment2.Window;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseClickListener implements MouseListener {

    Window window;

    /**
     * public MouseClickListener
     * Constructor of MouseClickListener class
     *
     * @param window - Window class that extends JFrame
     *               - Allows us to update the window after a change is made in the game
     */
    public MouseClickListener(Window window) {
        this.window = window;

    }

    /**
     * public void mouseClicked
     * Listens for a button click
     * When the button is clicked the game maze is displayed
     *
     * @param e - mouse event
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        window.initMazePanel();
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}

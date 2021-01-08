package Assignment2.ActionListeners;

import Assignment2.Window;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseClickListener implements MouseListener {

    Window window;

    public MouseClickListener(Window window) {
        this.window = window;

    }

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

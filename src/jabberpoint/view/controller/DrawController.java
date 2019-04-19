package jabberpoint.view.controller;

import jabberpoint.presentation.DrawItem;
import jabberpoint.presentation.Line;
import jabberpoint.presentation.Presentation;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class DrawController implements MouseListener, MouseMotionListener {
    Presentation presentation;
    DrawItem drawItem;
    int startX;
    int startY;
    private final int OFFSET_X = 8;
    private final int OFFSET_Y = 52;

    public DrawController(DrawItem drawItem, Presentation presentation) {
        this.drawItem = drawItem;
        this.presentation = presentation;
    }


    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        startX = e.getX() - OFFSET_X;
        startY = e.getY() - OFFSET_Y;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        startX = -1;
        startY = -1;

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if(startX > 0 && startY > 0) {
            int nowX = e.getX() - OFFSET_X;
            int nowY = e.getY() - OFFSET_Y;
            drawItem.addLine(new Line(startX, startY, nowX, nowY));
            startX = nowX;
            startY = nowY;
            presentation.update();
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}

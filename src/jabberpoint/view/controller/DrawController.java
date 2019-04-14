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

    public DrawController(DrawItem drawItem, Presentation presentation) {
        this.drawItem = drawItem;
        this.presentation = presentation;
    }


    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        startX = e.getX();
        startY = e.getY();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        drawItem.addLine(new Line(startX,startY,e.getX(),e.getY()));
        presentation.update();
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}

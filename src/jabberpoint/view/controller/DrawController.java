package jabberpoint.view.controller;

import jabberpoint.presentation.slideitem.DrawItem;
import jabberpoint.presentation.Line;
import jabberpoint.presentation.Presentation;
import jabberpoint.presentation.slideitem.ItemFactory;
import jabberpoint.presentation.style.LineStyle;

import java.awt.*;
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
    private Color color = Color.black;
    private int lineSize = 0;


    public DrawController(Presentation presentation, Color color, int linesz) {
        this.drawItem = (DrawItem) ItemFactory.getItem(ItemFactory.DRAW,0,null);
        this.presentation = presentation;
        presentation.getCurrentSlide().append(drawItem);
        this.setColor(color);
        this.setLineSize(linesz);
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getLineSize() {
        return lineSize;
    }

    public void setLineSize(int lineSize) {
        this.lineSize = lineSize;
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
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        int nowX = e.getX() - OFFSET_X;
        int nowY = e.getY() - OFFSET_Y;
        LineStyle lineStyle = new LineStyle(getColor(), getLineSize());
        drawItem.addLine(new Line(startX, startY, nowX, nowY, lineStyle));
        startX = nowX;
        startY = nowY;
        presentation.update();
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}

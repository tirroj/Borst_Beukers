package jabberpoint.view.drawer;

import jabberpoint.presentation.DrawItem;
import jabberpoint.presentation.Line;
import jabberpoint.presentation.style.Style;

import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.image.ImageObserver;

public class DrawItemDrawer implements Drawer {
    private DrawItem drawItem;

    public DrawItemDrawer(DrawItem drawItem) {
        this.drawItem = drawItem;
    }

    @Override
    public Rectangle getBoundingBox(Graphics g, ImageObserver observer, float scale, Style myStyle) {
        return new Rectangle(0,0,800,600);
    }

    @Override
    public void draw(int x, int y, float scale, Graphics g, Style myStyle, ImageObserver o) {
        Graphics2D graphic2D = (Graphics2D) g;

        Color color = Color.black; // kleur, later uit line
        graphic2D.setPaint(color);
        graphic2D.setStroke(new BasicStroke(2)); // hoe dik, later uit line

        //Enable antialiasing
        RenderingHints rh = new RenderingHints(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        graphic2D.setRenderingHints(rh);

        for (Line line :drawItem.getLines()) {
            graphic2D.drawLine(line.getStartX(), line.getStartY() , line.getEndX(), line.getEndY());
        }

    }
}

package jabberpoint.view.drawer;

import jabberpoint.presentation.DrawItem;
import jabberpoint.presentation.Line;
import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.image.ImageObserver;

public class DrawItemDrawer implements Drawer {
    private DrawItem drawItem;

    public DrawItemDrawer(DrawItem drawItem) {
        this.drawItem = drawItem;
    }

    @Override
    public Rectangle getBoundingBox(Graphics g, ImageObserver observer, float scale) {
        return new Rectangle(0,0,800,600);
    }

    @Override
    public void draw(int x, int y, float scale, Graphics g, ImageObserver o) {
        Graphics2D graphic2D = (Graphics2D) g;

        //Enable antialiasing
        RenderingHints rh = new RenderingHints(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        graphic2D.setRenderingHints(rh);

        for (Line line : drawItem.getLines()) {
            graphic2D.setPaint(line.getStyle().getColor());
            graphic2D.setStroke(new BasicStroke(line.getStyle().getLineSize())); // hoe dik, later uit line

            graphic2D.drawLine(line.getStartX(), line.getStartY() , line.getEndX(), line.getEndY());
        }

    }
}

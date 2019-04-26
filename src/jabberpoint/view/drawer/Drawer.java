package jabberpoint.view.drawer;

import java.awt.*;
import java.awt.image.ImageObserver;

public interface Drawer {

    public Rectangle getBoundingBox(Graphics g, ImageObserver observer, float scale);

    public void draw(int x, int y, float scale, Graphics g, ImageObserver o);

    }

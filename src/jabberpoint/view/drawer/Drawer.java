package jabberpoint.view.drawer;

import java.awt.*;
import java.awt.image.ImageObserver;

public interface Drawer {

    Rectangle getBoundingBox(Graphics g, ImageObserver observer, float scale);

    void draw(int x, int y, float scale, Graphics g, ImageObserver o);

    }

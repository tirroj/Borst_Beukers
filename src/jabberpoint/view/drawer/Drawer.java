package jabberpoint.view.drawer;

import jabberpoint.presentation.style.Style;

import java.awt.*;
import java.awt.image.ImageObserver;

public interface Drawer {

    public Rectangle getBoundingBox(Graphics g, ImageObserver observer, float scale, Style myStyle);

    public void draw(int x, int y, float scale, Graphics g, Style myStyle, ImageObserver o);

    }

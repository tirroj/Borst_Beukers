package jabberpoint.view.drawer;

import jabberpoint.presentation.BitmapItem;
import jabberpoint.presentation.style.Style;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

public class BitmapItemDrawer implements Drawer {
    private BitmapItem bitmapItem;

    public BitmapItemDrawer(BitmapItem bitmapItem) {
        this.bitmapItem = bitmapItem;
    }

    @Override
    public Rectangle getBoundingBox(Graphics g, ImageObserver observer, float scale, Style myStyle) {
        return new Rectangle((int) (myStyle.getIndent() * scale), 0,
                (int) (bitmapItem.getBufferedImage().getWidth(observer) * scale),
                ((int) (myStyle.getLeading() * scale)) + (int) (bitmapItem.getBufferedImage().getHeight(observer) * scale));
    }

    @Override
    public void draw(int x, int y, float scale, Graphics g, Style myStyle, ImageObserver observer) {
        BufferedImage bufferedImage = bitmapItem.getBufferedImage();
        int width = x + (int) (myStyle.getIndent() * scale);
        int height = y + (int) (myStyle.getLeading() * scale);
        g.drawImage(bufferedImage, width, height,(int) (bufferedImage.getWidth(observer)*scale),
                (int) (bufferedImage.getHeight(observer)*scale), observer);
    }
}

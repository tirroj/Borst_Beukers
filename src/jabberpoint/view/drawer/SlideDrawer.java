package jabberpoint.view.drawer;

import jabberpoint.presentation.Slide;
import jabberpoint.presentation.SlideItem;
import jabberpoint.presentation.TextItem;
import jabberpoint.presentation.style.Style;

import java.awt.*;
import java.awt.image.ImageObserver;

public class SlideDrawer {

    private Slide slide;

    public SlideDrawer(Slide slide) {
        this.slide = slide;
    }

    // teken de slide
    public void draw(Graphics g, Rectangle area, ImageObserver view) {
        float scale = getScale(area);
        int y = area.y;
        // De titel wordt apart behandeld
        SlideItem slideItem = new TextItem(0, slide.getTitle());
        Style style = Style.getStyle(slideItem.getLevel());
        Drawer drawer = getDrawer(slideItem);
        drawer.draw(area.x, y, scale, g, style, view);
        y += drawer.getBoundingBox(g, view, scale, style).height;

        for (int number=0; number<slide.getSize(); number++) {
            slideItem = (SlideItem)slide.getSlideItems().elementAt(number);
            drawer = getDrawer(slideItem);
            style = Style.getStyle(slideItem.getLevel());
            drawer.draw(area.x, y, scale, g, style, view);
            y += drawer.getBoundingBox(g, view, scale, style).height;
        }
    }

    // geef de schaal om de slide te kunnen tekenen
    private float getScale(Rectangle area) {
        return Math.min(((float)area.width) / ((float)slide.referenceWidth), ((float)area.height) / ((float)slide.referenceHeight));
    }

    private Drawer getDrawer(SlideItem item){
        return DrawerFactory.getDrawer(item);
    }
}

package jabberpoint.view.drawer;

import jabberpoint.presentation.Slide;
import jabberpoint.presentation.slideitem.TextItem;
import jabberpoint.presentation.style.Style;

import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.font.LineBreakMeasurer;
import java.awt.font.TextAttribute;
import java.awt.font.TextLayout;
import java.awt.geom.Rectangle2D;
import java.awt.image.ImageObserver;
import java.text.AttributedString;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TextItemDrawer implements Drawer{

    private TextItem item;

    public TextItemDrawer(TextItem item) {
        this.item = item;
    }

    @Override
    public Rectangle getBoundingBox(Graphics g, ImageObserver observer, float scale) {
        Style myStyle = item.getStyle();
        List layouts = getLayouts(g, myStyle, scale);
        int xsize = 0;
        int ysize = (int) (myStyle.getLeading() * scale);
        Iterator iterator = layouts.iterator();
        while (iterator.hasNext()) {
            TextLayout layout = (TextLayout) iterator.next();
            Rectangle2D bounds = layout.getBounds();
            if (bounds.getWidth() > xsize) {
                xsize = (int) bounds.getWidth();
            }
            if (bounds.getHeight() > 0) {
                ysize += bounds.getHeight();
            }
            ysize += layout.getLeading() + layout.getDescent();
        }
        return new Rectangle((int) (myStyle.getIndent()*scale), 0, xsize, ysize );
    }

    private void enableAntiAliasing(Graphics2D g2d) {
        RenderingHints rh = new RenderingHints(
             RenderingHints.KEY_TEXT_ANTIALIASING,
             RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g2d.setRenderingHints(rh);
    }

    @Override
    public void draw(int x, int y, float scale, Graphics g, ImageObserver o) {
        if (item.getText() == null || item.getText().length() == 0) {
          return;
        }
        Style myStyle = item.getStyle();
        List layouts = getLayouts(g, myStyle, scale);
        Point pen = new Point(x + (int)(myStyle.getIndent() * scale), y + (int)(myStyle.getLeading() * scale));
        Graphics2D g2d = (Graphics2D)g;
        enableAntiAliasing(g2d);
        g2d.setColor(myStyle.getColor());
        Iterator it = layouts.iterator();
        while (it.hasNext()) {
          TextLayout layout = (TextLayout) it.next();
          pen.y += layout.getAscent();
          layout.draw(g2d, pen.x, pen.y);
          pen.y += layout.getDescent();
        }

    }

    private List getLayouts(Graphics g, Style s, float scale) {
        List<TextLayout> layouts = new ArrayList<>();
        AttributedString attrStr = getAttributedString(s, scale);
        Graphics2D g2d = (Graphics2D) g;
        enableAntiAliasing(g2d);
        FontRenderContext frc = g2d.getFontRenderContext();
        LineBreakMeasurer measurer = new LineBreakMeasurer(attrStr.getIterator(), frc);
        float wrappingWidth = (Slide.REFERENCE_WIDTH - s.getIndent()) * scale;
        while (measurer.getPosition() < item.getText().length()) {
            TextLayout layout = measurer.nextLayout(wrappingWidth);
            layouts.add(layout);
        }
        return layouts;
    }

    // geef de AttributedString voor het items
    public AttributedString getAttributedString(Style style, float scale) {
        AttributedString attrStr = new AttributedString(item.getText());
        attrStr.addAttribute(TextAttribute.FONT, style.getFont(scale), 0, item.getText().length());
        return attrStr;
    }
}

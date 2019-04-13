package jabberpoint.presentation;

import jabberpoint.presentation.style.Style;

import java.awt.Rectangle;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.font.TextLayout;
import java.awt.font.TextAttribute;
import java.awt.font.LineBreakMeasurer;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import java.awt.image.ImageObserver;
import java.text.AttributedString;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

/** Een tekst item
 * <P>
 * This program is distributed under the terms of the accompanying
 * COPYRIGHT.txt file (which is NOT the GNU General Public License).
 * Please read it. Your use of the software constitutes acceptance
 * of the terms in the COPYRIGHT.txt file.
 * @author Ian F. Darwin, ian@darwinsys.com
 * @version $Id: presentation.TextItem.java,v 1.1 2002/12/17 Gert Florijn
 * @version $Id: presentation.TextItem.java,v 1.2 2003/11/19 Sylvia Stuurman
 * @version $Id: presentation.TextItem.java,v 1.2 2004/08/17 Sylvia Stuurman
 */

public class TextItem extends SlideItem {
  private String text;

// een textitem van level level, met als tekst string
  public TextItem(int level, String string) {
    super(level);
    text = string;
  }

// een leeg textitem
  public TextItem() {
    this(0, "NO TEXT GIVEN");
  }

// Geef de tekst
  public String getText() {
    return text == null ? "" : text;
  }


  public String toString() {
    return "presentation.TextItem[" + getLevel()+","+getText()+"]";
  }
}

package jabberpoint.presentation;

import jabberpoint.presentation.style.Style;
import jabberpoint.presentation.style.StyleFactory;

/** De abstracte klasse voor een item op een presentation.Slide
 * <P>
 * This program is distributed under the terms of the accompanying
 * COPYRIGHT.txt file (which is NOT the GNU General Public License).
 * Please read it. Your use of the software constitutes acceptance
 * of the terms in the COPYRIGHT.txt file.
 * @author Ian F. Darwin, ian@darwinsys.com
 * @version $Id: presentation.SlideItem.java,v 1.1 2002/12/17 Gert Florijn
 * @version $Id: presentation.SlideItem.java,v 1.2 2003/11/19 Sylvia Stuurman
 * @version $Id: presentation.SlideItem.java,v 1.3 2004/08/17 Sylvia Stuurman
 */

public abstract class SlideItem {
  private int level = 0; // het level van het slideitem
  private Style style;

  public SlideItem(int lev) {
    level = lev;
    style = StyleFactory.getStyle(getLevel());
  }

  public SlideItem() {
    this(0);
  }

// Geef het level
  public int getLevel() {
    return level;
  }

  public Style getStyle() { return style; }

}

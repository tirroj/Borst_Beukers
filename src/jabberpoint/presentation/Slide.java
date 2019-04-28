package jabberpoint.presentation;

import jabberpoint.presentation.slideitem.DrawItem;
import jabberpoint.presentation.slideitem.ItemFactory;
import jabberpoint.presentation.slideitem.SlideItem;

import java.util.Vector;

/** Ean slide
 * <P>
 * This program is distributed under the terms of the accompanying
 * COPYRIGHT.txt file (which is NOT the GNU General Public License).
 * Please read it. Your use of the software constitutes acceptance
 * of the terms in the COPYRIGHT.txt file.
 * @author Ian F. Darwin, ian@darwinsys.com
 * @version $Id: presentation.Slide.java,v 1.1 2002/12/17 Gert Florijn
 * @version $Id: presentation.Slide.java,v 1.2 2003/11/19 Sylvia Stuurman
 * @version $Id: presentation.Slide.java,v 1.3 2004/08/17 Sylvia Stuurman
 * @version $Id: presentation.Slide.java,v 1.4 2007/07/16 Sylvia Stuurman
 */

public class Slide {
  public final static int REFERENCE_WIDTH = 800;
  public final static int REFERENCE_HEIGHT = 600;
  protected String title; // de titel wordt apart bewaard
  protected Vector<SlideItem> items; // de slide-items wordne in een Vector bewaard

  public Slide() {
    items = new Vector<>();
  }

// Voeg een SlideItem toe
  public void append(SlideItem anItem) {
    items.addElement(anItem);
  }

// geef de titel van de slide
  public String getTitle() {
    return title;
  }

// verander de titel van de slide
  public void setTitle(String newTitle) {
    title = newTitle;
  }

// Maak een TextItem van String, en voeg het TextItem toe
  public void append(int level, String message) {
    append(ItemFactory.getItem(ItemFactory.TEXT, level, message));
  }

// geef het betreffende SlideItem
  public SlideItem getSlideItem(int number) {
    return items.elementAt(number);
  }

// geef alle SlideItems in een Vector
  public Vector getSlideItems() {
    return items;
  }

// geef de afmeting van de Slide
  public int getSize() {
    return items.size();
  }

  // teken op slide
  public DrawItem startTekenen(){
    DrawItem drawItem = (DrawItem)ItemFactory.getItem(ItemFactory.DRAW, 0 , null);
    items.add(drawItem);
    return drawItem;
  }
}

package jabberpoint.presentation;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


/** De klasse voor een Bitmap item
 * <P>
 * This program is distributed under the terms of the accompanying
 * COPYRIGHT.txt file (which is NOT the GNU General Public License).
 * Please read it. Your use of the software constitutes acceptance
 * of the terms in the COPYRIGHT.txt file.
 * @author Ian F. Darwin, ian@darwinsys.com
 * @version $Id: presentation.BitmapItem.java,v 1.1 2002/12/17 Gert Florijn
 * @version $Id: presentation.BitmapItem.java,v 1.2 2003/12/17 Sylvia Stuurman
 * @version $Id: presentation.BitmapItem.java,v 1.3 2004/08/17 Sylvia Stuurman
 * @version $Id: presentation.BitmapItem.java,v 1.4 2007/07/16 Sylvia Stuurman
 */

public class BitmapItem extends SlideItem {
  private BufferedImage bufferedImage;
  private String imageName;

  public BufferedImage getBufferedImage() {
    return bufferedImage;
  }

  // level staat voor het item-level; name voor de naam van het bestand met het plaatje
  public BitmapItem(int level, String name) {
    super(level);
    imageName = name;
    try {
      bufferedImage = ImageIO.read(new File(imageName));
    }
    catch (IOException e) {
      System.err.println("Bestand " + imageName + " niet gevonden") ;
    }
  }

// Een leeg bitmap-item
  public BitmapItem() {
    this(0, null);
  }

// geef de bestandsnaam van het plaatje
  public String getName() {
    return imageName;
  }

  public String toString() {
    return "BitmapItem[" + getLevel() + "," + imageName + "]";
  }
}

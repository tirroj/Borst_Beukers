package jabberpoint.view.controller;

import jabberpoint.presentation.Presentation;

import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;

/** This is the view.controller.KeyController (KeyListener) for the View
 * <P>
 * This program is distributed under the terms of the accompanying
 * COPYRIGHT.txt file (which is NOT the GNU General Public License).
 * Please read it. Your use of the software constitutes acceptance
 * of the terms in the COPYRIGHT.txt file.
 * @author Ian F. Darwin, ian@darwinsys.com
 * @version $Id: view.controller.KeyController.java,v 1.1 2002/12/17 Gert Florijn
 * @version $Id: view.controller.KeyController.java,v 1.2 2003/11/19 Sylvia Stuurman
 * @version $Id: view.controller.KeyController.java,v 1.3 2004/08/17 Sylvia Stuurman
 */

public class KeyController extends KeyAdapter {
  private Presentation presentation; // wat gecontrolled wordt is de presentatie

  public KeyController(Presentation p) {
    presentation = p;
  }

  @Override
  public void keyPressed(KeyEvent keyEvent) {
    switch(keyEvent.getKeyCode()) {
      case KeyEvent.VK_PAGE_DOWN:
      case KeyEvent.VK_DOWN:
      case KeyEvent.VK_ENTER:
      case '+':
        presentation.nextSlide();
	break;
      case KeyEvent.VK_PAGE_UP:
      case KeyEvent.VK_UP:
      case '-':
	presentation.prevSlide();
	break;
      case 'q':
      case 'Q':
	System.exit(0);
	break; // wordt nooit bereikt als het goed is
      default:
	break;
    }
  }
}

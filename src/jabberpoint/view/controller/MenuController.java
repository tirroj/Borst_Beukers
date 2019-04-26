package jabberpoint.view.controller;

import jabberpoint.file.Accessor;
import jabberpoint.file.XMLAccessor;
import jabberpoint.file.AccessorFactory;
import jabberpoint.presentation.Presentation;
import jabberpoint.view.AboutBox;
import jabberpoint.drawStyleDialogs.ColorChooser;
import jabberpoint.drawStyleDialogs.LineWidthSlider;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;
import javax.swing.JOptionPane;

/** De controller voor het menu
 * <P>
 * This program is distributed under the terms of the accompanying
 * COPYRIGHT.txt file (which is NOT the GNU General Public License).
 * Please read it. Your use of the software constitutes acceptance
 * of the terms in the COPYRIGHT.txt file.
 * @author Ian F. Darwin, ian@darwinsys.com
 * @version $Id: view.controller.MenuController.java,v 1.1 2002/12/17 Gert Florijn
 * @version $Id: view.controller.MenuController.java,v 1.2 2003/11/19 Sylvia Stuurman
 * @version $Id: view.controller.MenuController.java,v 1.3 2004/08/17 Sylvia Stuurman
 * @version $Id: view.controller.MenuController.java,v 1.4 2007/07/16 Sylvia Stuurman
 */
public class MenuController extends MenuBar {
  private static final long serialVersionUID = 227L;
  private Frame parent; // het frame, alleen gebruikt als ouder voor de Dialogs
  private Presentation presentation; // wat gecontrolled wordt is de presentatie
  private DrawController drawController; //tekenmodus
  private ColorChooser colorChooser; //dialoog om de kleur in te stellen voor de tekenmodus
  private LineWidthSlider lineSizeSlider; //dialoog om de dikte in te stellen voor de tekenmodus

  public MenuController(Frame frame, Presentation pres) {
    parent = frame;
    presentation = pres;
    colorChooser = new ColorChooser();
    lineSizeSlider = new LineWidthSlider();

    MenuItem menuItem;
    Menu fileMenu = new Menu("File");
    fileMenu.add(menuItem = mkMenuItem("Open"));

    menuItem.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent actionEvent) {
        presentation.clear();
        Accessor accessor = AccessorFactory.getAccessor();
        try {
          accessor.loadFile(presentation, "dump");
          presentation.update();
          presentation.setSlideNumber(0);
        } catch (IOException exc) {
          JOptionPane.showMessageDialog(parent, "IOException: " + exc, "Load Error", JOptionPane.ERROR_MESSAGE);
        }
      }
    });
    fileMenu.add(menuItem = mkMenuItem("New"));
    menuItem.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent actionEvent) {
        presentation.clear();
        presentation.update();
      }
    });
    fileMenu.add(menuItem = mkMenuItem("Save"));
    menuItem.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        Accessor accessor = AccessorFactory.getAccessor();
        try {
          accessor.saveFile(presentation, "dump");
        } catch (IOException exc) {
            JOptionPane.showMessageDialog(parent, "IOException: " + exc, "Save Error", JOptionPane.ERROR_MESSAGE);
        }
      }
    });
    fileMenu.addSeparator();
    fileMenu.add(menuItem = mkMenuItem("Exit"));
    menuItem.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent actionEvent) {
	presentation.exit(0);
      }
    });
    add(fileMenu);
    Menu viewMenu = new Menu("View");
    viewMenu.add(menuItem = mkMenuItem("Next"));
    menuItem.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent actionEvent) {
	presentation.nextSlide();
      }
    });
    viewMenu.add(menuItem = mkMenuItem("Prev"));
    menuItem.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent actionEvent) {
	presentation.prevSlide();
      }
    });
    viewMenu.add(menuItem = mkMenuItem("Goto"));
    menuItem.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent actionEvent) {
	String pageNumberStr = JOptionPane.showInputDialog((Object)"Page number?");
	int pageNumber = Integer.parseInt(pageNumberStr);
	presentation.setSlideNumber(pageNumber - 1);
      }
    });
    add(viewMenu);
    Menu drawMenu = new Menu("Draw");
    drawMenu.add(menuItem = mkMenuItem("Start drawing"));
    menuItem.setShortcut(new MenuShortcut('D', false));
    menuItem.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        drawController = new DrawController(presentation.startTekenen(), presentation, colorChooser.getColor(), lineSizeSlider.getWidth());
        parent.addMouseListener(drawController);
        parent.addMouseMotionListener(drawController);
      }
    });
    drawMenu.add(menuItem = mkMenuItem("Stop drawing"));
    menuItem.setShortcut(new MenuShortcut('X', false));
    menuItem.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        parent.removeMouseListener(drawController);
        parent.removeMouseMotionListener(drawController);
        drawController = null;
      }
    });
    drawMenu.add(menuItem = mkMenuItem("Select line width"));
    menuItem.setShortcut(new MenuShortcut('L', false));
    menuItem.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        lineSizeSlider.showDialog();
        if(drawController != null) {
          drawController.setLineSize(lineSizeSlider.getWidth());
        }
      }
    });
    drawMenu.add(menuItem = mkMenuItem("Select color"));
    menuItem.setShortcut(new MenuShortcut('C', false));
    menuItem.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        colorChooser.showDialog();
        if(drawController != null) {
          drawController.setColor(colorChooser.getColor());
        }
      }
    });

    add(drawMenu);
    Menu helpMenu = new Menu("Help");
    helpMenu.add(menuItem = mkMenuItem("About"));
    menuItem.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent actionEvent) {
	    AboutBox.show(parent);
      }
    });
    setHelpMenu(helpMenu);		// nodig for portability (Motif, etc.).
  }

// een menu-item aanmaken
  public MenuItem mkMenuItem(String name) {
    return new MenuItem(name, new MenuShortcut(name.charAt(0)));
  }
}

package jabberpoint.presentation.style;

import java.awt.Color;
import java.awt.Font;

/** presentation.Style staat voor Indent, Color, Font and Leading.
 * De koppeling tussen style-nummer en item-level is nu direct:
 * in presentation.Slide wordt de style opgehaald voor een item
 * met als style-nummer het item-level.
 * <P>
 * This program is distributed under the terms of the accompanying
 * COPYRIGHT.txt file (which is NOT the GNU General Public License).
 * Please read it. Your use of the software constitutes acceptance
 * of the terms in the COPYRIGHT.txt file.
 * @author Ian F. Darwin, ian@darwinsys.com
 * @version $Id: presentation.Style.java,v 1.1 2002/12/17 Gert Florijn
 * @version $Id: presentation.Style.java,v 1.2 2003/11/19 Sylvia Stuurman
 * @version $Id: presentation.Style.java,v 1.3 2004/08/17 Sylvia Stuurman
 */

public class Style {

  int indent;
  Color color;
  Font font;
  int fontSize;
  int leading;

  public Style(int indent, Color color, int points, int leading) {
    this.indent = indent;
    this.color = color;
    font = new Font("Helvetica", Font.BOLD, fontSize=points);
    this.leading = leading;
  }

  public String toString() {
    return "["+indent+","+color+"; "+fontSize+" on "+leading+"]";
  }

  public Font getFont(float scale) {
    return font.deriveFont(fontSize * scale);
  }

  public int getIndent() {
    return indent;
  }

  public Color getColor() {
    return color;
  }

  public Font getFont() {
    return font;
  }

  public int getFontSize() {
    return fontSize;
  }

  public int getLeading() {
    return leading;
  }
}

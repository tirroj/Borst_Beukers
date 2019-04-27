package jabberpoint.view.drawstyledialogs;

import javax.swing.*;
import javax.swing.colorchooser.AbstractColorChooserPanel;
import java.awt.Color;

public class ColorChooser {
    private JColorChooser colorChooser;
    private AbstractColorChooserPanel colorPanel;
    private JDialog dialog;

    public ColorChooser() {
        colorChooser = new JColorChooser();
        AbstractColorChooserPanel[] panels = colorChooser.getChooserPanels();
        for (AbstractColorChooserPanel accp : panels) {
            if (accp.getDisplayName().equals("Swatches")) {
                colorPanel = accp;
                break;
            }
        }
        JOptionPane optionPane = new JOptionPane();
        optionPane.setMessage(new Object[] {"Select the color: ", colorPanel});
        dialog = optionPane.createDialog(colorPanel, "Color selector");
    }
    public void showDialog() {
        dialog.setVisible(true);
    }
    public Color getColor() {return colorChooser.getColor();}
}


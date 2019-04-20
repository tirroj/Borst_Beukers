package jabberpoint.drawStyleDialogs;

import javax.swing.*;
import javax.swing.colorchooser.AbstractColorChooserPanel;

public class ColorChooser extends JColorChooser {
    private AbstractColorChooserPanel colorPanel;
    private JDialog dialog;

    public ColorChooser() {
        AbstractColorChooserPanel[] panels = getChooserPanels();
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
}


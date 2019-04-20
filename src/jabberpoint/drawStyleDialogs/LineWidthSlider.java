package jabberpoint.drawStyleDialogs;

import javax.swing.JSlider;
import javax.swing.JOptionPane;
import javax.swing.JDialog;

public class LineWidthSlider {
    private JSlider slider;
    private JDialog dialog;

    public LineWidthSlider() {
        slider = new JSlider(JSlider.HORIZONTAL, 0, 30, 3);
        slider.setMinorTickSpacing(1);
        slider.setMajorTickSpacing(3);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.setLabelTable(slider.createStandardLabels(3));
        JOptionPane optionPane = new JOptionPane();
        optionPane.setMessage(new Object[] {"Select the width: ", slider});
        dialog = optionPane.createDialog(slider, "Line width selector");

    }
    public void showDialog() {
        dialog.setVisible(true);
    }
    public int getWidth() {
        return slider.getValue();
    }
}

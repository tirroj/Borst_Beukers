package jabberpoint.presentation.style;

import java.awt.*;

public class LineStyle {

    private Color color;
    private int lineSize;

    public LineStyle(Color color, int lineSize) {
        this.color = color;
        this.lineSize = lineSize;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getLineSize() {
        return lineSize;
    }

    public void setLineSize(int lineSize) {
        this.lineSize = lineSize;
    }
}

package jabberpoint.presentation.style;

import java.awt.*;

public class StyleFactory {
    public static Style getStyle(int level) {
        if (level == 0)
            return new Style(0, Color.red,   48, 20);	// style voor item-level 0
        else if (level == 1)
            return new Style(20, Color.blue,  40, 10);	// style voor item-level 1
        else if (level == 2)
            return new Style(50, Color.black, 36, 10);	// style voor item-level 2
        else if (level == 3)
            return new Style(70, Color.black, 30, 10);	// style voor item-level 3
        else
            return new Style(90, Color.black, 24, 10);	// style voor item-level 4
    }
}

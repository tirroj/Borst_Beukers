package jabberpoint.presentation;

import java.util.ArrayList;
import java.util.List;

public class DrawItem extends SlideItem {

    List<Line> lines = new ArrayList<>();

    public List<Line> getLines() {
        return lines;
    }

    public void addLine (Line line){
        lines.add(line);
    }
}

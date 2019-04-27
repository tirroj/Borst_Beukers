package jabberpoint.presentation.slideitem;

import jabberpoint.presentation.Line;

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

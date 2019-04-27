package jabberpoint.presentation.slideitem;

public class ItemFactory {


    public static final String TEXT = "text";
    public static final String IMAGE = "image";
    public static final String DRAW = "draw";

    public static SlideItem getItem(String type, int level, String text){
        switch(type){
            case TEXT:
                return new TextItem(level,text);
            case IMAGE:
                return new BitmapItem(level,text);
            case DRAW:
                return new DrawItem();
            default:
                return null;
        }
    }


}

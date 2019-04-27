package jabberpoint.presentation.slideitem;

public class ItemFactory {

    public static SlideItem getItem(String type, int level, String text){
        switch(type){
            case "text":
                return new TextItem(level,text);
            case "image":
                return new BitmapItem(level,text);
            case "draw":
                return new DrawItem();
            default:
                return null;
        }
    }


}

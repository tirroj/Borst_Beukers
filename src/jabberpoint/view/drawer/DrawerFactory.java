package jabberpoint.view.drawer;

import jabberpoint.presentation.BitmapItem;
import jabberpoint.presentation.Slide;
import jabberpoint.presentation.SlideItem;
import jabberpoint.presentation.TextItem;

public class DrawerFactory {

    public static Drawer getDrawer(SlideItem slideItem){
        if(slideItem  instanceof TextItem){
            return new TextItemDrawer((TextItem) slideItem);
        }
        if(slideItem instanceof BitmapItem){
            return new BitmapItemDrawer((BitmapItem)slideItem);
        }
        //throw new Exception();
        return null;
    }

    public static SlideDrawer getDrawer(Slide slide){
        return new SlideDrawer(slide);
    }
}

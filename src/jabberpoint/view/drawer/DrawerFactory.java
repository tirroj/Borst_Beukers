package jabberpoint.view.drawer;

import jabberpoint.presentation.*;
import jabberpoint.presentation.slideitem.BitmapItem;
import jabberpoint.presentation.slideitem.DrawItem;
import jabberpoint.presentation.slideitem.SlideItem;
import jabberpoint.presentation.slideitem.TextItem;

public class DrawerFactory {

    public static Drawer getDrawer(SlideItem slideItem){
        if(slideItem  instanceof TextItem){
            return new TextItemDrawer((TextItem) slideItem);
        }
        if(slideItem instanceof BitmapItem){
            return new BitmapItemDrawer((BitmapItem)slideItem);
        }
        if(slideItem instanceof DrawItem){
            return new DrawItemDrawer((DrawItem)slideItem);
        }
        return null;
    }

    public static SlideDrawer getDrawer(Slide slide){
        return new SlideDrawer(slide);
    }
}

package jabberpoint.file;

import jabberpoint.demo.DemoPresentation;

public class AccessorFactory {

    private static final String XML_TYPE = "xml";
    private static final String JSON_TYPE = "json";

    private static String type = XML_TYPE;

    public static Accessor getAccessor() {
        switch (type) {
            case XML_TYPE:
                return new XMLAccessor();
            case JSON_TYPE:
                return new JSONAccessor();
            default:
                return new XMLAccessor();
        }
    }

    public static Accessor getDemoAccessor() {
        return new DemoPresentation();
    }


}

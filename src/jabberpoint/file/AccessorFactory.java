package jabberpoint.file;

public class AccessorFactory {
    public static Accessor getAccessor() {
        return new XMLAccessor();
    }

}

package jabberpoint.file;

public class AccessorFactory {
    public static XMLAccessor getAccessor() {
        System.out.println("CREATE");
        return new XMLAccessor();
    }

}

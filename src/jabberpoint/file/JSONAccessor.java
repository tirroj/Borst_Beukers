package jabberpoint.file;

import jabberpoint.presentation.*;
import java.io.IOException;

public class JSONAccessor extends Accessor {
    public JSONAccessor() {setExtension(".json");}

    public void loadFile(Presentation presentation, String fn) throws IOException {
        String filename = fn + getExtension();
    }
    public void saveFile(Presentation presentation, String fn) throws IOException {
        String filename = fn + getExtension();
    }
}

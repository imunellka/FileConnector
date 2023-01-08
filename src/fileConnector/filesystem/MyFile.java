package fileConnector.filesystem;

import java.util.ArrayList;
import java.util.List;

public class MyFile {
    public String name;
    public final List<String> children = new ArrayList<>();
    public List<String> text;

    public MyFile(String name, List<String> text) {
        this.name = name;
        this.text = text;
    }

    public void adopt(String child) {
        children.add(child);
    }
}

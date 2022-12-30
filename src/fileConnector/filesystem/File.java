package fileConnector.filesystem;

import java.util.ArrayList;
import java.util.List;

public class File {
    public String name;

    public final List<String> children = new ArrayList<String>();
    public  List<String> text;

    public File(String name, List<String> text) {
        this.name = name;
        this.text = text;
    }

    public void add(String child) {
        children.add(child);
    }

    public File find(List<File> list, String name) {
        for (File file : list) {
            if (name.equals(file.name)) {
                return file;
            }
        }
        return null;
    }
}

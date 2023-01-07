package fileConnector.filesystem;

import java.util.ArrayList;
import java.util.List;

public class MyFile {
    public String name;

    public final List<String> children = new ArrayList<>();
    public List<String> text;

    public boolean flag;

    public MyFile(String name, List<String> text) {
        this.name = name;
        this.text = text;
        this.flag = false;
    }

    public void adopt(String child) {
        children.add(child);
    }

    public MyFile find(List<MyFile> list, String name) {
        for (MyFile file : list) {
            if (name.equals(file.name)) {
                return file;
            }
        }
        return null;
    }
}

package fileConnector.filesystem;

import fileConnector.Controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class FileManager extends Controller {
    protected static final List<MyFile> system = new ArrayList<>();
    protected static final List<MyFile> sorted_system = new ArrayList<>();
    protected static String path;

    public void readDirectory() throws FileNotFoundException {}
    public void Sorting() throws UnsupportedOperationException {
        boolean hasNoChild = true;
        while (!system.isEmpty()) {
            MyFile v = null;
            for (MyFile file : system) {
                if (file.children.isEmpty()) {
                    sorted_system.add(file);
                    hasNoChild = true;
                    v = file;
                    break;
                }
                hasNoChild = false;
            }

            if (hasNoChild) {
                system.remove(v);
                for (MyFile file : system) {
                    while (file.children.remove(v.name)) { }
                }
            }
            else {
                StringBuilder eMessage = new StringBuilder();
                for (MyFile file : system) {
                    eMessage.append(file.name);
                    eMessage.append("; ");
                }
                throw new UnsupportedOperationException("Cycle was found in these files: " + eMessage);
            }
        }
    }
    public void addToSystem(String parentPath, List<String> text) {
        parentPath = parentPath.substring(path.length() + 1, parentPath.length() - 4);
        system.add(new MyFile(parentPath, text));
    }

    public void adoption(String parentPath, String childPath) {
        int length = parentPath.length();
        parentPath = parentPath.substring(path.length() + 1, length - 4);
        for (MyFile my_file : system) {
            if (Objects.equals(my_file.name, parentPath)) {
                my_file.adopt(childPath);
            }
        }
    }
}

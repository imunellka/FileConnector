package fileConnector.filesystem;

import fileConnector.Controller;

import java.util.List;
import java.util.Objects;

public class FileManager extends Controller {
    protected static String path;
    public MyFile NextFile(String startFile){
        for (MyFile file : system) {
            List<String> fileChildren = file.children;
            if (fileChildren.contains(startFile)) {
                return file;
            }
        }
        return null;
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

    public static boolean check(String start) {
        return false;
    }
}

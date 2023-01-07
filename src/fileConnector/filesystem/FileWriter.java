package fileConnector.filesystem;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileWriter extends FileManager {
    static String root;
    static List<String> sorted_system = new ArrayList<>();
    static FileOutputStream out;

    public  void print() throws IOException {
        out = new FileOutputStream(path + "/result.txt");
        findRoot();
        printDirectory();
        out.close();
    }

    private  void printDirectory() throws IOException {
        out.write("Your text: \n".getBytes());
        while (sorted_system.size() != system.size()) {
            MyFile next = NextFile(root);
            if (next != null) {
                printFile(false, next);
            }
        }
    }

    private  void printFile(boolean flag, MyFile file) throws IOException {
        if (file == null) {
            return;
        }
        if (!file.children.isEmpty()) {
            for (int i = 0; i < file.children.size(); i++) {
                if (!sorted_system.contains(file.children.get(i))) {
                    printFile(true, file.find(system, file.children.get(i)));
                }
            }
            //печатаем
            for (String obj : file.text) {
                out.write(obj.getBytes());
                out.write('\n');
                System.out.println(obj);
            }
            // добавляем в наш список
            sorted_system.add(file.name);
            if (!flag) {
                printFile(false, NextFile(file.name));
            }
        }
    }

    private  void findRoot() throws IOException {
        for (MyFile file : system) {
            if (file.children.isEmpty() && !file.flag) {
                root = file.name;
                sorted_system.add(root);
                for (String str : file.text) {
                    out.write(str.getBytes());
                    out.write('\n');
                    System.out.println(str);
                }
                file.flag = true;
                break;
            }
        }
    }
}

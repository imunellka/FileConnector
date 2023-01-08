package fileConnector.filesystem;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileWriter extends FileManager {
    static FileOutputStream out;

    @Override
    public void printDirectory() throws IOException {
        out = new FileOutputStream(path + "/result.txt");
        print();
        out.close();
    }

    private void print() throws IOException {
        out.write("Your text: \n".getBytes());

    }
}

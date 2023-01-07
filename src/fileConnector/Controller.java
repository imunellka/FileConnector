package fileConnector;

import fileConnector.filesystem.FileWriter;
import fileConnector.filesystem.MyFile;
import fileConnector.filesystem.FileReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Controller {

    public static final List<MyFile> system = new ArrayList<>();

    public void startProgram() throws IOException {
        FileReader fr = new FileReader();
        fr.readDirectory();
        FileWriter fw = new FileWriter();
        fw.print();
    }
}
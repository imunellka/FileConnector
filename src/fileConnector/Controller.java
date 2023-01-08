package fileConnector;

import fileConnector.filesystem.FileManager;
import fileConnector.filesystem.FileReader;
import fileConnector.filesystem.FileWriter;

import java.io.IOException;

public class Controller {

    public void startProgram() throws IOException {
        FileManager fr = new FileReader();
        fr.readDirectory();
        try {
            fr.sorting();
        }catch (UnsupportedOperationException e) {
            System.out.println(e.getMessage());
        }
        FileWriter fw = new FileWriter();
        fw.printDirectory();
    }
}
package fileConnector;

import fileConnector.filesystem.FileManager;

import java.io.IOException;

public class Controller {

    public void startProgram() throws IOException {
        FileManager fr = new FileManager();
        fr.readDirectory();
        try {
            fr.Sorting();
        }catch (UnsupportedOperationException e) {
            System.out.println(e.getMessage());
        }
        fr.printDirectory();
    }
}
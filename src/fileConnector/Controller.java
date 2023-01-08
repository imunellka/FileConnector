package fileConnector;

import fileConnector.filesystem.FileManager;
import fileConnector.filesystem.FileReader;
import fileConnector.filesystem.FileWriter;

import java.io.IOException;

public class Controller {

    /**
     * Общая логика программы
     *
     * @throws IOException на чтение файлов
     */
    public void startProgram() throws IOException {
        FileManager fr = new FileReader();
        fr.readDirectory();
        try {
            fr.sorting();
            FileWriter fw = new FileWriter();
            fw.printDirectory();
        } catch (UnsupportedOperationException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println("Mistakes happened during the files reading");
        }
    }
}
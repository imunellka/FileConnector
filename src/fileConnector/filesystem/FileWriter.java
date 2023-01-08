package fileConnector.filesystem;

import java.io.FileOutputStream;
import java.io.IOException;

public class FileWriter extends FileManager {
    private FileOutputStream out;

    /**
     * ЗАпускает печать списка файлов
     * @throws IOException ошибка записи в файл
     */
    public void printDirectory() throws IOException {
        out = new FileOutputStream(path + "/result.txt");
        out.write("Your text: \n".getBytes());
        print();
        out.close();
    }

    /**
     * печатает файл
     * @throws IOException ошибка записи в файл
     */
    private void print() throws IOException {
        for (var file : sorted_system) {
            for (String line : file.text) {
                out.write(line.getBytes());
                out.write('\n');
                System.out.println(line);
            }
        }
    }
}

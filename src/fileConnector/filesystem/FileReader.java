package fileConnector.filesystem;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class FileReader extends FileManager {
    private final List<File> folder = new ArrayList<>();

    /**
     * Обрабатываем папку со всеми подпапками
     * @throws FileNotFoundException директория не найдена
     */
    @Override
    public void readDirectory() throws FileNotFoundException {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter absolute path to your file: ");
        path = in.nextLine();
        // получаем все файлы из директории.
        try (Stream<Path> files = Files.walk(Paths.get(path))) {
            folder.addAll(files.filter(Files::isRegularFile).map(Path::toFile).toList());
        } catch (IOException e) {
            System.out.println("Directory not found :(");
            System.exit(0);
        }
        // считываем файлы
        for (File file : folder) {
            readFile(file);
        }
    }

    /**
     * добавляем файл в систему со всеми requires
     * @param file файл
     * @throws FileNotFoundException
     */
    private void readFile(File file) throws FileNotFoundException {
        // считываем текст
        List<String> text = new ArrayList<>();
        try (Scanner reader = new Scanner(file)) {
            while (reader.hasNextLine()) {
                text.add(reader.nextLine());
            }
        }
        // добавляем файл в нашу систему
        String parentPath = file.toString();
        addToSystem(file.toString(), text);
        // проверяем зависимости
        for (String s : text) {
            int ind = s.indexOf("require");
            if (ind != -1) {
                String childPath = s.substring(ind + 9, s.length() - 1);
                adoption(parentPath, childPath);
            }
        }
    }
}

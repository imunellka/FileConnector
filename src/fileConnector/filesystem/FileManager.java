package fileConnector.filesystem;

import java.io.FileNotFoundException;
import java.util.*;

public class FileManager {
    protected static final List<MyFile> system = new ArrayList<>();
    protected static final List<MyFile> sorted_system = new ArrayList<>();
    protected static String path;

    /**
     * Пустой метод для переопределения в FIleReader
     * @throws FileNotFoundException не найдена папка
     */
    public void readDirectory() throws FileNotFoundException {
    }

    /**
     * Сортировка списка файлов по зависимостям.
     * @throws UnsupportedOperationException в случае выявления зависимостей
     */
    public void sorting() throws UnsupportedOperationException {
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
                    while (file.children.contains(v.getName())) {
                        file.children.remove(v.getName());
                    }
                }
            } else {
                StringBuilder eMessage = new StringBuilder();
                for (MyFile file : system) {
                    eMessage.append(file.getName());
                    eMessage.append(", ");
                }
                throw new UnsupportedOperationException("Cycle was found in these files: " + eMessage);
            }
        }
    }

    /**
     * Добавляет прочтенный файл в систему
     * @param parentPath путь к файлу
     * @param text текст файла
     */
    protected void addToSystem(String parentPath, List<String> text) {
        parentPath = parentPath.substring(path.length() + 1, parentPath.length() - 4);
        system.add(new MyFile(parentPath, text));
    }

    /**
     * Добавляет к родителю ребенка (require зависимости)
     * @param parentPath файл родитель
     * @param childPath файл дите
     */
    protected void adoption(String parentPath, String childPath) {
        int length = parentPath.length();
        parentPath = parentPath.substring(path.length() + 1, length - 4);
        for (MyFile my_file : system) {
            if (Objects.equals(my_file.getName(), parentPath)) {
                my_file.adopt(childPath);
            }
        }
    }
}

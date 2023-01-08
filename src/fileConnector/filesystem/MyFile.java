package fileConnector.filesystem;

import java.util.ArrayList;
import java.util.List;

public class MyFile {
    private final String name;
    protected final List<String> children = new ArrayList<>();
    protected List<String> text;

    public MyFile(String name, List<String> text) {
        this.name = name;
        this.text = text;
    }

    /**
     * Инкупсулируем имя
     *
     * @return имя файла
     */
    public String getName() {
        return name;
    }

    /**
     * Добавление ребенка require
     *
     * @param child имя файла-ребенка
     */
    protected void adopt(String child) {
        children.add(child);
    }
}

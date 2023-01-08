package fileConnector;

import java.io.IOException;

public class Main {

    /**
     * Запускает программу
     * @param args стандартно
     * @throws IOException чтение файла
     */
    public static void main(String[] args) throws IOException {
        Controller process = new Controller();
        process.startProgram();
    }
}
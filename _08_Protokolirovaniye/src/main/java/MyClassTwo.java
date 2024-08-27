import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * Пример логирования с записью сообщений в файл.
 */
public class MyClassTwo {
    private static final Logger logger = Logger.getLogger(MyClassTwo.class.getName());

    static {
        try {
            // Создаем FileHandler для записи в файл с расширением .txt
            FileHandler fileHandler = new FileHandler("Logger.txt", true); // Параметр true в конструкторе
                              // указывает, что записи должны добавляться к существующему файлу, а не перезаписывать его.

            fileHandler.setFormatter(new SimpleFormatter()); // Устанавливаем форматтер для читаемого формата
            logger.addHandler(fileHandler);
        } catch (IOException e) {
            logger.severe("Не удалось создать файл логов: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        logger.info("Информационное сообщение");
        logger.warning("Предупреждающее сообщение");
        logger.severe("Сообщение об ошибке");

        try {
            throw new Exception("Пример исключения");
        } catch (Exception e) {
            logger.log(java.util.logging.Level.SEVERE, "Ошибка при выполнении", e);
        }
    }
}

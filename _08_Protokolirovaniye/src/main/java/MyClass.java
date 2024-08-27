import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * Создание объекта Logger. <p></p>
 * Обычно Logger создаётся с помощью статического метода Logger.getLogger().
 * Чаще всего для этого используют имя класса, в котором создаётся логгер: <p>
 * private static final Logger logger = Logger.getLogger(MyClass.class.getName()); <p>
 * В этом примере MyClass.class.getName() передаётся методу getLogger() для создания логгера с именем,
 * соответствующим имени класса. <p></p>
 * Logger поддерживает различные уровни логирования. Вот несколько основных уровней:<p>
 *
 * SEVERE (самый высокий уровень, критические ошибки); <p>
 * WARNING (предупреждения о потенциальных проблемах); <p>
 * INFO (информационные сообщения, важные для понимания работы программы); <p>
 * CONFIG (конфигурационные сообщения); <p>
 * FINE, FINER, FINEST (различные уровни подробности для отладки). <p></p>
 * Вот как можно записывать сообщения разных уровней: <p>
 * logger.severe("Это сообщение уровня SEVERE"); <p>
 * logger.warning("Это сообщение уровня WARNING"); <p>
 * logger.info("Это сообщение уровня INFO"); <p>
 *
 */

public class MyClass {
    /* В этом примере logger.log(Level.SEVERE, "Ошибка при выполнении", e);
    записывает сообщение об ошибке и исключение вместе с его стек-трейсом.

    Сообщения об ошибке выводятся в терминал.*/

    private static final Logger logger = Logger.getLogger(MyClass.class.getName());

    public static void main(String[] args) {
        logger.info("Информационное сообщение");
        logger.warning("Предупреждающее сообщение");
        logger.severe("Сообщение об ошибке");

        try {
            throw new Exception("Пример исключения");
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Ошибка при выполнении", e);
        }
    }
}

/* Конфигурация Logger.

* Логгеры можно настроить различными способами, например, через файл конфигурации logging.properties.
* Это позволяет настроить формат сообщений, их уровни и другие параметры.

Пример файла конфигурации logging.properties:

handlers=java.util.logging.ConsoleHandler
.level=INFO
java.util.logging.ConsoleHandler.level=INFO
java.util.logging.ConsoleHandler.formatter=java.util.logging.SimpleFormatter */


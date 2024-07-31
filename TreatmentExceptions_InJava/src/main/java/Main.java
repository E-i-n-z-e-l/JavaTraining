/**
 * Исключения — это особые объекты в Java, которые сигнализируют о возникновении ошибок во время выполнения программы.
 * Когда возникает исключение, программа прерывает своё нормальное выполнение и переходит в блок кода, предназначенный
 * для обработки ошибок.
 * <p>
 * Основные понятия: <p></p>
 * Исключение – это объект, который представляет собой ошибку или непредвиденную ситуацию.
 * В Java все исключения являются наследниками класса Throwable.
 * <p>
 * Классы исключений – в Java есть два основных типа исключений:
 * <p>
 * Checked exceptions (проверяемые): Эти исключения должны быть обработаны в коде. Примеры: IOException, SQLException. <p>
 * Unchecked exceptions (непроверяемые): Эти исключения не требуют обязательной обработки и обычно связаны
 * с ошибками программирования. Примеры: NullPointerException, ArrayIndexOutOfBoundsException.<p></p>
 * Блоки try, catch, finally:<p>
 * try: Блок кода, в котором может возникнуть исключение.<p>
 * catch: Блок кода, который перехватывает и обрабатывает исключение.<p>
 * finally: Блок кода, который выполняется независимо от того, произошло исключение или нет.
 * Обычно используется для освобождения ресурсов.<p>
 * throw: Оператор, который используется для явного выброса исключения.<p>
 * throws: Ключевое слово, которое используется в методе для указания, что этот метод может выбросить исключение.
 */

public class Main {
    public static void main(String[] args) {
        try {
            // Попытка разделения чисел
            int result = divide(10, 0);
            System.out.println("Результат деления: " + result);
        } catch (ArithmeticException e) {
            // Обработка исключения
            System.out.println("Ошибка: Деление на ноль!");
        } finally {
            // Этот блок выполняется всегда
            System.out.println("Завершение обработки исключений.");
        }
    }

    // Метод для деления чисел
    public static int divide(int a, int b) {
        return a / b; // Это может привести к исключению ArithmeticException
    }
}

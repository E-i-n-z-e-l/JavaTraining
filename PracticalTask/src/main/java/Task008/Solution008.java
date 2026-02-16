package Task008;

import java.util.Scanner;

/**
 * Задача №8.
 * Теория. <p>
 * Ввод данных пользователем. <p>
 * Метод Scanner. <p>
 * Используется для простого разбора входного потока на токены (по умолчанию — разделитель это пробельные символы) и
 * преобразования этих токенов в примитивные типы (int, double и т. п.) или строки.
 * <p>
 * Удобен для быстрых задач и консольных приложений, но медленнее чем низкоуровневые потоки/BufferedReader в задачах
 * с высокой производительностью.
 */
public class Solution008 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);  // Создаем Scanner для ввода из консоли;

        int[] inputValues =readTwoIntsInteractive(scanner);

        int firstNumber  = inputValues[0];
        int secondNumber = inputValues[1];

        System.out.println(firstNumber * secondNumber);

    }

    /**
     * Функция, принимающая от пользователя два числа и помещающая их в массив;
     * @param scanner
     * @return
     */
    public static int[] readInput(Scanner scanner) {
        System.out.println("Введите два целых числа через пробел: ");
        String inputLine = scanner.nextLine();        // Считываем одну строку из ввода и сохраняем в inputLine;

        /* \s — в регулярных выражениях означает любой пробельный символ (space, tab, newline, carriage return, form feed и др.).
           +  — квантификатор «один или более».
           Итого "\\s+" означает «один или более подряд идущих пробельных символов»; */
        String[] values = inputLine.trim().split("\\s+");

        // Проверим, ввел ли пользователь корректное количество чисел;
        if (values.length < 2) {
            throw new IllegalArgumentException("Ожидаются как минимум два числа в одной строке");
        }
        // Если пользователь ввел не числа, сообщим об этом;
        try {
            int a = Integer.parseInt(values[0]);      // Преобразуем первый токен в целое число;
            int b = Integer.parseInt(values[1]);      // Преобразуем второй токен в целое число;
            return new int[]{a, b}; // Возвращаем значение;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Ожидались целые числа в первых двух токенах", e);
        }
    }

    /**
     * Функция, принимающая два числа. Если пользователь вводит некорректные значения, просит ввести их заново;
     * @param scanner
     * @return
     */
    public static int[] readTwoIntsInteractive(Scanner scanner) {
        System.out.println("Введите два целых числа: ");
        while (true) { // будет работать пока не получит верные значения;
            String line = scanner.nextLine();
            String trimmed = line.trim(); // Удалим все пробелы;
            if (trimmed.isEmpty()) { // Проверим чтобы пользователь что-то ввел;
                System.out.println("Введите два целых числа: ");
                continue;
            }
            String[] vals = trimmed.split("\\s+"); // Удалим все пробелы;
            if (vals.length < 2) {
                System.out.println("Нужно как минимум два числа в одной строке. Попробуйте снова: ");
                continue;
            }
            if (vals.length >= 3) {
                System.out.println("Не вводите более двух целых чисел. Попробуйте снова: ");
                continue;
            }
            try {
                int a = Integer.parseInt(vals[0]); // Переведем полученные данные в целые числа;
                int b = Integer.parseInt(vals[1]);
                return new int[]{a, b};
            } catch (NumberFormatException e) {
                System.out.println("Пожалуйста, вводите только целые числа. Попробуйте снова:");
            }
        }
    }
}

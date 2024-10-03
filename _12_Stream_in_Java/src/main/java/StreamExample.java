import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Основные особенности Stream API:
 * <p>
 * 1. Ленивые вычисления: Операции с потоками не вызываются немедленно, а накапливаются до момента,
 * когда результаты действительно нужны (например, при вызове метода collect()). <p>
 * 2. Обработка данных: Streams поддерживают операции, такие как фильтрация, отображение, сортировка и агрегация. <p>
 * 3. Параллелизм: Вы можете легко использовать потоки для выполнения операций в параллельном режиме. <p>
 * ### Создание потоков: <p>
 *    - stream(): Создает последовательный поток из коллекции. <p>
 *    - parallelStream(): Создает параллельный поток. <p>
 * ### Промежуточные операции (возвращают новый поток): <p>
 *    - filter(Predicate<T> predicate): Фильтрует элементы по заданному условию. <p>
 *    - map(Function<T, R> mapper): Преобразует элементы (например, из одного типа в другой). <p>
 *    - flatMap(Function<T, Stream<R>> mapper): Преобразует элементы в стримы и объединяет их. <p>
 *    - distinct(): Удаляет дубликаты. <p>
 *    - sorted(): Сортирует элементы. <p>
 *    - limit(long maxSize): Ограничивает количество элементов. <p>
 *    - skip(long n): Пропускает первые n элементов. <p>
 * ### Конечные операции (возвращают результат): <p>
 *    - collect(Collector<T, A, R> collector): Собирать элементы в коллекцию (чаще всего в List, Set или Map). <p>
 *    - forEach(Consumer<? super T> action): Применяет действие к каждому элементу. <p>
 *    - reduce(T identity, BinaryOperator<T> accumulator): Сводит элементы к одному значению. <p>
 *    - count(): Подсчитывает количество элементов в потоке. <p>
 *    - anyMatch(Predicate<? super T> predicate): Проверяет, есть ли хотя бы один элемент, удовлетворяющий условию. <p>
 *    - allMatch(Predicate<? super T> predicate): Проверяет, удовлетворяют ли все элементы условию. <p>
 *    - noneMatch(Predicate<? super T> predicate): Проверяет, нет ли хотя бы одного элемента, который удовлетворяет условию.
 */
public class StreamExample {
    public static void main(String[] args) {
        // _____________________Пример №1___________________________________________________
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David");

        // Фильтрация и преобразование
        List<String> filteredNames = names.stream()
                .filter(name -> name.startsWith("A"))
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        System.out.println(filteredNames); // Вывод: [ALICE]

        // _____________________Пример №2___________________________________________________
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        List<Integer> evenNumbers = numbers.stream()
                .filter(currentNumber -> currentNumber % 2 == 0)      // Фильтрация четных чисел
                .map(currentNumber -> currentNumber * currentNumber)  // Квадрат каждого числа
                .collect(Collectors.toList()); // Сбор в список

        System.out.println(evenNumbers);  // Вывод: [4, 16, 36, 64, 100]
    }
}

import java.util.HashSet;
import java.util.Set;

/**
 * Основные реализации Set.
 * <p>
 * HashSet:
 * <p>
 * 1. Основан на хеш-таблице. <p>
 * 2. Очень быстрые операции добавления, удаления и поиска (в среднем O(1)). <p>
 * 3. Не гарантирует порядок элементов. <p>
 * Пример: <p>
 * Set<String> hashSet = new HashSet<>();<p>
 * hashSet.add("apple");<p>
 * hashSet.add("banana");
 * <p>
 * LinkedHashSet: <p>
 * 1. Сохраняет порядок добавления элементов.<p>
 * 2. Также основан на хеш-таблице, но дополнительно использует связный список для хранения порядка.<p>
 * Пример: <p>
 * Set<String> linkedHashSet = new LinkedHashSet<>(); <p>
 * linkedHashSet.add("apple"); <p>
 * linkedHashSet.add("banana");
 * <p>
 * TreeSet: <p>
 * 1. Реализует интерфейс NavigableSet и хранит элементы в отсортированном порядке.<p>
 * 2. Использует красно-черное дерево, что обеспечивает логарифмическое время для основных операций (добавление, удаление, поиск).<p>
 * Пример:<p>
 * Set<String> treeSet = new TreeSet<>();<p>
 * treeSet.add("banana");<p>
 * treeSet.add("apple");
 * <p>
 * Основные операции: <p>
 * 1. Добавление элемента: add(E e) — добавляет элемент, возвращает true, если элемент был добавлен (т.е. его не было в множестве). <p>
 * 2. Удаление элемента: remove(Object o) — удаляет элемент, возвращает true, если элемент был удалён. <p>
 * 3. Проверка на наличие: contains(Object o) — проверяет, есть ли элемент в множестве. <p>
 * 4. Размер: size() — возвращает количество элементов в множестве. <p>
 * 5. Очистка: clear() — удаляет все элементы из множества.
 */
public class SetExample {
    public static void main(String[] args) {
        Set<String> fruits = new HashSet<>();
        fruits.add("apple");
        fruits.add("banana");
        fruits.add("orange");

        // Попытка добавить дубликат
        fruits.add("apple"); // не добавится

        System.out.println(fruits); // Вывод: [banana, orange, apple]

        // Проверка наличия элемента
        if (fruits.contains("banana")) {
            System.out.println("Banana is in the set.");
        }

        // Удаление элемента
        fruits.remove("orange");
        System.out.println(fruits); // Вывод: [banana, apple]
    }
}

import java.util.HashMap;
import java.util.Map;

/**
 * Map — это интерфейс, представляющий коллекцию пар "ключ-значение". Он позволяет ассоциировать уникальные
 * ключи с определёнными значениями. В отличие от коллекций, таких как Set и List, Map не хранит дубликатов
 * ключей, но может хранить дубликаты значений. <p>
 * Основные реализации Map <p>
 * HashMap: <p>
 * 1. Основан на хеш-таблице. <p>
 * 2. Очень быстрые операции добавления, удаления и поиска (в среднем O(1)). <p>
 * 3. Не гарантирует порядок элементов. <p>
 * Пример: <p>
 * Map<String, Integer> hashMap = new HashMap<>(); <p>
 * hashMap.put("apple", 1); <p>
 * hashMap.put("banana", 2); <p>
 * LinkedHashMap: <p>
 * 1. Сохраняет порядок добавления элементов. <p>
 * 2. Использует хеш-таблицу и связный список. <p>
 * Пример: <p>
 * Map<String, Integer> linkedHashMap = new LinkedHashMap<>(); <p>
 * linkedHashMap.put("apple", 1); <p>
 * linkedHashMap.put("banana", 2); <p>
 * TreeMap: <p>
 * 1. Хранит элементы в отсортированном порядке по ключам. <p>
 * 2. Использует красно-черное дерево, что обеспечивает логарифмическое время для основных операций. <p>
 * Пример: <p>
 * Map<String, Integer> treeMap = new TreeMap<>(); <p>
 * treeMap.put("banana", 2); <p>
 * treeMap.put("apple", 1); <p>
 * Основные операции: <p>
 * 1. Добавление/обновление элемента: put(K key, V value) — добавляет пару ключ-значение или обновляет значение, если ключ уже существует. <p>
 * 2. Получение значения по ключу: get(Object key) — возвращает значение, связанное с указанным ключом, или null, если ключ не найден. <p>
 * 3. Удаление элемента: remove(Object key) — удаляет пару по ключу и возвращает удалённое значение. <p>
 * 4. Проверка на наличие ключа/значения: containsKey(Object key) и containsValue(Object value). <p>
 * 5. Размер: size() — возвращает количество пар ключ-значение. <p>
 * 6. Очистка: clear() — удаляет все пары.
 */
public class MapExample {
    public static void main(String[] args) {
        Map<String, Integer> fruitPrices = new HashMap<>();
        fruitPrices.put("apple", 100);
        fruitPrices.put("banana", 150);
        fruitPrices.put("orange", 120);

        // Получение цены на яблоки
        System.out.println("Price of apple: " + fruitPrices.get("apple")); // Вывод: 100

        // Проверка наличия ключа
        if (fruitPrices.containsKey("banana")) {
            System.out.println("Banana price: " + fruitPrices.get("banana")); // Вывод: 150
        }

        // Удаление элемента
        fruitPrices.remove("orange");
        System.out.println("Fruits map after removing orange: " + fruitPrices);
    }
}

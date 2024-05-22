package Task001;

/**
 * Напишите функцию для поиска самой длинной общей префиксной строки среди массива строк.
 * Если общего префикса нет, верните пустую строку.
 * <p>
 * Префиксная строка - это последовательность символов, которая является начальной частью другой строки.
 * Другими словами, префикс строки является начальным подмножеством символов этой строки.
 * А еще лучшими словами префикс это как приставка в слове.
 * <p>
 * Например, в строке "abcdef", префиксами будут "a", "ab", "abc", "abcd", "abcde" и "abcdef".
 * В этом контексте "abcdef" также является префиксом для самой себя.
 * <p>
 * В задаче о поиске самого длинного общего префикса среди массива строк требуется найти наибольшую общую
 * последовательность символов, которая является префиксом для всех строк в массиве.
 */
public class Solution001 {
    public static void main(String[] args) {
        String[] strs_1 = new String[] {"flower","flow","flight"};
        String[] strs_2 = new String[] {"dog","racecar","car"};
        String[] strs_3 = new String[] {"абаабабаба","ааба","аабапе"};

        System.out.println(searchString(strs_1));

        System.out.println(searchString(strs_2));
        System.out.println(searchStringGPT(strs_2));

        System.out.println(searchString(strs_3));
    }

    /**
     * Мое решение.
     * @param strs
     * @return
     */
    public static String searchString(String[] strs) {
        String prefix = ""; // Создаем пустую строку, которую будем возвращать, если не найдем префикс.
        if (strs.length > 0) { // Если длина массива больше 0, начинаем поиск.
            String firstElement = strs[0]; // Берем первый элемент строчного массива.
            char firstChar = firstElement.charAt(0); // Берем первую букву первого элемента массива.
            for (int i = 1; i < strs.length; i++) { // Проходимся по массиву, в поисках одинаковых букв.
                if (strs[i].charAt(0) != firstChar) { // Если одна из первых букв не равна первой букве первого элемента массива, заканчиваем поиск.
                    return ""; // Возвращаем пустую строку, если не нашли префикс.
                }
                for (int j = 1; j < strs[i].length(); j++) { // Проходимся по буквам следующих элементов массива;
                    if (strs[i].charAt(j) != strs[0].charAt(j)) { // Если символы не совпадают, общий префикс не найден.
                        return strs[0].substring(0, j); // Возвращаем префикс, который был найден до этого момента.
                    }
                }
            }
            prefix = Character.toString(firstChar); // Приводим тип char к типу String.
        }
        return prefix;
    }

    /**
     * Решение GPT.
     * @param strs
     * @return
     */
    public static String searchStringGPT(String[] strs) {
        if (strs == null || strs.length == 0) { // Если в списке нет элементов или он заполнен элементами null, вернуть пустую строку.
            return "";
        }

        String prefix = strs[0]; // Инициализируем префикс значением первой строки

        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) { // Метод indexOf() используется для поиска индекса первого вхождения подстроки в строке.
                prefix = prefix.substring(0, prefix.length() - 1); // Уменьшаем префикс на один символ (по сути уменьшаем строку на один символ).
                if (prefix.isEmpty()) { // Если префикс стал пустым, значит общего префикса нет.
                    return "";
                }
            }
        }
        return prefix;
    }
}

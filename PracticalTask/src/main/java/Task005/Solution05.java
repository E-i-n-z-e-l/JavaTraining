package Task005;

/**
 * Даны две строки: needle и haystack. Верните индекс первого вхождения needle в haystack, или -1,
 * если needle не является частью haystack.
 */
public class Solution05 {
    public static void main(String[] args) {
        String haystack01 = "sadbutsad";
        String needle01 = "sad";

        String haystack02 = "leetcode";
        String needle02 = "leeto";

        String haystack03 = "leetcode";
        String needle03 = "cod";

        System.out.println(solution(haystack01, needle01));
        System.out.println(solution(haystack02, needle02));
        System.out.println(solution(haystack03, needle03));
    }

    /**
     *
     * @param haystack
     * @param needle
     * @return index
     */
    public static int solution (String haystack, String needle) {
        int index = -1; // Инициализируем переменную index, которая будет хранить индекс первого вхождения
                        // `needle` в `haystack`. Начальное значение -1 указывает на то, что вхождение не найдено;

        char firstCharacter = needle.charAt(0); // Создаем переменную в которой сохраняем первый символ needle для начала проверки;

        // i <= haystack.length() - needle.length() - используем для того, чтобы убрать лишние проверки.
        // Например, есть строка "линейка".  Нам нужно взять из этой строки подстроку "ками", которой в строке нет.
        // И чтобы нам даже не начинать искать подстроку "ками" в строке "линейка", мы отнимаем длину строки от длины
        // подстроки, чтобы точно убедиться в том, что искомая подстрока по размеру будет подходить в искомой строке.
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            if (haystack.charAt(i) == firstCharacter) {
                // Метод substring(int beginIndex, int endIndex) в Java используется для извлечения подстроки из строки.
                // Он возвращает новую строку, которая состоит из символов оригинальной строки, начиная с beginIndex и
                // заканчивая символом перед endIndex.
                // Если символы подстроки с индексами i и i + needle.length() равны, значит найдено вхождение needle в
                // haystack с индексом i. Выходим из цикла, чтобы не продолжать искать дальше.
                // В противном случае продолжаем искать в оставшейся части исходной строки.
                if (haystack.substring(i, i + needle.length()).equals(needle)) {
                    index = i;
                    break;
                }
            }
        }
        return index;
    }
}

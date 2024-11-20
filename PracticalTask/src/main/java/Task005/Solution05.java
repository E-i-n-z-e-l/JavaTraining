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

    public static int solution (String haystack, String needle) {
        int index = -1;
        char firstCharacter = needle.charAt(0);

        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            if (haystack.charAt(i) == firstCharacter) {
                // Метод substring(int beginIndex, int endIndex) в Java используется для извлечения подстроки из строки.
                // Он возвращает новую строку, которая состоит из символов оригинальной строки, начиная с beginIndex и
                // заканчивая символом перед endIndex.
                if (haystack.substring(i, i + needle.length()).equals(needle)) {
                    index = i;
                    break;
                }
            }
        }
        return index;
    }
}

package Task03;

/**
 * Длина последнего слова. <p>
 * Дана строка s, состоящей из слов и пробелов, необходимо вернуть длину последнего слова в строке. <p>
 * Слово — это максимальная подстрока, состоящая только из не пробельных символов. <p> </p>
 * Ограничения: <p>
 * 1 <= String.length <= 104 <p>
 * String состоит только из английских букв и пробелов ' '. <p>
 * В String будет как минимум одно слово. <p>
 */
public class Solution003 {
    /**
     * Мое решение. Проход по строке и подсчет символов.
     * @param s вводная строка
     * @return количество символов в последнем слове
     */
    public static int lengthOfLastWord(String s) {
        int count = 0;
        int lastWordLength = 0;
        char targetCharacter = ' ';
        for (int i = 0; i < s.length(); i++) {
           if (s.charAt(i) != targetCharacter) {
               count++;
               lastWordLength = count;
           }
           else {
               count = 0;
           }
        }
        return lastWordLength;
    }

    /**
     * Используем два цикла - первый цикл для того, чтобы удалить все возможные пробелы с конца строки.
     * Второй цикл считает длину (количество символом) последнего слова.
     * @param s вводная строка
     * @return количество символов в последнем слове
     */
    public static int lengthOfLastWordGPT(String s) {
        int length = 0; // Длина последнего слова
        int i = s.length() - 1; // Начинаем с конца строки

        // Пропускаем пробелы в конце
        while (i >= 0 && s.charAt(i) == ' ') {
            i--;
        }

        // Считаем длину последнего слова
        while (i >= 0 && s.charAt(i) != ' ') {
            length++;
            i--;
        }
        return length;
    }


    public static void main(String[] args) {
        String firstRow = "Hello World";
        String secondRow = "   fly me   to   the moon  ";
        String thirdRow = "luffy is still joyboy";

        System.out.println(lengthOfLastWord(firstRow));
        System.out.println(lengthOfLastWord(secondRow));
        System.out.println(lengthOfLastWord(thirdRow));

        System.out.println(lengthOfLastWordGPT(firstRow));
        System.out.println(lengthOfLastWordGPT(secondRow));
        System.out.println(lengthOfLastWordGPT(thirdRow));
    }
}

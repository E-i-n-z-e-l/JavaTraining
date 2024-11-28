package Task007;

/**
 Даны две строки "s" и "t". Верните true, если s является подпоследовательностью t, в противном случае верните false. <p>

 Подпоследовательность строки — это новая строка, которая формируется из исходной строки путем удаления некоторых
 (может быть, ни одного) символов, не нарушая относительных позиций оставшихся символов. (например, "ace" является
 подпоследовательностью "abcde", в то время как "aec" — нет).
 */
public class Solution007 {
    public static void main(String[] args) {
        String s1 = "ace";
        String t1 = "abcde";
        System.out.println(isSubsequence(s1, t1)); // true

        String s2 = "aced";
        String t2 = "axcdef";
        System.out.println(isSubsequence(s2, t2)); // false

        String s3 = "cdef";
        String t3 = "abcdef";
        System.out.println(isSubsequence(s3, t3)); // true

        String s4 = "abc";
        String t4 = "ahbgdc";
        System.out.println(isSubsequence(s4, t4)); // true

        String s5 = "axc";
        String t5 = "ahbgdc";
        System.out.println(isSubsequence(s5, t5)); // false
    }

    /**
     * Метод поиска подпоследовательности в строке.
     * @param s подпоследовательность
     * @param t строка
     * @return true/false
     */
    public static boolean isSubsequence(String s, String t) {
        // Проверяем, что длина подпоследовательности меньше длины исходной строки;
        if (t.length() < s.length()) {
            return false;
        }

        int j = 0; // Используем эту переменную для проведения итерации символов из подпоследовательности;

        // Проходимся по строке;
        for (int i = 0; i < t.length(); i++) {
            // Если символы совпадают, идем дальше, при условии, что следующий символ меньше длины строки;
            if (j < s.length() && s.charAt(j) == t.charAt(i)) {
                j++;
            }
        }
        return j == s.length(); // Если j == s.length(), то значит что мы нашли подпоследовательность;
    }
}

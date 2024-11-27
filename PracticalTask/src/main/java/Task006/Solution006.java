package Task006;

/**
 * Фраза является палиндромом, если после преобразования всех заглавных букв в строчные и удаления всех
 * неалфавитно-цифровых символов она читается одинаково слева направо и справа налево. Алфавитно-цифровые
 * символы включают буквы и цифры. <p>
 * Дана строка s, верните true, если она является палиндромом, или false в противном случае.
 */
public class Solution006 {
    public static void main(String[] args) {
        String s01 = "abababa";
        System.out.println(isPalindrome(s01)); // true;

        String s02 = "race a car";
        System.out.println(isPalindrome(s02)); // false;

        String s03 = "nfdrgf";
        System.out.println(isPalindrome(s03)); // false;

        String s04 = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(s04)); // true;

        String s05 = " ";
        System.out.println(isPalindrome(s05)); // true;
    }

    /**
     * Метод создаем из входящей строки "s" StringBuilder, с помощью которого мы сможем очистить строку от всех
     * неалфавитно-цифровые символов. Потом строку снова соберем из StringBuilder и начнем сравнивать первый символ
     * строки с последним, пока не дойдем до середины. Если каждый раз символы будут совпадать, то палиндром найден.
     * @param s входящая строка
     * @return true || false
     */
    public static boolean isPalindrome(String s) {
        StringBuilder filteredString = new StringBuilder(); // Создаем StringBuilder для того, чтобы разобрать слово,
                                                            // удалить из него все неалфавитно-цифровые символы и
                                                            // потом снова преобразовать в строку;

        String lowerCaseInput = s.toLowerCase(); // Преобразуем строку в нижний регистр;

        // Удаляем все неалфавитно-цифровые символы;
        for (char c : lowerCaseInput.toCharArray()) {
            if (Character.isLetterOrDigit(c)) { // Если символ "c" цифра или пробел, удаляем его;
                filteredString.append(c); // Если все нормально, добавляем в StringBuilder;
            }
        }

        String processedString = filteredString.toString(); // Из StringBuilder снова собираем строку;

        for (int i = 0; i < processedString.length() / 2; i++) {
            char firstCharacter = processedString.charAt(i);
            if (processedString.charAt(i) != processedString.charAt(processedString.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}

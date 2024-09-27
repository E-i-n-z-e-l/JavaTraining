package Task002;

import java.util.Stack;

/**
 * Дана строка s, содержащая только символы '(', ')', '{', '}', '[', ']', определите, является ли входная строка допустимой. <p>
 * Входная строка допустима, если:<p>
 * 1. Открытые скобки должны быть закрыты скобками того же типа.<p>
 * 2. Открытые скобки должны быть закрыты в правильном порядке.<p>
 * 3. Каждой закрывающейся скобке соответствует открытая скобка того же типа.
 */
public class Solution002 {
    public boolean isValid(String s) {
        // Счетчики для каждой пары скобок
        int round = 0;
        int curly = 0;
        int square = 0;

        // Проходим по каждому символу в строке
        for (char ch : s.toCharArray()) {
            switch (ch) {
                case '(':
                    round++;
                    break;
                case ')':
                    round--;
                    if (round < 0) return false;
                    break;
                case '{':
                    curly++;
                    break;
                case '}':
                    curly--;
                    if (curly < 0) return false;
                    break;
                case '[':
                    square++;
                    break;
                case ']':
                    square--;
                    if (square < 0) return false;
                    break;
                default:
                    return false; // Неизвестный символ
            }
        }

        // Проверяем, что все счетчики вернулись к нулю
        return round == 0 && curly == 0 && square == 0;
    }

    public static void main(String[] args) {
        Solution002 solution = new Solution002();

        String s = "()";
        String d = "()[]{}";
        String f = "(]";
        String g = "([])";

        System.out.println(solution.isValid(s)); // true
        System.out.println(solution.isValid(d)); // true
        System.out.println(solution.isValid(f)); // false
        System.out.println(solution.isValid(g)); // true
        System.out.println("________________________________________________________________");
        System.out.println(solution.isValidStack(s)); // true
        System.out.println(solution.isValidStack(d)); // true
        System.out.println(solution.isValidStack(f)); // false
        System.out.println(solution.isValidStack(g)); // true
    }

    /**
     * Использование стека: <p>
     * Открывающая скобка добавляется в стек. <p>
     * При встрече закрывающей скобки проверяем, соответствует ли она последней открывающей скобке в стеке. <p>
     * Если скобка не соответствует или стек пуст, строка недопустима. <p>
     * В конце проверки стек должен быть пустым, если все скобки правильно закрыты. <p>
     * <p></p>
     * Объяснение: <p>
     * Стек используется для хранения открывающих скобок. При встрече закрывающей скобки мы проверяем, соответствует
     * ли она последней открывающей скобке из стека. <p>
     * Метод isValidPair помогает убедиться, что закрывающая скобка действительно соответствует своей открывающей скобке. <p>
     * После обработки всех символов в строке, если стек пуст, это означает, что все скобки корректно закрыты, и строка допустима. <p>
     * @param s
     * @return
     */
    public boolean isValidStack(String s) {
        // Создаем стек для хранения открывающих скобок
        Stack<Character> stack = new Stack<>();

        // Проходим по каждому символу в строке
        for (char ch : s.toCharArray()) {
            // Если символ - открывающая скобка, помещаем его в стек
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else {
                // Если символ - закрывающая скобка, проверяем стек
                if (stack.isEmpty()) {
                    return false; // Нет соответствующей открывающей скобки
                }

                // Получаем последнюю открывающую скобку из стека
                char top = stack.pop();

                // Проверяем соответствие закрывающей скобки открывающей
                if (!isValidPair(top, ch)) {
                    return false;
                }
            }
        }

        // В конце проверки стек должен быть пустым
        return stack.isEmpty();
    }

    // Метод для проверки соответствия пары скобок
    private boolean isValidPair(char open, char close) {
        return (open == '(' && close == ')') ||
                (open == '{' && close == '}') ||
                (open == '[' && close == ']');
    }
}

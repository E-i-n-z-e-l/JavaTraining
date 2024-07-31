import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.IntBinaryOperator;

/**
 * Лямбда-выражения в Java — это компактный способ представления анонимных функций, то есть функций без имени,
 * которые можно передавать как аргументы другим функциям.
 * <p>
 * Основные преимущества лямбда-выражений:
 * <p>
 * Краткость кода: Лямбда-выражения позволяют написать функциональный код более компактно, чем анонимные классы.
 * <p>
 * Удобство использования в коллекциях: Они очень удобны для работы с коллекциями (например, списками и картами)
 * благодаря методам высшего порядка, таким как forEach, filter, map и т.д.
 * <p>
 * Поддержка функционального программирования: Лямбда-выражения позволяют писать код в стиле функционального
 * программирования, что способствует более декларативному и выразительному стилю кода.
 * <p>
 * Общий синтаксис лямбда-выражения в Java выглядит так:
 * <p>
 * (parameters) -> expression
 * <p>
 * или
 * <p>
 * (parameters) -> { statements; }
 */

public class Main {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Alice");
        names.add("Bob");
        names.add("Charlie");
        names.add("David");

        // Сортировка списка по длине строк с использованием лямбда-выражения
        Collections.sort(names, (String s1, String s2) -> s1.length() - s2.length());

        // Вывод отсортированного списка
        System.out.println("Список отсортирован по длине строк:");
        for (String name : names) {
            System.out.println(name);
        }




        /* ___________________________________________________________________________________________
        Нельзя использовать лямбда-выражения просто так - нужен "функциональный" интерфейс,
        через который будет работать эта анонимная функция.
        В примере используется функциональный интерфейс BinaryOperator.
        */

        IntBinaryOperator sum = (a, b) -> a + b;
        int a = 2;
        int b = 1;

        // Вызов лямбда-выражения через функциональный интерфейс
        int result = sum.applyAsInt(a, b);
        System.out.println("Результат: " + result);
    }
}
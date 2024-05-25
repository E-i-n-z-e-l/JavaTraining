/**
 * Это простой пример использования enum в Java. В реальном коде enum часто используются для представления
 * различных состояний объекта, типов данных или опций, что делает код более читаемым и поддерживаемым.
 */
public class EnumExample {
    enum Size {
        SMALL,
        MEDIUM,
        LARGE
    }
    public static void main(String[] args) {
        // Использование enum
        Size pizzaSize = Size.MEDIUM;

        // Пример использования enum в условном операторе
        if (pizzaSize == Size.SMALL) {
            System.out.println("Выбрана маленькая пицца");
        } else if (pizzaSize == Size.MEDIUM) {
            System.out.println("Выбрана средняя пицца");
        } else if (pizzaSize == Size.LARGE) {
            System.out.println("Выбрана большая пицца");
        }
    }
}

package Task02;

/**
 * Класс-наследник Dog;
 */
public class Dog extends Animals{
    public Dog(String name) { // Вызов конструктора суперкласса для инициализации имени.
        super(name);
    }
    @Override // Переопределяем метод makeSound, потому что каждое животное издаем разные звуки.
    public void makeSound() {
        System.out.println("Гав-Гав");
    };
}

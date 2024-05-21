package Task02;

/**
 * Класс-наследник Cat.
 */
public class Cat extends Animals{
    public Cat(String name) {
        super(name); // Вызов конструктора суперкласса для инициализации имени.
    }
    @Override // Переопределяем метод makeSound, потому что каждое животное издаем разные звуки.
    public void makeSound() {
        System.out.println("Мяу-Мяу");
    }
}

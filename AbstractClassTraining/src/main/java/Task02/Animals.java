package Task02;

/**
 * Тренировка абстрактных классов №1.
 * Создание абстрактного класса, от которого потом будут наследоваться классы-наследники.
 * Создание общей переменной для всех классов-наследников - имени животного.
 */
public abstract class Animals {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name; // Объявляем глобальную переменную;
    public Animals(String name) { // Создаем для неё конструктор;
        this.name = name;
    }

    public abstract void makeSound(); // Создаем абстрактный метод, который потом сможем переопределить в классах наследниках;
}

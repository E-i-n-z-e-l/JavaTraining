package Task01;

/**
 * Создаем абстрактный класс Person.
 */
public abstract class Person {
    /**
     * Создаем метод getDescription(), реализацию которого опишем в другом классе.
     * В абстрактном классе это делать не обязательно.
     */
    public abstract String getDescription();
    private String name; // Объявляем приватное поле name;
    public Person(String name){
        this.name = name;
    }
    /**
     * Создаем getter.
     */
    public String getName(){
        return name;
    }
}

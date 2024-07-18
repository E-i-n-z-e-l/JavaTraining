import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Интерфейс Comparator.
 * <p>
 * Comparator используется для определения пользовательского порядка сортировки объектов, который может
 * отличаться от естественного порядка, заданного интерфейсом Comparable.
 * <p>
 * В этом примере ageComparator позволяет сортировать список объектов типа Person по возрасту. Это особенно
 * полезно, если класс Person не реализует интерфейс Comparable, или если требуется несколько различных способов
 * сортировки.
 */

public class Person {
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    private String name;
    private int age;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();

        people.add(new Person("John", 21));
        people.add(new Person("Nick", 23));
        people.add(new Person("Sally", 19));
        people.add(new Person("Sara", 32));

        /* Создаем Comparator "ageComparator", чтобы потом использовать его для сравнивания (сортировки) списков. */
        Comparator<Person> ageComparator = new Comparator<Person>() {
            @Override // Сортировка по возрастанию.
            public int compare(Person person1, Person person2) { // Метод compare сравнивает два объекта типа Person по их возрасту;
                return person1.getAge() - person2.getAge();
                /*
                * Если person1.getAge() меньше person2.getAge(), результат будет отрицательным числом;
                * Если возрасты равны, результат будет нулем;
                * Если person1.getAge() больше person2.getAge(), результат будет положительным числом; */
            }
        };

        /*  // Сортировка по убыванию.
            Comparator<Person> ageComparatorDescending = new Comparator<Person>() {
                @Override
                public int compare(Person person1, Person person2) {
                    return person2.getAge() - person1.getAge();
                }
            }; */

        people.sort(ageComparator);
        System.out.println(people);
    }
}

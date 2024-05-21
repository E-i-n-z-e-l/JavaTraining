package Task02;

public class MainAnimals {
    public static void main(String[] args) {
        Animals cat = new Cat("Murzik");
        Animals dog = new Dog("Sharika");

        cat.makeSound();
        cat.move();

        dog.makeSound();
        dog.move();
    }
}

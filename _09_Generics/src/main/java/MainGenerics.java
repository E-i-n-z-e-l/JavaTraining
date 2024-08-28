/**
 * Обобщенное программирование. (Generics)
 * <p>
 * В этом примере создается обобщенный класс, который имеет две переменные - oneValue и twoValue. Так как переменным
 * изначально не был присвоен тип данных (Sting или int и др.), то прямо в классе main мы можем задать этот тип данных
 * при создании объекта MainGenerics<String> generator.
 * @param <T>
 */

public class MainGenerics<T> {
    private T oneValue;
    private T twoValue;

    public T getOneValue() {
        return oneValue;
    }

    public void setOneValue(T newValue) {
        this.oneValue = newValue;
    }

    public T getTwoValue() {
        return twoValue;
    }

    public void setTwoValue(T newValue) {
        this.twoValue = newValue;
    }

    @Override
    public String toString() {
        return "MainGenerics {" +
                "oneValue это строка = " + oneValue +
                ", twoValue это число = " + twoValue +
                '}';
    }

    /* Обобщенный метод.
    * <U> — это параметр типа метода. Он позволяет методу работать с любым типом данных.
    *
    * В методе concatenate, мы используем first.toString() и second.toString(),
    * чтобы преобразовать оба параметра в строки и соединить их.
    * */
    public <U> String concatenate(U first, U second) {
        return first.toString() + second.toString();
    }

    public static void main(String[] args) {
        MainGenerics<String> generator = new MainGenerics<>();
        generator.setOneValue("OneValue");
        generator.setTwoValue("2");

        System.out.println(generator);

        // Использование обобщенного метода
        MainGenerics<String> generator2 = new MainGenerics<>();
        String result = generator2.concatenate("Hello", "World");
        System.out.println("Concatenated result: " + result);
    }
}

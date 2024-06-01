/**
 * В этом примере переменная shapes типа Shape[] является интерфейсной переменной.
 * Это позволяет нам хранить объекты любого класса, который реализует интерфейс Shape,
 * включая Circle, Rectangle и Triangle.
 * <p>
 * Это увеличивает гибкость нашего кода, поскольку
 * мы можем легко добавлять новые фигуры, не изменяя существующий код.
 */
public class Main {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];
        shapes[0] = new Circle(5);
        shapes[1] = new Rectangle(4, 3);
        shapes[2] = new Triangle(4, 5);

        ShapeCalculator calculator = new ShapeCalculator();
        double totalArea = calculator.calculateTotalArea(shapes);
        System.out.println("Total area: " + totalArea);
    }
}

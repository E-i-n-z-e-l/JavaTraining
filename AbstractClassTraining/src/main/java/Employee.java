import java.time.LocalDate;

public class Employee extends Person {
    private double salary; // Создаем поле заработной платы;
    private LocalDate hireDay; // Создаем поле дня найма сотрудника;
    public Employee(String name, double salary, int year, int month, int day) {
        super(name);
        this.salary = salary;
        hireDay = LocalDate.of (year, month, day); // С помощью метода of указываем дату, используя три переменных;
    }

    /**
     * Метод показывающий заработную плату;
     */
    public double getSalary() {
        return salary;
    }

    /**
     * Метод показывающий дату найма сотрудника;
     */
    public LocalDate getHireDay() {
        return hireDay;
    }
    public String getDescription() {
        return String.format("работник с зарплатой $%.2f", salary);
    }
    public void raiseSalary(double byPercent) {
        double raise = salary * byPercent / 100;
        salary += raise;
    }
}


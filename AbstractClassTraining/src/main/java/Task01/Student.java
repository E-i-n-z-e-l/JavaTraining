package Task01;

public class Student extends Person{
    private String major;
    public Student(String major, String name) {
        super(name);
        this.major = major;
    }
    public  String getDescription() {
        return "студент по специальности " + major;
    }
}

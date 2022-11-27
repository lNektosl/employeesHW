public class Employee extends Person{
    private Level level;
    private double salary;

    public Employee(String firstName, String lastName, int age, Gender gender, Level level, double salary) {
        super(firstName, lastName, age, gender);
        this.level = level;
        this.salary = salary;
    }

    public Level getLevel() {
        return level;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return String.format("%s, %s, %d, %s, %s, %.2f",
                this.firstName,
                this.lastName,
                this.age,
                this.gender,
                this.level,
                this.salary);
    }
}

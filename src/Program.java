public class Program {
    public static void main(String[] args) {
        Generator generator = new Generator("employees.csv", 100);
        generator.generate();

    }
}

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

//Класс будет генерить нам случайную выборку работников
public class Generator {
    private static final String[] maleNames = new String[] {
            "Никита",
            "Алексей",
            "Александр",
            "Демид",
            "Илья",
            "Владислав",
            "Вячеслав",
            "Давид",
            "Дмитрий",
            "Даниил"
    };

    private static final String[] femaleNames = new String[] {
            "Ева",
            "Ксения",
            "Мария",
            "Василиса",
            "Светлана",
            "Юлия",
            "Полина",
            "Ариана",
            "Варвара",
            "София"
    };

    //Женские фамилии будем получать добавлением буквы а к мужской фамилии
    private static final String[] maleLastNames = new String[] {
            "Богданов",
            "Захаров",
            "Чернов",
            "Соколов",
            "Абрамов",
            "Федотов",
            "Евдокимов",
            "Прокофьев",
            "Малышев",
            "Шульгин"
    };

    private static final int LOWER_BOUND_AGE = 18;
    private static final int UPPER_BOUND_AGE = 90;
    private static final double LOWER_BOUND_SALARY = 20000.0;
    private static final double UPPER_BOUND_SALARY = 200000.0;

    private final String fileName;
    private final int amount;

    public Generator(String fileName, int amount) {
        this.fileName = fileName;
        this.amount = amount;
    }

    private String generateName(Gender gender) {
        int nameIndex = (int)(Math.random() * (gender.equals(Gender.MALE) ? maleNames.length : femaleNames.length));
        return gender.equals(Gender.MALE)
                ? maleNames[nameIndex]
                : femaleNames[nameIndex];
    }

    private String generateLastName(Gender gender) {
        int lastNameIndex = (int)(Math.random() * maleLastNames.length);
        return gender.equals(Gender.MALE)
                ? maleLastNames[lastNameIndex]
                : maleLastNames[lastNameIndex] + "а";
    }

    private Employee generateOne() {
        Gender gender = (int)(Math.random() * 2) == 1 ? Gender.MALE : Gender.FEMALE;
        int age = (int)(Math.random() * (UPPER_BOUND_AGE - LOWER_BOUND_AGE + 1) + LOWER_BOUND_AGE);
        Level level = Level.values()[(int)(Math.random() * 3)];
        double salary = Math.random() * (UPPER_BOUND_SALARY - LOWER_BOUND_SALARY + 1.0);
        String name = generateName(gender);
        String lastName = generateLastName(gender);
        return new Employee(name, lastName, age, gender, level, salary);
    }

    public void generate() {
        try(FileOutputStream outputStream = new FileOutputStream(fileName);
            PrintWriter writer = new PrintWriter(outputStream)
        ) {
            writer.println("firstName,lastName,age,gender,level,salary");
            for(int i = 0; i < this.amount; ++i) {
                Employee employee = generateOne();
                writer.println(employee);
            }
        }
        catch(IOException ex) {
            ex.printStackTrace();
        }
    }
}

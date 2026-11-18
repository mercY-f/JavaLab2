import java.time.Year;
import java.util.Scanner;

public class SimpleTask3_LeapYear {

    public static boolean isLeapYear(int year) {
        return (year % 400 == 0) || (year % 4 == 0 && year % 100 != 0);
    }

    public static void run(Scanner scanner) {
        System.out.println("=== Простое задание 3: Проверка високосного года ===");
        System.out.print("Введите год (например, 2024): ");
        int year = scanner.nextInt();

        boolean leap = isLeapYear(year);
        boolean checkWithStdLib = Year.isLeap(year);

        if (leap) {
            System.out.printf("Год %d является ВИСОКОСНЫМ (366 дней).%n", year);
        } else {
            System.out.printf("Год %d НЕ является високосным (365 дней).%n", year);
        }
        System.out.println("Правило: делится на 400 ИЛИ (делится на 4 и не делится на 100).");
        System.out.println("Сверка с java.time.Year.isLeap: " + checkWithStdLib);
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            run(scanner);
        }
    }
}
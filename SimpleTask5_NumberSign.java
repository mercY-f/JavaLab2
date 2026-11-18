import java.util.Scanner;

public class SimpleTask5_NumberSign {

    public static String determineSign(double number) {
        if (number > 0) {
            return "ПОЛОЖИТЕЛЬНЫМ (> 0)";
        } else if (number < 0) {
            return "ОТРИЦАТЕЛЬНЫМ (< 0)";
        } else {
            return "НУЛЕВЫМ (== 0)";
        }
    }

    public static void run(Scanner scanner) {
        System.out.println("=== Простое задание 5: Определение знака числа ===");
        System.out.print("Введите число: ");
        double num = Double.parseDouble(scanner.next().replace(',', '.'));

        String result = determineSign(num);
        String formattedNum = (num == (long) num) ? String.valueOf((long) num) : String.valueOf(num);
        System.out.printf("Введённое число %s является %s.%n", formattedNum, result);
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            run(scanner);
        }
    }
}
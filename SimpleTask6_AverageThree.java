import java.util.Scanner;

public class SimpleTask6_AverageThree {

    public static double calculateAverage(double a, double b, double c) {
        return (a + b + c) / 3.0;
    }

    public static void run(Scanner scanner) {
        System.out.println("=== Простое задание 6: Среднее арифметическое трёх чисел ===");
        System.out.print("Введите первое число: ");
        double a = Double.parseDouble(scanner.next().replace(',', '.'));
        System.out.print("Введите второе число: ");
        double b = Double.parseDouble(scanner.next().replace(',', '.'));
        System.out.print("Введите третье число: ");
        double c = Double.parseDouble(scanner.next().replace(',', '.'));

        double sum = a + b + c;
        double avg = calculateAverage(a, b, c);

        System.out.printf("Сумма чисел: %.4f%n", sum);
        System.out.printf("Среднее арифметическое: (%.2f + %.2f + %.2f) / 3 = %.4f%n", a, b, c, avg);
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            run(scanner);
        }
    }
}
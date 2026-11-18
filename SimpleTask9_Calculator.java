import java.util.Scanner;

public class SimpleTask9_Calculator {

    public static Double calculate(double a, double b, char op) {
        switch (op) {
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
            case '/':
                if (b == 0) {
                    return null;
                }
                return a / b;
            default:
                throw new IllegalArgumentException("Неизвестная операция: " + op);
        }
    }

    public static void run(Scanner scanner) {
        System.out.println("=== Простое задание 9: Калькулятор (+, -, *, /) ===");
        System.out.print("Введите первое число: ");
        double a = Double.parseDouble(scanner.next().replace(',', '.'));

        System.out.print("Введите операцию (+, -, *, /): ");
        char op = scanner.next().trim().charAt(0);

        System.out.print("Введите второе число: ");
        double b = Double.parseDouble(scanner.next().replace(',', '.'));

        try {
            Double result = calculate(a, b, op);
            if (result == null) {
                System.out.println("Ошибка: деление на ноль невозможно!");
            } else {
                System.out.printf("Результат: %.4f %c %.4f = %.4f%n", a, op, b, result);
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            run(scanner);
        }
    }
}
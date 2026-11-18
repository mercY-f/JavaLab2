import java.util.Scanner;

public class SimpleTask1_Temperature {

    public static double celsiusToFahrenheit(double celsius) {
        return (celsius * 9.0 / 5.0) + 32.0;
    }

    public static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32.0) * 5.0 / 9.0;
    }

    public static void run(Scanner scanner) {
        System.out.println("=== Простое задание 1: Перевод температуры ===");
        System.out.println("1. Градусы Цельсия (°C) -> Градусы Фаренгейта (°F)");
        System.out.println("2. Градусы Фаренгейта (°F) -> Градусы Цельсия (°C)");
        System.out.print("Выберите направление перевода (1 или 2): ");

        int choice = scanner.nextInt();
        if (choice == 1) {
            System.out.print("Введите температуру в °C: ");
            double c = Double.parseDouble(scanner.next().replace(',', '.'));
            double f = celsiusToFahrenheit(c);
            System.out.printf("%.2f °C = %.2f °F%n", c, f);
        } else if (choice == 2) {
            System.out.print("Введите температуру в °F: ");
            double f = Double.parseDouble(scanner.next().replace(',', '.'));
            double c = fahrenheitToCelsius(f);
            System.out.printf("%.2f °F = %.2f °C%n", f, c);
        } else {
            System.out.println("Неверный выбор направления.");
        }
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            run(scanner);
        }
    }
}
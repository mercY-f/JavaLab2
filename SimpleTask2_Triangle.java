import java.util.Scanner;

public class SimpleTask2_Triangle {

    public static boolean isValidTriangle(double a, double b, double c) {
        return a > 0 && b > 0 && c > 0 && (a + b > c) && (a + c > b) && (b + c > a);
    }

    public static double calculatePerimeter(double a, double b, double c) {
        return a + b + c;
    }

    public static double calculateArea(double a, double b, double c) {
        double p = calculatePerimeter(a, b, c) / 2.0;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    public static void run(Scanner scanner) {
        System.out.println("=== Простое задание 2: Периметр и площадь треугольника ===");
        System.out.print("Введите сторону a: ");
        double a = Double.parseDouble(scanner.next().replace(',', '.'));
        System.out.print("Введите сторону b: ");
        double b = Double.parseDouble(scanner.next().replace(',', '.'));
        System.out.print("Введите сторону c: ");
        double c = Double.parseDouble(scanner.next().replace(',', '.'));

        if (!isValidTriangle(a, b, c)) {
            System.out.println("Ошибка: треугольник с такими сторонами не существует (нарушено неравенство треугольника или стороны <= 0).");
            return;
        }

        double perimeter = calculatePerimeter(a, b, c);
        double area = calculateArea(a, b, c);

        System.out.printf("Периметр треугольника P = %.4f%n", perimeter);
        System.out.printf("Площадь треугольника (по формуле Герона) S = %.4f%n", area);
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            run(scanner);
        }
    }
}
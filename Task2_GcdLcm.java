import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * Задание 2 (Сложные):
 * Написать программу для вычисления НОД и НОК двух чисел.
 * Реализация защищена от переполнения long (включая Long.MIN_VALUE и переполнение произведения в НОК).
 */
public class Task2_GcdLcm {
    public static BigInteger gcd(BigInteger a, BigInteger b) {
        return a.gcd(b).abs();
    }

    public static BigInteger lcm(BigInteger a, BigInteger b) {
        if (a.signum() == 0 || b.signum() == 0) {
            return BigInteger.ZERO;
        }
        BigInteger g = a.gcd(b);
        return a.divide(g).multiply(b).abs();
    }

    public static BigInteger gcd(long a, long b) {
        return gcd(BigInteger.valueOf(a), BigInteger.valueOf(b));
    }

    public static BigInteger lcm(long a, long b) {
        return lcm(BigInteger.valueOf(a), BigInteger.valueOf(b));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        System.out.println("=== Задание 2: Вычисление НОД и НОК ===");
        System.out.print("Введите первое число (a): ");
        if (!scanner.hasNextLong()) {
            System.out.println("Ошибка: введено не целое число типа long.");
            return;
        }
        long a = scanner.nextLong();

        System.out.print("Введите второе число (b): ");
        if (!scanner.hasNextLong()) {
            System.out.println("Ошибка: введено не целое число типа long.");
            return;
        }
        long b = scanner.nextLong();

        BigInteger g = gcd(a, b);
        BigInteger l = lcm(a, b);

        System.out.println("НОД(" + a + ", " + b + ") = " + g);
        System.out.println("НОК(" + a + ", " + b + ") = " + l);
    }
}
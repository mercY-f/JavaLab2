import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Задание 1 (Сложные):
 * Реализовать программу, которая выводит все делители числа.
 */
public class Task1_Divisors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        System.out.println("=== Задание 1: Поиск всех делителей числа ===");
        System.out.print("Введите целое число: ");

        if (!scanner.hasNextLong()) {
            System.out.println("Ошибка: введено не целое число или значение вне диапазона long.");
            return;
        }

        long n = scanner.nextLong();
        if (n == 0) {
            System.out.println("У числа 0 бесконечно много делителей (любое ненулевое число делит 0).");
            return;
        }

        // Краевой случай Long.MIN_VALUE (-2^63): Math.abs(Long.MIN_VALUE) переполняется
        if (n == Long.MIN_VALUE) {
            List<BigInteger> divisors = new ArrayList<>();
            BigInteger val = BigInteger.ONE;
            BigInteger two = BigInteger.valueOf(2);
            for (int k = 0; k <= 63; k++) {
                divisors.add(val);
                val = val.multiply(two);
            }
            System.out.println("Количество натуральных делителей: " + divisors.size());
            System.out.println("Делители: " + divisors);
            return;
        }

        long absN = Math.abs(n);
        List<Long> divisors = new ArrayList<>();

        // Оптимальный поиск до sqrt(absN): условие i <= absN / i исключает переполнение i * i
        for (long i = 1; i <= absN / i; i++) {
            if (absN % i == 0) {
                divisors.add(i);
                long pair = absN / i;
                if (pair != i) {
                    divisors.add(pair);
                }
            }
        }

        Collections.sort(divisors);

        System.out.println("Количество натуральных делителей: " + divisors.size());
        System.out.println("Делители: " + divisors);
    }
}
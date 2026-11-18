import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * Задание 4 (Сложные):
 * Написать программу для вычисления чисел Фибоначчи до n.
 * Использует BigInteger для вычисления значений любой длины без переполнения.
 */
public class Task4_Fibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        System.out.println("=== Задание 4: Числа Фибоначчи до n ===");
        System.out.println("1. Вывести первые N чисел Фибоначчи");
        System.out.println("2. Вывести все числа Фибоначчи со значением <= N");
        System.out.print("Выберите режим (1 или 2): ");
        if (!scanner.hasNextInt()) {
            System.out.println("Ошибка: ожидался номер режима (1 или 2).");
            return;
        }
        int mode = scanner.nextInt();

        if (mode == 1) {
            System.out.print("Введите количество чисел (N >= 1): ");
            if (!scanner.hasNextInt()) {
                System.out.println("Ошибка: введено не целое число.");
                return;
            }
            int n = scanner.nextInt();
            if (n <= 0) {
                System.out.println("Ошибка: количество должно быть положительным (>= 1).");
                return;
            }
            BigInteger a = BigInteger.ZERO;
            BigInteger b = BigInteger.ONE;
            System.out.println("Первые " + n + " чисел Фибоначчи:");
            for (int i = 0; i < n; i++) {
                System.out.print(a + (i == n - 1 ? "" : ", "));
                BigInteger next = a.add(b);
                a = b;
                b = next;
            }
            System.out.println();
        } else if (mode == 2) {
            System.out.print("Введите верхнюю границу N: ");
            if (!scanner.hasNextBigInteger()) {
                System.out.println("Ошибка: введено не целое число.");
                return;
            }
            BigInteger limit = scanner.nextBigInteger();
            if (limit.compareTo(BigInteger.ZERO) < 0) {
                System.out.println("Чисел Фибоначчи <= " + limit + " нет.");
                return;
            }
            BigInteger a = BigInteger.ZERO;
            BigInteger b = BigInteger.ONE;
            System.out.println("Числа Фибоначчи <= " + limit + ":");
            while (a.compareTo(limit) <= 0) {
                System.out.print(a + " ");
                BigInteger next = a.add(b);
                a = b;
                b = next;
            }
            System.out.println();
        } else {
            System.out.println("Ошибка: неверный режим (введите 1 или 2).");
        }
    }
}
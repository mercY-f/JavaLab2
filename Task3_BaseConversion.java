import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * Задание 3 (Сложные):
 * Реализовать программу, которая переводит число из десятичной системы в двоичную и обратно.
 * Учитывает особенности знакового представления: прямой двоичный код со знаком и дополнительный код (two's complement).
 */
public class Task3_BaseConversion {
    public static String decimalToBinary(long dec) {
        if (dec == 0) return "0";
        if (dec == Long.MIN_VALUE) {
            return "-1" + "0".repeat(63);
        }
        boolean negative = dec < 0;
        long n = Math.abs(dec);
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            sb.append(n % 2);
            n /= 2;
        }
        if (negative) sb.append("-");
        return sb.reverse().toString();
    }

    public static long binaryToDecimal(String bin) {
        if (bin == null) {
            throw new IllegalArgumentException("Входная строка не может быть null.");
        }
        bin = bin.trim();
        if (bin.isEmpty()) {
            throw new IllegalArgumentException("Введена пустая строка.");
        }

        boolean negative = bin.startsWith("-");
        if (negative || bin.startsWith("+")) {
            bin = bin.substring(1).trim();
        }
        if (bin.isEmpty()) {
            throw new IllegalArgumentException("Строка содержит только знак без цифр.");
        }

        long result = 0;
        for (int i = 0; i < bin.length(); i++) {
            char c = bin.charAt(i);
            if (c != '0' && c != '1') {
                throw new IllegalArgumentException("Недопустимый символ в двоичном числе: '" + c + "' (допустимы только 0 и 1)");
            }
            try {
                result = Math.multiplyExact(result, 2L);
                result = Math.addExact(result, (long) (c - '0'));
            } catch (ArithmeticException e) {
                throw new IllegalArgumentException("Число выходит за пределы диапазона 64-битного типа long.");
            }
        }
        return negative ? -result : result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        System.out.println("=== Задание 3: Перевод систем счисления (10 <-> 2) ===");
        System.out.println("1. Из десятичной в двоичную");
        System.out.println("2. Из двоичной в десятичную");
        System.out.print("Выберите вариант (1 или 2): ");
        if (!scanner.hasNextInt()) {
            System.out.println("Ошибка: ожидался номер пункта (1 или 2).");
            return;
        }
        int choice = scanner.nextInt();
        scanner.nextLine(); // Очистка буфера от перевода строки

        if (choice == 1) {
            System.out.print("Введите целое число в 10-й системе: ");
            if (!scanner.hasNextLong()) {
                System.out.println("Ошибка: введено не целое число типа long.");
                return;
            }
            long dec = scanner.nextLong();
            String customBinary = decimalToBinary(dec);
            if (dec < 0) {
                System.out.println("Прямой двоичный код со знаком: " + customBinary);
                System.out.println("Дополнительный код в памяти ЭВМ (two's complement / Long.toBinaryString):");
                System.out.println("  " + Long.toBinaryString(dec));
            } else {
                System.out.println("Двоичное представление: " + customBinary);
                System.out.println("(Проверка через Long.toBinaryString: " + Long.toBinaryString(dec) + ")");
            }
        } else if (choice == 2) {
            System.out.print("Введите число в 2-й системе: ");
            String bin = scanner.nextLine();
            try {
                long dec = binaryToDecimal(bin);
                System.out.println("Десятичное значение: " + dec);
            } catch (IllegalArgumentException e) {
                System.out.println("Ошибка: " + e.getMessage());
            }
        } else {
            System.out.println("Неверный выбор (введите 1 или 2).");
        }
    }
}
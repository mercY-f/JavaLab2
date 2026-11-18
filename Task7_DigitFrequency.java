import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * Задание 7 (Сложные):
 * Составить программу, которая определяет, сколько раз встречается каждая цифра в числе.
 * С полной валидацией ввода целого числа (включая многозначные числа с пробелами-разделителями).
 */
public class Task7_DigitFrequency {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        System.out.println("=== Задание 7: Частота цифр в числе ===");
        System.out.print("Введите целое число: ");

        if (!scanner.hasNextLine()) {
            System.out.println("Ошибка: пустой ввод.");
            return;
        }

        String input = scanner.nextLine().trim();
        if (input.isEmpty()) {
            System.out.println("Ошибка: введена пустая строка.");
            return;
        }

        // Удаляем пробелы (например, '123 456' или '1 000 000')
        String compact = input.replaceAll("\\s+", "");
        String digitsOnly = compact;
        if (digitsOnly.startsWith("+") || digitsOnly.startsWith("-")) {
            digitsOnly = digitsOnly.substring(1);
        }

        if (digitsOnly.isEmpty()) {
            System.out.println("Ошибка: строка содержит только знак без цифр.");
            return;
        }

        // Валидация: каждый символ обязан быть десятичной цифрой
        for (int i = 0; i < digitsOnly.length(); i++) {
            char c = digitsOnly.charAt(i);
            if (!Character.isDigit(c)) {
                System.out.println("Ошибка: введены недопустимые символы ('" + c + "'). Ожидается целое число.");
                return;
            }
        }

        int[] counts = new int[10];
        for (int i = 0; i < digitsOnly.length(); i++) {
            counts[digitsOnly.charAt(i) - '0']++;
        }

        System.out.println("Статистика встречаемости цифр для числа " + input + ":");
        for (int digit = 0; digit <= 9; digit++) {
            if (counts[digit] > 0) {
                System.out.println("Цифра '" + digit + "': " + counts[digit] + " раз(а)");
            }
        }
    }
}
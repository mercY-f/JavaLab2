import java.util.Scanner;

public class SimpleTask7_CountDigits {

    public static int countDigitsMath(long number) {
        if (number == 0) return 1;
        long n = Math.abs(number);
        int count = 0;
        while (n > 0) {
            count++;
            n /= 10;
        }
        return count;
    }

    public static void run(Scanner scanner) {
        System.out.println("=== Простое задание 7: Подсчёт количества цифр в числе ===");
        System.out.print("Введите целое число: ");
        String input = scanner.next().trim();

        try {
            long num = Long.parseLong(input);
            int count = countDigitsMath(num);
            System.out.printf("В числе %d ровно %d цифр(а/ы).%n", num, count);
        } catch (NumberFormatException e) {
            String digitsOnly = input.replaceAll("[^0-9]", "");
            if (digitsOnly.isEmpty()) {
                System.out.println("Ошибка: введённая строка не содержит цифр.");
            } else {
                System.out.printf("Число очень большое. Количество цифр: %d%n", digitsOnly.length());
            }
        }
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            run(scanner);
        }
    }
}
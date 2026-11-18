import java.util.Random;
import java.util.Scanner;

public class SimpleTask10_GuessNumber {

    public static void run(Scanner scanner) {
        System.out.println("=== Простое задание 10: Игра «Угадай число» (1 - 100) ===");
        Random random = new Random();
        int target = random.nextInt(100) + 1;
        int attempts = 0;

        System.out.println("Я загадал целое число от 1 до 100. Попробуйте его угадать!");
        System.out.println("(Для досрочного выхода введите 0)");

        while (true) {
            System.out.print("Ваша догадка: ");
            if (!scanner.hasNextInt()) {
                System.out.println("Пожалуйста, введите корректное целое число.");
                scanner.next();
                continue;
            }

            int guess = scanner.nextInt();
            if (guess == 0) {
                System.out.printf("Вы сдались! Было загадано число: %d.%n", target);
                break;
            }

            attempts++;

            if (guess < target) {
                System.out.println("Загаданное число БОЛЬШЕ (>).");
            } else if (guess > target) {
                System.out.println("Загаданное число МЕНЬШЕ (<).");
            } else {
                System.out.printf("ПОЗДРАВЛЯЕМ! Вы угадали число %d за %d попыток!%n", target, attempts);
                break;
            }
        }
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            run(scanner);
        }
    }
}
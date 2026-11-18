import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SimpleTask8_EvenNumbers {

    public static List<Integer> getEvenNumbers(int n) {
        List<Integer> evens = new ArrayList<>();
        for (int i = 2; i <= n; i += 2) {
            evens.add(i);
        }
        return evens;
    }

    public static void run(Scanner scanner) {
        System.out.println("=== Простое задание 8: Чётные числа от 1 до n ===");
        System.out.print("Введите верхнюю границу n: ");
        int n = scanner.nextInt();

        if (n < 2) {
            System.out.printf("В диапазоне от 1 до %d нет чётных чисел.%n", n);
            return;
        }

        List<Integer> evens = getEvenNumbers(n);
        System.out.printf("Чётные числа от 1 до %d (всего %d):%n", n, evens.size());
        System.out.println(evens);
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            run(scanner);
        }
    }
}
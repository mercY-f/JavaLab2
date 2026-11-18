import java.util.Scanner;

public class SimpleTask4_SquareTable {

    public static void printSquareTable(int n) {
        System.out.println("+--------+------------------+");
        System.out.println("|   Число|           Квадрат|");
        System.out.println("+--------+------------------+");
        for (int i = 1; i <= n; i++) {
            long sq = (long) i * i;
            System.out.printf("| %6d | %16d |%n", i, sq);
        }
        System.out.println("+--------+------------------+");
    }

    public static void run(Scanner scanner) {
        System.out.println("=== Простое задание 4: Таблица квадратов от 1 до n ===");
        System.out.print("Введите целое положительное число n: ");
        int n = scanner.nextInt();

        if (n < 1) {
            System.out.println("Ошибка: число n должно быть больше либо равно 1.");
            return;
        }

        printSquareTable(n);
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            run(scanner);
        }
    }
}
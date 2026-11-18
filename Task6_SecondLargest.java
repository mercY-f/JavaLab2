import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Задание 6 (Сложные):
 * Реализовать программу для поиска второго по величине элемента массива.
 * Однопроходный алгоритм O(N), корректно работающий с дубликатами и отрицательными числами.
 */
public class Task6_SecondLargest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        System.out.println("=== Задание 6: Второй по величине элемент массива ===");
        System.out.print("Введите размер массива: ");
        if (!scanner.hasNextInt()) {
            System.out.println("Ошибка: размер массива должен быть целым числом.");
            return;
        }
        int size = scanner.nextInt();
        if (size < 2) {
            System.out.println("Для поиска второго максимума нужно минимум 2 элемента.");
            return;
        }

        int[] arr = new int[size];
        System.out.println("Введите " + size + " элементов через пробел:");
        for (int i = 0; i < size; i++) {
            if (!scanner.hasNextInt()) {
                System.out.println("Ошибка: ожидалось целое число для элемента [" + i + "].");
                return;
            }
            arr[i] = scanner.nextInt();
        }

        System.out.println("Массив: " + Arrays.toString(arr));

        // Однопроходный алгоритм O(N)
        Integer max1 = null;
        Integer max2 = null;

        for (int num : arr) {
            if (max1 == null || num > max1) {
                max2 = max1;
                max1 = num;
            } else if (num < max1 && (max2 == null || num > max2)) {
                max2 = num;
            }
        }

        if (max2 == null) {
            System.out.println("Второго по величине элемента нет (все элементы массива равны " + max1 + ").");
        } else {
            System.out.println("Наибольший элемент: " + max1);
            System.out.println("Второй по величине элемент: " + max2);
        }
    }
}
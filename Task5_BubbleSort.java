import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Задание 5 (Сложные):
 * Составить программу, которая сортирует массив целых чисел методом пузырька.
 * Содержит оптимизацию флагом swapped (досрочный выход) и подсчёт шагов.
 */
public class Task5_BubbleSort {
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;
        int comparisons = 0;
        int swaps = 0;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                comparisons++;
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                    swaps++;
                }
            }
            if (!swapped) break;
        }
        System.out.println("Статистика: сравнений = " + comparisons + ", перестановок = " + swaps);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        System.out.println("=== Задание 5: Пузырьковая сортировка массива ===");
        System.out.print("Введите размер массива: ");
        if (!scanner.hasNextInt()) {
            System.out.println("Ошибка: размер массива должен быть целым числом.");
            return;
        }
        int size = scanner.nextInt();
        if (size <= 0) {
            System.out.println("Ошибка: размер массива должен быть больше 0.");
            return;
        }

        int[] arr = new int[size];
        System.out.println("Введите " + size + " целых чисел через пробел:");
        for (int i = 0; i < size; i++) {
            if (!scanner.hasNextInt()) {
                System.out.println("Ошибка: ожидалось целое число для элемента [" + i + "].");
                return;
            }
            arr[i] = scanner.nextInt();
        }

        System.out.println("Исходный массив: " + Arrays.toString(arr));
        bubbleSort(arr);
        System.out.println("Отсортированный массив: " + Arrays.toString(arr));
    }
}
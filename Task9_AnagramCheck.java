import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Задание 9 (Сложные):
 * Написать программу, которая проверяет, является ли введённая строка анаграммой другой строки.
 * Учитывает: регистронезависимость, игнорирование пробелов/пунктуации, эквивалентность 'е' и 'ё', явную кодировку UTF-8.
 */
public class Task9_AnagramCheck {
    public static String normalize(String s) {
        if (s == null) return "";
        return s.toLowerCase()
                .replace('ё', 'е')
                .replaceAll("[^a-zA-Zа-я0-9]", "");
    }

    public static boolean isAnagram(String s1, String s2) {
        String clean1 = normalize(s1);
        String clean2 = normalize(s2);

        if (clean1.isEmpty() || clean2.isEmpty()) {
            return false;
        }

        if (clean1.length() != clean2.length()) {
            return false;
        }

        char[] chars1 = clean1.toCharArray();
        char[] chars2 = clean2.toCharArray();
        Arrays.sort(chars1);
        Arrays.sort(chars2);

        return Arrays.equals(chars1, chars2);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        System.out.println("=== Задание 9: Проверка строк на анаграмму ===");
        System.out.print("Введите первую строку: ");
        if (!scanner.hasNextLine()) return;
        String s1 = scanner.nextLine();

        System.out.print("Введите вторую строку: ");
        if (!scanner.hasNextLine()) return;
        String s2 = scanner.nextLine();

        String clean1 = normalize(s1);
        String clean2 = normalize(s2);

        if (clean1.isEmpty() || clean2.isEmpty()) {
            System.out.println("Ошибка: одна или обе строки не содержат буквенно-цифровых символов для сравнения.");
            return;
        }

        boolean result = isAnagram(s1, s2);
        System.out.println("Нормализованная строка 1: " + clean1);
        System.out.println("Нормализованная строка 2: " + clean2);
        if (result) {
            System.out.println("Результат: Строки ЯВЛЯЮТСЯ анаграммами!");
        } else {
            System.out.println("Результат: Строки НЕ являются анаграммами.");
        }
    }
}
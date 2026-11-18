import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * Задание 8 (Сложные):
 * Реализовать программу для подсчёта количества гласных и согласных букв в строке.
 * Корректно учитывает фонетическую классификацию букв русского и латинского алфавитов,
 * включая выделение букв без звука ('ъ', 'ь').
 */
public class Task8_VowelsConsonants {
    private static final String VOWELS_RU = "аеёиоуыэюя";
    private static final String VOWELS_EN = "aeiouy";
    private static final String CONSONANTS_RU = "бвгджзйклмнпрстфхцчшщ";
    private static final String CONSONANTS_EN = "bcdfghjklmnpqrstvwxyz";
    private static final String SIGNS_RU = "ъь";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        System.out.println("=== Задание 8: Подсчёт гласных и согласных букв ===");
        System.out.print("Введите строку текста: ");
        if (!scanner.hasNextLine()) return;
        String text = scanner.nextLine();

        int vowels = 0;
        int consonants = 0;
        int signs = 0;
        int otherChars = 0;

        for (int i = 0; i < text.length(); i++) {
            char c = Character.toLowerCase(text.charAt(i));
            if (VOWELS_RU.indexOf(c) != -1 || VOWELS_EN.indexOf(c) != -1) {
                vowels++;
            } else if (CONSONANTS_RU.indexOf(c) != -1 || CONSONANTS_EN.indexOf(c) != -1) {
                consonants++;
            } else if (SIGNS_RU.indexOf(c) != -1) {
                signs++;
            } else if (Character.isLetter(c)) {
                // Буквы прочих алфавитов
                consonants++;
            } else {
                otherChars++;
            }
        }

        int totalLetters = vowels + consonants + signs;

        System.out.println("--- Результаты подсчёта ---");
        System.out.println("Гласных букв: " + vowels);
        System.out.println("Согласных букв: " + consonants);
        if (signs > 0) {
            System.out.println("Букв без звука (ъ, ь): " + signs);
        }
        System.out.println("Всего букв в строке: " + totalLetters);
        System.out.println("Прочих символов (пробелы, знаки препинания, цифры): " + otherChars);
    }
}
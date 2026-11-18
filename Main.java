import java.util.Scanner;

/**
 * Главное консольное меню для запуска любого из заданий Лабораторной работы №1
 * (Простые задания 1-10 и Сложные задания 1-10).
 */
public class Main {

    private static void runSimpleMenu(Scanner scanner) {
        while (true) {
            System.out.println("\n-------------------------------------------------------");
            System.out.println("            ПРОСТЫЕ ЗАДАНИЯ (3 БАЛЛА)                 ");
            System.out.println("-------------------------------------------------------");
            System.out.println("1. Перевод температуры C <-> F (SimpleTask1_Temperature)");
            System.out.println("2. Периметр и площадь треугольника (SimpleTask2_Triangle)");
            System.out.println("3. Проверка високосного года (SimpleTask3_LeapYear)");
            System.out.println("4. Таблица квадратов от 1 до n (SimpleTask4_SquareTable)");
            System.out.println("5. Определение знака числа (SimpleTask5_NumberSign)");
            System.out.println("6. Среднее арифметическое 3 чисел (SimpleTask6_AverageThree)");
            System.out.println("7. Количество цифр в числе (SimpleTask7_CountDigits)");
            System.out.println("8. Чётные числа от 1 до n (SimpleTask8_EvenNumbers)");
            System.out.println("9. Простой калькулятор (SimpleTask9_Calculator)");
            System.out.println("10. Игра «Угадай число» 1..100 (SimpleTask10_GuessNumber)");
            System.out.println("0. Назад в главное меню");
            System.out.println("-------------------------------------------------------");
            System.out.print("Выберите номер простого задания (0-10): ");

            if (!scanner.hasNextInt()) {
                scanner.next();
                System.out.println("Введите число от 0 до 10.");
                continue;
            }

            int choice = scanner.nextInt();
            System.out.println();
            switch (choice) {
                case 1: SimpleTask1_Temperature.run(scanner); break;
                case 2: SimpleTask2_Triangle.run(scanner); break;
                case 3: SimpleTask3_LeapYear.run(scanner); break;
                case 4: SimpleTask4_SquareTable.run(scanner); break;
                case 5: SimpleTask5_NumberSign.run(scanner); break;
                case 6: SimpleTask6_AverageThree.run(scanner); break;
                case 7: SimpleTask7_CountDigits.run(scanner); break;
                case 8: SimpleTask8_EvenNumbers.run(scanner); break;
                case 9: SimpleTask9_Calculator.run(scanner); break;
                case 10: SimpleTask10_GuessNumber.run(scanner); break;
                case 0: return;
                default: System.out.println("Задание не найдено.");
            }
        }
    }

    private static void runComplexMenu(Scanner scanner) {
        while (true) {
            System.out.println("\n-------------------------------------------------------");
            System.out.println("            СЛОЖНЫЕ ЗАДАНИЯ (4 БАЛЛА)                 ");
            System.out.println("-------------------------------------------------------");
            System.out.println("1. Делители числа (Task1_Divisors)");
            System.out.println("2. НОД и НОК двух чисел (Task2_GcdLcm)");
            System.out.println("3. Перевод систем счисления 10 <-> 2 (Task3_BaseConversion)");
            System.out.println("4. Числа Фибоначчи до n (Task4_Fibonacci)");
            System.out.println("5. Пузырьковая сортировка массива (Task5_BubbleSort)");
            System.out.println("6. Второй по величине элемент массива (Task6_SecondLargest)");
            System.out.println("7. Частота каждой цифры в числе (Task7_DigitFrequency)");
            System.out.println("8. Количество гласных и согласных в строке (Task8_VowelsConsonants)");
            System.out.println("9. Проверка строк на анаграмму (Task9_AnagramCheck)");
            System.out.println("10. Программа «Банк» (Task10_Bank)");
            System.out.println("0. Назад в главное меню");
            System.out.println("-------------------------------------------------------");
            System.out.print("Выберите номер сложного задания (0-10): ");

            if (!scanner.hasNextInt()) {
                scanner.next();
                System.out.println("Введите число от 0 до 10.");
                continue;
            }

            int choice = scanner.nextInt();
            System.out.println();
            switch (choice) {
                case 1: Task1_Divisors.main(new String[0]); break;
                case 2: Task2_GcdLcm.main(new String[0]); break;
                case 3: Task3_BaseConversion.main(new String[0]); break;
                case 4: Task4_Fibonacci.main(new String[0]); break;
                case 5: Task5_BubbleSort.main(new String[0]); break;
                case 6: Task6_SecondLargest.main(new String[0]); break;
                case 7: Task7_DigitFrequency.main(new String[0]); break;
                case 8: Task8_VowelsConsonants.main(new String[0]); break;
                case 9: Task9_AnagramCheck.main(new String[0]); break;
                case 10: Task10_Bank.main(new String[0]); break;
                case 0: return;
                default: System.out.println("Задание не найдено.");
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n=======================================================");
            System.out.println("             ЛАБОРАТОРНАЯ РАБОТА №1                    ");
            System.out.println("       Тема: Создание программ на языке Java           ");
            System.out.println("=======================================================");
            System.out.println("1. Простые задания (10 задач, 3 балла)");
            System.out.println("2. Сложные задания (10 задач, 4 балла)");
            System.out.println("0. Выход");
            System.out.println("=======================================================");
            System.out.print("Выберите раздел (0-2): ");

            if (!scanner.hasNextInt()) {
                String token = scanner.next();
                if (token.equalsIgnoreCase("exit") || token.equalsIgnoreCase("q")) break;
                System.out.println("Некорректный ввод. Введите число 0, 1 или 2.");
                continue;
            }

            int choice = scanner.nextInt();
            switch (choice) {
                case 1: runSimpleMenu(scanner); break;
                case 2: runComplexMenu(scanner); break;
                case 0:
                    System.out.println("Завершение работы программы.");
                    return;
                default:
                    System.out.println("Неверный пункт меню.");
            }
        }
    }
}
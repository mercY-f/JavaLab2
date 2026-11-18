import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Задание 10 (Сложные):
 * Реализовать программу «Банк»: счёт клиента, пополнение, снятие, проверка остатка (через меню).
 * Защищена от: проблем локали с точкой/запятой, NaN/Infinity, зависания символа перевода строки в буфере Scanner.
 */
public class Task10_Bank {
    public static class BankAccount {
        private final String accountNumber;
        private final String ownerName;
        private double balance;
        private final List<String> transactions = new ArrayList<>();

        public BankAccount(String accountNumber, String ownerName, double initialBalance) {
            this.accountNumber = accountNumber;
            this.ownerName = ownerName;
            if (Double.isNaN(initialBalance) || Double.isInfinite(initialBalance) || initialBalance < 0) {
                this.balance = 0.0;
            } else {
                this.balance = initialBalance;
            }
            this.transactions.add(String.format("Открытие счёта с балансом: %.2f руб.", this.balance));
        }

        public double getBalance() {
            return balance;
        }

        public boolean deposit(double amount) {
            if (Double.isNaN(amount) || Double.isInfinite(amount) || amount <= 0) {
                System.out.println("Ошибка: сумма пополнения должна быть строго положительным конечным числом.");
                return false;
            }
            balance += amount;
            transactions.add(String.format("Пополнение: +%.2f руб., баланс: %.2f руб.", amount, balance));
            System.out.printf("Счёт успешно пополнен на %.2f руб. Текущий баланс: %.2f руб.%n", amount, balance);
            return true;
        }

        public boolean withdraw(double amount) {
            if (Double.isNaN(amount) || Double.isInfinite(amount) || amount <= 0) {
                System.out.println("Ошибка: сумма снятия должна быть строго положительным конечным числом.");
                return false;
            }
            if (amount > balance) {
                System.out.printf("Ошибка: недостаточно средств! Запрошено: %.2f руб., доступно: %.2f руб.%n", amount, balance);
                return false;
            }
            balance -= amount;
            transactions.add(String.format("Снятие: -%.2f руб., баланс: %.2f руб.", amount, balance));
            System.out.printf("Успешно снято %.2f руб. Текущий баланс: %.2f руб.%n", amount, balance);
            return true;
        }

        public void printInfo() {
            System.out.println("--- Информация о счёте ---");
            System.out.println("Номер счёта: " + accountNumber);
            System.out.println("Владелец: " + ownerName);
            System.out.printf("Текущий баланс: %.2f руб.%n", balance);
        }

        public void printHistory() {
            System.out.println("--- История операций ---");
            if (transactions.isEmpty()) {
                System.out.println("История пуста.");
            } else {
                for (int i = 0; i < transactions.size(); i++) {
                    System.out.println((i + 1) + ". " + transactions.get(i));
                }
            }
        }
    }

    private static Double parseAmount(String rawInput) {
        if (rawInput == null) return null;
        String clean = rawInput.trim().replace(',', '.');
        if (clean.isEmpty()) {
            System.out.println("Ошибка: сумма не может быть пустой.");
            return null;
        }
        try {
            double val = Double.parseDouble(clean);
            if (Double.isNaN(val) || Double.isInfinite(val)) {
                System.out.println("Ошибка: введено недопустимое число (NaN / Infinity).");
                return null;
            }
            if (val <= 0) {
                System.out.println("Ошибка: сумма должна быть строго больше нуля.");
                return null;
            }
            return val;
        } catch (NumberFormatException e) {
            System.out.println("Ошибка: некорректный формат денежной суммы ('" + rawInput + "').");
            return null;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        System.out.println("=== Программа «Банковский счёт» ===");
        System.out.print("Введите имя владельца счёта: ");
        String name = scanner.nextLine().trim();
        if (name.isEmpty()) name = "Иван Иванов";

        BankAccount account = new BankAccount("RU-40817810001", name, 1000.0);
        System.out.println("Счёт успешно создан с начальным балансом 1000.00 руб.\n");

        boolean running = true;
        while (running) {
            System.out.println("\n--- МЕНЮ БАНКА ---");
            System.out.println("1. Проверить баланс и данные счёта");
            System.out.println("2. Пополнить счёт");
            System.out.println("3. Снять наличные");
            System.out.println("4. Посмотреть историю операций");
            System.out.println("0. Выход");
            System.out.print("Выберите пункт: ");

            String line = scanner.nextLine().trim();
            if (line.isEmpty()) continue;

            int cmd;
            try {
                cmd = Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.println("Пожалуйста, введите цифру пункта меню (0..4).");
                continue;
            }

            switch (cmd) {
                case 1:
                    account.printInfo();
                    break;
                case 2:
                    System.out.print("Введите сумму для пополнения: ");
                    String depStr = scanner.nextLine();
                    Double dep = parseAmount(depStr);
                    if (dep != null) account.deposit(dep);
                    break;
                case 3:
                    System.out.print("Введите сумму для снятия: ");
                    String withStr = scanner.nextLine();
                    Double with = parseAmount(withStr);
                    if (with != null) account.withdraw(with);
                    break;
                case 4:
                    account.printHistory();
                    break;
                case 0:
                    System.out.println("Спасибо за использование банковской системы. До свидания!");
                    running = false;
                    break;
                default:
                    System.out.println("Неизвестный пункт меню. Выберите от 0 до 4.");
            }
        }
    }
}
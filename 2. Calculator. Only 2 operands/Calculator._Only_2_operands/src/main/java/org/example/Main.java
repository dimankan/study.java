package org.example;

import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {
        // Создаем объект калькулятора
        ICalculator calculator = new Calculator();
        Scanner scanner = new Scanner(System.in);

        // Запрашиваем два числа у пользователя
        double num1 = getValidNumber(scanner, "Введите первое число:");
        double num2 = getValidNumber(scanner, "Введите второе число:");

        // Выполняем все операции и выводим результаты
        try {
            System.out.println("Результаты:");
            System.out.println("Сложение: " + calculator.add(num1, num2));
            System.out.println("Вычитание: " + calculator.subtract(num1, num2));
            System.out.println("Умножение: " + calculator.multiply(num1, num2));
            System.out.println("Деление: " + calculator.divide(num1, num2));
        } catch (ArithmeticException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    // Метод для запроса корректного числа
    public static double getValidNumber(Scanner scanner, String prompt) {
        double number = 0;
        boolean valid = false;

        while (!valid) {
            System.out.println(prompt);
            try {
                number = scanner.nextDouble();
                valid = true;  // Ввод корректен, выходим из цикла
            } catch (InputMismatchException e) {
                System.out.println("Ошибка: введено не число. Попробуйте снова.");
                scanner.nextLine();  // Очищаем буфер ввода
            }
        }
        return number;
    }
}

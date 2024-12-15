package org.example;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Создаем экземпляр сервиса
        CurrencyService currencyService = new CurrencyService();

        // Форматировщик для округления до двух знаков
        DecimalFormat df = new DecimalFormat("#.00");

        // Сканер для ввода от пользователя
        Scanner scanner = new Scanner(System.in);

        try {
            // Получаем данные о курсах валют
            CurrencyData currencyData = currencyService.fetchCurrencyData();

            // Округляем и форматируем курсы
            double usdRate = 1 / currencyData.getUsdRate();
            double eurRate = 1 / currencyData.getEurRate();

            String formattedUsdRate = df.format(usdRate);
            String formattedEurRate = df.format(eurRate);

            // Выводим текущие курсы валют
            System.out.println("Дата: " + currencyData.getDate());
            System.out.println("1 доллар равен " + formattedUsdRate + " рублям");
            System.out.println("1 евро равен " + formattedEurRate + " рублям");

            // Запрашиваем у пользователя сумму в долларах/евро
            System.out.println("Введите сумму в долларах или евро:");
            double amount = scanner.nextDouble();

            // Вычисляем эквиваленты в рублях
            double usdInRub = amount * usdRate;
            double eurInRub = amount * eurRate;

            // Округляем результаты
            String formattedUsdInRub = df.format(usdInRub);
            String formattedEurInRub = df.format(eurInRub);

            // Выводим результаты
            System.out.println(amount + " долларов равны " + formattedUsdInRub + " рублям");
            System.out.println(amount + " евро равны " + formattedEurInRub + " рублям");

        } catch (Exception e) {
            System.out.println("Ошибка при получении данных: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}

package com.company;

import java.util.Scanner;

public class ConvertAmountWithLoop {
    public static void main(String[] args) {
        final double ROUBLES_PER_DOLLAR = 72.12;
        int dollars;
        double roubles;
        int digit; //полследняя цифра dollars
        int numberOfConversions; // количество конвертаций
        int counter; //счетчик

        Scanner input = new Scanner(System.in);
        do {
            // Получить количество итераций конвертирования
            System.out.println("Введите количесто конвертаций, которые вы хотите выполнить: ");
            numberOfConversions = input.nextInt();
        } while (numberOfConversions <= 0);

        // Пока не конвертированы все суммы, получать, отображать и конвертировать в рубли американские доллары
        for (counter = 0; counter < numberOfConversions; ++counter) {
            //Получить сумму денег в американских долларах
            System.out.println("Введите сумму денег в американских долларах: ");
            dollars = input.nextInt();

            // Отобразить сумму американских долларов с правильным окончанием
            System.out.print(dollars);

            if (dollars >=5 && dollars <=20)
                System.out.print(" американских долларов равны ");
            else {
                digit = dollars % 10;
                if (digit == 1);
                System.out.print(" американский доллар равен ");
                if (digit >= 2 && digit <= 4)
                    System.out.print(" американских доллара равны ");
                else
                    System.out.print(" американских долларов равны ");
            }
            // Конвертировать сумму денег в рубли
            roubles = ROUBLES_PER_DOLLAR * dollars;
            System.out.println((int)(roubles * 100) / 100.0 + " российских рубля.");
        }
    }
}

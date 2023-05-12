package com.company;

import java.util.Scanner;
import java.time.LocalDate;

public class DepositCalculation {

    static final int MONTH_OF_YEAR = 12;
    static final int DAYS_YEAR = 365;

    public static void main(String[] args) {

        int startMonth; //номер месяца открытия вклада
        int startYear; // год открытия вклада
        int depositTerm; //срок вклада в месяцах
        double rate; //процентная ставка в год
        double depositAmount; //сумма вклада
        double accruedInterestPerMonth; //доход по вкладу в текущем месяце
        double accruedInterestTotal = 0;

        Scanner input = new Scanner(System.in);

        //получаем месяц открытия вклада
        System.out.print("Введите номер месяца открытия вклада: ");
        startMonth = input.nextInt();

        //получаем год открытия вклада
        System.out.print("Введите номер года открытия вклада: ");
        startYear = input.nextInt();

        //получаем срок вклада
        System.out.print("Введите срок вклада в месяцах: ");
        depositTerm = input.nextInt();

        //получаем сумму вклада
        System.out.print("Введите сумму вклада в рублях: ");
        depositAmount = input.nextDouble();

        //получаем %
        System.out.print("Введите ставку по вкладу в процентах: ");
        rate = input.nextDouble();

        int monthsCount = 0; // счетчик месяцев
        int i = startYear;
        while (monthsCount < depositTerm) {
            for (int j = 1; j <= MONTH_OF_YEAR; j++) {
                // Если номер месяца меньше или равно номеру месяца открытия вклада
                // то переходим к следующему месяцу, он не попадает в интервал
                if (i == startYear && j <= startMonth) {
                    continue;
                    // Если номер текущего месяца равен сроку вклада,
                    // то расчет заканчиваем и выходим из цикла
                }
                if (monthsCount == depositTerm) {
                    break;
                }
                // Получаем количество дней в текущем месяце
                int lengthOfMonth = LocalDate.of(i, j, 1).lengthOfMonth();

                // Расчитаем доход по вкладу в текущем месяце
                accruedInterestPerMonth = depositAmount * rate / 100 / DAYS_YEAR * lengthOfMonth;
                accruedInterestPerMonth = Math.round(accruedInterestPerMonth * 100) / 100.0; // округлим до копейки

                // Вывести результат начисленных процентов в месяце
                System.out.println("Начисленно процентов в " + i + " году " + j + " месяца = " + accruedInterestPerMonth);

                // Добавим процент по вкладам текущего месяца к суммарной выплате
                accruedInterestTotal = accruedInterestTotal + accruedInterestPerMonth;

                monthsCount++; // увеличим счетчик месяцев на 1
            }
            i++; // увеличим год на 1
        }
        // Вывести итоговый результат начисленных процентов за весь период
        System.out.println("Всего начисленно процентов = " + accruedInterestTotal);
        }
    }
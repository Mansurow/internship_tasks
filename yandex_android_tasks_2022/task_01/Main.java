package yandextask.com;

import java.util.Scanner;

public class Main {
    // констаты для работы с задачей
    static final int minNumberTask = 100000;
    static final int maxNumberTask = 999999;
    static final int devide = 1000;
    public static void main(String[] args) {
        Scanner getData = new Scanner(System.in);
        int inputNumber = getData.nextInt();
        if (minNumberTask > inputNumber || inputNumber > maxNumberTask)
            System.out.println("Ошибка ввода! Число должно быть 16-ти значным!");
        else {
            while (!checkSuccessfulTicket(inputNumber)) inputNumber++;
            System.out.println(inputNumber);
        }
    }
    // проверка условия счасливого билета
    public static boolean checkSuccessfulTicket(int number) {
        int firstPart = number / devide;
        int secondPart = number % devide;

        if (sumFigureOfNumber(firstPart) == sumFigureOfNumber(secondPart))
            return true;
        return false;
    }
    // подсчет суммы цифр числа
    public static int sumFigureOfNumber(int number) {
        int sum = 0;
        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }
}

package yandextask.com;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner getData = new Scanner(System.in);

        Time startFlying = new Time(getData.nextLine());
        Time endFlying = new Time(getData.nextLine());
        byte timeZone = getData.nextByte();

        Time result = startFlying.findDifferents(endFlying, timeZone);
        result.printTime();
    }
}

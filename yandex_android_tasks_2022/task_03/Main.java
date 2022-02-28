package yandextask.com;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner getData = new Scanner(System.in);

        String firstString = getData.nextLine();
        String secondString = getData.nextLine();

        String[] firstData = (firstString.split("\\."))[0].split(", ");
        String[] secondData = (secondString.split("\\."))[0].split(", ");

        boolean checkFlag = true;
        for (int i = 0; i < firstData.length && checkFlag; i++)
            checkFlag = checkStudentName(firstData[i], secondData);

        if (checkFlag)
            System.out.println("YES");
        else
            System.out.println("NO");
    }

    public static boolean checkStudentName(String findStudent, String[] allStudents) {
        String[] splitFindStudent = findStudent.split(" ");

        for (String allStudent : allStudents) {
            String[] splitIndexAllStudents = allStudent.split(" ");

            if ((splitFindStudent[0].equals(splitIndexAllStudents[0]) && splitFindStudent[1].equals(splitIndexAllStudents[1])) ||
                    (splitFindStudent[0].equals(splitIndexAllStudents[1]) && splitFindStudent[1].equals(splitIndexAllStudents[0])))
                return true;
        }

        return false;
    }
}
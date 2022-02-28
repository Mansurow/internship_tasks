package yandextask.com;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static final int NMax = (int) Math.pow(10, 5);
    static final int NMin = 1;

    static final int MMax = (int) Math.pow(10, 18);
    static final int MMin = 1;

    static final int AiMax = (int) Math.pow(10, 9);
    static final int AiMin = 1;

    static final int BiMin = 0;

    public static void main(String[] args) {
        Scanner getData = new Scanner(System.in);
        int countDepartment, investmentBudget;
        List<Integer> departmentsEfficiency = new ArrayList<>();
        List<Integer> parentDepartments = new ArrayList<>();
        int[] allocatedBudgetForDepartments;

        countDepartment = getData.nextInt();

        if (countDepartment < NMin || countDepartment > NMax)
            System.out.println("Превышены пределы! Количество отделов в комании не может быть таким!\n" +
                    "1 <= N <= 10^5");
        else {
            investmentBudget = getData.nextInt();

            if (investmentBudget < MMin || investmentBudget > MMax)
                System.out.println("Превышены пределы! Количество выделенного бюджета не может быть таким!\n" +
                        "1 <= N <= 10^18");
            else {

                for (int i = 0; i < countDepartment; i++)
                    departmentsEfficiency.add(getData.nextInt());

                for (int i = 0; i < countDepartment; i++) {
                    parentDepartments.add(getData.nextInt());
                }

                allocatedBudgetForDepartments = new int[countDepartment];

                int currentBudget = investmentBudget;
                int max, indexMax, nextIndexMax, size, nextMax = 0;

                for (int i = 0; i < countDepartment; i++) {
                    List<Integer> indexSubDepartment = findSubDepartment(parentDepartments, i);

                    if (i != 0)
                        currentBudget = allocatedBudgetForDepartments[i - 1];

                    size = indexSubDepartment.size();

                    for (int j = 0; j < size; j++) {

                        int round = currentBudget / size;
                        max = departmentsEfficiency.get(indexSubDepartment.get(j));
                        indexMax = indexSubDepartment.get(j);
                        nextIndexMax = indexMax;

                        if (j + 1 >= size)
                            nextMax = -1;

                        for (int k = j + 1; k < size; k++)
                            if (max < departmentsEfficiency.get(indexSubDepartment.get(k))) {
                                max = departmentsEfficiency.get(indexSubDepartment.get(k));
                                indexMax = indexSubDepartment.get(k);
                            }

                        for (int k = j + 1; k < size; k++)
                            if (nextMax <= departmentsEfficiency.get(indexSubDepartment.get(k))) {
                                nextMax = departmentsEfficiency.get(indexSubDepartment.get(k));
                                nextIndexMax = indexSubDepartment.get(k);
                            }

                        if (max == nextMax) {
                            allocatedBudgetForDepartments[indexMax] = round;
                            allocatedBudgetForDepartments[nextIndexMax] = round;
                            j++;
                        } else {
                            if (currentBudget % size != 0) {
                                currentBudget = (currentBudget / size) * (max / nextMax);
                            } else {
                                currentBudget = currentBudget / size;
                            }

                            allocatedBudgetForDepartments[indexMax] = currentBudget;
                        }

                    }
                    indexSubDepartment.clear();
                }

                for (int el : allocatedBudgetForDepartments)
                    System.out.printf("%d ", el);

            }
        }
    }

    public static List<Integer> findSubDepartment(List<Integer> parentDepartments, int indexParentDepartment) {
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < parentDepartments.size(); i++)
            if (parentDepartments.get(i) == indexParentDepartment)
                result.add(i);

        return result;
    }
}

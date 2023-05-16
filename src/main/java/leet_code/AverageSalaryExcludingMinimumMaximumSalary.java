package leet_code;

import java.util.Arrays;

public class AverageSalaryExcludingMinimumMaximumSalary {

    public static void main(String[] args) {

        System.out.println(average2(new int[]{4000,3000,1000,2000}));

    }

    public static double average(int[] salary) {
        Arrays.sort(salary);
        int sum = 0;
        for (int i = 1; i <salary.length-1; i++)
            sum += salary[i];
        return (double) sum /(salary.length - 2);
    }


    public static double average2(int[] salaries) {
        if(salaries == null || salaries.length <= 2) {
            return 0;
        }

        double minSalary = Math.min(salaries[0], salaries[1]);
        double maxSalary = Math.max(salaries[0], salaries[1]);
        double averageSalary = (double) 0;

        for(int i = 2; i < salaries.length; i++) {
            double salary = salaries[i];
            if(salary < minSalary) {
                averageSalary += minSalary;
                minSalary = salary;
            } else if(salary > maxSalary) {
                averageSalary += maxSalary;
                maxSalary = salary;
            } else {
                averageSalary += salary;
            }
        }
        return averageSalary / (salaries.length - 2);
    }
}

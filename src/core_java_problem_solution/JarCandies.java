package core_java_problem_solution;

import java.util.Scanner;

public class JarCandies {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter no. of candies");
        int candies = scanner.nextInt();
        int n=10;
        int m=n-candies;
        if (m<=5){
            m=10;
        }
        if(candies>0) {
            System.out.println("Numbers of candies sold  " + candies);
            System.out.println("Number of candies available  " +m);
        }else {
            System.out.println("Invalid Input");
            System.out.println("Number of candies left "+n);
        }


    }
}

package core_java_problem_solution;

import java.util.Scanner;

public class StringAtOddPosition {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useDelimiter("\\n");
        System.out.println("Enter String");
        String string = scanner.next();
        for (int i=1; i<=string.length(); i=i+2) {
                System.out.print(string.charAt(i));
            }
        }
    }

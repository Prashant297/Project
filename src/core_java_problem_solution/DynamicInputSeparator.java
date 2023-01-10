package core_java_problem_solution;

import java.util.Scanner;

public class DynamicInputSeparator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useDelimiter("\\n");
        System.out.println("Enter String");
        String[] string = scanner.next().split(" ",0);
            for (int i=0;i< string.length;i++){
                int count = 1;
                for (int j = string.length - 1; j >= i + 1; j--){
                    if (string[i].equals(string[j])){
                      count++;
                      string[j]="0";
                    }
                }
                if (!string[i].equals("0")) {
                    System.out.println(string[i] + " = " + count);
                }
            }

    }
}

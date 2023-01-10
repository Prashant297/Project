package core_java_problem_solution;

import java.util.Scanner;

public class Vehicle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the value of V");
        int v = scanner.nextInt();
        System.out.println("Enter the value of W");
        int w = scanner.nextInt();
        int x=0,y=0;
        if(v<w){
            y=(w/2)-v;
            x=v-y;
            System.out.println(x +" + "+ y +" = "+v+" Vehicle");
            System.out.println(x+" *2 +"+y+" * 4" + " = "+w+" Vehicle");
            System.out.println((x*2)+" + "+(y*4) +" = "+w+" Vehicle");
        }else {
            System.out.println("Invalid input");
        }

    }
}
/*
130+70 = 200 vehicles
(70*4)+(130*2)= 540 wheels
Constraints :
2<=W
W%2=0
V<W
*/
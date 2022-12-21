package exceptionHandling;

public class Throws {
    public static void eligibleForVoting(int age){
        if (age<18){
            throw new ArithmeticException("You Are Not Eligible To Vote");
        }else {
            System.out.println("You Are Eligible To Vote");
        }

    }
    public static void main(String[] args) {
        eligibleForVoting(19);

    }
}

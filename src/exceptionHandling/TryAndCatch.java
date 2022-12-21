package exceptionHandling;

public class TryAndCatch {
    public static void main(String[] args) {
        int n=12;
       try {
          n=n/0;
            System.out.println(n);
        }catch (ArithmeticException e){
            System.out.println(e);
        }
       int[] number={1,2,3,4};
        System.out.println("nested");
       try {
           int m=number[1]/1;
           System.out.println(m);
           try {
               System.out.println(number[10]);
           }catch (ArrayIndexOutOfBoundsException e){
               System.out.println(e);
           }
       }catch (ArithmeticException e1){
           System.out.println(e1);
       }
       finally {
           System.out.println("Program executed");
       }
    }
}

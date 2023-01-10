package core_java_problem_solution.ip_address;

import java.util.Scanner;
import java.util.regex.*;
public class CheckIpAddresses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useDelimiter("\\n");
        System.out.println("Enter no of IP Address you want to enter");
        int n = scanner.nextInt();
        for (int i=0;i<n;i++ ){
        System.out.println("Enter IP Address");
        String ip = scanner.next();
        System.out.println("IP Addresses is "+checkIPAddressIsValidOrNot(ip)+"\n");

        }

    }
     static boolean checkIPAddressIsValidOrNot(String s){

         String zeroTo255 = "(\\d{1,2}|(0|1)\\" + "d{2}|2[0-4]\\d|25[0-5])";
         String regex= zeroTo255 + "\\."+ zeroTo255 + "\\." + zeroTo255 + "\\." + zeroTo255;
         Pattern p = Pattern.compile(regex);
         Matcher m = p.matcher(s );
         return m.matches();
        /* String str[] = s.split("\\.");
        for (int i=0;i<str.length;i++){
            if (str[i].length()<=3 && str.length==4){
                for (int j=0;j<4; j++) {
                    String string = String.valueOf(str[j].charAt(0));
                    if (string.equals("0") && str[j].matches()) {
                        return 0;
                    }
                }return 1;
            }
        }*/
     }
}

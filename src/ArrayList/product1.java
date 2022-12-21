package ArrayList;

import java.util.*;

public class product1 {
    static void Productdetail(int num){

        ArrayList prt = new ArrayList();
        Scanner sc=new Scanner(System.in);
        Get_set gs = new Get_set();
        int add;

        for (int i=1; i<=num; i++){

            System.out.println("Enter "+i+" Product id");
            add= sc.nextInt();
            prt.add(gs.setid(add));

            System.out.println("Enter Product Name");
            String adds= sc.next();
            prt.add(gs.setname(adds));

            System.out.println("Enter Product price");
            add= sc.nextInt();
            prt.add(gs.setprice(add));

            System.out.println("Enter Product size");
            add= sc.nextInt();
            prt.add(gs.setsize(add));

        }
        System.out.println(prt);
        System.out.println("Id \tName \t price  size");
        for (int i=0; i<num; i++){
            System.out.println(+gs.getid()+" \t"+gs.getname()+" \t"+gs.getprice()+" \t"+gs.getsize());
        }
    }



    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int n;
        System.out.println("Enter no of product you want to add");
        n= sc.nextInt();
        Productdetail(n);


    }
}


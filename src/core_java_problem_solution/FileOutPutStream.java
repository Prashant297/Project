package core_java_problem_solution;

import java.io.*;
import java.util.Scanner;

public class FileOutPutStream {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("D:\\Hello.txt"));
        bufferedWriter.write("Student Name"+"\t");
        bufferedWriter.write("Student Mark");
            for (int i=1; i<3; i++){
                System.out.println("Enter Student Name");
                String name = scanner.next();
                System.out.println("Enter Student Marks");
                int mark = scanner.nextInt();
                bufferedWriter.newLine();
                bufferedWriter.write("  "+name+"\t   ");
                bufferedWriter.write(Integer.toString(mark));
            }
            bufferedWriter.close();

/*
        Path newFile = Paths.get("D:\\NewFile.txt");
        Files.createFile(newFile);

        Path newFilePath = Paths.get("D:\\Hello.txt");
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("D:\\Hello.txt"));
        String st = scanner.next();
        for (int i=1; i<5; i++){
            for (int j=0; j<i; j++){
                bufferedWriter.write(st);
                if(i==j+1) {
                    bufferedWriter.newLine();
                }
            }
        }
*/

        BufferedWriter writer = new BufferedWriter(new FileWriter("D:\\NewFile.txt"));
        BufferedReader bufferedReader = new BufferedReader(new FileReader("D:\\Hello.txt"));
        StringBuilder content = new StringBuilder();
        String str;
        while ((str = bufferedReader.readLine())!= null){
            content.append(str);
            content.append(System.lineSeparator());
        }
        writer.write(String.valueOf(content));
        System.out.println(content);
        writer.close();
        bufferedReader.close();

    }
}


package core_java_problem_solution;

import java.io.*;
import java.util.*;

public class ReadFile {
    public static  void main(String[] args) throws IOException {
        List<Integer> countList = new ArrayList<>();
        final List<String> string = new ArrayList<>();
        String[] word = new String[0];
        int count = 1;
        BufferedReader bufferedReader = new BufferedReader(new FileReader("D:\\sample.txt"));
        StringBuilder content = new StringBuilder();
        String str;

        while ((str = bufferedReader.readLine())!= null){
            word = str.split(" ");
            string.addAll(List.of(word));
            content.append(str);
            content.append(System.lineSeparator());
        }
        System.out.println(content);
        Set<String> sort = new HashSet<>(string);
        System.out.println(word);

        List<String> setList = new ArrayList<>(sort);
        Collections.sort(setList);
        for (String s : setList) {
            for (String value : string) {
                if (s.equals(value)) {
                    count++;
                }
            }
            countList.add(count);
            count = 1;
        }

            for (int j=1;j<setList.size(); j++){
            System.out.println(setList.get(j)+" = "+countList.get(j));
        }
        bufferedReader.close();
    }
}

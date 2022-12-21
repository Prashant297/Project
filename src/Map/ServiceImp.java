package Map;

import java.util.*;
interface UserService {
    void saveDetail(HashMap<String,User> map);
}
public class ServiceImp implements UserService {
    @Override
    public void saveDetail(HashMap<String,User> map) {
        Scanner sc = new Scanner(System.in);
        String name, occ, status;
        int age, salary, n;

        System.out.println("Enter no of detail you want to enter");
        n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            System.out.println("Enter " + i + "Name");
            name = sc.next();
            System.out.println("Enter age");
            age = sc.nextInt();
            System.out.println("Enter Salary");
            salary = sc.nextInt();
            System.out.println("Enter Occupation");
            occ = sc.next();
            System.out.println("Enter Marital status");
            status = sc.next();
            User serve = new User(name, age, salary, occ, status);
            map.put(uniqeString(), serve);
        }
    }

    void display(HashMap<String,User> map) {
        for (Map.Entry<String,User> entry : map.entrySet()) {
            String key = entry.getKey();
            User s = entry.getValue();
            System.out.println(key + ": Details");
            System.out.println(s.name + "  " + s.age + "  " + s.salary + "  " + s.occupation + "  " + s.material);
            System.out.println();
        }
    }

    String uniqeString() {
        UUID uniqueString = UUID.randomUUID();
        return uniqueString.toString().substring(30);
    }
}
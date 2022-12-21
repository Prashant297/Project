package Map;

import java.util.*;

public class Main {
        public static void main(String[] args) {
           final HashMap<String, User> map = new HashMap<>();
            ServiceImp user = new ServiceImp();
            user.saveDetail(map);
            user.display(map);

        }
    }

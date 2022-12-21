package ArrayList;

public class FirstElementOccur {
    int Element() {
        int arr[] = {1, 7, 4, 3, 4, 8, 7};


        int n=0;
        for (int i =0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (arr[i] == arr[j]) {
                    n++;
                }if(n==2){
                    return arr[i];
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        FirstElementOccur el = new FirstElementOccur();
        System.out.println(el.Element());

    }
}

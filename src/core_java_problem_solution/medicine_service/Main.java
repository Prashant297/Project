package core_java_problem_solution.medicine_service;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MedicineServiceImpl medicineService = new MedicineServiceImpl();
        List<Medicine> medicineList = new ArrayList<>(medicineService.addMedicineDetail());
        System.out.println("\nEnter Disease");
        String disease = sc.next();
        System.out.println(MedicineServiceImpl.getMedicineByDisease(disease,medicineList));
    }

}

package core_java_problem_solution.medicine_service;

import java.util.*;
import java.util.stream.Collectors;


public class MedicineServiceImpl implements MedicineService {

    @Override
    public List<Medicine> addMedicineDetail() {
        Scanner scanner = new Scanner(System.in);


        System.out.println("Number of medicine you want to enter");
        int count = scanner.nextInt();
        List<Medicine> medicineList = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            Medicine medicine = new Medicine();
            System.out.println("Enter medicine Name");
            String medicineName = scanner.next();
            medicine.setMedicineName(medicineName);

            System.out.println("Enter medicine Batch");
            String medicineBatch = scanner.next();
            medicine.setBatch(medicineBatch);

            System.out.println("Enter Disease Name");
            String diseaseName = scanner.next();
            medicine.setDisease(diseaseName);

            System.out.println("Enter Price");
            int medicinePrice = scanner.nextInt();
            medicine.setPrice(medicinePrice);

            medicineList.add(medicine);
        }
        return medicineList;
    }

    static List<Integer> getMedicineByDisease(String disease, List<Medicine> medicineList) {

        List<Integer> priceList;
        priceList =  medicineList
                     .stream()
                     .filter(medicine -> medicine.getDisease().equalsIgnoreCase(disease))
                     .map(Medicine::getPrice)
                     .sorted(Comparator.naturalOrder())
                     .collect(Collectors.toList());


        return priceList;
    }
}

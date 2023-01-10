package core_java_problem_solution.travel_agency;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        TravelAgencyServiceImpl travelAgencyService = new TravelAgencyServiceImpl();
        Scanner scanner = new Scanner(System.in).useDelimiter("\\n");
        List<TravelAgency> travelAgencies = new ArrayList<>(travelAgencyService.addTravelAgencyDetail());

        if (!travelAgencies.isEmpty()) {
            System.out.println("Enter regNo1");
            int regNo1 = scanner.nextInt();
            System.out.println("Enter package");
            String pack = scanner.next();
            System.out.println(TravelAgencyServiceImpl.findAgencyWithHighestPackagePrice(travelAgencies));

            List<TravelAgency> agencyList = new ArrayList<>(TravelAgencyServiceImpl.agencyDetailsForGivenIdAndType(travelAgencies, pack, regNo1));

            for (TravelAgency travelAgency : agencyList) {
                System.out.println(travelAgency.getAgencyName() + " " + travelAgency.getPrice());
            }
        }

    }
}

package core_java_problem_solution.travel_agency;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class TravelAgencyServiceImpl implements TravelAgencyServices {
    @Override
    public List<TravelAgency> addTravelAgencyDetail() {
        Scanner scanner = new Scanner(System.in).useDelimiter("\\n");

        List<TravelAgency> agencyList = new ArrayList<>(); //agency

        System.out.println("Enter no. Travel Agency you want ");
        int count = scanner.nextInt();

        for (int i=0; i<count; i++) {
            TravelAgency travelAgency = new TravelAgency();
            System.out.println("Enter Registration No");
            int regNo = scanner.nextInt();
            travelAgency.setRegNo(regNo);
            System.out.println("Enter Agency Name");
            String name = scanner.next();
            travelAgency.setAgencyName(name);
            System.out.println("Enter Package");
            String packages = scanner.next();
            travelAgency.setPackageType(packages);
            System.out.println("Enter price");
            int price = scanner.nextInt();
            travelAgency.setPrice(price);
            System.out.println("Enter Flight Facility");
            boolean flight = scanner.nextBoolean();
            travelAgency.setFlightFacility(flight);

            if (agencyList.isEmpty()) {
                agencyList.add(travelAgency);
            }

            if (!checkAgencyAndPackageExist(agencyList, travelAgency)){
                agencyList.add(travelAgency);
            }
        }
        return agencyList;
    }

    private boolean checkAgencyAndPackageExist(List<TravelAgency> agencyList, TravelAgency travelAgency) {
        AtomicBoolean exist = new AtomicBoolean(false);
        agencyList.forEach(travelAgency1 -> {
            if ( travelAgency1.getAgencyName().equalsIgnoreCase(travelAgency.getAgencyName()) &&
            travelAgency1.getPackageType().equalsIgnoreCase(travelAgency.getPackageType())){
                exist.set(true);
            }
        });
        return exist.get();
    }

    static int findAgencyWithHighestPackagePrice(List<TravelAgency> travelAgencyList){
        List<Integer> price = new ArrayList<>();
        for (TravelAgency travelAgency : travelAgencyList){
            price.add(travelAgency.getPrice());
        }
        return Collections.max(price);
    }

    static List<TravelAgency> agencyDetailsForGivenIdAndType(List<TravelAgency> travelAgencyList, String packages, int regNo1){
        List<TravelAgency> agencyList = new ArrayList<>();
            for (TravelAgency travelAgency : travelAgencyList){
                if (travelAgency.isFlightFacility() && (travelAgency.getRegNo()== regNo1 &&
                        travelAgency.getPackageType().replaceAll("\\s","").equals(packages.replaceAll("\\s","") ))){
                    agencyList.add(travelAgency);
                }
            }
        return agencyList;
    }
}

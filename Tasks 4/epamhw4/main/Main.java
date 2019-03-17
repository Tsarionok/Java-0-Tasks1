package epamhw4.main;

import epamhw4.domain.Vehicle;
import epamhw4.service.VehicleByFuelConsumption;
import epamhw4.service.VehicleSearch;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Double totalCost = 0.0;
        List<Vehicle> vehicles = new LinkedList<>();
        File file = new File("E:\\Java\\EPAM_HW_1\\src\\epamhw4\\service\\Obj.txt");
        Scanner sc;

        try {

            sc = new Scanner(file);

            while (sc.hasNextLine()) {
                String line = sc.nextLine().trim();
                vehicles.add(Vehicle.parseVehicle(line));
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        for (Vehicle v : vehicles) {
            System.out.println(v.toString());
            totalCost += v.getPrice();
        }
        System.out.println(" Total cost is: " + totalCost + "\n");
        System.out.println(" Sorted by Fuel Consumption:");
        vehicles.sort(new VehicleByFuelConsumption());
        for (Vehicle v : vehicles) {
            System.out.println(v.toString());
        }
        System.out.println("\nSorted by parameters range:");
        VehicleSearch.searchByYear(2009, 2004, vehicles);
        VehicleSearch.searchByMileage(200000, 350000, vehicles);

        for (Vehicle v : vehicles) {
            System.out.println(v.toString());
        }
    }
}

package epamhw4.main;

import epamhw4.entities.Vehicle;
import epamhw4.actions.VehicleByFuelConsumption;
import epamhw4.actions.VehicleSearch;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final int minYear = 2000, maxYear = 2010, minMiliage = 150_000, maxMiliage = 350_000;
        double totalCost = 0.0;
        List<Vehicle> vehicles = new ArrayList<>();
        File file = new File("E:\\Java\\EPAM_HW_1\\src\\epamhw4\\actions\\Obj.txt");
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
        System.out.println(" Sorting by fuel consumption:");

        vehicles.sort(new VehicleByFuelConsumption());

        for (Vehicle v : vehicles) {
            System.out.println(v.toString());
        }

        System.out.println("\nSorted by parameters range:");
        VehicleSearch.searchByYear(minYear, maxYear, vehicles);
        VehicleSearch.searchByMileage(minMiliage, maxMiliage, vehicles);

        for (Vehicle v : vehicles) {
            System.out.println(v.toString());
        }
    }
}

package epamhw4.entities;

import epamhw4.entities.impl.Taxi;
import epamhw4.entities.impl.Cargo;
import epamhw4.entities.impl.Minibus;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

abstract public class Vehicle implements Serializable {
    private Manufacturer manufacturer;
    private Model model;
    private Integer year;
    private Integer price;
    private Integer mileage;
    private Double fuelConsumption; // liters per 100km

    protected Vehicle() {
    }

    public Vehicle(Manufacturer manufacturer,
                   Model model, Integer year,
                   Integer price, Integer mileage,
                   Double fuelConsumption) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.year = year;
        this.price = price;
        this.mileage = mileage;
        this.fuelConsumption = fuelConsumption;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getMileage() {
        return mileage;
    }

    public void setMileage(Integer mileage) {
        this.mileage = mileage;
    }

    public Double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(Double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public static Vehicle parseVehicle(String str) {
        Vehicle vehicle = null;

        Pattern manufacturer = Pattern.compile("manufacturer = ([^,]*|$)");
        Matcher manufacturerMatcher = manufacturer.matcher(str);
        boolean manufacturerFound = manufacturerMatcher.find();

        Pattern model = Pattern.compile("model = ([^,]*|$)");
        Matcher modelMatcher = model.matcher(str);
        boolean modelFound = modelMatcher.find();

        Pattern year = Pattern.compile("year = ([^,]*|$)");
        Matcher yearMatcher = year.matcher(str);
        boolean yearFound = yearMatcher.find();

        Pattern price = Pattern.compile("price = ([^,]*|$)");
        Matcher priceMatcher = price.matcher(str);
        boolean priceFound = priceMatcher.find();

        Pattern mileage = Pattern.compile("mileage = ([^,]*|$)");
        Matcher mileageMatcher = mileage.matcher(str);
        boolean mileageFound = mileageMatcher.find();

        Pattern fuelConsumption = Pattern.compile("fuelConsumption = ([^,]*|$)");
        Matcher fuelConsumptionMatcher = fuelConsumption.matcher(str);
        boolean fuelConsumptionFound = fuelConsumptionMatcher.find();

        Pattern numberOfSeats = Pattern.compile("numberOfSeats = ([^,]*|$)");
        Matcher numberOfSeatsMatcher = numberOfSeats.matcher(str);
        boolean numberOfSeatsFound = numberOfSeatsMatcher.find();

        Pattern cargoPlaces = Pattern.compile("cargoPlaces = ([^,]*|$)");
        Matcher cargoPlacesMatcher = cargoPlaces.matcher(str);
        boolean cargoPlacesFound = cargoPlacesMatcher.find();

        Pattern currentPassengersCount = Pattern.compile("currentPassengersCount = ([^,]*|$)");
        Matcher currentPassengersCountMatcher = currentPassengersCount.matcher(str);
        boolean currentPassengersCountFound = currentPassengersCountMatcher.find();

        Pattern currentCargoCount = Pattern.compile("currentCargoCount = ([^,]*|$)");
        Matcher currentCargoCountMatcher = currentCargoCount.matcher(str);
        boolean currentCargoCountFound = currentCargoCountMatcher.find();

        if (manufacturerFound &&
                modelFound &&
                yearFound &&
                priceFound &&
                mileageFound &&
                fuelConsumptionFound) {
            if (numberOfSeatsFound &&
                    currentPassengersCountFound &&
                    cargoPlacesFound &&
                    currentCargoCountFound) {
                vehicle = new Minibus(
                        Manufacturer.valueOf(manufacturerMatcher.group(1).toUpperCase()),
                        Model.valueOf(modelMatcher.group(1).toUpperCase()),
                        Integer.valueOf(yearMatcher.group(1)),
                        Integer.valueOf(priceMatcher.group(1)),
                        Integer.valueOf(mileageMatcher.group(1)),
                        Double.valueOf(fuelConsumptionMatcher.group(1)),
                        Integer.valueOf(numberOfSeatsMatcher.group(1)),
                        Integer.valueOf(cargoPlacesMatcher.group(1)),
                        Integer.valueOf(currentPassengersCountMatcher.group(1)),
                        Integer.valueOf(currentCargoCountMatcher.group(1))
                );

            } else if (numberOfSeatsFound &&
                    currentPassengersCountFound) {
                vehicle = new Taxi(
                        Manufacturer.valueOf(manufacturerMatcher.group(1).toUpperCase()),
                        Model.valueOf(modelMatcher.group(1).toUpperCase()),
                        Integer.valueOf(yearMatcher.group(1)),
                        Integer.valueOf(priceMatcher.group(1)),
                        Integer.valueOf(mileageMatcher.group(1)),
                        Double.valueOf(fuelConsumptionMatcher.group(1)),
                        Integer.valueOf(numberOfSeatsMatcher.group(1)),
                        Integer.valueOf(currentPassengersCountMatcher.group(1))
                );
            } else if (cargoPlacesFound &&
                    currentCargoCountFound) {
                vehicle = new Cargo(
                        Manufacturer.valueOf(manufacturerMatcher.group(1).toUpperCase()),
                        Model.valueOf(modelMatcher.group(1).toUpperCase()),
                        Integer.valueOf(yearMatcher.group(1)),
                        Integer.valueOf(priceMatcher.group(1)),
                        Integer.valueOf(mileageMatcher.group(1)),
                        Double.valueOf(fuelConsumptionMatcher.group(1)),
                        Integer.valueOf(cargoPlacesMatcher.group(1)),
                        Integer.valueOf(currentCargoCountMatcher.group(1))
                );
            }
        } else {
            System.out.println("Incorrect file input");
        }

        return vehicle;
    }

    @Override
    public String toString() {
        return "manufacturer = " + manufacturer +
                ", model = " + model +
                ", year = " + year +
                ", price = " + price +
                ", mileage = " + mileage +
                ", fuelConsumption = " + fuelConsumption;
    }
}

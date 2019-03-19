package epamhw4.entities.impl;

import epamhw4.entities.Manufacturer;
import epamhw4.entities.Model;
import epamhw4.entities.PassengersTransportation;
import epamhw4.entities.Vehicle;
import epamhw4.exception.VehicleSeatsCountException;

public class Taxi extends Vehicle implements PassengersTransportation {

    private Integer numberOfSeats;
    private Integer currentPassengersCount;

    public Taxi(Integer numberOfSeats,
                Integer currentPassengersCount) {
        this.numberOfSeats = numberOfSeats;
        this.currentPassengersCount = currentPassengersCount;
    }

    public Taxi(Manufacturer manufacturer,
                Model model,
                Integer year,
                Integer price,
                Integer mileage,
                Double fuelConsumption,
                Integer numberOfSeats,
                Integer currentPassengersCount) {
        super(manufacturer,
                model,
                year,
                price,
                mileage,
                fuelConsumption);
        this.numberOfSeats = numberOfSeats;
        this.currentPassengersCount = currentPassengersCount;
    }

    public Integer getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(Integer numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public Integer getCurrentPassengersCount() {
        return currentPassengersCount;
    }

    public void setCurrentPassengersCount(Integer currentPassengersCount) {
        this.currentPassengersCount = currentPassengersCount;
    }

    @Override
    public boolean addPassenger(Integer numPassengers) throws VehicleSeatsCountException {
        if (numPassengers < (currentPassengersCount - numberOfSeats)) {
            currentPassengersCount += numPassengers;
            return true;
        } else {
            throw new VehicleSeatsCountException("Not enough free seats.");
        }

    }

    @Override
    public Integer getPassengerCount() {

        return currentPassengersCount;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", numberOfSeats = " + numberOfSeats +
                ", currentPassengersCount = " + currentPassengersCount;
    }
}

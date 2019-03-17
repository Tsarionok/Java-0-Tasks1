package epamhw4.domain.impl;

import epamhw4.domain.Manufacturer;
import epamhw4.domain.Model;
import epamhw4.domain.PassengersTransportation;
import epamhw4.domain.Vehicle;
import epamhw4.exception.VehicleSeatsCountException;

public class Car extends Vehicle implements PassengersTransportation {

    private Integer numberOfSeats;
    private Integer currentPassengersCount;

    public Car(Integer numberOfSeats,
               Integer currentPassengersCount) {
        this.numberOfSeats = numberOfSeats;
        this.currentPassengersCount = currentPassengersCount;
    }

    public Car(Manufacturer manufacturer,
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

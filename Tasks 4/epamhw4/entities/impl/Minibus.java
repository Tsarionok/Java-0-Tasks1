package epamhw4.entities.impl;

import epamhw4.entities.*;
import epamhw4.exception.VehicleCargoPlacesException;
import epamhw4.exception.VehicleSeatsCountException;

public class Minibus extends Vehicle implements CargoTransportation, PassengersTransportation {

    private Integer numberOfSeats;
    private Integer currentPassengersCount;
    private Integer currentCargoCount;
    private Integer cargoPlaces;

    public Minibus(Integer numberOfSeats,
                   Integer currentPassengersCount,
                   Integer currentCargoCount,
                   Integer cargoPlaces) {
        this.numberOfSeats = numberOfSeats;
        this.currentPassengersCount = currentPassengersCount;
        this.cargoPlaces = cargoPlaces;
        this.currentCargoCount = currentCargoCount;
    }

    public Minibus(Manufacturer manufacturer,
                   Model model,
                   Integer year,
                   Integer price,
                   Integer mileage,
                   Double fuelConsumption,
                   Integer numberOfSeats,
                   Integer currentPassengersCount,
                   Integer cargoPlaces,
                   Integer currentCargoCount) {
        super(manufacturer,
                model,
                year,
                price,
                mileage,
                fuelConsumption);
        this.numberOfSeats = numberOfSeats;
        this.currentPassengersCount = currentPassengersCount;
        this.cargoPlaces = cargoPlaces;
        this.currentCargoCount = currentCargoCount;
    }

    public Integer getCargoPlaces() {
        return cargoPlaces;
    }

    public void setCargoPlaces(Integer cargoPlaces) {
        this.cargoPlaces = cargoPlaces;
    }

    public Integer getCurrentCargoCount() {
        return currentCargoCount;
    }

    public void setCurrentCargoCount(Integer currentCargoCount) {
        this.currentCargoCount = currentCargoCount;
    }

    @Override
    public boolean addPassenger(Integer numberOfPassengers) throws VehicleSeatsCountException {
        if (numberOfPassengers < (currentPassengersCount - numberOfSeats)) {
            currentPassengersCount += numberOfPassengers;
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
    public boolean addCargo(Integer numberOfCargo) throws VehicleCargoPlacesException {
        if (numberOfCargo < (this.currentCargoCount - cargoPlaces)) {
            this.currentCargoCount += numberOfCargo;
            return true;
        } else {
            throw new VehicleCargoPlacesException("Not enough free cargo places.");
        }
    }

    @Override
    public Integer getCargoCount() {
        return currentCargoCount;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", numberOfSeats = " + numberOfSeats +
                ", currentPassengersCount = " + currentPassengersCount +
                ", currentCargoCount = " + currentCargoCount +
                ", cargoPlaces = " + cargoPlaces;
    }
}

package epamhw4.domain.impl;

import epamhw4.domain.CargoTransportation;
import epamhw4.domain.Manufacturer;
import epamhw4.domain.Model;
import epamhw4.domain.Vehicle;
import epamhw4.exception.VehicleCargoPlacesException;

public class Truck extends Vehicle implements CargoTransportation {

    private Integer currentCargoCount;
    private Integer cargoPlaces;

    public Truck(Integer currentCargoCount,
                 Integer cargoPlaces) {
        this.currentCargoCount = currentCargoCount;
        this.cargoPlaces = cargoPlaces;
    }

    public Truck(Manufacturer manufacturer,
                 Model model,
                 Integer year,
                 Integer price,
                 Integer mileage,
                 Double fuelConsumption,
                 Integer cargoPlaces,
                 Integer currentCargoCount) {
        super(manufacturer,
                model,
                year,
                price,
                mileage,
                fuelConsumption);
        this.cargoPlaces = cargoPlaces;
        this.currentCargoCount = currentCargoCount;

    }

    public Integer getCurrentCargoCount() {
        return currentCargoCount;
    }

    public void setCurrentCargoCount(Integer currentCargoCount) {
        this.currentCargoCount = currentCargoCount;
    }

    public Integer getCargoPlaces() {
        return cargoPlaces;
    }

    public void setCargoPlaces(Integer cargoPlaces) {
        this.cargoPlaces = cargoPlaces;
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
                ", currentCargoCount = " + currentCargoCount +
                ", cargoPlaces = " + cargoPlaces;
    }
}

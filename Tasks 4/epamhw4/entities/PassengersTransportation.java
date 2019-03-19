package epamhw4.entities;

import epamhw4.exception.VehicleSeatsCountException;

public interface PassengersTransportation {

    boolean addPassenger(Integer numPassengers) throws VehicleSeatsCountException, VehicleSeatsCountException;

    Integer getPassengerCount();
    
}

package epamhw4.domain;

import epamhw4.exception.VehicleSeatsCountException;
import epamhw4.exception.VehicleSeatsCountException;

public interface PassengersTransportation {

    boolean addPassenger(Integer numPassengers) throws VehicleSeatsCountException, VehicleSeatsCountException;

    Integer getPassengerCount();
    
}

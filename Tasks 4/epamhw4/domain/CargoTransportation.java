package epamhw4.domain;

import epamhw4.exception.VehicleCargoPlacesException;

public interface CargoTransportation {

    boolean addCargo(Integer numberOfCargo) throws VehicleCargoPlacesException;

    Integer getCargoCount();

}

package com.parking;

import java.util.HashMap;

public class ParkingManagement {
    int sizeOfParking = 2;
    int parkingLot = 0;

    public HashMap<Integer, Vehical> map = new HashMap<>(sizeOfParking);
    public ParkingStatus parkingLotStatus = ParkingStatus.PARKING_EMPTY;
    private Object vehicle;

    public boolean parkVehicle(Object vehicle) {
        if (this.vehicle != null)
            return false;
        this.vehicle = vehicle;
        return true;
    }

    public boolean unParkVehicle(Object vehicle) {
        if (this.vehicle == null)
            return false;
        if (this.vehicle.equals(vehicle)) {
            this.vehicle = null;
            return true;
        }
        return false;
    }

    public void checkParkingLotsStatus() {
        if (parkingLot > sizeOfParking) {
            parkingLotStatus = ParkingStatus.PARKING_FULL;
            AirportSecurity.airportSecurityStatus = parkingLotStatus;
        } else {
            parkingLotStatus = ParkingStatus.PARKING_EMPTY;
            AirportSecurity.airportSecurityStatus = parkingLotStatus;
        }
    }
}

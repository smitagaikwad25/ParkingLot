package com.parking;

import java.util.HashMap;

public class ParkingManagement {
    int sizeOfParking = 2;
    int parkingLot = 0;

    public HashMap<Integer, Vehical> map = new HashMap<>(sizeOfParking);
    public ParkingStatus parkingLotStatus = ParkingStatus.PARKING_EMPTY;

    public boolean parkVehical(Object vehical) {
        return true;
    }

    public void unParkVehical(Vehical vehical) {
        int srNumber = vehical.getSrNumber();
        map.remove(srNumber);
        parkingLot--;
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

package com.parking;

import java.util.HashMap;

public class ParkingManagment {
    int sizeOfParking = 2;
    int parkingLot = 0;

    public HashMap<Integer, Vehical> map = new HashMap<>(sizeOfParking);
    public ParkingStatus parkingLotStatus = ParkingStatus.PARKING_EMPTY;

    public void parkVehical(Vehical vehical) {
        map.put(parkingLot, vehical);
        parkingLot++;
    }

    public void unParkVehical(Vehical vehical) {
        int srNumber = vehical.getSrNumber();
        map.remove(srNumber);
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

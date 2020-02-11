package com.parking;

import java.util.HashMap;

public class ParkingManegment {
    int sizeOfParking = 2;
    int parkingLot = 0;

    public HashMap<Integer, Vehical> map = new HashMap<>(sizeOfParking);
    public ParkingStatus parkingLotStatus = ParkingStatus.PARKING_EMPTY;


    public void parkVehical(Vehical vehical) {
        map.put(parkingLot, vehical);
        parkingLot++;
    }

    public void unParkVehical(Vehical vehical) {
        int srNumbere = vehical.getSrNumber();
        map.remove(srNumbere);
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

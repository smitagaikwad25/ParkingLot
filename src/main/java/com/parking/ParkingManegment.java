package com.parking;

import java.util.HashMap;

public class ParkingManegment {
    int sizeOfParking = 2;
    int parkingSlotNumber = 0;
    public HashMap<Integer, Vehical> map = new HashMap<>(sizeOfParking);
    public ParkingStatus parkingLotStatus = ParkingStatus.PARKING_EMPTY;

    public void parkVehical(Vehical vehical) {
        map.put(parkingSlotNumber, vehical);
        parkingSlotNumber++;
    }

    public void unParkVehical(Vehical vehical) {
        int srNumbere = vehical.getSrNumber();
        map.remove(srNumbere);
    }

    public void checkParkingLotsStatus() {
        if (parkingSlotNumber > sizeOfParking) {
            parkingLotStatus = ParkingStatus.PARKING_FULL;
        }
        parkingLotStatus = ParkingStatus.PARKING_EMPTY;
    }
}

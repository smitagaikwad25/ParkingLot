package com.parking;

import java.util.HashMap;

public class ParkingLot {
    int sizeOfParking = 2;
    int parkingSlotNumber = 1;
    public HashMap<Integer, Vehical> map = new HashMap<>(sizeOfParking);

    public void parkVehical(Vehical vehical) {
        map.put(parkingSlotNumber, vehical);
        parkingSlotNumber++;
    }

    public void unParkVehical(Vehical vehical) {
        int srNumbere = vehical.getSrNumbere();
        map.remove(srNumbere);
    }
}

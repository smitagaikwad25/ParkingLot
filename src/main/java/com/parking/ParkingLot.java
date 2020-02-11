package com.parking;

import java.util.HashMap;

public class ParkingLot {
    int sizeOfParking = 100;
    public HashMap<Integer, Vehical> map = new HashMap<>(sizeOfParking);
    int parkingSlotNumber = 1;

    public void parkVehical(Vehical vehical) {
        map.put(parkingSlotNumber, vehical);
        parkingSlotNumber++;
        System.out.println(map.values());
    }

    public void unParkVehical(Vehical vehical) {
        int srNumbere = vehical.getSrNumbere();
        map.remove(srNumbere);
        System.out.println(map);
    }
}

package com.parking;

import java.util.HashMap;

public class ParkingLot {

    HashMap<Integer, Vehical> map = new HashMap<>(4);

    public int parkVehical(Vehical vehical) {
        int parkingSlotNumber = 1;
        while (map.isEmpty())
            map.put(parkingSlotNumber,vehical);
            parkingSlotNumber ++;
        return map.size();
    }
}

package com.parking;

import org.junit.Assert;
import org.junit.Test;

public class ParkingLotTest {
    @Test
    public void whenGivenVehical_ShouldAddAndRetrunSizeOfParkingLotRemaing() {

        ParkingLot parkingLot = new ParkingLot();
        parkingLot.parkVehical(new Vehical(1, "car", 1245, "black"));
        parkingLot.parkVehical(new Vehical(2, "c", 1245, "black"));
        Assert.assertEquals(2, parkingLot.map.size());
    }
}



package com.parking;

import org.junit.Assert;
import org.junit.Test;

public class ParkingLotTest {
    @Test
    public void whenGivenVehical_ShouldAddAndRetrunSizeOfParkingLotRemaing() {
        ParkingLot parkingLot = new ParkingLot();
        int parkVehical = parkingLot.parkVehical(new Vehical(1, "car", 1245, "black"));
        Assert.assertEquals(1, parkVehical);
    }
}



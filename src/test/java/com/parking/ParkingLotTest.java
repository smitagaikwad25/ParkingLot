package com.parking;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ParkingLotTest {

    @Test
    public void whenGivenVehical_ShouldPark() {
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.parkVehical(new Vehical(1, "car", 1245, "black"));
        parkingLot.parkVehical(new Vehical(2, "bike", 1240, "black"));
        Assert.assertEquals(2, parkingLot.map.size());
    }

    @Test
    public void whenGivenVehicalParkingNumber_ShouldUnparkVehical() {
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.parkVehical(new Vehical(1, "car", 1245, "black"));
        parkingLot.parkVehical(new Vehical(2, "bike", 1240, "black"));
        parkingLot.unParkVehical(new Vehical(1, "car", 1245, "black"));
        Assert.assertEquals(1, parkingLot.map.size());
    }
}



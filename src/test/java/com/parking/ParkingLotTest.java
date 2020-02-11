package com.parking;

import org.junit.Assert;
import org.junit.Test;

public class ParkingLotTest {

    @Test
    public void whenGivenVehical_ShouldPark() {
        ParkingManegment parkingLot = new ParkingManegment();
        parkingLot.parkVehical(new Vehical(1, "car", 1245, "black"));
        parkingLot.parkVehical(new Vehical(2, "bike", 1240, "black"));
        Assert.assertEquals(2, parkingLot.map.size());
    }

    @Test
    public void whenGivenVehicalParkingNumber_ShouldUnparkVehical() {
        ParkingManegment parkingLot = new ParkingManegment();
        parkingLot.parkVehical(new Vehical(1, "car", 1245, "black"));
        parkingLot.parkVehical(new Vehical(2, "bike", 1240, "black"));
        parkingLot.unParkVehical(new Vehical(1, "car", 1245, "black"));
        Assert.assertEquals(1, parkingLot.map.size());
    }

    @Test
    public void whenGivenParkingLot_WhenFull_ReturnParkingStatus() {
        ParkingManegment parkingLot = new ParkingManegment();
        parkingLot.parkVehical(new Vehical(1, "car", 1245, "black"));
        parkingLot.parkVehical(new Vehical(2, "bike", 1240, "black"));
        parkingLot.parkVehical(new Vehical(3, "truck", 1241, "black"));
        parkingLot.checkParkingLotsStatus();
        Assert.assertEquals(parkingLot.parkingLotStatus, ParkingStatus.PARKING_FULL);
    }
}
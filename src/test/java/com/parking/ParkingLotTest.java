package com.parking;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ParkingLotTest {

    Object vehicle = null;
    ParkingLotManagement parkingLotManagement = null;

    @Before
    public void setUp(){
        vehicle = new Object();
        parkingLotManagement = new ParkingLotManagement(1);
    }

    @Test
    public void givenVehicle_whenPark_ShouldReturnTrue() throws ParkingLotException {
        try {
            parkingLotManagement.parkVehicle(vehicle);
            boolean isVehiclePark = parkingLotManagement.isVehiclePark(vehicle);
            Assert.assertTrue(isVehiclePark);
        }catch (ParkingLotException e){
        }
    }

    @Test
    public void givenVehicle_whenAlreadyPark_shouldReturnFalse() {
        try {
            parkingLotManagement.parkVehicle(vehicle);
            parkingLotManagement.parkVehicle(new Object());
        } catch (ParkingLotException e) {
            Assert.assertEquals("Parking Lot Is Full",e.getMessage());
        }
    }

    @Test
    public void givenVehicle_whenUnPark_ShouldReturnTrue() throws ParkingLotException {
        parkingLotManagement.parkVehicle(vehicle);
        boolean unParkVehicle = parkingLotManagement.unParkVehicle(vehicle);
        Assert.assertTrue(unParkVehicle);
    }

    @Test
    public void givenParkingLot_whenFull_ShuldInformToOwner() {
        ParkingLotOwner parkingLotOwner = new ParkingLotOwner();
        parkingLotManagement.OwnerOfParking(parkingLotOwner);
        try {
            parkingLotManagement.parkVehicle(vehicle);
            parkingLotManagement.parkVehicle(new Object());
        } catch (ParkingLotException e) {
            boolean parkingFull = parkingLotOwner.isParkingFull();
            Assert.assertTrue(parkingFull);
        }
    }

}
package com.parking;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ParkingLotTest {

    Object vehicle = null;
    ParkingManagement parkingManagement = null;

    @Before
    public void setUp(){
        vehicle = new Object();
        parkingManagement = new ParkingManagement();
    }

    @Test
    public void givenVehicle_whenPark_ShouldReturnTrue() {
        boolean parkVehicle = parkingManagement.parkVehicle(vehicle);
        Assert.assertTrue(parkVehicle);
    }

    @Test
    public void givenVehicle_whenAlreadyPark_shouldReturnFalse(){
        parkingManagement.parkVehicle(vehicle);
        boolean parkVehicle = parkingManagement.parkVehicle(new Object());
        Assert.assertFalse(parkVehicle);
    }

    @Test
    public void givenVehicle_whenUnPark_ShouldReturnTrue() {
        parkingManagement.parkVehicle(vehicle);
        boolean unParkVehicle = parkingManagement.unParkVehicle(vehicle);
        Assert.assertTrue(unParkVehicle);
    }

    @Test
    public void whenGivenParkingLot_WhenFull_ReturnParkingStatus() {
        ParkingManagement parkingLot = new ParkingManagement();
        parkingLot.parkVehicle(new Vehical(1, "car", "MH12 1245", "black"));
        parkingLot.parkVehicle(new Vehical(2, "bike", "MH12 1240", "black"));
        parkingLot.parkVehicle(new Vehical(3, "truck", "MH12 1241", "black"));
        parkingLot.checkParkingLotsStatus();
        Assert.assertEquals(parkingLot.parkingLotStatus, ParkingStatus.PARKING_FULL);
    }

    @Test
    public void whenGivenParkingLot_WhenEmpty_ReturnParkingStatus() {
        ParkingManagement parkingLot = new ParkingManagement();
        parkingLot.parkVehicle(new Vehical(1, "car", "MH12 1245", "black"));
        parkingLot.parkVehicle(new Vehical(2, "bike", "KH04 1240", "black"));
        parkingLot.checkParkingLotsStatus();
        Assert.assertEquals(parkingLot.parkingLotStatus, ParkingStatus.PARKING_EMPTY);
    }

    @Test
    public void whenGivenParkingLot_WhenEmpty_ShouldRedirctSecurity() {
        ParkingManagement parkingLot = new ParkingManagement();
        parkingLot.parkVehicle(new Vehical(1, "car", "MH12 1245", "black"));
        parkingLot.parkVehicle(new Vehical(2, "bike", "KH04 1240", "black"));
        parkingLot.checkParkingLotsStatus();
        Assert.assertEquals(AirportSecurity.airportSecurityStatus, ParkingStatus.PARKING_EMPTY);
    }

    @Test
    public void whenGivenParkingLot_WhenFull_ShouldRedirctSecurity() {
        ParkingManagement parkingLot = new ParkingManagement();
        parkingLot.parkVehicle(new Vehical(1, "car", "MH12 1245", "black"));
        parkingLot.parkVehicle(new Vehical(2, "bike", "KH041240", "black"));
        parkingLot.parkVehicle(new Vehical(3, "truck", "MH12 1241", "black"));
        parkingLot.checkParkingLotsStatus();
        Assert.assertEquals(AirportSecurity.airportSecurityStatus, ParkingStatus.PARKING_FULL);
    }

    @Test
    public void whenGivenParkingLot_WhenFullOrEmpty_ShouldReturnStatus() {
        ParkingManagement parkingLot = new ParkingManagement();
        parkingLot.parkVehicle(new Vehical(1, "car", "MH12 1245", "black"));
        parkingLot.parkVehicle(new Vehical(2, "bike", "KH041240", "black"));
        parkingLot.parkVehicle(new Vehical(3, "truck", "MH12 1241", "black"));
        parkingLot.checkParkingLotsStatus();
        Assert.assertEquals(AirportSecurity.airportSecurityStatus, ParkingStatus.PARKING_FULL);
        parkingLot.unParkVehicle(new Vehical(1, "car", "MH12 1240", "black"));
        parkingLot.checkParkingLotsStatus();
        Assert.assertEquals(AirportSecurity.airportSecurityStatus, ParkingStatus.PARKING_EMPTY);
    }

}
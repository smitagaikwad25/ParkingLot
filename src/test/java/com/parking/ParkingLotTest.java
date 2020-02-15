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
    public void givenVehicle_whenPark_ShouldReturnTrue() throws ParkingLotException {
        try {
            parkingManagement.parkVehicle(vehicle);
            boolean isVehiclePark = parkingManagement.isVehiclePark(vehicle);
            Assert.assertTrue(isVehiclePark);
        }catch (ParkingLotException e){
            e.getStackTrace();
        }
    }

    @Test
    public void givenVehicle_whenAlreadyPark_shouldReturnFalse() {
        try {
            parkingManagement.parkVehicle(vehicle);
            parkingManagement.parkVehicle(new Object());
        } catch (ParkingLotException e) {
            Assert.assertEquals("Parking Lot Is Full",e.getMessage());
        }
    }

    @Test
    public void givenVehicle_whenUnPark_ShouldReturnTrue() throws ParkingLotException {
        parkingManagement.parkVehicle(vehicle);
        boolean unParkVehicle = parkingManagement.unParkVehicle(vehicle);
        Assert.assertTrue(unParkVehicle);
    }

    @Test
    public void whenGivenParkingLot_WhenFull_ReturnParkingStatus() throws ParkingLotException {
        ParkingManagement parkingLot = new ParkingManagement();
        parkingLot.parkVehicle(new Vehical(1, "car", "MH12 1245", "black"));
        parkingLot.parkVehicle(new Vehical(2, "bike", "MH12 1240", "black"));
        parkingLot.parkVehicle(new Vehical(3, "truck", "MH12 1241", "black"));
        parkingLot.checkParkingLotsStatus();
        Assert.assertEquals(parkingLot.parkingLotStatus, ParkingStatus.PARKING_FULL);
    }

    @Test
    public void whenGivenParkingLot_WhenEmpty_ReturnParkingStatus() throws ParkingLotException {
        ParkingManagement parkingLot = new ParkingManagement();
        parkingLot.parkVehicle(new Vehical(1, "car", "MH12 1245", "black"));
        parkingLot.parkVehicle(new Vehical(2, "bike", "KH04 1240", "black"));
        parkingLot.checkParkingLotsStatus();
        Assert.assertEquals(parkingLot.parkingLotStatus, ParkingStatus.PARKING_EMPTY);
    }

    @Test
    public void whenGivenParkingLot_WhenEmpty_ShouldRedirctSecurity() throws ParkingLotException {
        ParkingManagement parkingLot = new ParkingManagement();
        parkingLot.parkVehicle(new Vehical(1, "car", "MH12 1245", "black"));
        parkingLot.parkVehicle(new Vehical(2, "bike", "KH04 1240", "black"));
        parkingLot.checkParkingLotsStatus();
        Assert.assertEquals(AirportSecurity.airportSecurityStatus, ParkingStatus.PARKING_EMPTY);
    }

    @Test
    public void whenGivenParkingLot_WhenFull_ShouldRedirctSecurity() throws ParkingLotException {
        ParkingManagement parkingLot = new ParkingManagement();
        parkingLot.parkVehicle(new Vehical(1, "car", "MH12 1245", "black"));
        parkingLot.parkVehicle(new Vehical(2, "bike", "KH041240", "black"));
        parkingLot.parkVehicle(new Vehical(3, "truck", "MH12 1241", "black"));
        parkingLot.checkParkingLotsStatus();
        Assert.assertEquals(AirportSecurity.airportSecurityStatus, ParkingStatus.PARKING_FULL);
    }

    @Test
    public void whenGivenParkingLot_WhenFullOrEmpty_ShouldReturnStatus() throws ParkingLotException {
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
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

    @Test
    public void whenGivenParkingLot_WhenFull_ReturnParkingStatus() throws ParkingLotException {
        ParkingLotManagement parkingLot = new ParkingLotManagement(1);
        parkingLot.parkVehicle(new Vehical(1, "car", "MH12 1245", "black"));
        parkingLot.parkVehicle(new Vehical(2, "bike", "MH12 1240", "black"));
        parkingLot.parkVehicle(new Vehical(3, "truck", "MH12 1241", "black"));
        parkingLot.checkParkingLotsStatus();
        Assert.assertEquals(parkingLot.parkingLotStatus, ParkingStatus.PARKING_FULL);
    }

    @Test
    public void whenGivenParkingLot_WhenEmpty_ReturnParkingStatus() throws ParkingLotException {
        ParkingLotManagement parkingLot = new ParkingLotManagement(1);
        parkingLot.parkVehicle(new Vehical(1, "car", "MH12 1245", "black"));
        parkingLot.parkVehicle(new Vehical(2, "bike", "KH04 1240", "black"));
        parkingLot.checkParkingLotsStatus();
        Assert.assertEquals(parkingLot.parkingLotStatus, ParkingStatus.PARKING_EMPTY);
    }

    @Test
    public void whenGivenParkingLot_WhenEmpty_ShouldRedirctSecurity() throws ParkingLotException {
        ParkingLotManagement parkingLot = new ParkingLotManagement(1);
        parkingLot.parkVehicle(new Vehical(1, "car", "MH12 1245", "black"));
        parkingLot.parkVehicle(new Vehical(2, "bike", "KH04 1240", "black"));
        parkingLot.checkParkingLotsStatus();
        Assert.assertEquals(AirportSecurity.airportSecurityStatus, ParkingStatus.PARKING_EMPTY);
    }

    @Test
    public void whenGivenParkingLot_WhenFull_ShouldRedirctSecurity() throws ParkingLotException {
        ParkingLotManagement parkingLot = new ParkingLotManagement(1);
        parkingLot.parkVehicle(new Vehical(1, "car", "MH12 1245", "black"));
        parkingLot.parkVehicle(new Vehical(2, "bike", "KH041240", "black"));
        parkingLot.parkVehicle(new Vehical(3, "truck", "MH12 1241", "black"));
        parkingLot.checkParkingLotsStatus();
        Assert.assertEquals(AirportSecurity.airportSecurityStatus, ParkingStatus.PARKING_FULL);
    }

    @Test
    public void whenGivenParkingLot_WhenFullOrEmpty_ShouldReturnStatus() throws ParkingLotException {
        ParkingLotManagement parkingLot = new ParkingLotManagement(1);
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
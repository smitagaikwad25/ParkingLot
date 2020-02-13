package com.parking;

import org.junit.Assert;
import org.junit.Test;

public class ParkingLotTest {

    @Test
    public void givenVehicle_whenPark_ShouldReturnVehical() {
        ParkingManagement parkingManagement = new ParkingManagement();
        boolean parkVehicle = parkingManagement.parkVehical(new Object());
        Assert.assertTrue(parkVehicle);
    }

    @Test
    public void whenGivenVehical_ShouldPark() {
        ParkingManagement parkingLot = new ParkingManagement();
        parkingLot.parkVehical(new Vehical(1, "car", "MH12 1245", "black"));
        parkingLot.parkVehical(new Vehical(2, "bike", "AK04 1240", "black"));
        Assert.assertEquals(2, parkingLot.map.size());
    }

    @Test
    public void whenGivenVehicalParkingNumber_ShouldUnparkVehical() {
        ParkingManagement parkingLot = new ParkingManagement();
        parkingLot.parkVehical(new Vehical(1, "car", "MH12 1245", "black"));
        parkingLot.parkVehical(new Vehical(2, "bike", "KH04 1240", "black"));
        parkingLot.unParkVehical(new Vehical(1, "car", "MH12 1240", "black"));
        Assert.assertEquals(1, parkingLot.map.size());
    }

    @Test
    public void whenGivenParkingLot_WhenFull_ReturnParkingStatus() {
        ParkingManagement parkingLot = new ParkingManagement();
        parkingLot.parkVehical(new Vehical(1, "car", "MH12 1245", "black"));
        parkingLot.parkVehical(new Vehical(2, "bike", "MH12 1240", "black"));
        parkingLot.parkVehical(new Vehical(3, "truck", "MH12 1241", "black"));
        parkingLot.checkParkingLotsStatus();
        Assert.assertEquals(parkingLot.parkingLotStatus, ParkingStatus.PARKING_FULL);
    }

    @Test
    public void whenGivenParkingLot_WhenEmpty_ReturnParkingStatus() {
        ParkingManagement parkingLot = new ParkingManagement();
        parkingLot.parkVehical(new Vehical(1, "car", "MH12 1245", "black"));
        parkingLot.parkVehical(new Vehical(2, "bike", "KH04 1240", "black"));
        parkingLot.checkParkingLotsStatus();
        Assert.assertEquals(parkingLot.parkingLotStatus, ParkingStatus.PARKING_EMPTY);
    }

    @Test
    public void whenGivenParkingLot_WhenEmpty_ShouldRedirctSecurity() {
        ParkingManagement parkingLot = new ParkingManagement();
        parkingLot.parkVehical(new Vehical(1, "car", "MH12 1245", "black"));
        parkingLot.parkVehical(new Vehical(2, "bike", "KH04 1240", "black"));
        parkingLot.checkParkingLotsStatus();
        Assert.assertEquals(AirportSecurity.airportSecurityStatus, ParkingStatus.PARKING_EMPTY);
    }

    @Test
    public void whenGivenParkingLot_WhenFull_ShouldRedirctSecurity() {
        ParkingManagement parkingLot = new ParkingManagement();
        parkingLot.parkVehical(new Vehical(1, "car", "MH12 1245", "black"));
        parkingLot.parkVehical(new Vehical(2, "bike", "KH041240", "black"));
        parkingLot.parkVehical(new Vehical(3, "truck", "MH12 1241", "black"));
        parkingLot.checkParkingLotsStatus();
        Assert.assertEquals(AirportSecurity.airportSecurityStatus, ParkingStatus.PARKING_FULL);
    }

    @Test
    public void whenGivenParkingLot_WhenFullOrEmpty_ShouldReturnStatus() {
        ParkingManagement parkingLot = new ParkingManagement();
        parkingLot.parkVehical(new Vehical(1, "car", "MH12 1245", "black"));
        parkingLot.parkVehical(new Vehical(2, "bike", "KH041240", "black"));
        parkingLot.parkVehical(new Vehical(3, "truck", "MH12 1241", "black"));
        parkingLot.checkParkingLotsStatus();
        Assert.assertEquals(AirportSecurity.airportSecurityStatus, ParkingStatus.PARKING_FULL);
        parkingLot.unParkVehical(new Vehical(1, "car", "MH12 1240", "black"));
        parkingLot.checkParkingLotsStatus();
        Assert.assertEquals(AirportSecurity.airportSecurityStatus, ParkingStatus.PARKING_EMPTY);
    }

}
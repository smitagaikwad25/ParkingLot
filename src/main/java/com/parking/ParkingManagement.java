package com.parking;

public class ParkingManagement {
    int sizeOfParking = 2;
    int parkingLot = 0;

    public ParkingStatus parkingLotStatus = ParkingStatus.PARKING_EMPTY;
    private Object vehicle;

    public void parkVehicle(Object vehicle) throws ParkingLotException {
        if (this.vehicle != null)
            throw new ParkingLotException("Parking Lot Is Full");
        this.vehicle = vehicle;
    }

    public boolean isVehiclePark(Object vehicle) {
        if (this.vehicle.equals(vehicle))
            return true;
        return false;
    }

    public boolean unParkVehicle(Object vehicle) throws ParkingLotException {
        if (this.vehicle == null) return false;
        if (this.vehicle.equals(vehicle)) {
            this.vehicle = null;
            return true;
        }
        return false;
    }

    public void checkParkingLotsStatus() {
        if (parkingLot > sizeOfParking) {
            parkingLotStatus = ParkingStatus.PARKING_FULL;
            AirportSecurity.airportSecurityStatus = parkingLotStatus;
        } else {
            parkingLotStatus = ParkingStatus.PARKING_EMPTY;
            AirportSecurity.airportSecurityStatus = parkingLotStatus;
        }
    }
}

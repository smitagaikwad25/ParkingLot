package com.parking;

public class ParkingManagement {
    private final int actualCapacity;
    private  int currentCapacity;
    private ParkingLotOwner parkingLotOwner;
    int sizeOfParking = 2;
    int parkingLot = 0;

    public ParkingStatus parkingLotStatus = ParkingStatus.PARKING_EMPTY;
    private Object vehicle;

    public ParkingManagement(int capacity) {
    this.actualCapacity = capacity;
    this.currentCapacity = 0;
    }

    public void OwnerOfParking(ParkingLotOwner parkingLotOwner) {
     this.parkingLotOwner = parkingLotOwner;
    }

    public void parkVehicle(Object vehicle) throws ParkingLotException {
        if (this.currentCapacity == actualCapacity) {
            parkingLotOwner.InformStatusOfParking();
            throw new ParkingLotException("Parking Lot Is Full");
        }
        this.currentCapacity++;
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

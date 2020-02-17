package com.parking;

public class ParkingLotOwner {
    private boolean isParkingLotFull;

    public void InformStatusOfParking() {
        isParkingLotFull = true;
    }

    public boolean isParkingFull() {
        return this.isParkingLotFull;
    }
}

package com.parking;

import java.sql.Time;

public class Vehical {
    public int SrNumber;
    public String VevicalType;
    public int NumberPlate;
    public String colour;
    public Time time;

    public int getSrNumber() {
        return SrNumber;
    }

    public void setSrNumber(int srNumber) {
        SrNumber = srNumber;
    }

    public String getVevicalType() {
        return VevicalType;
    }

    public void setVevicalType(String vevicalType) {
        VevicalType = vevicalType;
    }

    public int getNumberPlate() {
        return NumberPlate;
    }

    public void setNumberPlate(int numberPlate) {
        NumberPlate = numberPlate;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public Vehical(int srNumber, String vevicalType, int numberPlate, String colour) {
        SrNumber = srNumber;
        VevicalType = vevicalType;
        NumberPlate = numberPlate;
        this.colour = colour;
        this.time = time;
    }

    @Override
    public String toString() {
        return "Vehical{" +
                "SrNumbere=" + SrNumber +
                ", VevicalType='" + VevicalType + '\'' +
                ", NumberPlate=" + NumberPlate +
                ", colour='" + colour + '\'' +
                ", time=" + time +
                '}';
    }
}

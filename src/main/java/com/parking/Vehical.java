package com.parking;

import java.sql.Time;

public class Vehical {
    public int SrNumber;
    public String VehicalType;
    public String VehicalNumber;
    public String colour;
    public Time time;

    public int getSrNumber() {
        return SrNumber;
    }

    public void setSrNumber(int srNumber) {
        SrNumber = srNumber;
    }

    public String getVehicalType() {
        return VehicalType;
    }

    public void setVehicalType(String vehicalType) {
        VehicalType = vehicalType;
    }

    public String getVehicalNumber() {
        return VehicalNumber;
    }

    public void setVehicalNumber(String vehicalNumber) {
        VehicalNumber = vehicalNumber;
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

    public Vehical(int srNumber, String vehicalType, String vehicalNumber, String colour) {
        SrNumber = srNumber;
        VehicalType = vehicalType;
        VehicalNumber = vehicalNumber;
        this.colour = colour;
        this.time = time;
    }

    @Override
    public String toString() {
        return "Vehical{" +
                "SrNumbere=" + SrNumber +
                ", VevicalType='" + VehicalType + '\'' +
                ", NumberPlate=" + VehicalNumber +
                ", colour='" + colour + '\'' +
                ", time=" + time +
                '}';
    }
}

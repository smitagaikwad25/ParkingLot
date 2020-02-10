package com.parking;

import java.sql.Time;

public class Vehical {
    public int SrNumbere;
    public String VevicalType;
    public int NumberPlate;
    public  String colour;


//    public Time time;

    public int getSrNumbere() {
        return SrNumbere;
    }

    public void setSrNumbere(int srNumbere) {
        SrNumbere = srNumbere;
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

//    public Time getTime() {
//        return time;
//    }

//    public void setTime(Time time) {
//        this.time = time;
//    }

    public Vehical(int srNumbere, String vevicalType, int numberPlate, String colour) {
        SrNumbere = srNumbere;
        VevicalType = vevicalType;
        NumberPlate = numberPlate;
        this.colour = colour;
//        this.time = time;
    }

    @Override
    public String toString() {
        return "Vehical{" +
                "SrNumbere=" + SrNumbere +
                ", VevicalType='" + VevicalType + '\'' +
                ", NumberPlate=" + NumberPlate +
                ", colour='" + colour + '\'' +
//                ", time=" + time +
                '}';
    }
}

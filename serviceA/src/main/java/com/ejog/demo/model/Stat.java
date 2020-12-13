package com.ejog.demo.model;

public class Stat {
    public static int requestNumber;
    public static long requestAvgMSec;
    public static long requestTotalMSec;

    public static int getRequestNumber() {
        return requestNumber;
    }

    public static void setRequestNumber(int requestNumber) {
        Stat.requestNumber = requestNumber;
    }

    public static long getRequestAvgMSec() {
        return requestAvgMSec;
    }

    public static void setRequestAvgMSec(long requestAvgMSec) {
        Stat.requestAvgMSec = requestAvgMSec;
    }

    public static float getRequestTotalMSec() {
        return requestTotalMSec;
    }

    public static void setRequestTotalMSec(long requestTotalMSec) {
        Stat.requestTotalMSec = requestTotalMSec;
    }

    public static void countRequests(long time){
        requestNumber++;
        requestTotalMSec += time;
        requestAvgMSec = requestTotalMSec/(long) requestNumber;
    }


}

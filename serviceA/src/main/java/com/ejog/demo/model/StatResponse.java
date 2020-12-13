package com.ejog.demo.model;

public class StatResponse {
    public int requestNumber;
    public float requestAvgMSec;
    public float requestTotalMSec;

    public StatResponse(int requestNumber, float requestAvgMSec, float requestTotalMSec){
        this.requestNumber = requestNumber;
        this.requestAvgMSec = requestAvgMSec;
        this.requestTotalMSec = requestTotalMSec;
    }

    public int getRequestNumber() {
        return requestNumber;
    }

    public void setRequestNumber(int requestNumber) {
        this.requestNumber = requestNumber;
    }

    public float getRequestAvgMSec() {
        return requestAvgMSec;
    }

    public void setRequestAvgMSec(float requestAvgMSec) {
        this.requestAvgMSec = requestAvgMSec;
    }

    public float getRequestTotalMSec() {
        return requestTotalMSec;
    }

    public void setRequestTotalMSec(float requestTotalMSec) {
        this.requestTotalMSec = requestTotalMSec;
    }

    @Override
    public String toString() {
        return "StatResponse{" +
                "requestNumber=" + requestNumber +
                ", requestAvgMSec=" + requestAvgMSec +
                ", requestTotalMSec=" + requestTotalMSec +
                '}';
    }
}

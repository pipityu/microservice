package com.ejog.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
public class EntityTwoConsumer {

    @JsonProperty("id")
    private int id;
    @JsonProperty("myTime")
    private LocalDateTime myTime;
    @JsonProperty("myString")
    private String myString;
    @JsonProperty("myBoolean")
    private Boolean myBoolean;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getMyTime() {
        return myTime;
    }

    public void setMyTime(LocalDateTime myTime) {
        this.myTime = myTime;
    }

    public String getMyString() {
        return myString;
    }

    public void setMyString(String myString) {
        this.myString = myString;
    }

    public Boolean getMyBoolean() {
        return myBoolean;
    }

    public void setMyBoolean(Boolean myBoolean) {
        this.myBoolean = myBoolean;
    }
}

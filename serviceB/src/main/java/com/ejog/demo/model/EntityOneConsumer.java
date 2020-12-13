package com.ejog.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

public class EntityOneConsumer implements Serializable {
    private int id;
    private String myData;
    @JsonProperty("entityTwoList")
    List<EntityTwoConsumer> entityTwoConsumers;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMyData() {
        return myData;
    }

    public void setMyData(String myData) {
        this.myData = myData;
    }

    public List<EntityTwoConsumer> getEntityTwoConsumers() {
        return entityTwoConsumers;
    }

    public void setEntityTwoConsumers(List<EntityTwoConsumer> entityTwoConsumers) {
        this.entityTwoConsumers = entityTwoConsumers;
    }
}

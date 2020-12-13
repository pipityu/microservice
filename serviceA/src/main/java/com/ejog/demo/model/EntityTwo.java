package com.ejog.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "entitytwo")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class EntityTwo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private LocalDateTime myTime;
    private String myString;
    private Boolean myBoolean;
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "entity_one_id" ,referencedColumnName = "id")
    private EntityOne entityOne;


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

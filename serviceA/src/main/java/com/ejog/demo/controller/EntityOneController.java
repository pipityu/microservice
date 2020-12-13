package com.ejog.demo.controller;

import com.ejog.demo.model.EntityOne;
import com.ejog.demo.model.Stat;
import com.ejog.demo.model.StatResponse;
import com.ejog.demo.service.EntityOneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class EntityOneController {

    private EntityOneService entityOneService;
    private Environment environment;

    @Autowired
    public EntityOneController(EntityOneService entityOneService, Environment environment){
        this.entityOneService = entityOneService;
        this.environment = environment;
    }

    @GetMapping("/")
    public String hi(){
        return "/";
    }

    //Create Entity
    @PostMapping("/create")
    public ResponseEntity<String> createEntityOne(@RequestBody EntityOne entityOne){
        return (entityOneService.createEntityOne(entityOne))
                ? new ResponseEntity<>(entityOne.toString(), HttpStatus.CREATED)
                : new ResponseEntity<>("Couldn't create Entity",HttpStatus.BAD_REQUEST);
    }


    //Read Entity by id
    @GetMapping("/read/{id}")
    public ResponseEntity<EntityOne> getEntity (@PathVariable int id){

        EntityOne entityOne = entityOneService.readEntityOne(id);
        System.out.println(entityOne.toString());
        return (entityOne.getId() > 0)
            ? new ResponseEntity<>(entityOne, HttpStatus.OK)
            : new ResponseEntity<>(entityOne, HttpStatus.NOT_FOUND);
    }

    //Update Entity by id
    @PutMapping("update/{id}")
    public ResponseEntity<String> updateEntity(@RequestBody EntityOne entityOne){
        String response;
        HttpStatus status;
        switch (entityOneService.updateEntityOne(entityOne)){
            case 0: response = "Couldn't find Entity for update"; status = HttpStatus.NOT_FOUND;
            break;
            case 1: response = "Successful update"; status = HttpStatus.OK;
            break;
            default: response = "Something went wrong"; status = HttpStatus.BAD_REQUEST;
        }
        return new ResponseEntity<>(response, status);
    }

    //Delete Entity by id
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEntityOne(@PathVariable int id){
        return entityOneService.deleteEntityOne(id)
                ? new ResponseEntity<>("Successful deleted",HttpStatus.OK)
                : new ResponseEntity<>("Something went wrong", HttpStatus.BAD_REQUEST);
    }

    //Retrieve my own 'statistics'
    @GetMapping("/stat")
    public ResponseEntity<StatResponse> getStat(){
        return new ResponseEntity<>(new StatResponse(Stat.getRequestNumber(), Stat.getRequestAvgMSec(), Stat.requestTotalMSec),HttpStatus.OK);
    }
}

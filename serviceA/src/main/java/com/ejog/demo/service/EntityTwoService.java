package com.ejog.demo.service;

import com.ejog.demo.repository.EntityTwoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EntityTwoService {

    private EntityTwoRepository entityTwoRepository;

    @Autowired
    public EntityTwoService(EntityTwoRepository entityTwoRepository){
        this.entityTwoRepository = entityTwoRepository;
    }


}

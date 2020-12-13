package com.ejog.demo.service;


import com.ejog.demo.model.EntityOne;
import com.ejog.demo.repository.EntityOneRepository;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EntityOneService {
    private EntityOneRepository entityOneRepository;

    @Autowired
    public EntityOneService(EntityOneRepository entityOneRepository){
        this.entityOneRepository = entityOneRepository;
    }


    public boolean createEntityOne(EntityOne entityOne){
        try{
            entityOneRepository.save(entityOne);
            return true;
        }catch (HibernateException hibernateException){
            hibernateException.printStackTrace();
            return false;
        }
    }

    public EntityOne readEntityOne(int id){
        return entityOneRepository.findById(id).orElse(new EntityOne());
    }

    public int updateEntityOne(EntityOne entityOne){
        if(entityOneRepository.findById(entityOne.getId()).isPresent()){
            try {

                entityOneRepository.save(entityOne);
                return 1;
            }catch (HibernateException hibernateException){
                hibernateException.printStackTrace();
                return 2;
            }
        }else return 0;
    }

    public boolean deleteEntityOne(int id){
        if(entityOneRepository.findById(id).isPresent())
            try{
                entityOneRepository.delete(entityOneRepository.findById(id).get());
                return true;
            }catch (HibernateException hibernateException){
                hibernateException.printStackTrace();
            }
        return false;
    }
}

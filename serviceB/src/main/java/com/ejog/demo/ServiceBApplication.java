package com.ejog.demo;

import com.ejog.demo.config.RibbonConfiguration;
import com.ejog.demo.model.EntityOneConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
@RibbonClient(name = "serviceA", configuration = RibbonConfiguration.class)
public class ServiceBApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceBApplication.class, args);
    }

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @LoadBalanced
    @Bean
    RestTemplate restTemplate(){
        return new RestTemplate();
    }

    RestTemplate restTemplate;

    @Autowired
    public void setRestTemplate(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    @GetMapping("/get/{id}")
    public EntityOneConsumer getEntity(@PathVariable int id){
        ResponseEntity<EntityOneConsumer> responseEntity =
                restTemplate.getForEntity("http://serviceA/read/"+id, EntityOneConsumer.class);
        return responseEntity.getBody();
    }


}

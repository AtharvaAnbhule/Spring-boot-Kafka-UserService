package com.singhdevhub.userservice.consumer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.singhdevhub.userservice.entities.UserInfoDto;
import com.singhdevhub.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceConsumer
{

    private UserRepository userRepository;

    @Autowired
    public AuthServiceConsumer(ObjectMapper objectMapper, UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @KafkaListener(topics = "${spring.kafka.topic-json.name}", groupId = "${spring.kafka.consumer.group-id}")
    public void listen(Object eventData) {
        try{
//            userRepository.save(eventData);
            System.out.println("hello");
        }catch(Exception ex){
            System.out.println("AuthServiceConsumer: Exception is thrown while consuming kafka event");
        }
    }

}

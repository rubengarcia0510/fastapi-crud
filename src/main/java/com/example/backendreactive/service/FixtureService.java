package com.example.backendreactive.service;

import com.example.backendreactive.model.Fixture;
import com.example.backendreactive.model.Group;
import com.example.backendreactive.model.Groups;
import com.example.backendreactive.repository.FixtureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class FixtureService {

    @Autowired
    private FixtureRepository fixtureRepository;

    public Mono<Fixture> getFixtureByGroup(String group) {
        Fixture error=new Fixture();
        error.setGroup("not found");

        try{
            Optional<Fixture> result = fixtureRepository.findById(group);
            if(result.isPresent()){
                error.setGroup(result.get().getGroup());
                error.setGameList(result.get().getGameList());
            }


        }catch(NoSuchElementException e){
            System.out.println(e.getMessage());
        }

        return Mono.just(error);
    }
}

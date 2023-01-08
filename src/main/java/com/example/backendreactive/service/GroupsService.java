package com.example.backendreactive.service;

import com.example.backendreactive.model.Group;
import com.example.backendreactive.model.Groups;
import com.example.backendreactive.repository.GroupsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class GroupsService {

    @Autowired
    private GroupsRepository groupsRepository;

    public Flux<Groups> getAllGroups(){
        return Flux.fromIterable(groupsRepository.findAll());
    }

    public Mono<Group> getGroupByName(String name){
        Group error=new Group();
        error.setName("not found");

        try{
            Optional<Groups> result = groupsRepository.findById(name);
            if(result.isPresent()){
                error.setName(result.get().getName());
                error.setTeams(result.get().getTeams());
            }


        }catch(NoSuchElementException e){
            System.out.println(e.getMessage());
        }

        return Mono.just(error);
    }
}

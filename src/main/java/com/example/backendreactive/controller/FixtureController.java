package com.example.backendreactive.controller;

import com.example.backendreactive.model.Fixture;
import com.example.backendreactive.model.Group;
import com.example.backendreactive.service.FixtureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/fixture")
public class FixtureController {

    @Autowired
    private FixtureService fixtureService;

    @GetMapping("/{id}")
    private Mono<Fixture> getFixtureByGroup(@PathVariable String id){
        return fixtureService.getFixtureByGroup(id).log();
    }

}

package com.example.backendreactive.controller;


import com.example.backendreactive.model.Game;
import com.example.backendreactive.repository.GamesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/games")
public class GameController {
    @Autowired
    private GamesRepository gamesRepository;

    @GetMapping("/all")
    private Flux<Game> getGames(){

        return gamesRepository.findAllGames();
    }
}

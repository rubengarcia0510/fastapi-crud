package com.example.backendreactive.repository;

import com.example.backendreactive.model.Game;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

@Repository
public class GamesRepository {

    public Flux<Game> findAllGames() {
        List<Game> games= new ArrayList<>();
        Game game=new Game("Alemania","Francia","1");
        Game game2=new Game("Alemania","Argentina","1");
        games.add(game);
        games.add(game2);
        Flux<Game> juegos=Flux.fromIterable(games);
        return juegos.log();
    }
}

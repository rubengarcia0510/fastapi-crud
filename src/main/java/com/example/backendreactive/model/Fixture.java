package com.example.backendreactive.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "fixture")
public class Fixture {

    @Id
    private String group;
    private List<Game> gameList;

    public Fixture(String group, List<Game> gameList) {
        this.group = group;
        this.gameList = gameList;
    }

    public Fixture() {

    }
}

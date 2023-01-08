package com.example.backendreactive.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "groups")
public class Groups {
    @Id
    private String name;

    private List<Team> teams;

    public Groups(String name, List<Team> teams) {
        this.name = name;
        this.teams = teams;
    }
}

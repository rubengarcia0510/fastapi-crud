package com.example.backendreactive.repository;

import com.example.backendreactive.model.Group;
import com.example.backendreactive.model.Team;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class GroupRepository {
    private List<Group> groups;

    public GroupRepository() {

    }

    public void addGroup(Group group){
        this.groups.add(group);
    }

    public Mono<Group> getGroup(String group){
        Team team1=new Team("Argentina");
        Team team2=new Team("Arabia Saudita");
        Team team3=new Team("Polonia");
        Team team4=new Team("Mexico");
        Group grupoC=new Group();
        grupoC.setName("C");
        List<Team> teams=new ArrayList<>();
        teams.add(team1);
        teams.add(team2);
        teams.add(team3);
        teams.add(team4);

        team1=new Team("Senegal");
        team2=new Team("Holanda");
        team3=new Team("Qatar");
        team4=new Team("Ecuador");
        List<Group> grupos=new ArrayList<>();
        grupoC.setTeams(teams);
        grupos.add(grupoC);

        Group grupoA=new Group();
        grupoA.setName("A");
        teams=new ArrayList<>();
        teams.add(team1);
        teams.add(team2);
        teams.add(team3);
        teams.add(team4);

        grupoA.setTeams(teams);
        grupos.add(grupoA);

        for(int i=0;i<grupos.size();i++){
            if(grupos.get(i).getName().equalsIgnoreCase(group)){
                return Mono.just(grupos.get(i));
            }
        }
        Group error=new Group();
        error.setName("not found");

        return Mono.just(error);
    }

    public Flux<Group> getAllGroups(){
        Team team1=new Team("Argentina");
        Team team2=new Team("Arabia Saudita");
        Team team3=new Team("Polonia");
        Team team4=new Team("Mexico");
        Group grupoC=new Group();
        grupoC.setName("C");
        List<Team> teams=new ArrayList<>();
        teams.add(team1);
        teams.add(team2);
        teams.add(team3);
        teams.add(team4);

        team1=new Team("Senegal");
        team2=new Team("Holanda");
        team3=new Team("Qatar");
        team4=new Team("Ecuador");
        List<Group> grupos=new ArrayList<>();
        grupoC.setTeams(teams);
        grupos.add(grupoC);

        Group grupoA=new Group();
        grupoA.setName("A");
        teams=new ArrayList<>();
        teams.add(team1);
        teams.add(team2);
        teams.add(team3);
        teams.add(team4);

        grupoA.setTeams(teams);
        grupos.add(grupoA);

        return Flux.fromIterable(grupos);
    }
}

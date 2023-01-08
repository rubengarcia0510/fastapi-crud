package com.example.backendreactive;

import com.example.backendreactive.model.*;
import com.example.backendreactive.repository.FixtureRepository;
import com.example.backendreactive.repository.GroupsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.config.EnableWebFlux;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
@EnableWebFlux
public class BackendReactiveApplication implements CommandLineRunner {

    @Autowired
    GroupsRepository groupsRepository;

    @Autowired
    FixtureRepository fixtureRepository;


    public static void main(String[] args) {

        SpringApplication.run(BackendReactiveApplication.class, args);


    }

    @Override
    public void run(String... args) {
        deleteAll();
        addSampleData();
        
        System.out.println("------------------");
        System.out.println("Create fixture");
        createFixture("A");
        createFixture("B");
        createFixture("C");
        createFixture("D");
        createFixture("E");
        createFixture("F");
        createFixture("G");
        createFixture("H");

        listAll();

    }

    public void deleteAll() {
        System.out.println("Deleting all records..");
        groupsRepository.deleteAll();
        fixtureRepository.deleteAll();
    }

    public void addSampleData() {
        System.out.println("Adding sample data");

        //grupo A
        List<Team> teams = new ArrayList<>();


        Team team1 = new Team("Senegal");
        Team team2 = new Team("Holanda");
        Team team3 = new Team("Qatar");
        Team team4 = new Team("Ecuador");


        teams.add(team1);
        teams.add(team2);
        teams.add(team3);
        teams.add(team4);

        Teams equiposA = new Teams(teams);
        Groups grupoA = new Groups("A", teams);



        //grupo b
        team1 = new Team("Inglaterra");
        team2 = new Team("Iran");
        team3 = new Team("USA");
        team4 = new Team("Gales");

        teams = new ArrayList<>();
        teams.add(team1);
        teams.add(team2);
        teams.add(team3);
        teams.add(team4);

        Teams equiposB = new Teams(teams);
        Groups grupoB = new Groups("B", teams);

        //grupo C
        team1 = new Team("Argentina");
        team2 = new Team("Arabia Saudita");
        team3 = new Team("Mexico");
        team4 = new Team("Polonia");

        teams = new ArrayList<>();
        teams.add(team1);
        teams.add(team2);
        teams.add(team3);
        teams.add(team4);

        Teams equiposC = new Teams(teams);
        Groups grupoC = new Groups("C", teams);

        //grupo D
        team1 = new Team("Francia");
        team2 = new Team("Australia");
        team3 = new Team("Dinamarca");
        team4 = new Team("Tunez");

        teams = new ArrayList<>();
        teams.add(team1);
        teams.add(team2);
        teams.add(team3);
        teams.add(team4);

        Teams equiposD = new Teams(teams);
        Groups grupoD = new Groups("D", teams);

        //grupo E
        team1 = new Team("España");
        team2 = new Team("Costa Rica");
        team3 = new Team("Alemania");
        team4 = new Team("Japon");

        teams = new ArrayList<>();
        teams.add(team1);
        teams.add(team2);
        teams.add(team3);
        teams.add(team4);

        Teams equiposE = new Teams(teams);
        Groups grupoE = new Groups("E", teams);

        //grupo F
        team1 = new Team("Belgica");
        team2 = new Team("Canada");
        team3 = new Team("Marruecos");
        team4 = new Team("Croacia");

        teams = new ArrayList<>();
        teams.add(team1);
        teams.add(team2);
        teams.add(team3);
        teams.add(team4);

        Teams equiposF = new Teams(teams);
        Groups grupoF = new Groups("F", teams);

        //grupo G
        team1 = new Team("Brasil");
        team2 = new Team("Serbia");
        team3 = new Team("Suiza");
        team4 = new Team("Camerun");

        teams = new ArrayList<>();
        teams.add(team1);
        teams.add(team2);
        teams.add(team3);
        teams.add(team4);

        Teams equiposG = new Teams(teams);
        Groups grupoG = new Groups("G", teams);

        //grupo H
        team1 = new Team("Portugal");
        team2 = new Team("Ghana");
        team3 = new Team("Uruguay");
        team4 = new Team("Corea Del Sur");

        teams = new ArrayList<>();
        teams.add(team1);
        teams.add(team2);
        teams.add(team3);
        teams.add(team4);

        Teams equiposH = new Teams(teams);
        Groups grupoH = new Groups("H", teams);

        groupsRepository.save(grupoA);
        groupsRepository.save(grupoB);
        groupsRepository.save(grupoC);
        groupsRepository.save(grupoD);
        groupsRepository.save(grupoE);
        groupsRepository.save(grupoF);
        groupsRepository.save(grupoG);
        groupsRepository.save(grupoH);


    }

    public void listAll() {
        System.out.println("Listing sample data");

        groupsRepository.findAll().forEach(element->System.out.println(element.toString()));
        //fixtureRepository.findAll().forEach(element->System.out.println(element.toString()));
    }

    private void createFixture(String grupo){

        Optional<Groups> variable = groupsRepository.findById(grupo);
        List<String> equipos=new ArrayList<>();

        equipos.add(variable.get().getTeams().get(0).getName());
        equipos.add(variable.get().getTeams().get(1).getName());
        equipos.add(variable.get().getTeams().get(2).getName());
        equipos.add(variable.get().getTeams().get(3).getName());

        List<Game> games=new ArrayList<>();
        System.out.println("------------------");
        System.out.println("Partidos grupo: "+grupo);
        System.out.println("------------------");
        for(int i=0;i<equipos.size();i++){
            int fecha=0;
            if(i==0){
                fecha=i+1;
            }
            if(i==1){
                fecha=3;
            }

            for(int j=i+1;j<equipos.size();j++){
                    if(i==0){
                        Game newGame=new Game(equipos.get(i), equipos.get(j),Integer.toString(fecha) );
                        games.add(newGame);
                        fecha++;
                    }
                    if(i==1){
                        Game newGame=new Game(equipos.get(i), equipos.get(j),Integer.toString(fecha) );
                        games.add(newGame);
                        fecha--;
                    }

                    if(i==2){
                        fecha=1;
                        Game newGame=new Game(equipos.get(i), equipos.get(j),Integer.toString(fecha) );
                        games.add(newGame);
                    }
            }

        }

        Collections.sort(games);

        games.forEach(element->{
            System.out.println(element.getHome()+":"+element.getVisitor()+":"+element.getFase());
        });

        Fixture fixture=new Fixture(grupo,games);

        fixtureRepository.save(fixture);



    }
}

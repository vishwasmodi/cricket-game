package org.example;

import com.google.gson.Gson;
import com.mongodb.ClientSessionOptions;
import com.mongodb.MongoClientURI;
import com.mongodb.MongoCredential;
import com.mongodb.client.*;
import com.mongodb.connection.ClusterDescription;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.example.dto.Player;
import org.example.dto.Team;

import javax.print.Doc;
import java.util.List;

import static java.lang.Integer.parseInt;
public class CricketGame {

    private static GameHelper helper = new GameHelper();
    public static Integer numberOfOvers;
    Team team1;
    Team team2;

    private void setUpGame() {
        numberOfOvers = parseInt(helper.getUserInput("Enter number of overs"));

        team1 = new Team();
        team2 = new Team();

        CreateTeam.createTeam(team1);
        CreateTeam.createTeam(team2);
    }

    private void startGame() {
        Match match = new Match();
        match.startPlaying(team1, team2);
    }

    private void displayScoreboard() {

    }

    public static void main(String[] args) {
        System.out.println("*** Welcome to World Class Cricket Game Simulator ***" +
                           "Enter 1 to view previous matches scoreboards" +
                           "Enter 2 to start a new game simulation" +
                           "Enter 3 to exit");

        Integer choice = parseInt(helper.getUserInput(""));
        CricketGame game = new CricketGame();

        while(choice != 3) {
            switch (choice) {
                case 1:
                    game.displayScoreboard();
                    break;
                case 2:
                    game.setUpGame();
                    game.startGame();
                    break;
                default:
                    break;
            }

        }
    }
}
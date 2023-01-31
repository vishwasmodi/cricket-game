import java.util.ArrayList;

public class Team {
    private String name;
    private ArrayList<Player> players = new ArrayList<>();
    private GameHelper helper = new GameHelper();
    private static Integer teamNumber = 1;

    void createTeam() {
        this.name = helper.getUserInput("Enter Team's name =");

        for (int player = 1; player <= 11; player++) {
            Integer playerId = (teamNumber - 1) * 9 + player;

            String playerName = String.valueOf((char) ((int) 'A' + ((teamNumber - 1) * 9 + player - 1)));

            Player p = new Player();
            p.setId(playerId);
            p.setName(playerName);

            this.players.add(p);
        }
        teamNumber++;
    }

    ArrayList<Player> getPlayers() {
        return players;
    }

    String getName() {
        return name;
    }
}
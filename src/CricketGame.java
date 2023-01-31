import static java.lang.Integer.parseInt;

public class CricketGame {
    static Integer numberOfOvers;
    final static Integer numberOfBallsInOver = 6;
    private GameHelper helper = new GameHelper();

    private void setUpGame(Team team1, Team team2) {
        numberOfOvers = parseInt(helper.getUserInput("Enter number of overs"));
        team1.createTeam();
        team2.createTeam();
    }

    private Integer playInnings(Team battingTeam, Team ballingTeam) {

        Integer player = 0, totalRuns = 0;
        for (int over = 1; over <= numberOfOvers; over++) {
            for (int ball = 1; ball <= numberOfBallsInOver; ball++) {

                Integer res = helper.randomResultGenerator();
                System.out.print("Over: " + over + " | Ball: " + ball + " | Batsmen: " + battingTeam.getPlayers().get(player).getName() + " | Verdict: ");

                if (res == 8) {
                    System.out.println("Out");
                    player++;
                } else {
                    totalRuns += res;
                    System.out.println(res + " runs!");
                }

                if (player == 10) break;
            }
            if (player == 10) break;
        }
        System.out.println("Innings over");
        System.out.println("Total runs of team " + battingTeam.getName() + " are " + totalRuns);
        return totalRuns;
    }

    private void startPlaying(Team team1, Team team2) {
        Integer team1Runs = playInnings(team1, team2);

        Integer team2Runs = playInnings(team2, team1);

        System.out.println("Team 1 scored " + team1Runs + " runs.");
        System.out.println("Team 2 scored " + team2Runs + " runs.");

        if (team1Runs > team2Runs) {
            System.out.println("Team 1 won by " + (team1Runs - team2Runs) + " runs.");
        } else if (team1Runs < team2Runs) {
            System.out.println("Team 2 won by " + (team2Runs - team1Runs) + " runs.");
        } else {
            System.out.println("It's a draw");
        }
    }

    public static void main(String[] args) {

        Team team1 = new Team();
        Team team2 = new Team();
        CricketGame match = new CricketGame();
        match.setUpGame(team1, team2);
        match.startPlaying(team1, team2);
    }
}
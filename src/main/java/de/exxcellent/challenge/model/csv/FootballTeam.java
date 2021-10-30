package de.exxcellent.challenge.model.csv;

import com.opencsv.bean.CsvBindByName;

/**
 * Class representing one football team imported from csv files.
 * 
 * @author <a href="https://github.com/tlahmann">Tobias Lahmann</a>
 */
public class FootballTeam extends CsvData {
    @CsvBindByName(column = "Team")
    private String team;
    @CsvBindByName(column = "Games")
    private int games;
    @CsvBindByName(column = "Wins")
    private int wins;
    @CsvBindByName(column = "Losses")
    private int losses;
    @CsvBindByName(column = "Draws")
    private int draws;
    @CsvBindByName(column = "Goals")
    private int goals;
    @CsvBindByName(column = "Goals Allowed")
    private int goalsAllowed;
    @CsvBindByName(column = "Points")
    private int points;

    public int deltaGoals() {
        return Math.abs(this.goals - this.goalsAllowed);
    }

    @Override
    public String toString() {
        return String.format(
                "FootballTeam {\n\tTeam = %s,\n\tGames = %d,\n\tWins = %d,\n\tLosses = %d,\n"
                        + "\tDraws = %d,\n\tGoals = %d,\n\tGoals Allowed = %d,\n\tPoints = %d\n}",
                this.team, this.games, this.wins, this.losses, this.draws, this.goals, this.goalsAllowed, this.points);
    }
}

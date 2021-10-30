package de.exxcellent.challenge;

import java.util.List;
import java.util.function.BinaryOperator;

import de.exxcellent.challenge.handler.CsvReaderHandler;
import de.exxcellent.challenge.handler.ListReducerHandler;
import de.exxcellent.challenge.model.csv.CsvData;
import de.exxcellent.challenge.model.csv.FootballTeam;
import de.exxcellent.challenge.model.csv.WeatherDay;

/**
 * The entry class for your solution. This class is only aimed as starting point
 * and not intended as baseline for your software design. Read: create your own
 * classes and packages as appropriate.
 *
 * @author Benjamin Schmid <benjamin.schmid@exxcellent.de>
 * @author <a href="https://github.com/tlahmann">Tobias Lahmann</a>
 */
public final class App {

    /**
     * This is the main entry method of your program.
     * 
     * @param args The CLI arguments passed
     */
    public static void main(String... args) {

        /**
         * ===========================================================================
         * smallest temp difference pipeline
         * ===========================================================================
         */
        @SuppressWarnings("unchecked")
        var findSmallestTempDiffPipeline = new Pipeline<String, List<? extends CsvData>>(
                // read the csv file
                new CsvReaderHandler().useType(WeatherDay.class)
            ).addHandler(
                // reduce the list to the smallest temp difference
                new ListReducerHandler(new BinaryOperator<WeatherDay>() {
                    @Override
                    public WeatherDay apply(WeatherDay t, WeatherDay u) {
                        return t.deltaTemperature() < u.deltaTemperature() ? t : u;
                    }
                })
            );

        // Your day analysis function call …
        try {
            var dayWithSmallestTempSpread = findSmallestTempDiffPipeline.execute("de/exxcellent/challenge/weather.csv");
            System.out.printf("Day with smallest temperature spread : %s%n", dayWithSmallestTempSpread);
        } catch (Exception e) {
            // No intelligent exception handling...
            e.printStackTrace();
        }

        /**
         * ===========================================================================
         * smallest temp difference pipeline
         * ===========================================================================
         */
        @SuppressWarnings("unchecked")
        var findSmallestGoalDiffPipeline = new Pipeline<String, List<? extends CsvData>>(
                // read the csv file
                new CsvReaderHandler().useType(FootballTeam.class)
            ).addHandler(
                // reduce the list to the smallest goal difference
                new ListReducerHandler(new BinaryOperator<FootballTeam>() {
                    @Override
                    public FootballTeam apply(FootballTeam t, FootballTeam u) {
                        return t.deltaGoals() < u.deltaGoals() ? t : u;
                    }
                })
            );

        // Your goal analysis function call …
        try {
            var teamWithSmallestGoalSpread = findSmallestGoalDiffPipeline.execute("de/exxcellent/challenge/football.csv");
            System.out.printf("Team with smallest goal spread       : %s%n", teamWithSmallestGoalSpread);
        } catch (Exception e) {
            // No intelligent exception handling...
            e.printStackTrace();
        }
    }
}

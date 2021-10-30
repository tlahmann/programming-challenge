package de.exxcellent.challenge;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import de.exxcellent.challenge.handler.CsvReaderHandler;
import de.exxcellent.challenge.handler.ListReducerHandler;
import de.exxcellent.challenge.model.csv.CsvData;
import de.exxcellent.challenge.model.csv.WeatherDay;

/**
 * @author <a href="https://github.com/tlahmann">Tobias Lahmann</a>
 */
public class HandlerTest {
    private final CsvReaderHandler DATA_HANDLER;
    private final ListReducerHandler REDUCER;
    private List<CsvData> data;

    public HandlerTest() {
        this.DATA_HANDLER = new CsvReaderHandler().useType(WeatherDay.class);
        this.REDUCER = new ListReducerHandler();
    }

    @BeforeEach
    public void readFile() throws IllegalStateException, FileNotFoundException {
        this.data = this.DATA_HANDLER.process("de/exxcellent/challenge/weather.csv");
    }

    @Test
    public void successfullInstantiation() {
        assertNotNull(this.DATA_HANDLER, "pipeline should not be null");
    }

    @Test
    public void throwsExceptionOnEmptyPath() {
        assertThrows(IllegalArgumentException.class, () -> {
            this.DATA_HANDLER.validate(null);
        }, "exception should be thrown on null path");
        assertThrows(IllegalArgumentException.class, () -> {
            this.DATA_HANDLER.validate("");
        }, "exception should be thrown on empty path");
    }

    @Test
    public void throwsExceptionOnWrongFileFormat() {
        assertThrows(IllegalArgumentException.class, () -> {
            this.DATA_HANDLER.validate("noop.txt");
        }, "exception should be thrown on invalid file extension");
    }

    @Test
    public void successfullFileRead() {
        assertNotNull(this.data, "data should not be null");
        assertFalse(this.data.isEmpty(), "data should not be empty");
    }

    @Test
    public void throwsExceptionOnUnkownFile() {
        assertThrows(NullPointerException.class, () -> {
            this.DATA_HANDLER.process("noop.csv");
        }, "exception should be thrown on unkown file");
    }

    @Test
    public void throwsExceptionOnCorruptedFile() {
        assertThrows(RuntimeException.class, () -> {
            this.DATA_HANDLER.process("../../test/java/de/exxcellent/challenge/weather_corrupt.csv");
        }, "exception should be thrown on corrupted file");
    }

    @Test
    public void shouldContainCorrectElement() {
        var dataPoint = this.data.get(0);
        assertTrue(dataPoint instanceof WeatherDay, "data point should be of type WeatherDay");
    }

    @Test
    public void throwsExceptionOnEmptyList() {
        assertThrows(IllegalStateException.class, () -> {
            this.REDUCER.validate(new ArrayList<>());
        }, "exception should be thrown on empty list");
    }
}

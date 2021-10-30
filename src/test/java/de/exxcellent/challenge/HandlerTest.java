package de.exxcellent.challenge;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import de.exxcellent.challenge.handler.CsvReaderHandler;

/**
 * @author <a href="https://github.com/tlahmann">Tobias Lahmann</a>
 */
public class HandlerTest {
    private final CsvReaderHandler DATA_HANDLER;

    public HandlerTest() {
        this.DATA_HANDLER = new CsvReaderHandler();
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
        }, "exception should be thrown on invalid path");
    }
}

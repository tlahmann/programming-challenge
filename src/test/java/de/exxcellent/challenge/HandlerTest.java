package de.exxcellent.challenge;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import de.exxcellent.challenge.handler.CsvReaderHandler;

public class HandlerTest {
    private final CsvReaderHandler DATA_HANDLER;

    public HandlerTest() {
        this.DATA_HANDLER = new CsvReaderHandler();
    }

    @Test
    public void successfullInstantiation() {
        assertNotNull(this.DATA_HANDLER, "pipeline should not be null");
    }
}

package de.exxcellent.challenge;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class PipelineTest {
    private final Pipeline PIPELINE;

    public PipelineTest() {
        this.PIPELINE = new Pipeline(null);
    }

    @Test
    public void successfullInstantiation() {
        assertNotNull(this.PIPELINE, "pipeline should not be null");
    }

    @Test
    public void throwsExceptionOnEmptyPath() {
        assertThrows(NullPointerException.class, () -> {
            this.PIPELINE.execute(null);
        }, "exception should be thrown on missing handlers");
    }
}

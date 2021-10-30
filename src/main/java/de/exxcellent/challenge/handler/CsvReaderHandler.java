package de.exxcellent.challenge.handler;

import java.util.List;

public class CsvReaderHandler implements IHandler<String, List<String>> {
    @Override
    public void validate(String filePath) throws IllegalArgumentException {
        if (filePath == null || filePath.isEmpty()) {
            throw new IllegalArgumentException("File path is empty");
        } else if (!filePath.endsWith(".csv")) {
            throw new IllegalArgumentException("File path is not a csv file");
        }
    }

    @Override
    public List<String> process(String filePath) {
        return null;
    }
}

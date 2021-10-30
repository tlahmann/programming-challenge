package de.exxcellent.challenge.handler;

import java.util.List;

/**
 * The csv reader implements a handler. It expects a string representing the
 * file path to a csv file. This path is importet and returned as a list of
 * strings.
 * 
 * @author <a href="https://github.com/tlahmann">Tobias Lahmann</a>
 */
public class CsvReaderHandler implements IHandler<String, List<String>> {
    /**
     * Validates the given input string. The csv reaer expects a non empty string
     * with the '.csv' file extension
     * 
     * @throws IllegalArgumentException if the given input is null, empty or does
     *                                  not end with '.csv'
     */
    @Override
    public void validate(String filePath) throws IllegalArgumentException {
        if (filePath == null || filePath.isEmpty()) {
            throw new IllegalArgumentException("File path is empty");
        } else if (!filePath.endsWith(".csv")) {
            throw new IllegalArgumentException("File path is not a csv file");
        }
    }

    /**
     * Reads the given file path and returns a list of strings.
     * @param filePath the file path to the csv file
     * @return a list of strings representing the csv file
     */
    @Override
    public List<String> process(String filePath) {
        this.validate(filePath);
        filePath = getClass().getClassLoader().getResource(filePath).getFile();
        return null;
    }
}

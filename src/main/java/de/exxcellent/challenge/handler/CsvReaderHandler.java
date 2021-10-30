package de.exxcellent.challenge.handler;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

import com.opencsv.bean.CsvToBeanBuilder;

import de.exxcellent.challenge.model.csv.CsvData;

/**
 * The csv reader implements a handler. It expects a string representing the
 * file path to a csv file. This path is importet and returned as a list of
 * strings.
 * 
 * @author <a href="https://github.com/tlahmann">Tobias Lahmann</a>
 */
public class CsvReaderHandler implements IHandler<String, List<? extends CsvData>> {
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
     * 
     * @param filePath the file path to the csv file
     * @return a list of strings representing the csv file
     * @throws FileNotFoundException if the given file path does not point to a file
     * @throws IllegalStateException If a necessary parameter was not specified.
     *                               Currently this means that both the mapping
     *                               strategy and the bean type are not set, so it
     *                               is impossible to determine a mapping strategy.
     *                               <a href=
     *                               "http://opencsv.sourceforge.net/apidocs/com/opencsv/bean/CsvToBeanBuilder.html#build--">-
     *                               source</a>
     */
    @Override
    public List<CsvData> process(String filePath) throws IllegalStateException, FileNotFoundException {
        this.validate(filePath);
        filePath = getClass().getClassLoader().getResource(filePath).getFile();
        List<CsvData> records = new CsvToBeanBuilder<CsvData>(new FileReader(filePath)).withType(CsvData.class).build()
                .parse();
        return records;
    }
}

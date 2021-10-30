package de.exxcellent.challenge.model.csv;

import com.opencsv.bean.CsvBindByName;

/**
 * Class representing one day of weather data imported from csv files.
 * 
 * @author <a href="https://github.com/tlahmann">Tobias Lahmann</a>
 */
public class WeatherDay extends CsvData {
    @CsvBindByName(column = "Day")
    private String day;
    @CsvBindByName(column = "MxT")
    private int maxTemperature;
    @CsvBindByName(column = "MnT")
    private int minTemperature;
    @CsvBindByName(column = "AvT")
    private int averageTemperature;
    @CsvBindByName(column = "AvDP")
    private float averageDewPoint;
    @CsvBindByName(column = "1HrP TPcpn")
    private int oHrPTPcpn;
    @CsvBindByName(column = "PDir")
    private int pDir;
    @CsvBindByName(column = "AvSp")
    private float avSp;
    @CsvBindByName(column = "Dir")
    private int windDirection;
    @CsvBindByName(column = "MxS")
    private int mxS;
    @CsvBindByName(column = "SkyC")
    private float skyC;
    @CsvBindByName(column = "MxR")
    private int mxR;
    @CsvBindByName(column = "Mn")
    private int mn;
    @CsvBindByName(column = "R AvSLP")
    private float rAvSLP;

    /**
     * Calculate the difference between the maximum and minimum temperature.
     */
    public int deltaTemperature() {
        return this.maxTemperature - this.minTemperature;
    }

    @Override
    public String toString() {
        return String.format(
                "WeatherDay {\n\tDay = %s,\n\tmaxTemperature = %s,\n\tminTemperature = %s,\n\tdeltaTemperature = %s,\n"
                        + "\taverageTemperature = %s,\n\taverageDewPoint = %s\n}",
                this.day, this.maxTemperature, this.minTemperature, this.deltaTemperature(), this.averageTemperature,
                this.averageDewPoint);
    }
}

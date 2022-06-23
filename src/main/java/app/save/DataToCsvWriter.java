package app.save;

import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;

/**
 * This class is being used to write data lines to an output.csv file.
 */
public class DataToCsvWriter {
    public String filename;

    /**
     * @param filename csv file directory.
     */
    public DataToCsvWriter(String filename) {
        this.filename = filename;
    }

    /**
     * Method creates a csv file and writes arrays of String data.
        Note: The file is not overwritten, just data lines are added.
     * @param dataLine the array of data extracted from the simulation.
     */
    public void saveSimulationData(String[] dataLine) {
        try (CSVWriter writer = new CSVWriter(new FileWriter(filename, true), ',', CSVWriter.NO_QUOTE_CHARACTER)) {
            writer.writeNext(dataLine);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Method used to clear the file of existing data, before running
        the simulation once more.
     */
    public void flushCSVFile() {
        try (CSVWriter writer = new CSVWriter(new FileWriter(filename))) {
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
package app.save;

import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class SaveDataToCSV {
    public String filename;

    public SaveDataToCSV(String filename) {
        this.filename = filename;
    }

    public void saveSimulationData(String[] dataLine) {
        try (CSVWriter writer = new CSVWriter(new FileWriter(filename, true))) {
            writer.writeNext(dataLine);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void flushCSVFile() {
        try (CSVWriter writer = new CSVWriter(new FileWriter(filename))) {
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

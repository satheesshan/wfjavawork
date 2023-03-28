package wellsfargo.pm;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import wellsfargo.pm.models.collectors.ModelCollector;
import wellsfargo.pm.models.mappers.ModelMapper;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public abstract class CSVReader {

    private FileReader fileReader;
    private BufferedReader bufferedReader;
    private final String filePath;

    // todo - chuck size, for memory utilization optimization
    private final int chuckSize;

    protected CSVReader(String filePath) {
        this.filePath = filePath;
        this.chuckSize = 1000;   // default chunk size
    }

    protected CSVReader(String filePath, int chuckSize) {
        this.filePath = filePath;
        this.chuckSize = chuckSize;
    }

    protected void initReader() throws IOException {

        fileReader = new FileReader(filePath);
        bufferedReader = new BufferedReader(fileReader);
    }

    protected int getChuckSize() {
        return chuckSize;
    }

    protected void closeFile() throws IOException {
        bufferedReader.close();
    }

    protected <T> void process(ModelMapper<T> modelMapper, ModelCollector<T> modelCollector) throws IOException {

        initReader();
        Iterable<CSVRecord> records = CSVFormat.RFC4180.withFirstRecordAsHeader().parse(bufferedReader);
        for (CSVRecord r : records) {
            T model = modelMapper.transform(r);
            modelCollector.collect(model);
        }
        closeFile();
    }
}

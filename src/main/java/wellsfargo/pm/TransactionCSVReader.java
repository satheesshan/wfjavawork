package wellsfargo.pm;

import wellsfargo.pm.models.Transaction;
import wellsfargo.pm.models.collectors.ListModelCollector;
import wellsfargo.pm.models.mappers.ModelMapper;
import wellsfargo.pm.models.mappers.TransactionModelMapper;

import java.io.IOException;
import java.util.List;

public class TransactionCSVReader extends CSVReader {

    public TransactionCSVReader(String filePath) {
        super(filePath);
    }

    // questions: given this is transaction file, how many records can we expect, file larger than 1GB?
    // assumption: CSV file will not be larger tens of MB, therefore load all data.
    // todo: optimization - chunk the records processing so that we can control the data in memory.
    public List<Transaction> getTransactions() throws IOException {
        ModelMapper<Transaction> modelMapper = new TransactionModelMapper();
        ListModelCollector<Transaction> modelCollector = new ListModelCollector();
        this.process(modelMapper, modelCollector);
        return modelCollector.getListOfModels();
    }
}
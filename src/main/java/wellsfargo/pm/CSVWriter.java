package wellsfargo.pm;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import wellsfargo.pm.models.Portfolio;
import wellsfargo.pm.models.Security;
import wellsfargo.pm.models.Transaction;
import wellsfargo.pm.models.constants.OrderType;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public abstract class CSVWriter {

    private String[] headers;
    private BufferedWriter bufferedWriter;

    private FileWriter fileWriter;

    private CSVFormat csvFormat;

    private String filePath;

    private CSVPrinter writer;

    private OrderType orderType;

    protected CSVWriter(String filePath, String[] headers, OrderType orderType) {
        this.filePath = filePath;
        this.headers = headers;
        this.orderType = orderType;
    }

    public void initWriter() throws IOException {

        fileWriter = new FileWriter(filePath);
        bufferedWriter = new BufferedWriter(fileWriter);
        csvFormat = CSVFormat.DEFAULT.builder()
                .setHeader(headers)
                .build();
    }

    public void writeToFile(List<Transaction> transactionList, OMSRecordWriter recordWriter, Map<String, Security> securityMap, Map<String, Portfolio> portfolioMap) throws IOException {
        this.initWriter();
        writer = new CSVPrinter(bufferedWriter, csvFormat);

        for (Transaction t : transactionList) {
            if (t.getOrderType() == orderType) {
                recordWriter.write(t, writer, securityMap, portfolioMap);
            }
        }
        writer.flush();
        closeFile();
    }

    public void closeFile() throws IOException {
        writer.close();
        bufferedWriter.close();
    }
}

package wellsfargo.pm;

import wellsfargo.pm.models.Portfolio;
import wellsfargo.pm.models.Security;
import wellsfargo.pm.models.Transaction;
import wellsfargo.pm.models.constants.OrderType;
import wellsfargo.pm.models.mappers.CSVHeaders;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class CCCOMSWriter extends CSVWriter {
    private static String[] HEADERS = new String[] {CSVHeaders.PORTFOLIO_CODE, CSVHeaders.TICKER, CSVHeaders.NOMINAL, CSVHeaders.TRANSACTION_TYPE};
    public CCCOMSWriter(String filePath) {
        super(filePath, HEADERS, OrderType.CCC);
    }

    public void export(List<Transaction> transactionList, Map<String , Security> securityMap, Map<String, Portfolio> portfolioMap) throws IOException {
        OMSRecordWriter omsRecordWriter = new CCCOMSRecordWriter();
        writeToFile(transactionList, omsRecordWriter, securityMap, portfolioMap);
    }
}

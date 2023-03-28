package wellsfargo.pm;

import org.apache.commons.csv.CSVPrinter;
import wellsfargo.pm.models.Portfolio;
import wellsfargo.pm.models.Security;
import wellsfargo.pm.models.Transaction;

import java.io.IOException;
import java.util.Map;

public class CCCOMSRecordWriter implements OMSRecordWriter {
    @Override
    public void write(Transaction transaction, CSVPrinter printer, Map<String, Security> securityMap, Map<String, Portfolio> portfolioMap) throws IOException {

        String ticker = securityMap.get(transaction.getSecurityId()).getTicker();
        String portfolioCode = portfolioMap.get(transaction.getPortfolioId()).getPortfolioCode();
        Float nominal = transaction.getNominal();
        String transactionType = transaction.getTransactionType().toString();
        printer.printRecord(portfolioCode, ticker, nominal, transactionType);
    }
}

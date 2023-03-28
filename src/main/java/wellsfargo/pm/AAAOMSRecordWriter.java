package wellsfargo.pm;

import org.apache.commons.csv.CSVPrinter;
import wellsfargo.pm.models.Portfolio;
import wellsfargo.pm.models.Security;
import wellsfargo.pm.models.Transaction;

import java.io.IOException;
import java.util.Map;

public class AAAOMSRecordWriter implements OMSRecordWriter {
    @Override
    public void write(Transaction transaction, CSVPrinter printer, Map<String, Security> securityMap, Map<String, Portfolio> portfolioMap) throws IOException {

        String isin = securityMap.get(transaction.getSecurityId()).getIsin();
        String portfolioCode = portfolioMap.get(transaction.getPortfolioId()).getPortfolioCode();
        Float nominal = transaction.getNominal();
        String transcationType = transaction.getTransactionType().toString();
        printer.printRecord(isin, portfolioCode, nominal, transcationType);

    }
}

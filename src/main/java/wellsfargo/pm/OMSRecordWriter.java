package wellsfargo.pm;

import org.apache.commons.csv.CSVPrinter;
import wellsfargo.pm.models.Portfolio;
import wellsfargo.pm.models.Security;
import wellsfargo.pm.models.Transaction;

import java.io.IOException;
import java.util.Map;

public interface OMSRecordWriter {
    void write(Transaction transaction, CSVPrinter printer, Map<String, Security> securityMap, Map<String, Portfolio> portfolioMap) throws IOException;
}

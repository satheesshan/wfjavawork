package wellsfargo.pm.models.mappers;

import org.apache.commons.csv.CSVRecord;
import wellsfargo.pm.models.Security;

public class SecurityModelMapper implements ModelMapper<Security> {
    @Override
    public Security transform(CSVRecord record) {
        return new Security(
                record.get(CSVHeaders.SECURITY_ID)
                , record.get(CSVHeaders.ISIN)
                , record.get(CSVHeaders.TICKER)
                , record.get(CSVHeaders.CUSIP)
        );
    }
}

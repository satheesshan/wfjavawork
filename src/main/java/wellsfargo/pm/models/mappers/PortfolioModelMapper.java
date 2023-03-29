package wellsfargo.pm.models.mappers;

import org.apache.commons.csv.CSVRecord;
import wellsfargo.pm.models.Portfolio;

public class PortfolioModelMapper implements ModelMapper<Portfolio> {

    @Override
    public Portfolio transform(CSVRecord record) {
        return new Portfolio(
                record.get(CSVHeaders.PORTFOLIO_ID)
                , record.get(CSVHeaders.PORTFOLIO_CODE)
        );
    }
}

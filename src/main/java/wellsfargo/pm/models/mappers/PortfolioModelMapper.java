package wellsfargo.pm.models.mappers;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.apache.commons.csv.CSVRecord;
import wellsfargo.pm.models.Portfolio;

public class PortfolioModelMapper implements ModelMapper<Portfolio> {

    @Override
    public Portfolio transform(CSVRecord record) {
        return new Portfolio(
                record.get(CSVHeaders.PORTFOLIO_ID)
                ,record.get(CSVHeaders.PORTFOLIO_CODE)
        );
    }
}

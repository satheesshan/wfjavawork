package wellsfargo.pm.models.mappers;

import org.apache.commons.csv.CSVRecord;
import wellsfargo.pm.models.Transaction;
import wellsfargo.pm.models.constants.OrderType;
import wellsfargo.pm.models.constants.TransactionType;

public class TransactionModelMapper implements ModelMapper<Transaction> {
    @Override
    public Transaction transform(CSVRecord record) {
        return new Transaction(
                record.get(CSVHeaders.SECURITY_ID)
                , record.get(CSVHeaders.PORTFOLIO_ID)
                , Float.parseFloat(record.get(CSVHeaders.NOMINAL))   //runtime exception need to protect
                , OrderType.valueOf(record.get(CSVHeaders.OMS)),
                TransactionType.valueOf(record.get(CSVHeaders.TRANSACTION_TYPE))
        );
    }
}

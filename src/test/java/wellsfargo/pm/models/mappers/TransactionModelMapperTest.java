package wellsfargo.pm.models.mappers;


import org.apache.commons.csv.CSVRecord;
import org.junit.Test;
import wellsfargo.pm.models.Transaction;
import wellsfargo.pm.models.constants.OrderType;
import wellsfargo.pm.models.constants.TransactionType;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TransactionModelMapperTest {

    @Test
    public void transactionModelMapper_With_Valid_RecordHeaders() {

        CSVRecord record = mock(CSVRecord.class);
        when(record.get(CSVHeaders.SECURITY_ID)).thenReturn("S1");
        when(record.get(CSVHeaders.PORTFOLIO_ID)).thenReturn("P1");
        when(record.get(CSVHeaders.NOMINAL)).thenReturn("100.0");
        when(record.get(CSVHeaders.OMS)).thenReturn(OrderType.AAA.toString());
        when(record.get(CSVHeaders.TRANSACTION_TYPE)).thenReturn(TransactionType.BUY.toString());

        TransactionModelMapper transactionModelMapper = new TransactionModelMapper();
        Transaction transaction = transactionModelMapper.transform(record);

        assertThat(transaction.getSecurityId(), equalToIgnoringCase("S1"));
        assertThat(transaction.getPortfolioId(), equalToIgnoringCase("P1"));
        assertThat(transaction.getNominal(), is(equalTo(100.0f)));
        assertEquals(transaction.getOrderType(), OrderType.AAA);
        assertEquals(transaction.getTransactionType(), TransactionType.BUY);
    }
}

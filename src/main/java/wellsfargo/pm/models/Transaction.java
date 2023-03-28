package wellsfargo.pm.models;

import wellsfargo.pm.models.constants.OrderType;
import wellsfargo.pm.models.constants.TransactionType;

import java.util.Objects;

public class Transaction {

    private String securityId;
    private String portfolioId;
    private float nominal;
    private OrderType orderType;
    private TransactionType transactionType;

    public Transaction(String securityId, String portfolioId, float nominal, OrderType orderType, TransactionType transactionType) {
        this.securityId = securityId;
        this.portfolioId = portfolioId;
        this.nominal = nominal;
        this.orderType = orderType;
        this.transactionType = transactionType;
    }

    public String getSecurityId() {
        return securityId;
    }

    public String getPortfolioId() {
        return portfolioId;
    }

    public float getNominal() {
        return nominal;
    }

    public OrderType getOrderType() {
        return orderType;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return nominal == that.nominal && Objects.equals(securityId, that.securityId) && Objects.equals(portfolioId, that.portfolioId) && orderType == that.orderType && transactionType == that.transactionType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(securityId, portfolioId, nominal, orderType, transactionType);
    }

    @Override
    public String toString() {
        return "Transaction {" +
                "securityId='" + securityId + '\'' +
                ", portfolioId='" + portfolioId + '\'' +
                ", nominal=" + nominal +
                ", orderType=" + orderType +
                ", transactionType=" + transactionType +
                '}';
    }
}
package wellsfargo.pm.models;

import java.util.Objects;

public class Security {

    private String securityId;
    private String isin;
    private String ticker;
    private String cusip;

    public Security(String securityId, String isin, String ticker, String cusip) {
        this.securityId = securityId;
        this.isin = isin;
        this.ticker = ticker;
        this.cusip = cusip;
    }

    public String getSecurityId() {
        return securityId;
    }

    public String getIsin() {
        return isin;
    }

    public String getTicker() {
        return ticker;
    }

    public String getCusip() {
        return cusip;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Security security = (Security) o;
        return Objects.equals(securityId, security.securityId) && Objects.equals(isin, security.isin) && Objects.equals(ticker, security.ticker) && Objects.equals(cusip, security.cusip);
    }

    @Override
    public int hashCode() {
        return Objects.hash(securityId, isin, ticker, cusip);
    }

    @Override
    public String toString() {
        return "Security{" +
                "securityId='" + securityId + '\'' +
                ", isin='" + isin + '\'' +
                ", ticker='" + ticker + '\'' +
                ", cusip='" + cusip + '\'' +
                '}';
    }
}

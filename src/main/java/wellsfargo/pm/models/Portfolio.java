package wellsfargo.pm.models;

import java.util.Objects;

public class Portfolio {

    private String portfolioId;
    private String PortfolioCode;

    public Portfolio(String portfolioId, String portfolioCode) {
        this.portfolioId = portfolioId;
        PortfolioCode = portfolioCode;
    }

    public String getPortfolioId() {
        return portfolioId;
    }

    public String getPortfolioCode() {
        return PortfolioCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Portfolio portfolio = (Portfolio) o;
        return Objects.equals(portfolioId, portfolio.portfolioId) && Objects.equals(PortfolioCode, portfolio.PortfolioCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(portfolioId, PortfolioCode);
    }

    @Override
    public String toString() {
        return "Portfolio{" +
                "portfolioId='" + portfolioId + '\'' +
                ", PortfolioCode='" + PortfolioCode + '\'' +
                '}';
    }
}

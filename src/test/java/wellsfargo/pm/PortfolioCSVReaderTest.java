package wellsfargo.pm;

import org.junit.Test;
import wellsfargo.pm.models.Portfolio;

import javax.sound.sampled.Port;
import java.io.IOException;
import java.util.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class PortfolioCSVReaderTest {

    @Test
    public void portfolioCSVReader_valid_record_count() throws IOException {
        PortfolioCSVReader portfolioCSVReader = new PortfolioCSVReader("src/test/resources/wellsfargo/pm/portfolios.csv");
        Map<String, Portfolio> portfolioMap = portfolioCSVReader.getPortfolios();
        Set<String> portfolioIds = portfolioMap.keySet();

        assertThat(portfolioIds.size(), is(equalTo(2)));
;
    }

    @Test
    public void portfolioCSVReader_valid_record_data() throws IOException {

        //set up data expected data
        List<Portfolio> expectedPortfolioData = new ArrayList<>(2);
        expectedPortfolioData.add(new Portfolio("1", "p1"));
        expectedPortfolioData.add(new Portfolio("2", "p2"));

        // code tested
        PortfolioCSVReader portfolioCSVReader = new PortfolioCSVReader("src/test/resources/wellsfargo/pm/portfolios.csv");
        Map<String, Portfolio> portfolioMap = portfolioCSVReader.getPortfolios();
        List<Portfolio> actualPortfolioData = new ArrayList<>(portfolioMap.values());

        assertThat(actualPortfolioData, is(equalTo(expectedPortfolioData)));
    }
}

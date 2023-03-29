package wellsfargo.pm;

import org.junit.Test;
import wellsfargo.pm.models.Portfolio;
import wellsfargo.pm.models.Security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class SecurityCSVReaderTest {

    @Test
    public void securityCSVReader_valid_record_count() throws IOException {
        SecurityCSVReader securityCSVReader = new SecurityCSVReader("src/test/resources/wellsfargo/pm/securities.csv");
        Map<String, Security> securityMap = securityCSVReader.getSecurity();
        Set<String> securityIds = securityMap.keySet();

        assertThat(securityIds.size(), is(equalTo(2)));
;
    }

    @Test
    public void securityCSVReader_valid_record_data() throws IOException {

        //set up data expected data
        List<Security> expectedSecurityData = new ArrayList<>(2);
        expectedSecurityData.add(new Security("1", "ISIN11111111", "s1", "CUSIP0001"));
        expectedSecurityData.add(new Security("2", "ISIN22222222", "s2", "CUSIP0002"));

        // code tested
        SecurityCSVReader securityCSVReader = new SecurityCSVReader("src/test/resources/wellsfargo/pm/securities.csv");
        Map<String, Security> securityMap = securityCSVReader.getSecurity();
        List<Security> actualSecurityData = new ArrayList<>(securityMap.values());

        assertThat(actualSecurityData, is(equalTo(expectedSecurityData)));
    }
}

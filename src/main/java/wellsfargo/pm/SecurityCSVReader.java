package wellsfargo.pm;

import wellsfargo.pm.models.Security;
import wellsfargo.pm.models.collectors.ListModelCollector;
import wellsfargo.pm.models.mappers.ModelMapper;
import wellsfargo.pm.models.mappers.SecurityModelMapper;

import java.io.IOException;
import java.util.Map;
import java.util.stream.Collectors;

public class SecurityCSVReader extends CSVReader {

    public SecurityCSVReader(String filePath) {
        super(filePath);
    }

    // given this is reference data of for Security, can this be 100K+ records?
    public Map<String, Security> getSecurity() throws IOException {
        ModelMapper<Security> modelMapper = new SecurityModelMapper();
        ListModelCollector<Security> modelCollector = new ListModelCollector();
        this.process(modelMapper, modelCollector);
        return modelCollector.getListOfModels().stream()
                .collect(Collectors.toMap(s -> s.getSecurityId(), s -> s));
    }
}

package wellsfargo.pm;

import wellsfargo.pm.models.Portfolio;
import wellsfargo.pm.models.collectors.ListModelCollector;
import wellsfargo.pm.models.mappers.ModelMapper;
import wellsfargo.pm.models.mappers.PortfolioModelMapper;

import java.io.IOException;
import java.util.Map;
import java.util.stream.Collectors;

public class PortfolioCSVReader extends CSVReader {
    public PortfolioCSVReader(String filePath) {
        super(filePath);
    }

    public Map<String, Portfolio> getPortfolios() throws IOException {
        ModelMapper<Portfolio> modelMapper = new PortfolioModelMapper();
        ListModelCollector<Portfolio> modelCollector = new ListModelCollector();
        this.process(modelMapper, modelCollector);
        return modelCollector.getListOfModels().stream()
                .collect(Collectors.toMap(p -> p.getPortfolioId(), p -> p));
    }
}

package wellsfargo.pm.models.mappers;

import org.apache.commons.csv.CSVRecord;

public interface ModelMapper<T> {

    public T transform(CSVRecord record);

}

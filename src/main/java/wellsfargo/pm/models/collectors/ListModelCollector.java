package wellsfargo.pm.models.collectors;

import java.util.LinkedList;
import java.util.List;

public class ListModelCollector<T> implements ModelCollector<T> {

    List<T> listOfModels = new LinkedList<>();

    @Override
    public void collect(T model) {
        listOfModels.add(model);
    }

    public List<T> getListOfModels() {
        return listOfModels;
    }
}

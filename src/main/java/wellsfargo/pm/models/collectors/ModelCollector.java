package wellsfargo.pm.models.collectors;

public interface ModelCollector<T> {

    public void collect(T model);
}

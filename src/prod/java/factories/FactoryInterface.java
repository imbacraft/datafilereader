package factories;

public interface FactoryInterface<T> {

    public T create(String[] splitBlock);

    public boolean hasAllRequiredFields(String[] splitItemLine);
}

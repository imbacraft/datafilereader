package factories;

public interface FactoryInterface<T> {

    public T create(String[] splitBlock);

    public boolean hasAllRequiredFields(String[] splitItemLine);

    public boolean allFieldsAreValid(String[] splitItemLine);

    public void addToItemList(T item);

}

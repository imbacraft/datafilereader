package factories;

public interface FactoryInterface<T> {

    public T create(String[] splitBlock, long lineNumber);

    public boolean hasAllRequiredFields(String[] splitItemLine);

    public boolean allFieldsAreValid(String[] splitItemLine, long errorLineNumber);

    public void addToItemList(T item);

}

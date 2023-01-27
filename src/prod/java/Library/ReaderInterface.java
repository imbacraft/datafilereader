package Library;

public interface ReaderInterface<T> {

    public T process(String[] splitBlock);

    public boolean hasAllRequiredFields(String[] splitItemLine);
}

package filereader;

public interface DataFileReaderInterface<T> {

    public T readDataFileAndExtractEntities(String filepath);

}

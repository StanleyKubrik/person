package model.filereader;

import java.io.IOException;

public interface FileReaderContract {
    void writer(String text) throws IOException;
    String reader() throws IOException;
}

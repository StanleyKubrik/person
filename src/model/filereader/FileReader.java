package model.filereader;

import constanta.Constanta;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class FileReader implements FileReaderContract {
    private FileInputStream fileInputStream;
    private FileOutputStream fileOutputStream;

    @Override
    public void writer(String text) throws IOException {
        fileOutputStream = new FileOutputStream(Constanta.PATH_OUT);
        byte[] buffer = text.getBytes();
        fileOutputStream.write(buffer,0,buffer.length);
        fileOutputStream.close();
    }

    @Override
    public String reader() throws IOException {
        fileInputStream = new FileInputStream(Constanta.PATH_IN);
        StringBuilder text = new StringBuilder();
        byte[] buffer = new byte[1024];
        while(fileInputStream.read() != -1) {
            String bug = new String(buffer, StandardCharsets.UTF_8);
            text.append(bug);
        }
        fileInputStream.close();
        return text.toString();
    }
}
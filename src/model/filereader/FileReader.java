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

    public FileReader() throws FileNotFoundException {
        fileInputStream = new FileInputStream(Constanta.PATH);
        fileOutputStream = new FileOutputStream(Constanta.PATH);
    }

    @Override
    public void writer(String text) throws IOException {
        if (fileOutputStream != null) {
            byte[] buffer = text.getBytes();
            fileOutputStream.write(buffer,0,buffer.length);
            fileOutputStream.close();
        }
    }

    @Override
    public String reader() throws IOException {
        StringBuilder text = new StringBuilder();
        if(fileInputStream != null){
            byte[] buffer = new byte[1024];
            while(fileInputStream.read() != -1) {
                String bug = new String(buffer, StandardCharsets.UTF_8);
                text.append(bug);
            }
            fileInputStream.close();
        }
        return text.toString();
    }
}
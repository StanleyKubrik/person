package model.filereader;

import constanta.Constanta;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static java.nio.charset.StandardCharsets.UTF_8;

public class FileReader implements FileReaderContract {
    private FileInputStream fileInputStream;
    private FileOutputStream fileOutputStream;

    public FileReader() throws FileNotFoundException {
    }

    @Override
    public void writer(String text) throws IOException {
        fileOutputStream = new FileOutputStream(Constanta.PATH);
        if (fileOutputStream != null) {
            byte[] buffer = text.getBytes();
            fileOutputStream.write(buffer, 0, buffer.length);
            fileOutputStream.close();
        }
    }

    @Override
    public String reader() throws IOException {
        fileInputStream = new FileInputStream(Constanta.PATH);
        StringBuilder text = new StringBuilder();
        byte[] buffer = new byte[1024];
        //TODO было так  while(fileInputStream.read() != -1)
        //TODO вот какой у меня пример на репе что я скидывал 35 строка while((inputStream.read(buffer)) != -1)
        while ((fileInputStream.read(buffer)) != -1) {
            String bug = new String(buffer, UTF_8);
            text.append(bug);
        }
        fileInputStream.close();
        return text.toString();
    }
}
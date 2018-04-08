package scooterise.rpg.story;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class TextOuputStream extends OutputStream{

    @Override
    public void write(int b) throws IOException {

    }

    @Override
    public void write(byte[] b) throws IOException {

        FileOutputStream output = new FileOutputStream(new File("output.txt"));
        output.write(b);
        System.out.println(b);

    }


}

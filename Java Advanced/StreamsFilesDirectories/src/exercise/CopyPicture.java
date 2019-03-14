package exercise;

import java.io.*;

public class CopyPicture {
    public static void main(String[] args) throws IOException {

        //Trqbva da sloja i svalq snimka za da stane

        //Copirane na snimka
        //Sudurja pikseli prezentirani v bytove

        String name="PicureName";
        FileInputStream fileInputStream=new FileInputStream(name);

        byte []bufer=fileInputStream.readAllBytes();

        FileOutputStream outputStream=new FileOutputStream("copyJava.jpg");
        outputStream.write(bufer);

    }
}

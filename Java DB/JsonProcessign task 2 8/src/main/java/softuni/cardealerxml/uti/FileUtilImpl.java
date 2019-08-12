package softuni.cardealerxml.uti;

import java.io.*;

public class FileUtilImpl implements FileUtil {

    @Override
    public String getContent(String path) throws IOException {
        File file=new File(path);
        BufferedReader bf=new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        StringBuilder sb=new StringBuilder();

        String line;
        while ((line=bf.readLine())!=null){
            sb.append(line).append(System.lineSeparator());
        }

        return sb.toString();
    }
}

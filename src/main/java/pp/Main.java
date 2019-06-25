package pp;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;


public class Main {

    private static List<String> fileNames = new ArrayList<>();
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        logger.debug("Hello this is a debug message");
        logger.info("Hello this is an info message");
        try {
            //read list of files from the file txt
            BufferedReader bufferedReader = new BufferedReader(new FileReader("list.txt"));
            String line;
            while ((line = bufferedReader.readLine()) != null){
                fileNames.add(line.trim());
            }
            bufferedReader.close();

            //copy files
            FileInputStream inputStream = null;
            FileOutputStream outputStream = null;
            for (int i = 0; i < fileNames.size(); i++) {
                inputStream = new FileInputStream(fileNames.get(i));
                if (!Files.exists(Paths.get("result/"))) {
                    Files.createDirectories(Paths.get("result/"));
                }
                outputStream = new FileOutputStream("result/" + fileNames.get(i));
                byte[] buffer = new byte[1000];
                while (inputStream.available() > 0) {
                    int count = inputStream.read(buffer);
                    outputStream.write(buffer, 0, count);
                }
            }
            inputStream.close();
            outputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
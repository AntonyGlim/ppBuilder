package pp;

import java.io.*;
import java.nio.file.Path;
import java.util.List;

public class Main {

    List<String > fileNames;
    List<Path> files;

    public static void main(String[] args) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("list.txt"));
            String line

            FileInputStream inputStream = null; //Создаем поток-чтения-байт-из-файла
            inputStream = new FileInputStream("src/test/java/files/1.jpg");
            FileOutputStream outputStream = new FileOutputStream("result.jpg");// Создаем поток-записи-байт-в-файл

            byte[] buffer = new byte[1000];
            while (inputStream.available() > 0) { //пока есть еще непрочитанные байты
                int count = inputStream.read(buffer); // прочитать очередной блок байт в переменную buffer и реальное количество в count
                outputStream.write(buffer, 0, count); //записать блок(часть блока) во второй поток
            }
            inputStream.close(); //закрываем оба потока. Они больше не нужны.
            outputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
//		BufferedReader reader;
//		try {
//			reader = new BufferedReader(new FileReader(
//					"/Users/pankaj/Downloads/myfile.txt"));
//			String line = reader.readLine();
//			while (line != null) {
//				System.out.println(line);
//				// read next line
//				line = reader.readLine();
//			}
//			reader.close();
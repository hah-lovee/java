package first_block.laba4;

import java.io.*;

public class FileCopy {
    public static void main(String[] args) {
        String sourceFileName = "first_block/laba4/source.txt";
        String destinationFileName = "first_block/laba4/destination.txt";

        try (
            FileInputStream inputStream = new FileInputStream(sourceFileName);
            FileOutputStream outputStream = new FileOutputStream(destinationFileName)
        ) {
            byte[] buffer = new byte[1024];
            int bytesRead;

            // inputStream.close();

            while ((bytesRead = inputStream.read(buffer)) != -1) {

                // outputStream.close();

                outputStream.write(buffer, 0, bytesRead);
            }

            System.out.println("Файл успешно скопирован.");
        } catch (FileNotFoundException e) {
            System.out.println("Ошибка: Файл не найден");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Ошибка ввода-вывода при копировании файла");
            e.printStackTrace();
        }
    }
}
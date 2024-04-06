package org.example.Modules;

import com.drew.metadata.exif.ExifIFD0Directory;
import com.drew.metadata.exif.ExifSubIFDDirectory;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Iterator;

import com.drew.imaging.ImageMetadataReader;
import com.drew.imaging.ImageProcessingException;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.Tag;
@Component
public class PngFileModule implements FileModule{
    String basePath = "C:\\Users\\Informant\\source\\repos\\JavaLaba8.2\\JustDirWithRandomFiles";
    //Завтра доделать
    @Override
    public boolean isCurrentFileFormatWorks(String path) {
        return path.endsWith(".jpg");
    }

    @Override
    public void getDesc() {
        System.out.println("Функция номер 1 - выводит размер изображения");
        System.out.println("Функция номер 2 - выводит информацию exif");
        System.out.println("Функция номер 3 - подумаю");
    }

    @Override
    public void method1(String path) {
        try (FileInputStream inputStream = new FileInputStream(basePath+"\\"+path)) {
            // Пропускаем первые 16 байтов (это фиксированный размер заголовка PNG)
            inputStream.skip(16);

            // Считываем ширину изображения (4 байта)
            byte[] widthBytes = new byte[4];
            inputStream.read(widthBytes);
            int width = ByteBuffer.wrap(widthBytes).getInt();

            // Считываем высоту изображения (4 байта)
            byte[] heightBytes = new byte[4];
            inputStream.read(heightBytes);
            int height = ByteBuffer.wrap(heightBytes).getInt();

            System.out.println("Ширина изображения: " + width + " пикселей");
            System.out.println("Высота изображения: " + height + " пикселей");
        } catch (IOException e) {
            System.err.println("Ошибка при чтении изображения: " + e.getMessage());
        }
    }

    @Override
    public void method2(String path) {
        File file = new File(basePath+"\\"+path);
        try {
            Metadata metadata = ImageMetadataReader.readMetadata(file);
            Directory exifDirectory = metadata.getFirstDirectoryOfType(com.drew.metadata.exif.ExifDirectoryBase.class);
            if (exifDirectory != null) {
                Iterator<?> tags = exifDirectory.getTags().iterator();
                while (tags.hasNext()) {
                    System.out.println(tags.next());
                }
            }else {
                System.out.println("В данном png файле нет EXIF информации");
            }
        } catch (ImageProcessingException | IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void method3(String path) {
        System.out.println("Пока здесь ничего нет");
    }
}

package org.example.Modules;

import com.drew.metadata.exif.ExifSubIFDDirectory;
import org.springframework.stereotype.Component;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Date;
import java.util.Iterator;

import com.drew.imaging.ImageMetadataReader;
import com.drew.imaging.ImageProcessingException;
import com.drew.metadata.Metadata;
import com.drew.metadata.Tag;

import javax.imageio.ImageIO;

@Component
public class ImageFileModule implements FileModule{
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
        System.out.println("Функция номер 3 - выводит дату сьёмки из информации exif");
    }

    @Override
    public void method1(String path) {
        try {
            // Загрузка изображения
            File imageFile = new File(basePath+"\\"+path);
            BufferedImage image = ImageIO.read(imageFile);

            // Получение размеров изображения
            int width = image.getWidth();
            int height = image.getHeight();

            // Вывод размеров
            System.out.println("Ширина: " + width + " пикселей");
            System.out.println("Высота: " + height + " пикселей");
        } catch (IOException e) {
            System.err.println("Ошибка при чтении изображения: " + e.getMessage());
        }
    }

    @Override
    public void method2(String path) {
        File file = new File(basePath+"\\"+path);
        try {
            Metadata metadata = ImageMetadataReader.readMetadata(file);

            // Получаем директорию Exif
            ExifSubIFDDirectory directory = metadata.getFirstDirectoryOfType(ExifSubIFDDirectory.class);

            if (directory != null) {
                // Получаем все теги Exif из директории Exif
                for (Tag tag : directory.getTags()) {
                    System.out.println(tag.getTagName() + " : " + tag.getDescription());
                }
            }else {
                System.out.println("В данном файле нет EXIF информации");
            }
        } catch (ImageProcessingException | IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void method3(String path) {
        File file = new File(basePath+"\\"+path);
        try {
            Metadata metadata = ImageMetadataReader.readMetadata(file);

            // Получаем директорию Exif
            ExifSubIFDDirectory directory = metadata.getFirstDirectoryOfType(ExifSubIFDDirectory.class);

            if (directory != null) {
                Date date = directory.getDate(ExifSubIFDDirectory.TAG_DATETIME_ORIGINAL);
                if (date != null) {
                    System.out.println("Дата съёмки: " + date);
                } else {
                    System.out.println("Дата съёмки не найдена в метаданных Exif.");
                }
            }else {
                System.out.println("В данном файле нет EXIF информации");
            }
        } catch (ImageProcessingException | IOException e) {
            e.printStackTrace();
        }
    }
}

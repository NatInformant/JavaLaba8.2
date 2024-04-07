package org.example.Modules;

import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class DirFileModule implements FileModule {
    String basePath = "C:\\Users\\Informant\\source\\repos\\JavaLaba8.2\\JustDirWithRandomFiles";

    @Override
    public boolean isCurrentFileFormatWorks(String path) {
        File fileSystemElement = new File(basePath + "\\" + path);
        return fileSystemElement.isDirectory();
    }

    @Override
    public void getDesc() {
        System.out.println("Функция номер 1 - выводит список файлов в каталоге");
        System.out.println("Функция номер 2 - выводит суммарный размер всех файлов в каталоге");
        System.out.println("Функция номер 3 - считает кол-во файлов и папок в каталоге");
    }

    @Override
    public void method1(String path) {
        File directory = new File(basePath + "\\" + path);

        // Получаем список файлов в каталоге
        File[] files = directory.listFiles();

        // Выводим имена файлов
        if (files != null) {
            for (File file : files) {
                if(file.isFile()){
                    System.out.println(file.getName());
                }
            }
        }

    }

    @Override
    public void method2(String path) {
        File directory = new File(basePath + "\\" + path);
        // Получаем список файлов в каталоге
        File[] files = directory.listFiles();

        long size = 0;
        // Выводим имена файлов
        if (files != null) {
            for (File file : files) {
                if(file.isFile()){
                    size+=file.length();
                }
            }
        }
        System.out.printf("%d байт",size);
    }

    @Override
    public void method3(String path) {
        File directory = new File(basePath + "\\" + path);


        // Получаем список файлов в каталоге
        File[] files = directory.listFiles();
        int fileCount = 0;
        int dirCount = 0;
        // Выводим имена файлов
        if (files != null) {
            for (File file : files) {
                if(file.isFile()){
                    fileCount++;
                }else{
                    dirCount++;
                }
            }
        }
        System.out.printf("%d папок%n",dirCount);
        System.out.printf("%d файлов%n",fileCount);
    }
}

package org.example.Modules;

import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class DirFileModule implements FileModule {
    String basePath = "C:\\Users\\Informant\\source\\repos\\JavaLaba8.2\\JustDirWithRandomFiles";
    @Override
    public boolean isCurrentFileFormatWorks(String path) {
        File fileSystemElement = new File(basePath+"\\"+path);
        return fileSystemElement.isDirectory();
    }

    @Override
    public void getDesc() {
        System.out.println("Функция номер 1 - выводит список файлов в каталоге");
        System.out.println("Функция номер 2 - выводит суммарный размер всех файлов в каталоге");
        System.out.println("Функция номер 3 - подумаю");
    }

    @Override
    public void method1(String path) {
        System.out.println("Пока здесь ничего нет");
    }

    @Override
    public void method2(String path) {
        System.out.println("Пока здесь ничего нет");
    }

    @Override
    public void method3(String path) {
        System.out.println("Пока здесь ничего нет");
    }
}

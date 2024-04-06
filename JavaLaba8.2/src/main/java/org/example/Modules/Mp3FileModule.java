package org.example.Modules;

import org.springframework.stereotype.Component;

@Component
public class Mp3FileModule implements FileModule{
    String basePath = "C:\\Users\\Informant\\source\\repos\\JavaLaba8.2\\JustDirWithRandomFiles";
    @Override
    public boolean isCurrentFileFormatWorks(String path) {
        return path.endsWith(".mp3");
    }

    @Override
    public void getDesc() {
        System.out.println("Функция номер 1 - выводит название трека из тегов");
        System.out.println("Функция номер 2 - выводит длительность в секундах");
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

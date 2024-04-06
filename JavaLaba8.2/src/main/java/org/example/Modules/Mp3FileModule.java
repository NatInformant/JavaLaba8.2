package org.example.Modules;

import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

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
        File file = new File(basePath+"\\"+path);
        try {
            // Команда для выполнения
            ProcessBuilder processBuilder = new ProcessBuilder();
            processBuilder.command("cmd.exe", "/c", "ffmpeg -i "+basePath+"\\"+path);
            processBuilder.redirectInput(file);
            processBuilder.redirectOutput(ProcessBuilder.Redirect.PIPE);
            processBuilder.redirectError(ProcessBuilder.Redirect.INHERIT);
            Process process = processBuilder.start();
            String res = "";
            try (BufferedReader reader= new BufferedReader(new InputStreamReader(process.getInputStream()))){
                for (String line:
                        reader.lines().collect(Collectors.toList())) {
                    if (line.contains("format.tags.title")){
                        res = line.split("=")[1].replace("\"","");
                    }
                }
            }
            System.out.println(res);
        } catch (IOException e) {
            e.printStackTrace();
        }
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

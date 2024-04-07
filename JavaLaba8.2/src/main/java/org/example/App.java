package org.example;

import org.example.Modules.FileModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.List;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
@SpringBootApplication(scanBasePackages = "org.example")
public class App 
{
    private static List<FileModule> fileModules;
    @Autowired
    public App(List<FileModule> fileModules){
        App.fileModules =fileModules;
    }
    public static void main( String[] args )
    {
        SpringApplication.run(App.class, args);

        Scanner scanner = new Scanner(System.in);
        System.out.println( "Здравствуйте, вас приветсвует обработчик файлов, введите имя файла, " +
                "чтобы я мог начать с ним работу");


        FileModule fileModuleForThisFormat = null;

        String fileName = scanner.nextLine();
        for (FileModule fileModule : fileModules) {
            if (fileModule.isCurrentFileFormatWorks(fileName)) {
                fileModuleForThisFormat = fileModule;
                break;
            }
        }

        if(fileModuleForThisFormat == null){
            System.out.println("К сожалению данный формат файла не поддерживается");
        }
        else {
            System.out.println("Выберите какую из предложенных функций вы бы хотели использовать:");
            fileModuleForThisFormat.getDesc();
            while (true){
                System.out.print("Введите номер функции:");
                String funcNum = scanner.nextLine();
                switch(funcNum){
                    case("1"):
                        fileModuleForThisFormat.method1(fileName);
                        return;
                    case("2"):
                        fileModuleForThisFormat.method2(fileName);
                        return;
                    case("3"):
                        fileModuleForThisFormat.method3(fileName);
                        return;
                    default:
                        System.out.println("Вы не выбрали не одну из функций, попробуйте ещё раз");
                        break;
                }
            }
        }
    }
}

package org.example.Modules;

import org.springframework.stereotype.Component;

@Component
public class DirFileModule implements FileModule {

    @Override
    public boolean isCurrentFileFormatWorks(String path) {
        return false;
    }

    @Override
    public void getDesc() {

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

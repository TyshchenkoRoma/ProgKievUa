package com.company;

import java.io.FileWriter;
import java.io.IOException;

/**
 * 2. Написать класс TextContainer, который содержит в себе строку. С помощью механизма аннотаций указать
 * 1) в какой файл должен сохраниться текст 2) метод, который выполнит сохранение. Написать класс Saver,
 * который сохранит поле класса TextContainer в указанный файл.
 *
 * @SaveTo(path=“c:\\file.txt”) class Container {
 * String text = “...”;
 * @Saver public void save(..) {...}
 * }
 */
@SaveTo(PATH = "/home/roman/ROMA/JAVA/ProgKievUa/HW1 Refl 13.10/Task2/file.txt")
public class TestConteiner {
    String text = "text from textContainer";

    @Saver
    public void save(String text1, String path) throws IOException {
        FileWriter w = new FileWriter(path);
        try {
            w.write(text1);
        } finally {
            w.close();
        }
    }
}

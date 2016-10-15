package com.company;

import java.lang.annotation.*;

@Inherited
@Retention(value = RetentionPolicy.RUNTIME)
public @interface SaveTo {
    String PATH(); // = "/home/roman/ROMA/JAVA/ProgKievUa/HW1 Refl 13.10/Task2/file.txt";
}

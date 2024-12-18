package com.example.practick_demo_pattern.hashEquels;

import java.util.Objects;

public class Student {

    private String id;
    private String name;

    public Student(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        // Сравнение ссылок
        // Проверка типа
        // Создать обект и присвоить ему обект который передали в парметрах
        // Сравнение содержимого
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Student s = (Student) obj;
        return name.equals(s.name) && id.equals(((Student) obj).id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}

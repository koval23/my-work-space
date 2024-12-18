package com.example.practick_demo_pattern.hashEquels;

public class Student {
    private String name;

    public Student(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        // Сравнение ссылок
        // Проверка типа
        // Сравнение содержимого
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Student student = (Student) obj;
        return name.equals(student.name);
    }
}

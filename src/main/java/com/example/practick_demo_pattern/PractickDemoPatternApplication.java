package com.example.practick_demo_pattern;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class PractickDemoPatternApplication {


    public static void main(String[] args) {
        SpringApplication.run(PractickDemoPatternApplication.class, args);
//        //todo 5. Клиентский код
//
//        // Создаём машину с бензиновым двигателем
//        Car gasolineCar = new GasolineCar();
//        gasolineCar.startCar(); // Вывод: Газовый двигатель запущен.
//
//        // Создаём машину с электрическим двигателем
//        Car electricCar = new ElectricCar();
//        electricCar.startCar(); // Вывод: Электрический двигатель запущен.
//        ===============================================================================
        String[][] studentData = {
                {"Samvel", "78"},//84
                {"John", "85"},//82,5
                {"Samvel", "90"},
                {"John", "80"},
                {"Alice", "95"}//95
        };
        System.out.println(studentData.length + " кол-во оценок");
        avarageStudensGare(studentData);

//        double averageGrade = Arrays.stream(studentData)
//                .mapToInt(s -> Integer.parseInt(s[1]))
//                .average()
//                .orElse(0);
//
//        System.out.println(averageGrade + " сумма оценок");
//        System.out.println("среднее " + averageGrade / studentData.length);
//
//        int[] numbers = {10, 5, 1, 7, 2, 1, 25, 6, 2};
//
//        twoCount(numbers);

    }

    public static void avarageStudensGare(String[][] studentData) {
        Set<String> names = new HashSet<String>();

        String studentName = null;
        int studentAvarageGare = 0;

        int avarageGare = 0;
        int count = 0;

        for (int i = 0; i < studentData.length; i++) {
            if (names.size() == 0 || !names.contains(studentData[i][0])) {
                avarageGare = 0;
                count = 0;
                for (int j = 0; j < studentData.length; j++) {
                    String name = studentData[i][0];
                    names.add(name);
                    if (name.equals(studentData[j][0])) {
                        int gare = Integer.parseInt(studentData[j][1]);
                        avarageGare += gare;
                        count++;
                    }
                }
                int res = avarageGare / count;
                if (names.size() == 0 || res > studentAvarageGare) {
                    studentAvarageGare = res;
                    studentName = studentData[i][0];
                }
            }
        }
        System.out.println("Name Student: " + studentName);
        System.out.println("Gare Student: " + studentAvarageGare);
    }


    public static void twoCount(int[] nums) {
        if (nums.length < 1) {
            System.out.println("array < 2");
            return;
        }
        int[] one = {0, nums[0]};//5
        int[] two = {1, nums[1]};//2

        for (int i = 2; i < nums.length; i++) {
            if (nums[i] < one[1] && nums[i] != one[1] && nums[i] != two[1]) {
                one[0] = i;
                one[1] = nums[i];
            } else if (nums[i] < two[1] && nums[i] != two[1] && nums[i] != one[1]) {
                two[0] = i;
                two[1] = nums[i];
            }
        }
        if (one[0] < two[0]) {
            System.out.println("число 1 = " + one[1]);
            System.out.println("число 2 = " + two[1]);
        } else {
            System.out.println("число 1 = " + two[1]);
            System.out.println("число 2 = " + one[1]);
        }
    }

}


//todo 1. Интерфейс продукта
interface Engine {
    void start();
}
//todo 2. Реализация продуктов

// Конкретная реализация для бензинового двигателя
class GasolineEngine implements Engine {
    @Override
    public void start() {
        System.out.println("Газовый двигатель запущен.");
    }
}

// Конкретная реализация для электрического двигателя
class ElectricEngine implements Engine {
    @Override
    public void start() {
        System.out.println("Электрический двигатель запущен.");
    }
}

//todo 3. Абстрактный класс с фабричным методом

// Абстрактный класс, описывающий машину
abstract class Car {
    // Фабричный метод (делегируется подклассам)
    public abstract Engine createEngine();

    // Метод, который использует созданный продукт
    public void startCar() {
        Engine engine = createEngine(); // Создание двигателя через фабричный метод
        engine.start();                 // Использование двигателя
    }
}

//todo 4. Конкретные подклассы

// Класс для машины с бензиновым двигателем
class GasolineCar extends Car {
    @Override
    public Engine createEngine() {
        return new GasolineEngine(); // Возвращает бензиновый двигатель
    }
}

// Класс для машины с электрическим двигателем
class ElectricCar extends Car {
    @Override
    public Engine createEngine() {
        return new ElectricEngine(); // Возвращает электрический двигатель
    }
}


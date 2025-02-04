package ru.practicum.dinner;

import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    static DinnerConstructor dc;
    static Scanner scanner;

    public static void main(String[] args) {
        dc = new DinnerConstructor();
        scanner = new Scanner(System.in);
        System.out.println("Вас приветствует генератор комбо-обедов Солянка 0.1! Добро пожаловать!");

        while (true) {
            printMenu();
            String command = scanner.nextLine();

            switch (command) {
                case "1":
                    addNewDish();
                    break;
                case "2":
                    generateDishCombo();
                    break;
                case "3":
                    System.out.println("Благодарим Вас за использование Солянки 0.1!");
                    return;
                default:
                    System.out.println("Команда нераспознана, попробуйте ещё раз!");
            }
            System.out.println();
            System.out.println("*".repeat(20));
            System.out.println();
        }
    }

    private static void printMenu() {
        System.out.println("Вы находитесь в главном меню. Пожалуйста, выберите команду:");
        System.out.println("1 - Добавить новое блюдо.");
        System.out.println("2 - Сгенерировать комбинации блюд.");
        System.out.println("3 - Выход.");
    }

    private static void addNewDish() {
        System.out.println("Введите тип блюда:");
        String dishType = scanner.nextLine();
        System.out.println("Введите название блюда:");
        String dishName = scanner.nextLine();
        dc.addNewDish(dishType, dishName);
    }

    private static void generateDishCombo() {
        if (dc.isDishListEmpty()) {
            System.out.println("Нет блюд для сбора комбо. Сначала добавьте блюда!");
            return;
        }

        System.out.println("Начинаем конструировать обед...");
        System.out.println("Введите количество наборов, которые нужно сгенерировать:");
        int numberOfCombos;
        if (scanner.hasNextInt()) {
            numberOfCombos = scanner.nextInt();
            if (numberOfCombos <= 0) {
                System.out.println("Количество комбо-наборов не может быть меньше 1!");
                System.out.println("Выполняется возврат в меню.");
                scanner.nextLine();
                return;
            }
        } else {
            scanner.nextLine();
            System.out.println("Количество наборов должно являться числом. Выполняется возврат в меню.");
            return;
        }
        scanner.nextLine();

        System.out.println("Вводите типы блюда, разделяя символом переноса строки (enter). Для завершения ввода " +
                "введите пустую строку.");
        String nextItem = scanner.nextLine();
        ArrayList<String> comboTypes = new ArrayList<>();
        while (!nextItem.isEmpty()) {
            if (dc.checkItem(nextItem)) {
                comboTypes.add(nextItem);
            } else {
                System.out.println("Ошибка! Такого типа блюд не существует! Пропускаем этот пункт и едем дальше.");
            }
            nextItem = scanner.nextLine();
        }

        for (int i = 0; i < numberOfCombos; i++) {
            String[] combo = dc.generateCombo(comboTypes);
            System.out.println("Комбо №" + (i + 1) + ".");
            for (int j = 0; j < combo.length; j++) {
                System.out.print(combo[j]);
                if (j < (combo.length - 1)) {
                    System.out.print(" + ");
                }
            }
            System.out.println();
            if (i < (numberOfCombos - 1)) {
                System.out.println("-".repeat(10));
            }
        }
    }
}

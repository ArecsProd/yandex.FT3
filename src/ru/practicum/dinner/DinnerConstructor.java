package ru.practicum.dinner;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Random;

public class DinnerConstructor {
    Random rnd = new Random();
    HashMap<String, ArrayList<String>> dishList = new HashMap<>();

    void createMenu() {
        ArrayList<String> menu1 = new ArrayList<>();
        menu1.add("Морс");
        menu1.add("Компот");
        menu1.add("Кофе 3 в 1");
        dishList.put("Напиток", menu1);

        ArrayList<String> menu2 = new ArrayList<>();
        menu2.add("Кура");
        menu2.add("Говядина");
        menu2.add("Утка");
        dishList.put("Мясо", menu2);

        ArrayList<String> menu3 = new ArrayList<>();
        menu3.add("Греча");
        menu3.add("Пюре");
        menu3.add("Макароны");
        dishList.put("Гарнир", menu3);

        ArrayList<String> menu4 = new ArrayList<>();
        menu4.add("Борщ");
        menu4.add("Щи");
        menu4.add("Уха по-фински");
        dishList.put("Суп", menu4);
    } // удалить по завершению, метод для тестов

    void addNewDish(String dishType, String dishName) {
        if (dishList.containsKey(dishType)) {
            dishList.get(dishType).add(dishName);
            System.out.println("dishList = " + dishList);
        } else {
            ArrayList<String> newArray = new ArrayList<>();
            newArray.add(dishName);
            dishList.put(dishType, newArray);
            System.out.println("Создан новый тип блюд - " + dishType);
        }
        System.out.println("Добавили блюдо \"" + dishName + "\" типа \"" + dishType + "\"");
    }

    boolean checkItem (String item) {
        return dishList.containsKey(item);
    }

    String[] generateCombo(ArrayList<String> comboTypes) {
        String[] combo = new String[comboTypes.size()];
        for (int i = 0; i < comboTypes.size(); i++) {
            String actualType = comboTypes.get(i);
            ArrayList<String> actualListOfDishes = dishList.get(actualType);
            String actualDish = actualListOfDishes.get(rnd.nextInt(actualListOfDishes.size()));
            combo[i] = actualDish;
        }
        return combo;
    }
}

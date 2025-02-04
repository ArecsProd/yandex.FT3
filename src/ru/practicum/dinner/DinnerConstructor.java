package ru.practicum.dinner;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Random;

public class DinnerConstructor {
    Random rnd = new Random();
    HashMap<String, ArrayList<String>> dishList = new HashMap<>();

    boolean isDishListEmpty () {
        return dishList.isEmpty();
    }

    void addNewDish(String dishType, String dishName) {
        if (dishList.containsKey(dishType)) {
            if (dishList.get(dishType).contains(dishName)) {
                System.out.println("В категории " + dishType + " уже существует блюдо " + dishName + "!");
                System.out.println("Выполняется возврат в меню");
                return;
            } else {
                dishList.get(dishType).add(dishName);
            }
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

package org.example;

import java.util.HashMap;
import java.util.Map;

public class FirstTask
{
    // Задание 1: Реализуй метод, который поменяет ключи и значения в HashMap местами.
    // На вход в метод поступает HashMap<Interger, String>, надо вернуть HashMap<String, Integer>.
    // Выведи результат.

    public HashMap<String,Integer> SwapKeysValues(HashMap <Integer, String> hm)
    {
        if (hm.size() == 0)
            return null;
        else
        {
            HashMap <String,Integer> new_Hash_map = new HashMap<>();
            for (Map.Entry<Integer,String> element : hm.entrySet())
            {
                new_Hash_map.put(element.getValue(), element.getKey());
            }
            return new_Hash_map;
        }
    }
}

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Integer array
        Integer[] integers = {30, 31, 34, 28, 49};
        JSONArray intArrayJson = new JSONArray();
        for (Integer num : integers) {
            intArrayJson.add(num);
        }
        System.out.println("Integer array JSON: " + intArrayJson.toJSONString());

        // String array
        String[] strings = {"One", "Two", "Three", "Four"};
        JSONArray strArrayJson = new JSONArray();
        for (String str : strings) {
            strArrayJson.add(str);
        }
        System.out.println("String array JSON: " + strArrayJson.toJSONString());

        // Object array
        Object[] objects = {31, 32, "Hello World", new String[]{"One", "Two", "Three"}};
        JSONArray objArrayJson = new JSONArray();
        for (Object obj : objects) {
            objArrayJson.add(obj);
        }
        System.out.println("Object array JSON: " + objArrayJson.toJSONString());

        // Map with String values
        Map<String, String> stringMap = new TreeMap<>();
        stringMap.put("Name", "Name1");
        stringMap.put("Address", "213 Washington Blv");
        stringMap.put("Zip", "90532");
        JSONObject stringMapJson = new JSONObject(stringMap);
        System.out.println("Map with String values JSON: " + stringMapJson.toJSONString());

        // Map with Object values (including a Set)
        Map<String, Object> objectMap = new TreeMap<>();
        Set<String> friends = new TreeSet<>();
        friends.add("Friend 1");
        friends.add("Friend 2");
        objectMap.put("Name", "Name1");
        objectMap.put("Address", "213 Washington Blv");
        objectMap.put("Zip", "90532");
        objectMap.put("Friends", friends);
        JSONObject objectMapJson = new JSONObject(objectMap);
        System.out.println("Map with Object values JSON: " + objectMapJson.toJSONString());
    }
}

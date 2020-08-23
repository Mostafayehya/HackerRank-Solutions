package javaproblems.datastructures;

import java.util.HashMap;
import java.util.Map;

public class TestHashMapsPutMethodReturnValue {

    public static void main(String[] args) {

        Map<String,String> map = new HashMap<>();

        Object o = ovveridePut("Mostafa","Yahia",map);
        System.out.println(o);
    }

    public static Object ovveridePut(String key,String value,Map map){

        Object o = map.put(key,value);
        return  map.get(key);
    }
}

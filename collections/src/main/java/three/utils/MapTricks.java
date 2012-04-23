package three.utils;

import three.generics.Holder;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author Tedikova O.
 * @version 1.0
 */
public class MapTricks {
    private static Random random = new Random();

    public static void main(String[] args) {
        Map<Integer, Holder<Integer>> map = new HashMap<Integer, Holder<Integer>>();
        initializeRandomly(map, 20, 10);
        for (int i = 0; i < 20; i++) {
            System.out.println("Element with key " + i * i + " contains: " + map.containsKey(i * i) +
                    ". It's value: " + map.get(i * i));
        }
    }

    private static void initializeRandomly(Map<Integer, Holder<Integer>> map, int range, int count) {
        for (int i = 0; i < count; i++) {
            Holder<Integer> holder = new Holder<Integer>(random.nextInt(range));
            System.out.println(holder);
            map.put((int) Math.pow(holder.getValue(), 2), holder);
        }
    }

}


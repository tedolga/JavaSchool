package three.utils;

import three.generics.DescendingComparator;
import three.generics.Holder;

import java.util.*;

/**
 * @author Tedikova O.
 * @version 1.0
 */
public class ListTricks {
    private static Random random = new Random();

    public static void main(String[] args) {
        List<Holder<Integer>> list = new ArrayList<Holder<Integer>>(10);
        printList(list);
        initializeRandomly(list, 5);
        printList(list);
        Collections.sort(list);
        printList(list);
        Collections.sort(list, new DescendingComparator<Integer>());
        printList(list);

        Holder[] array = new Holder[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = new Holder<Integer>(i);
        }
        List<Holder> fromArray = Arrays.asList(array);
        printList(fromArray);
    }

    private static void printList(List list) {
        StringBuilder builder = new StringBuilder();
        builder.append("List with size = ");
        builder.append(list.size());
        builder.append(" :\n");
        builder.append(list.toString());
        builder.append("\n");
        builder.append("-------------------------------------------------------");
        builder.append("\n");
        System.out.println(builder);
    }

    private static void initializeRandomly(List<Holder<Integer>> list, int range) {
        for (int i = 0; i < 10; i++) {
            int nextInt = random.nextInt(range);
            list.add(new Holder<Integer>(nextInt));
            System.out.println(nextInt);
        }
    }
}

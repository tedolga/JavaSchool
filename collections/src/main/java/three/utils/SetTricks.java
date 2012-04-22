package three.utils;

import three.generics.Holder;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author Tedikova O.
 * @version 1.0
 */
public class SetTricks {

    public static void main(String[] args) {
        Set<Holder<Integer>> firstSet = new HashSet<Holder<Integer>>(10);
        initializeSet(firstSet, 0, 9);
        printSet(firstSet);

        Set<Holder<Integer>> secondSet = new HashSet<Holder<Integer>>(10);

        initializeSet(secondSet, 1, 10);
        printSet(secondSet);

        secondSet.addAll(firstSet);
        printSet(secondSet);

        firstSet = new HashSet<Holder<Integer>>(10);
        secondSet = new HashSet<Holder<Integer>>(10);
        initializeSet(firstSet, 0, 9);
        initializeSet(secondSet, 1, 10);
        secondSet.retainAll(firstSet);
        printSet(secondSet);

        firstSet = new HashSet<Holder<Integer>>(10);
        secondSet = new HashSet<Holder<Integer>>(10);
        initializeSet(firstSet, 0, 9);
        initializeSet(secondSet, 1, 10);
        Set<Holder<Integer>> tempSet = new HashSet<Holder<Integer>>(10);
        tempSet.addAll(secondSet);
        secondSet.removeAll(firstSet);
        firstSet.removeAll(tempSet);
        secondSet.addAll(firstSet);
        printSet(secondSet);

        Set<Holder<Integer>> treeSet = new TreeSet<Holder<Integer>>();
        initializeSet(treeSet, 0, 9);
        printSet(treeSet);
    }

    private static void printSet(Set set) {
        StringBuilder builder = new StringBuilder();
        builder.append("Hash set with size = ");
        builder.append(set.size());
        builder.append(" :\n");
        builder.append(set.toString());
        builder.append("\n");
        builder.append("-------------------------------------------------------");
        builder.append("\n");
        System.out.println(builder);
    }

    private static void initializeSet(Set<Holder<Integer>> set, int minValue, int maxValue) {
        for (int i = minValue; i < maxValue + 1; i++) {
            set.add(new Holder<Integer>(i));
        }
    }

}

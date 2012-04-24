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
        //Initializing of first set
        Set<Holder<Integer>> firstSet = new HashSet<Holder<Integer>>(10);
        initializeSet(firstSet, 0, 9);
        printSet(firstSet);

        //initializing of second set
        Set<Holder<Integer>> secondSet = new HashSet<Holder<Integer>>(10);
        initializeSet(secondSet, 1, 10);
        printSet(secondSet);

        //Disjunction of 2 sets (union of elements from 2 sets)
        secondSet.addAll(firstSet);
        printSet(secondSet);

        //Reinitialization of sets
        firstSet = new HashSet<Holder<Integer>>(10);
        secondSet = new HashSet<Holder<Integer>>(10);
        initializeSet(firstSet, 0, 9);
        initializeSet(secondSet, 1, 10);

        //Conjunction of 2 sets (in secondSet will be only elements which there are in first set)
        secondSet.retainAll(firstSet);
        printSet(secondSet);

        //Reinitialization of 2 sets
        firstSet = new HashSet<Holder<Integer>>(10);
        secondSet = new HashSet<Holder<Integer>>(10);
        initializeSet(firstSet, 0, 9);
        initializeSet(secondSet, 1, 10);

        //Temp set for holding secondSet elements
        Set<Holder<Integer>> tempSet = new HashSet<Holder<Integer>>(10);
        tempSet.addAll(secondSet);

        //Difference of two sets (in second set will be unique elements from both sets)
        secondSet.removeAll(firstSet);
        firstSet.removeAll(tempSet);
        secondSet.addAll(firstSet);
        printSet(secondSet);

        //Sorted set
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

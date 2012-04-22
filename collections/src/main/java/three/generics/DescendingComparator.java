package three.generics;

import java.util.Comparator;

/**
 * @author Tedikova O.
 * @version 1.0
 */
public class DescendingComparator<T extends Comparable<? super T>> implements Comparator<Holder<T>> {

    @Override
    public int compare(Holder o1, Holder o2) {
        return o2.compareTo(o1);
    }
}

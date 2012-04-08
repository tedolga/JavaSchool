package two.essential;

import java.util.Random;

/**
 * @author Tedikova O.
 * @version 1.0
 */
public class StringGenerator {

    private static final String JACK_POT_STRING = "777";

    public static CharSequence generateString(int valuesCount, int valueRange) {
        StringBuilder result = new StringBuilder(valuesCount);
        Random random = new Random();
        for (int i = 0; i < valuesCount; i++) {
            result.append(random.nextInt(valueRange - 1) + 1);
        }
        return result;
    }

    public static CharSequence replaceDevilsDozen(CharSequence sequence) {
        StringBuilder result = new StringBuilder(sequence.length() + 16);
        int i = 0;
        while (i < sequence.length() - 1) {
            if (sequence.charAt(i) == '1' && sequence.charAt(i + 1) == '3') {
                result.append(JACK_POT_STRING);
                i += 2;
            } else {
                result.append(sequence.charAt(i));
                i++;
            }
        }
        if (i < sequence.length()) {
            result.append(sequence.charAt(i));
        }
        return result;
    }
}

package two.essential;

/**
 * @author O. Tedikova
 * @version 1.0
 */
public class TextRepresenter {

    public static String representText(String source) {
        StringBuilder result = new StringBuilder();
        StringBuilder tempWord = new StringBuilder();
        TextStates previousState = TextStates.START;
        TextStates currentState = TextStates.START;
        CharSequence sourceChars = source.subSequence(0, source.length());
        for (int i = 0; i < sourceChars.length(); i++) {
            char sourceChar = sourceChars.charAt(i);
            switch (sourceChar) {
                case '.':
                    if (currentState == TextStates.WORD) {
                        addWord(tempWord, result, previousState);
                    }
                    previousState = currentState;
                    currentState = TextStates.FULL_STOP;
                    result.append(sourceChar);
                    break;
                case '\t':
                case '\r':
                case '\n':
                case ' ':
                    if (currentState == TextStates.WORD) {
                        addWord(tempWord, result, previousState);
                    }
                    previousState = currentState;
                    currentState = TextStates.SPECIAL_CHARACTER;
                    result.append(sourceChar);
                    break;
                default:
                    if (tempWord.length() == 0) {
                        previousState = currentState;
                        currentState = TextStates.WORD;
                    }
                    tempWord.append(sourceChar);
                    break;

            }

        }

        return result.toString();

    }

    private static void addWord(StringBuilder tempWord, StringBuilder result, TextStates previousState) {
        if (!tempWord.toString().equals(tempWord.toString().toUpperCase())) {
            if (previousState == TextStates.START || previousState == TextStates.FULL_STOP) {
                tempWord.setCharAt(0, Character.toUpperCase(tempWord.charAt(0)));
                for (int i = 1; i < tempWord.length(); i++) {
                    tempWord.setCharAt(i, Character.toLowerCase(tempWord.charAt(i)));
                }
            } else {
                for (int i = 0; i < tempWord.length(); i++) {
                    tempWord.setCharAt(i, Character.toLowerCase(tempWord.charAt(i)));
                }
            }
        }
        result.append(tempWord);
        tempWord.setLength(0);
    }

}

package two.essential;

import java.util.StringTokenizer;

/**
 * @author O. Tedikova
 * @version 1.0
 */
public class TextRepresenter {

    public static String representText(String source) {
        StringTokenizer tokenizer = new StringTokenizer(source, " .\t\r\n", true);
        StringBuilder result = new StringBuilder(source.length());
        boolean fullStop = true;
        while (tokenizer.hasMoreTokens()) {
            String nextToken = tokenizer.nextToken();
            if (!isDelimiter(nextToken)) {
                if (!isAcronym(nextToken)) {
                    nextToken = fullStop ? toMixedCase(nextToken) : nextToken.toLowerCase();
                }
                fullStop = false;
            } else {
                if (".".equals(nextToken)) {
                    fullStop = true;
                }
            }
            result.append(nextToken);
        }
        return result.toString();
    }

    public static boolean isDelimiter(String token) {
        if (token.length() > 1) {
            return false;
        } else {
            switch (token.charAt(0)) {
                case ' ':
                case '\t':
                case '\r':
                case '\n':
                case '.':
                    return true;
                default:
                    return false;
            }
        }
    }

    public static boolean isAcronym(String word) {
        for (int i = 0; i < word.length(); i++) {
            if (!Character.isUpperCase(word.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static String toMixedCase(String word) {
        char[] chars = new char[word.length()];
        chars[0] = Character.toUpperCase(word.charAt(0));
        for (int i = 1; i < chars.length; i++) {
            chars[i] = Character.toLowerCase(word.charAt(i));
        }
        return new String(chars);
    }

}

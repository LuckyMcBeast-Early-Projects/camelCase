import java.lang.*;

/**
 * Simple camelCase class that has methods used to convert a string to camelCase
 *
 * @author M. Cullen McClellan
 */
public class camelCase {
    /**
     * Converts camelCase version of input String based on a single character delimiter
     *
     * @param toBeCamelized input String
     * @param delimiter delimiter character for camelCasing
     * @return camelized String
     */
    public String convertToCamel(String toBeCamelized, char delimiter) {
        StringBuilder camelized = new StringBuilder(toBeCamelized.toLowerCase());
        camelBuilder(camelized, delimiter);
        return camelized.toString();
    }

    /**
     * Converts camelCase version of input String based on multiple character delimiter
     *
     * @param toBeCamelized input String
     * @param delimiters array of delimiters characters for camelCasing
     * @return camelized String
     */
    public String convertToCamel(String toBeCamelized, char[] delimiters) {
        StringBuilder dynamicCamel = new StringBuilder(toBeCamelized.toLowerCase());
        for (int i = 0; i < delimiters.length; i++) {
            camelBuilder(dynamicCamel, delimiters[i]);
        }
        return dynamicCamel.toString();
    }

    /**
     * Internal method to construct the camelCase String
     *
     * @param lowerCaseCamel StringBuilder object sent from convertToCamel
     * @param delimiter      delimiter character from convertToCamel
     */
    private void camelBuilder(StringBuilder lowerCaseCamel, char delimiter) {
        for (int i = 0; i < lowerCaseCamel.length(); i++) {
            char currentChar = lowerCaseCamel.charAt(i);
            if (!Character.isLetter(currentChar) && !Character.isDigit(currentChar)) {
                if (currentChar == delimiter) {
                    lowerCaseCamel.deleteCharAt(i);
                    i--;
                    if ((i) < lowerCaseCamel.length()) {
                        lowerCaseCamel.setCharAt(i + 1, Character.toUpperCase(lowerCaseCamel.charAt(i + 1)));
                    }
                }
            }
        }
    }

    public static void main(String[] vars) {
        String camelCamel = "Ride the  camel";
        camelCase camel = new camelCase();
        System.out.println(camel.convertToCamel(camelCamel, ' '));

        String crazyCamel = "CRAZY.CAMELS 8 are, cool";
        char[] delimiters = {' ', '.', ','};
        System.out.println(camel.convertToCamel(crazyCamel, delimiters));
    }
}

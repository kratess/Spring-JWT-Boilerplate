package dev.kratess.boilerplate.util;

public class StringUtil {
    public static String toPascalCase(String s) {
        String[] parts = s.split("_");
        StringBuilder camelCaseString = new StringBuilder();
        for (String part : parts) {
            camelCaseString.append(part.substring(0, 1).toUpperCase()).append(part.substring(1).toLowerCase());
        }
        return camelCaseString.toString();
    }
}

package utils;

public class Formater {
    public static String formatPrice(int value){
        String price = String.valueOf(value);
        return " \\$"+price+"                              ";
    }
}

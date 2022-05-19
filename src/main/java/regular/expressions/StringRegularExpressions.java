package regular.expressions;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class StringRegularExpressions {

    public static void main(String[] args) {
        expressions();
    }

    static public void expressions() {
        String s1 = "apple, apple and orange please";
        String s2 = s1.replaceAll("ple", "ricot");
        String s3 = s1.replaceAll("ple\\b", "ricot");
        System.out.println(s2);
        System.out.println(s3);

        String[] parts = s1.split("\\b");
        for(String word: parts) {
            if(word.matches("\\w+")) {
                System.out.println(word);
            }
        }

        System.out.println("=================");
        Pattern pattern = Pattern.compile("\\w+");
        Matcher matcher = pattern.matcher(s1);
        while(matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}

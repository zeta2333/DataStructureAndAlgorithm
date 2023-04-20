import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        String s = "is2 sentence4 This1 a3";
        System.out.println(sortSentence(s));
    }

    public static String sortSentence(String s) {
        String[] sp = s.split(" ");

        Comparator<String> com = (s1, s2) -> {
            int n1 = Integer.parseInt(String.valueOf(s1.charAt(s1.length() - 1)));
            int n2 = Integer.parseInt(String.valueOf(s2.charAt(s2.length() - 1)));
            return n1 - n2;
        };
        Arrays.sort(sp, com);
        String res2 = "";
        for (String item : sp) {
            res2 += item.substring(0, item.length() - 1) + " ";
        }
        return res2.strip();
    }
}


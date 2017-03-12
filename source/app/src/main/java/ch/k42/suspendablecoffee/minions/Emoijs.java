package ch.k42.suspendablecoffee.minions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by trichner on 11.03.17.
 */

public class Emoijs {

    public static String from(String str){
        StringBuilder sb = new StringBuilder(str);

        Matcher m = Pattern.compile("U\\+([A-z0-9]+)").matcher(str);
        while (m.find()) {
            String hexStr = m.group(1);
            int codePoint = Integer.parseInt(hexStr, 16);
            String rune = new String(Character.toChars(codePoint));
            sb = sb.replace(m.start(0), m.end(0), rune);
        }
        return sb.toString();
    }
}

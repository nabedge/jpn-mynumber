package org.mixer2.jpnmynumber;

import java.util.ArrayList;
import java.util.List;

/**
 * "My number" and "Corporation number" checker in Japan
 * 
 * @author nabedge
 *
 */
public class MyNumberUtil {

    private static final int myNumberDigits = 12;
    private static final int corporationNumberDigits = 13;

    private MyNumberUtil() {
    }

    /**
     * verify by check digit of "corporation number"
     * 
     * @param coNumber
     *            13 digit number
     * @return
     */
    public static final boolean verifyCorporationNumber(String coNumber) {
        String errMsg = "must be " + corporationNumberDigits + " digit number:" + coNumber;
        if (coNumber == null || coNumber.length() != corporationNumberDigits) {
            throw new IllegalArgumentException(errMsg);
        }
        List<Integer> list = splitToInteger(coNumber);
        if (coNumber.length() != list.size()) {
            throw new IllegalArgumentException(errMsg);
        }
        int checkDigit = list.remove(corporationNumberDigits - 1).intValue();
        int total = 0;
        for (int i = 1; i <= 12; i++) {
            int m = list.get(12 - i).intValue();
            int n = (i % 2 == 0) ? 1 : 2;
            total += m * n;
        }
        int calculatedDigit = 9 - total % 9;
        return checkDigit == calculatedDigit;
    }

    /**
     * verify by check digit of "my number"
     * 
     * @param myNumber
     *            12 digit number
     * @return
     */
    public static final boolean verifyMyNumber(String myNumber) {
        String errMsg = "must be " + myNumberDigits + " digit number:" + myNumber;
        if (myNumber == null || myNumber.length() != myNumberDigits) {
            throw new IllegalArgumentException(errMsg);
        }
        List<Integer> list = splitToInteger(myNumber);
        if (myNumber.length() != list.size()) {
            throw new IllegalArgumentException(errMsg);
        }
        int checkDigit = list.remove(myNumberDigits - 1).intValue();
        int total = 0;
        for (int i = 1; i <= 11; i++) {
            int m = list.get(11 - i).intValue();
            int n = (i <= 6) ? i + 1 : i - 5;
            total += m * n;
        }
        int calculatedDigit = 11 - (total % 11);
        return checkDigit == calculatedDigit;
    }

    private static List<Integer> splitToInteger(String str) {
        String[] chars = str.split("");
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < chars.length; i++) {
            try {
                list.add(new Integer(chars[i]));
            } catch (NumberFormatException nfe) {
                // do nothing
            }
        }
        return list;
    }
}

package infinitelibrary;

import java.math.BigInteger;

public class TextDecoder {

    private static final String ALPHABET =
            "ABCDEFGHIJKLMNOPQRSTUVWXYZ ";

    public String decode(
            BigInteger value,
            int length) {

        char[] result =
                new char[length];

        BigInteger base =
                BigInteger.valueOf(
                        ALPHABET.length()
                );

        for (int i = length - 1; i >= 0; i--) {

            BigInteger[] division =
                    value.divideAndRemainder(base);

            int digit =
                    division[1].intValue();

            result[i] =
                    ALPHABET.charAt(digit);

            value =
                    division[0];
        }

        return new String(result);
    }
}
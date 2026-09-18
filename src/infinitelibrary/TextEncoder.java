package infinitelibrary;

import java.math.BigInteger;

public class TextEncoder {

    private static final String ALPHABET =
            "ABCDEFGHIJKLMNOPQRSTUVWXYZ ";

    public BigInteger encode(String text) {

        BigInteger value =
                BigInteger.ZERO;

        BigInteger base =
                BigInteger.valueOf(
                        ALPHABET.length()
                );

        for (char c : text.toCharArray()) {

            int digit =
                    ALPHABET.indexOf(c);

            if (digit == -1) {

                throw new IllegalArgumentException(
                        "Unsupported character: " + c +
                        "\n\nUse only A-Z and spaces."
                );
            }

            value =
                    value.multiply(base)
                         .add(
                             BigInteger.valueOf(digit)
                         );
        }

        return value;
    }
}
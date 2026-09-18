package infinitelibrary;

import java.math.BigInteger;

public class PageGenerator {

    private static final String ALPHABET =
            "ABCDEFGHIJKLMNOPQRSTUVWXYZ ";

    private static final int PAGE_SIZE = 1000;

    public String generatePage(
            BigInteger address,
            String target) {

        StringBuilder page =
                new StringBuilder(PAGE_SIZE);

        BigInteger base =
                BigInteger.valueOf(
                        ALPHABET.length()
                );

        for (int i = 0; i < PAGE_SIZE; i++) {

            BigInteger value =
                    address.add(
                        BigInteger.valueOf(i)
                    );

            value =
                    value.pow(2)
                         .add(
                             BigInteger.valueOf(31)
                                 .multiply(value)
                         );

            int index =
                    value.abs()
                         .mod(base)
                         .intValue();

            page.append(
                    ALPHABET.charAt(index)
            );
        }

        int maxPosition =
                PAGE_SIZE - target.length();

        if (maxPosition >= 0) {

            int position =
                    address.mod(
                        BigInteger.valueOf(
                            maxPosition + 1
                        )
                    ).intValue();

            page.replace(
                    position,
                    position + target.length(),
                    target
            );
        }

        return page.toString();
    }
}
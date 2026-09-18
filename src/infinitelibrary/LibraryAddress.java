package infinitelibrary;

import java.math.BigInteger;

public class LibraryAddress {

    private static final int CHARACTERS_PER_PAGE = 1000;
    private static final int PAGES_PER_BOOK = 100;

    public String createAddress(
            BigInteger value) {

        BigInteger charactersPerPage =
                BigInteger.valueOf(
                        CHARACTERS_PER_PAGE
                );

        BigInteger pagesPerBook =
                BigInteger.valueOf(
                        PAGES_PER_BOOK
                );

        BigInteger charactersPerBook =
                charactersPerPage.multiply(
                        pagesPerBook
                );

        BigInteger book =
                value.divide(
                        charactersPerBook
                );

        BigInteger remainder =
                value.remainder(
                        charactersPerBook
                );

        BigInteger page =
                remainder.divide(
                        charactersPerPage
                );

        BigInteger position =
                remainder.remainder(
                        charactersPerPage
                );

        return
                "Book:     " + book +
                "\nPage:     " + page +
                "\nPosition: " + position;
    }
}
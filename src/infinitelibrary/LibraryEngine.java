package infinitelibrary;

import java.math.BigInteger;

public class LibraryEngine {

    private final TextEncoder encoder;
    private final TextDecoder decoder;
    private final LibraryAddress addressGenerator;
    private final PageGenerator pageGenerator;

    public LibraryEngine() {

        encoder = new TextEncoder();
        decoder = new TextDecoder();
        addressGenerator = new LibraryAddress();
        pageGenerator = new PageGenerator();
    }

    public SearchResult search(String text) {

        BigInteger address =
                encoder.encode(text);

        String decoded =
                decoder.decode(
                    address,
                    text.length()
                );

        String location =
                addressGenerator.createAddress(
                    address
                );

        String page =
                pageGenerator.generatePage(
                    address,
                    text
                );

        return new SearchResult(
                text,
                address,
                location,
                page,
                decoded
        );
    }
}
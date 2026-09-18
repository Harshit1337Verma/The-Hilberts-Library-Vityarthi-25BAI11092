package infinitelibrary;

import java.math.BigInteger;

public class SearchResult {

    private final String text;
    private final BigInteger address;
    private final String location;
    private final String page;
    private final String decoded;

    public SearchResult(
            String text,
            BigInteger address,
            String location,
            String page,
            String decoded) {

        this.text = text;
        this.address = address;
        this.location = location;
        this.page = page;
        this.decoded = decoded;
    }

    public String getText() {
        return text;
    }

    public BigInteger getAddress() {
        return address;
    }

    public String getLocation() {
        return location;
    }

    public String getPage() {
        return page;
    }

    public String getDecoded() {
        return decoded;
    }
}
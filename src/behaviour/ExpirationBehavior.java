package behaviour;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class ExpirationBehavior implements Expiration {
    private final LocalDate expirationDate;

    public ExpirationBehavior(String expirationDate) {
        // input the date in format "YYYY-MM-DD"
        this.expirationDate = LocalDate.parse(expirationDate, DateTimeFormatter.ISO_LOCAL_DATE);
    }

    @Override
    public String getExpirationDate() {
        return expirationDate.toString();
    }

    
    // check if the item is isExpired
    @Override
    public boolean isExpired() {
        return LocalDate.now().isAfter(expirationDate);
    }
}
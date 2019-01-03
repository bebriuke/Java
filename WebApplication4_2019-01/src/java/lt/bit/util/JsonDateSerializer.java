package lt.bit.util;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import javax.json.bind.adapter.JsonbAdapter;

public class JsonDateSerializer implements JsonbAdapter<Date, String> {

    private final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public String adaptToJson(Date date) throws Exception {
        if (date == null) {
            return null;
        }
        return sdf.format(date);
    }

    @Override
    public Date adaptFromJson(String dateStr) throws Exception {
        try {
            Instant now = Instant.parse(dateStr);
            return Date.from(now);
        } catch (Exception ex) {
            return null;
        }
    }

}

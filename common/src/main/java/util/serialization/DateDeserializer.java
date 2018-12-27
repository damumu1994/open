package util.serialization;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * @author Aswords
 * @Date 09/12/2016
 * @since v0.1
 */
@SuppressWarnings("rawtypes")
public class DateDeserializer implements JsonDeserializer {

    @Override
    public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
            throws JsonParseException {
        try {
            if (json == null) {
                return null;
            } else if (json.getAsString().isEmpty()) {
                return null;
            } else {
                String str = json.getAsString();
                if (str.contains("-") && !str.contains(":")) {
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    return sdf.parse(str);
                } else if (str.contains("T")) {
                    str = str.replace("Z", "");
                    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
                    return df.parse(str);
                } else if (str.contains("AM") || str.contains("PM")) {
                    SimpleDateFormat sdf =
                            new SimpleDateFormat("MMM d, yyyy K:m:s a", Locale.ENGLISH);
                    return sdf.parse(str);
                } else if (str.contains("-") && str.contains(":")) {
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    return sdf.parse(str);
                } else if (str.contains(",")) {
                    SimpleDateFormat sdf = new SimpleDateFormat("MMM d, yyyy K:m:s", Locale.ENGLISH);
                    return sdf.parse(str);
                } else {
                    return new Date(json.getAsLong());
                }
            }
        } catch (ParseException e) {
            e.printStackTrace();
            //LogUtil.error(DateDeserializer.class, e.getMessage());
        }
        return null;
    }
}

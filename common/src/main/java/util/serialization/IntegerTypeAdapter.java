package util.serialization;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

public class IntegerTypeAdapter extends TypeAdapter<Integer> {

    @Override
    public void write(JsonWriter out, Integer value) throws IOException {
        if (value == null) {
            out.nullValue();
            return;
        }
        out.value(value);
    }

    @Override
    public Integer read(JsonReader in) throws IOException {
        if (in.peek() == JsonToken.NULL) {
            in.nextNull();
            return null;
        }
        String stringValue = in.nextString();
        if (stringValue.isEmpty()) {
            //stringValue = "-1";
            return null;
        }
        try {
            Integer value = Integer.valueOf(stringValue);
            return value;
        } catch (NumberFormatException e) {
            return null;
        }
    }

}

/**
 * Copyright (c) @2016,cmct 版权所有
 */
package util.serialization;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Date;

/**
 * json工具类
 *
 * @author losing
 * @Date 2016年8月14日
 * @since v0.1
 */
public class JsonUtil {

    //    private static final Type INSTANT_TYPE = new TypeToken<Instant>() {}.getType();
    private static Gson gson = null;

    static {
        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(Date.class, new DateDeserializer());
        builder.registerTypeAdapter(Double.class, new DoubleTypeAdapter());
        builder.registerTypeAdapter(Long.class, new LongTypeAdapter());
        builder.registerTypeAdapter(Integer.class, new IntegerTypeAdapter());
        builder.registerTypeAdapterFactory(new NullStringToEmptyAdapterFactory<String>());
//        builder.registerTypeAdapter(INSTANT_TYPE, new InstantConverter());
        gson = builder.create();
    }

    public static Gson getInstance() {
        return gson;
    }

    public static String toJson(Object o) {
        return gson.toJson(o);
    }

    public static <T> T toObj(String s, Class<T> jsonCls) {
        return gson.fromJson(s, jsonCls);
    }
}

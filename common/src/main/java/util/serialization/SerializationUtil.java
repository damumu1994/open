/**
 * Copyright (c) @2016,cmct 版权所有
 */
package util.serialization;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.msgpack.jackson.dataformat.MessagePackFactory;

import java.io.IOException;

/**
 * 序列化工具类
 *
 * @author losing
 * @Date 2016年8月15日
 * @since v0.1
 */
public class SerializationUtil {

    private static ObjectMapper msgpackMapper = new ObjectMapper(new MessagePackFactory());

    /**
     * 对象序列化
     *
     * @param
     * @return 返回值含义的说明
     */
    public static byte[] msgpackSerialize(Object obj) {
        try {
            return msgpackMapper.writeValueAsBytes(obj);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 对象反序列化
     *
     * @param
     * @return 返回值含义的说明
     */
    public static <T> T msgpackDeSerialize(byte[] data, Class<T> cls) {
        try {
            T obj = msgpackMapper.readValue(data, cls);
            return obj;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

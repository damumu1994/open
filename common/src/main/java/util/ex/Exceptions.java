/**
 * Copyright (c) @2016,cmct 版权所有
 */
package util.ex;


import util.serialization.JsonUtil;

/**
 * 自定义异常
 *
 * @author losing
 * @Date 2016年8月14日
 * @since v0.1
 */
public class Exceptions {

    public static CmctException createException(Errorcode errorcode) {
        return createException(errorcode, null);
    }

    public static CmctException createException(Errorcode errorcode, Object data) {
        if (data != null) {
            return new CmctException(errorcode, JsonUtil.toJson(data));
        } else {
            return new CmctException(errorcode, null);
        }
    }
}

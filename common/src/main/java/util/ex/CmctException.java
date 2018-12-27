/**
 * Copyright (c) @2016,cmct 版权所有
 */
package util.ex;

@SuppressWarnings("serial")
public class CmctException extends RuntimeException {

    private Errorcode errorcode;

    private String extraInfo;

    private static String format =
            "errorcode:%d,typeid:%d,appid:%d,code:%d,errormsg:%s \n extrainfo:%s";

    public CmctException(Errorcode errorcode) {
        this.errorcode = errorcode;
    }

    public CmctException(Errorcode errorcode, String extraInfo) {
        super(formatMsg(errorcode, extraInfo));
        this.errorcode = errorcode;
        this.extraInfo = extraInfo;
    }

    public String getExtraInfo() {
        return extraInfo;
    }

    public Errorcode getErrorcode() {
        return errorcode;
    }

    private static String formatMsg(Errorcode errorcode, String extraInfo) {
        return String.format(format, errorcode.getErrorcode(), errorcode.getTypeId(),
                errorcode.getAppId(), errorcode.getCode(), errorcode.getDesc(), extraInfo);
    }
}

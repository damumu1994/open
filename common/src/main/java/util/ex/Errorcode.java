package util.ex;

/**
 * 错误代码工具类
 *
 * @author losing
 * @Date 2016年8月14日
 * @since v0.1
 */
public class Errorcode {

    // 错误吗 0-31位表示应用的错误编码 32-56 位表示应用的编码 57-64位表示错误的类型
    private long errorcode;
    // 描述
    private String desc;

    public Errorcode(int typeId, int appId, int code, String desc) {
        this.errorcode =
                ((((long) typeId) & 0x0000000000ff) << 56) | ((((long) appId) & 0x0000000000ffffff) << 32)
                        | ((((long) code) & 0x00000000ffffffff));
        this.desc = desc;
    }

    public int getTypeId() {
        return (int) ((errorcode >> 56) & 0xff);
    }

    public int getAppId() {
        return (int) ((errorcode >> 32) & 0xffffff);
    }

    public int getCode() {
        return (int) (errorcode & 0xffffffff);
    }

    public long getErrorcode() {
        return errorcode;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}

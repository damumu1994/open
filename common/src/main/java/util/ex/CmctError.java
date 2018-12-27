package util.ex;

/**
 * 统一的错误码
 *
 * @author Aswords
 * @Date 2017/2/20
 * @since v0.1
 */
public class CmctError {

    public static final Integer APP_ID = 1;

    public static final Errorcode NO_COMPONNENT = new Errorcode(ErrorConstant.BUSINESS_ERROR, APP_ID, 904, "此桥梁还没有部件");

    public static final Errorcode NO_BRIDGE_UNIT = new Errorcode(ErrorConstant.BUSINESS_ERROR, APP_ID, 904, "没有评分单元");

    public static final Errorcode COMPONENT_CAL_ERROR = new Errorcode(ErrorConstant.BUSINESS_ERROR, APP_ID, 904, "部位得分计算错误");

    public static final Errorcode PARAM_ERROR = new Errorcode(ErrorConstant.BUSINESS_ERROR, APP_ID, 903, "参数错误");

    public static final Errorcode EXSIST_DIR = new Errorcode(ErrorConstant.BUSINESS_ERROR, APP_ID, 905, "目录已存在");

    public static final Errorcode EXSIST_FILE = new Errorcode(ErrorConstant.BUSINESS_ERROR, APP_ID, 906, "文件已存在");

    public static final Errorcode DATA_ERROR = new Errorcode(ErrorConstant.BUSINESS_ERROR, APP_ID, 902, "数据错误");

    public static final Errorcode UNIT_ERROR = new Errorcode(ErrorConstant.BUSINESS_ERROR, APP_ID, 902, "评分单元错误");

    public static final Errorcode LOGIN_FAILURE = new Errorcode(ErrorConstant.BUSINESS_ERROR, APP_ID, 901, "登录失败");

    public static final Errorcode REGIST_FAILURE = new Errorcode(ErrorConstant.BUSINESS_ERROR, APP_ID, 909, "用户名已经存在");

    public static final Errorcode AVAILABLE_BRIDGE_ERROR = new Errorcode(ErrorConstant.BUSINESS_ERROR, APP_ID, 901, "没有足够的桥梁检测数，请联系管理员");

    public static final Errorcode SYS_ERROR = new Errorcode(ErrorConstant.BUSINESS_ERROR, APP_ID, 907, "系统错误");

    public static final Errorcode CONFIG_ERROR = new Errorcode(ErrorConstant.BUSINESS_ERROR, APP_ID, 908, "配置错误");

    public static final Errorcode TOKEN_EXPIRED = new Errorcode(ErrorConstant.BUSINESS_ERROR, APP_ID, 700, "token过期");

    public static final Errorcode TOKEN_ERROR = new Errorcode(ErrorConstant.BUSINESS_ERROR, APP_ID, 701, "token验证失败");

    public static final Errorcode SIGN_ERROR = new Errorcode(ErrorConstant.BUSINESS_ERROR, APP_ID, 702, "签名验证失败");

    public static final Errorcode CHECK_ERROR = new Errorcode(ErrorConstant.BUSINESS_ERROR, APP_ID, 909, "交竣工检查不存在");

    public static final Errorcode PAVE_WEIGHT_ERROR = new Errorcode(ErrorConstant.BUSINESS_ERROR, APP_ID, 910, "已经配置过该权重");

    public static final Errorcode PAVE_CRITERION_ERROR = new Errorcode(ErrorConstant.BUSINESS_ERROR, APP_ID, 910, "已经配置过该标准");

}

package util;

import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 常量集
 */
public class MyConstants {
    public static final ExecutorService executorService = Executors.newFixedThreadPool(10);
    //accessToken过期时间 单位秒
    public static final int ACCESS_TOKEN_TIMEOUT = 15 * 60;
    //验证码过期时间 单位秒 300
    public static final int AUTHCODE_TIMEOUT = 300;

   // public static final String QINIU_ACCESS_KEY = "V1WLfR1dJgoMEnYF3qMPErbNLrRFzpc_JRSyru-G";
   // public static final String QINIU_SECRET_KEY = "zuC6r_qtGsesLq6qHNKO-rGNJhmUtIJKJ0yhq4fN";
  //  public static final String IMAGE_URL="https://static.zhangdamiao.com/";

    public static final String QINIU_ACCESS_KEY = "8M0iH2HBY1oQBKYm02VDVqqncBbU-cbmg_dnk9Km";
    public static final String QINIU_SECRET_KEY = "5YvURgIlwnLIOS0D1BL4XhgIp4HNOIyQsfB761PH";
    public static final String IMAGE_URL="http://static.app.gongyitech.com/";

    public static final String SALT = "!@#paocheng#@!";
    public static boolean ifDebug = false;
    public static IdWorkerUtil idWorkerUtil=new IdWorkerUtil(1);
    //注册
    public  static final  String SMS_TYPE_REGISTRATION="SMS_88985020";
    //找回密码
    public  static  final  String SMS_TYPE_BACKPWD="SMS_89075017";
    //修改密码
    public static final  String SMS_TYPE_UPDATEPWD="";
    //修改绑定手机号
    public  static  final  String SMS_TYPE_CHANGEBAND="SMS_89070029";

    //可以不被auth2机制过滤的接口
    //融云
    public static final String RONGYUN_KEY = "e5t4ouvpte1qa";
    public static final String RONGYUN_SECRET = "pm7FjjJgsjW1KD";
    //极光推送
    public static final String JPUSH_AppKey = "7e169286f0ee1ee8be82cf98";
    public static final String JPUSH_DevSecret = "e35e9d696b2c78dff08b22a6";
    public static final String JPUSH_DevKey = "1f5296c21a279d5301d79d27";
    public static final String JPUSH_TOKEN_USER = "user";
    //阿里短信
    static final String ALI_ACCESS_KEY_ID = "LTAIMhWOAtFVC1MF";
    static final String ALI_ACCESS_KEY_SECRET = "A3iLxFxkhgNRdspaxDwF0LGgmNfA91";



}